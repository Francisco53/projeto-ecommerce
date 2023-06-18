package com.francisco.ecommerce.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;

    @OneToMany
    private List<Cidade> cidades = new ArrayList<>();



    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}
