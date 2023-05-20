package com.francisco.ecommerce.entities;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    @NotBlank(message = "CPF é obrigatório")
    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    @NotNull(message = "Nome é obrigatório")
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
