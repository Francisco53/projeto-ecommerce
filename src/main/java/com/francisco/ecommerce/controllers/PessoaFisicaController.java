package com.francisco.ecommerce.controllers;

import com.francisco.ecommerce.entities.Endereco;
import com.francisco.ecommerce.entities.Pessoa;
import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.entities.PessoaJuridica;
import com.francisco.ecommerce.respositories.EnderecoRepository;
import com.francisco.ecommerce.respositories.PessoaFisicaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Controller
@RequestMapping("pessoasFisicas")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository repository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("/list")
    public String listar(Model model){
        List<PessoaFisica> pessoaFisicas = repository.pessoaFisicas();
        model.addAttribute("pessoas", pessoaFisicas);
        return "/pessoaFisica/list-pessoa-fisica";
    }

    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica, Model model){
        //model.addAttribute("enderecos", pessoaFisica.getEnderecos());
        model.addAttribute("endereco", new Endereco());
        return "/pessoaFisica/form";
    }

    @PostMapping("/save")
    public ModelAndView salvar(@Valid PessoaFisica pessoaFisica, Endereco endereco, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()){

            ModelAndView modelAndView = new ModelAndView();
            List<String> msg = new ArrayList<>();
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                msg.add(objectError.getDefaultMessage());
            }

            modelAndView.addObject("msg", msg);
            return new ModelAndView("/pessoaFisica/form", model);
        }

        endereco = enderecoRepository.save(endereco); // Salva o endereço no banco de dados


        pessoaFisica.setEndereco(endereco);
        repository.salvar(pessoaFisica);

        //endereco = enderecoRepository.save(endereco);
        //pessoaFisica.setEndereco(endereco);
        //repository.salvar(pessoaFisica);

        //repository.salvar(pessoaFisica);
        //enderecoRepository.save(endereco);
        //pessoaFisica.setEndereco(enderecoRepository.findById(endereco.getId()));

        return new ModelAndView("redirect:/pessoasFisicas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasFisicas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("/pessoaFisica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoasFisicas/list");
    }

    @GetMapping("/pesquisarpessoafisica")
    public ModelAndView pesquisarPessoaJuridica(@RequestParam("nomepesquisa") String nomepesquisa, ModelMap model) {
        List<PessoaFisica> pessoaFisicas = repository.findPessoaFisicaByNome(nomepesquisa);
        model.addAttribute("pessoas", pessoaFisicas);
        return new ModelAndView("/pessoaFisica/list-pessoa-fisica", model);
    }

}
