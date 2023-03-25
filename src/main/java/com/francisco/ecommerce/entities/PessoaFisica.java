package com.francisco.ecommerce.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(){

    }

    public PessoaFisica( String cpf) {
        this.cpf = cpf;
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
