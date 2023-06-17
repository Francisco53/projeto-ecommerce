package com.francisco.ecommerce.entities;

public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;

    private Cidade cidade;

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }
}
