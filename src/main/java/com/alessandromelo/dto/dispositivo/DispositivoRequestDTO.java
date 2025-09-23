package com.alessandromelo.dto.dispositivo;

import com.alessandromelo.enums.DispositivoStatus;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DispositivoRequestDTO {

    @NotBlank(message = "O modelo do Dispositivo deve ser informado!")
    private String modelo;

    @NotBlank(message = "A marca do Dispositivo deve ser informada!")
    private String marca;

    @NotBlank(message = "O número de série do Dispositivo deve ser informado!")
    private String numeroSerie;

    private String sistemaOperacional;
    private String versaoSO;
    private DispositivoStatus status;
    private LocalDate dataAquisicao;
    private LocalDateTime dataUltimaAtualizacao;
    private String observacoes;

    private Long usuarioId; //(FK)



    public DispositivoRequestDTO() {
    }

    public DispositivoRequestDTO(String modelo, String marca, String numeroSerie, String sistemaOperacional, String versaoSO, DispositivoStatus status, LocalDate dataAquisicao, LocalDateTime dataUltimaAtualizacao,String observacoes, Long usuarioId) {
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.sistemaOperacional = sistemaOperacional;
        this.versaoSO = versaoSO;
        this.status = status;
        this.dataAquisicao = dataAquisicao;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.observacoes = observacoes;
        this.usuarioId = usuarioId;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getVersaoSO() {
        return versaoSO;
    }

    public void setVersaoSO(String versaoSO) {
        this.versaoSO = versaoSO;
    }

    public DispositivoStatus getStatus() {
        return status;
    }

    public void setStatus(DispositivoStatus status) {
        this.status = status;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
