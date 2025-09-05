package com.alessandromelo.dto.comando;

import com.alessandromelo.enums.ComandoStatus;
import com.alessandromelo.enums.ComandoTipo;

import java.time.LocalDateTime;

public class ComandoResumoResponseDTO {

    private Long id;
    private ComandoTipo tipo;
    private ComandoStatus status;
    private LocalDateTime dataCriacao;


    public ComandoResumoResponseDTO() {
    }

    public ComandoResumoResponseDTO(Long id, ComandoTipo tipo, ComandoStatus status, LocalDateTime dataCriacao) {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ComandoTipo getTipo() {
        return tipo;
    }

    public void setTipo(ComandoTipo tipo) {
        this.tipo = tipo;
    }

    public ComandoStatus getStatus() {
        return status;
    }

    public void setStatus(ComandoStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
