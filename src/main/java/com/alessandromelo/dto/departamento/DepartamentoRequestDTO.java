package com.alessandromelo.dto.departamento;

public class DepartamentoRequestDTO {

    private String nome;
    private String sigla;


    public DepartamentoRequestDTO() {
    }

    public DepartamentoRequestDTO(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
