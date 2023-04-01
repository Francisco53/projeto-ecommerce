package com.francisco.ecommerce.controllers;

import com.francisco.ecommerce.entities.Pessoa;
import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.respositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("pessoasFisicas")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository repository;

    @GetMapping("/list")
    public String listar(Model model){
        List<PessoaFisica> pessoaFisicas = repository.pessoaFisicas();
        model.addAttribute("pessoas", pessoaFisicas);
        return "/pessoaFisica/list-pessoa-fisica";
    }

    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica){
        return "/pessoaFisica/form";
    }

    @PostMapping("/save")
    public ModelAndView salvar(PessoaFisica pessoaFisica) {
        repository.salvar(pessoaFisica);
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

}
