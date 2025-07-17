package com.alessandromelo.dto.usuario;

import com.alessandromelo.dto.departamento.DepartamentoResumoDTO;

public class UsuarioDepartamentoResponseDTO {

    private Long usuarioId;
    private String nome;
    private String matricula;
    private DepartamentoResumoDTO departamentoResumoDTO;


    public UsuarioDepartamentoResponseDTO() {
    }

    public UsuarioDepartamentoResponseDTO(Long usuarioId, String nome, String matricula, DepartamentoResumoDTO departamentoResumoDTO) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.matricula = matricula;
        this.departamentoResumoDTO = departamentoResumoDTO;
    }


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public DepartamentoResumoDTO getDepartamentoResumoDTO() {
        return departamentoResumoDTO;
    }

    public void setDepartamentoResumoDTO(DepartamentoResumoDTO departamentoResumoDTO) {
        this.departamentoResumoDTO = departamentoResumoDTO;
    }
}
