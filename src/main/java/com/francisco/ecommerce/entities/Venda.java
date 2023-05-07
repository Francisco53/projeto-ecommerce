package com.francisco.ecommerce.entities;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Scope("session")
@Component
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @OneToMany(mappedBy = "venda",cascade = CascadeType.PERSIST)
    private List<ItemVenda> itemVendas = new ArrayList<>();

    @ManyToOne
    private Pessoa pessoa;


    public Venda(){

    }


    public Venda(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }



    public double total(){
        double soma = 0;
        for (ItemVenda venda  : itemVendas) {
            soma += venda.total();
        }

        return soma;
    }
}
