package com.francisco.ecommerce.controllers;


import com.francisco.ecommerce.entities.Produto;
import com.francisco.ecommerce.respositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/list")
    public String listar(Model model){
        List<Produto> produtos = repository.produtos();
        model.addAttribute("produtos", produtos);
        return "/produtos/list";
    }

    @GetMapping("/form")
    public String form(Produto produto){
        return "/produtos/form";
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("/produtos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    @GetMapping("/pesquisarproduto")
    public ModelAndView pesquisarProduto(@RequestParam("nomepesquisa") String nomepesquisa, ModelMap model) {
        List<Produto> produtos = repository.findProdutoByNome(nomepesquisa.toUpperCase());
        model.addAttribute("produtos",produtos);
        return new ModelAndView("/produtos/list",model);
    }


}
