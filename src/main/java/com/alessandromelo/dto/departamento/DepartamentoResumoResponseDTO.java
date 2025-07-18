package com.alessandromelo.dto.departamento;

public class DepartamentoResumoResponseDTO {

    private Long id;
    private String nome;


    public DepartamentoResumoResponseDTO() {
    }

    public DepartamentoResumoResponseDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
