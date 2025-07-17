package com.alessandromelo.dto.usuario;

import com.alessandromelo.dto.departamento.DepartamentoResumoDTO;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String matricula;
    private String cargo;
    private Boolean ativo;
    private DepartamentoResumoDTO departamentoResumoDTO; //(FK)


    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, String matricula, String cargo, Boolean ativo, DepartamentoResumoDTO departamentoDTO) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.cargo = cargo;
        this.ativo = ativo;
        this.departamentoResumoDTO = departamentoDTO;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public DepartamentoResumoDTO getDepartamentoResumoDTO() {
        return departamentoResumoDTO;
    }

    public void setDepartamentoResumoDTO(DepartamentoResumoDTO departamentoResumoDTO) {
        this.departamentoResumoDTO = UsuarioResponseDTO.this.departamentoResumoDTO;
    }


}
