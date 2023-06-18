package com.francisco.ecommerce.entities;

import jakarta.persistence.*;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne
    private Endereco endereco;

    @ManyToOne
    private Estado estado;



    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
