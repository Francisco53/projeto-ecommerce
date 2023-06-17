package com.francisco.ecommerce.controllers;


import com.francisco.ecommerce.entities.*;
import com.francisco.ecommerce.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @Autowired
    private PesssoaRepository pessoaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private Venda venda;



    @GetMapping("/carrinho/list")
    public ModelAndView carrinho(){
        return new ModelAndView("/carrinho/list");
    }


    @PostMapping("/pesquisar")
    public String listaPessoas(Model model, @RequestParam("pessoa") String pessoa) {
        List<PessoaFisica> pessoaFisicas = pessoaFisicaRepository.pessoaFisicas();
        List<PessoaJuridica> pessoaJuridicas = pessoaJuridicaRepository.pessoaJuridicas();

        if (pessoa.equals("F")) {
            model.addAttribute("pessoas", pessoaFisicas);
            model.addAttribute("tipoPessoa", "F");
        } else {
            model.addAttribute("pessoas", pessoaJuridicas);
            model.addAttribute("tipoPessoa", "J");
        }

        return "/carrinho/list";
    }



    @PostMapping("/adicionar/{id}")
    public ModelAndView adicionarCarrinho(@PathVariable Long id, @RequestParam("quantidade") String quantidade, RedirectAttributes redirect) {
        if(quantidade.isEmpty()){
            redirect.addFlashAttribute("erroQtd","Você deve inserir uma quantidade!");
            return new ModelAndView("redirect:/produtos/list");
        }
        ModelAndView mv = new ModelAndView("/carrinho/list");
        Produto produto = produtoRepository.findById(id);
        if (produto != null){
            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(Double.parseDouble(quantidade));
            item.setVenda(venda);
            venda.getItemVendas().add(item);

        }

        return mv;
    }

    @GetMapping("/remover/{posicao}")
    public String removerProdutoCarrinho(@PathVariable int posicao) {

        venda.getItemVendas().remove(posicao);
        double qtd = venda.getItemVendas().size();
        return "/carrinho/list";
    }


    @GetMapping("/selecionar/{id}")
    public String selecionarPessoa(@PathVariable("id") Long id, Model map){
        Pessoa p = pessoaRepository.findById(id);
        venda.setPessoa(p);
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(p);
        if(p.getClass().getSimpleName().equals("PessoaFisica"))
            map.addAttribute("tipoPessoa", "F");
        else
            map.addAttribute("tipoPessoa", "J");

        map.addAttribute("pessoas",pessoas);

        return "/carrinho/list";
    }



    @GetMapping("/finalizar")
    public String finalizarVenda() {
        venda.setId(null);
        //PessoaFisica pessoaFisica = pessoaFisicaRepository.pessoaFisica(1L);
        //venda.setPessoa(pessoaFisica);
        venda.setData(LocalDate.now());
        repository.save(venda);
        venda.getItemVendas().clear();
        return "redirect:/vendas/list";
    }




    @GetMapping("/list")
    public String listar(Model model){
        List<Venda> vendas = repository.vendas();
        model.addAttribute("vendas", vendas);
        return "/vendas/list";
    }

    @GetMapping("/pesquisarvenda")
    public ModelAndView pesquisarVenda(@RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data, ModelMap model, RedirectAttributes redirect) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = data.format(formatter);

        if(dataString.isEmpty()){
            redirect.addFlashAttribute("erroQtd","Você deve inserir uma data!");
            return new ModelAndView("redirect:/vendas/list");
        }

        List<Venda> vendas = repository.findByData(data);
        model.addAttribute("vendas", vendas);
        return new ModelAndView("/vendas/list", model);


    }

}
