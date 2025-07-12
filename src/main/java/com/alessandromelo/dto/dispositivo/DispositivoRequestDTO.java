package com.alessandromelo.dto.dispositivo;

public class DispositivoRequestDTO {

    private String modelo;
    private String marca;
    private String numeroSerie;
    private String sistemaOperacional;
    private String versãoSO;
    private String status;
    private String dataAquisicao;
    private String observacoes;

    private Long usuarioId; //(FK)


    public DispositivoRequestDTO() {
    }

    public DispositivoRequestDTO(String modelo, String marca, String numeroSerie, String sistemaOperacional, String versãoSO, String status, String dataAquisicao, String observacoes, Long usuarioId) {
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.sistemaOperacional = sistemaOperacional;
        this.versãoSO = versãoSO;
        this.status = status;
        this.dataAquisicao = dataAquisicao;
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

    public String getVersãoSO() {
        return versãoSO;
    }

    public void setVersãoSO(String versãoSO) {
        this.versãoSO = versãoSO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
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
