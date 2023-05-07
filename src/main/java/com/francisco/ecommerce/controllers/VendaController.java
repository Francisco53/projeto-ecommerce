package com.francisco.ecommerce.controllers;


import com.francisco.ecommerce.entities.ItemVenda;
import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.entities.Produto;
import com.francisco.ecommerce.entities.Venda;
import com.francisco.ecommerce.respositories.PessoaFisicaRepository;
import com.francisco.ecommerce.respositories.ProdutoRepository;
import com.francisco.ecommerce.respositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private Venda venda;


    @GetMapping("/carrinho/list")
    public ModelAndView carrinho(){
        return new ModelAndView("/carrinho/list");
    }

    @PostMapping("/adicionar/{id}")
    public ModelAndView adicionarCarrinho(@PathVariable Long id, @RequestParam("quantidade") double quantidade) {
        ModelAndView mv = new ModelAndView("/carrinho/list");
        Produto produto = produtoRepository.findById(id);
        if (produto != null){

            ItemVenda item = new ItemVenda();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
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

    @GetMapping("/finalizar")
    public String finalizarVenda() {
        venda.setId(null);
        PessoaFisica pessoaFisica = pessoaFisicaRepository.pessoaFisica(1L);
        venda.setPessoa(pessoaFisica);
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
}
