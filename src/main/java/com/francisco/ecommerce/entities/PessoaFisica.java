package com.francisco.ecommerce.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    private String cpf;

    private String nome;

    public PessoaFisica(){

    }

    public PessoaFisica(Long id, String email, String telefone, String cpf, String nome) {
        super(id, email, telefone);
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
