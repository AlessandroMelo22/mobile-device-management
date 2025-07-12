package com.alessandromelo.dto.usuario;

import com.alessandromelo.dto.departamento.DepartamentoDTO;
import com.alessandromelo.dto.dispositivo.DispositivoDTO;

import java.util.List;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String matricula;
    private String cargo;
    private Boolean ativo;
    private DepartamentoDTO departamentoDTO;
    private List<DispositivoDTO> dispositivoDTOs;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String email, String matricula, String cargo, Boolean ativo, DepartamentoDTO departamentoDTO, List<DispositivoDTO> dispositivoDTOs) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.cargo = cargo;
        this.ativo = ativo;
        this.departamentoDTO = departamentoDTO;
        this.dispositivoDTOs = dispositivoDTOs;
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

    public DepartamentoDTO getDepartamentoDTO() {
        return departamentoDTO;
    }

    public void setDepartamentoDTO(DepartamentoDTO departamentoDTO) {
        this.departamentoDTO = departamentoDTO;
    }

    public List<DispositivoDTO> getDispositivoDTOs() {
        return dispositivoDTOs;
    }

    public void setDispositivoDTOs(List<DispositivoDTO> dispositivoDTOs) {
        this.dispositivoDTOs = dispositivoDTOs;
    }
}
