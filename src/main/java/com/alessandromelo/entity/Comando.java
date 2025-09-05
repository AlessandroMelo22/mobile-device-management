package com.alessandromelo.entity;

import com.alessandromelo.enums.ComandoStatus;
import com.alessandromelo.enums.ComandoTipo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comando {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ComandoTipo tipo; // Tipo do comando (ex: "REINICIAR", "ATUALIZAR", "BLOQUEAR" etc.)
    @Enumerated(EnumType.STRING)
    private ComandoStatus status; // Status do comando (ex: "PENDENTE", "EXECUTADO", "FALHA")
    private String parametros; // Parâmetros adicionais para o comando, se necessário
    private LocalDateTime dataCriacao; //Data de criação do comando no banco
    private LocalDateTime dataExecucao;

    @ManyToOne
    @JoinColumn(name = "id_agente")
    private Agente agente; // FK




    public Comando() {
    }

    public Comando(Long id, ComandoTipo tipo, ComandoStatus status, String parametros, LocalDateTime dataCriacao, LocalDateTime dataExecucao, Long agenteId) {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        this.parametros = parametros;
        this.dataCriacao = dataCriacao;
        this.dataExecucao = dataExecucao;
        this.agente = agente;
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

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }
}
