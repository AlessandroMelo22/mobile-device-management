package com.alessandromelo.dto.usuario;

import com.alessandromelo.dto.dispositivo.DispositivoResumoDTO;

public class UsuarioDispositivoResponseDTO {

    private Long usuarioId;
    private String nome;
    private String matricula;
    private DispositivoResumoDTO dispositivoResumoDTO;


    public UsuarioDispositivoResponseDTO() {
    }

    public UsuarioDispositivoResponseDTO(Long usuarioId, String nome, String matricula, DispositivoResumoDTO dispositivoResumoDTO) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.matricula = matricula;
        this.dispositivoResumoDTO = dispositivoResumoDTO;
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

    public DispositivoResumoDTO getDispositivoResumoDTO() {
        return dispositivoResumoDTO;
    }

    public void setDispositivoResumoDTO(DispositivoResumoDTO dispositivoResumoDTO) {
        this.dispositivoResumoDTO = dispositivoResumoDTO;
    }
}
