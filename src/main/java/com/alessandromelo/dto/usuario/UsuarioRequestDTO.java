package com.alessandromelo.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {

    @NotBlank(message = "O nome do Usuário deve ser informado!")
    private String nome;

    @NotBlank(message = "O e-mail do Usuário deve ser informado!")
    @Email(message = "Formato de e-mail inválido!")
    private String email;

    @NotBlank(message = "A matrícula do Usuário deve ser informada!")
    private String matricula;

    private String cargo;
    private Boolean ativo;

    private Long departamentoId; //(FK)



    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String matricula, String cargo, Boolean ativo, Long departamentoId) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.cargo = cargo;
        this.ativo = ativo;
        this.departamentoId = departamentoId;
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

    public Long getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Long departamentoId) {
        this.departamentoId = departamentoId;
    }
}
