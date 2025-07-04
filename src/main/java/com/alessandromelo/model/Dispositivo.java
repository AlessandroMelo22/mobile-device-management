package com.alessandromelo.model;

import jakarta.persistence.*;

@Entity
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String marca;

    @Column(unique = true)
    private String numeroSerie;

    private String sistemaOperacional;

    private String versaoSO;

    private String status; //enum (ATIVO, INATIVO, EM_MANUTENCAO, PERDIDO, BLOQUEADO)

    private String dataAquisicao;

    private String dataUltimaAtualizacao;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; // FK


    public Dispositivo() {
    }

    public Dispositivo(String modelo, String marca, String numeroSerie, String sistemaOperacional, String versaoSO, String status, Usuario usuario, String dataAquisicao, String dataUltimaAtualizacao, String observacoes) {
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.sistemaOperacional = sistemaOperacional;
        this.versaoSO = versaoSO;
        this.status = status;
        this.usuario = usuario;
        this.dataAquisicao = dataAquisicao;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.observacoes = observacoes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
