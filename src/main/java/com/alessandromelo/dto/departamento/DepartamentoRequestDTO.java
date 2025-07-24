package com.alessandromelo.dto.departamento;

import jakarta.validation.constraints.NotBlank;

public class DepartamentoRequestDTO {

    @NotBlank(message = "O nome do Departamento deve ser informado!")
    private String nome;

    @NotBlank(message = "A sigla do Departamento deve ser informada!")
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
