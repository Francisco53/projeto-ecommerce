package com.francisco.ecommerce.controllers;

import com.francisco.ecommerce.entities.PessoaFisica;
import com.francisco.ecommerce.entities.PessoaJuridica;
import com.francisco.ecommerce.respositories.PessoaFisicaRepository;
import com.francisco.ecommerce.respositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("pessoasJuridicas")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaRepository repository;

    @GetMapping("/list")
    public String listar(Model model){
        List<PessoaJuridica> pessoaJuridicas = repository.pessoaJuridicas();
        model.addAttribute("pessoas", pessoaJuridicas);
        return "/pessoaJuridica/list-pessoa-juridica";
    }

    @GetMapping("/form")
    public String form(PessoaJuridica pessoaJuridica){
        return "/pessoaJuridica/form";
    }

    @PostMapping("/save")
    public ModelAndView salvar(PessoaJuridica pessoaJuridica) {
        repository.salvar(pessoaJuridica);
        return new ModelAndView("redirect:/pessoasJuridicas/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoasJuridicas/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaJuridica", repository.pessoaJuridica(id));
        return new ModelAndView("/pessoaJuridica/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        repository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoasJuridicas/list");
    }

}
