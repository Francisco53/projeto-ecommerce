package com.francisco.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa{

    @NotBlank(message = "CNPJ é obrigatório")
    @NotNull(message = "CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "Razão Social é obrigatório")
    @NotNull(message = "Razão Social é obrigatório")
    private String razaoSocial;

    public PessoaJuridica(){

    }

    public PessoaJuridica(Long id, String email, String telefone, String cnpj, String razaoSocial) {
        super(id, email, telefone);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
