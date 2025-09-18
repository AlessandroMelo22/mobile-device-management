package com.alessandromelo.dto.comando;

import com.alessandromelo.enums.ComandoStatus;
import com.alessandromelo.enums.ComandoTipo;

import java.time.LocalDateTime;

public class ComandoResponseDTO {

    private Long id;
    private ComandoTipo tipo;
    private ComandoStatus status;
    private String parametros;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataExecucao;
    private Long agenteId; //mostra apenas o ID do agente

    public ComandoResponseDTO() {
    }

    public ComandoResponseDTO(Long id, ComandoTipo tipo, ComandoStatus status, String parametros, LocalDateTime dataCriacao, LocalDateTime dataExecucao, Long agenteId) {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        this.parametros = parametros;
        this.dataCriacao = dataCriacao;
        this.dataExecucao = dataExecucao;
        this.agenteId = agenteId;
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

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(LocalDateTime dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Long getAgenteId() {
        return agenteId;
    }

    public void setAgenteId(Long agenteId) {
        this.agenteId = agenteId;
    }



}
