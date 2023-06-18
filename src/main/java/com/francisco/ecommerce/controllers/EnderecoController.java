package com.francisco.ecommerce.controllers;


import com.francisco.ecommerce.entities.Endereco;
import com.francisco.ecommerce.entities.Produto;
import com.francisco.ecommerce.respositories.EnderecoRepository;
import com.francisco.ecommerce.respositories.ProdutoRepository;
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
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    EnderecoRepository repository;

    @GetMapping("/list")
    public String listar(Model model){
        List<Endereco> enderecos = repository.enderecos();
        model.addAttribute("enderecos", enderecos);
        return "/enderecos/list";
    }

    @GetMapping("/form")
    public String form(Endereco endereco){
        return "/enderecos/form";
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Endereco endereco, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();

        repository.save(endereco);
        return new ModelAndView("redirect:/enderecos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("endereco", repository.endereco(id));
        return new ModelAndView("/enderecos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Endereco endereco) {
        repository.update(endereco);
        return new ModelAndView("redirect:/enderecos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/enderecos/list");
    }


}
