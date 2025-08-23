package com.alessandromelo.entity;

import com.alessandromelo.enums.AgenteStatus;
import jakarta.persistence.*;

@Entity
public class Agente {

    @Id
    private Long id;
    private String versao;
    @Enumerated(EnumType.STRING)
    private AgenteStatus status; // enum (ATIVO, INATIVO, EM_EXECUCAO)
    private String log; // Log de execução do agente
    private String dataUltimaAtividade;

    @OneToOne
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo; //FK

    //private String ip;
    //private String tipoConexao;

    public Agente() {
    }

    public Agente(Long id, String versao, AgenteStatus status, String log, String dataUltimaAtividade, Dispositivo dispositivo) {
        this.id = id;
        this.versao = versao;
        this.status = status;
        this.log = log;
        this.dataUltimaAtividade = dataUltimaAtividade;
        this.dispositivo = dispositivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public AgenteStatus getStatus() {
        return status;
    }

    public void setStatus(AgenteStatus status) {
        this.status = status;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getDataUltimaAtividade() {
        return dataUltimaAtividade;
    }

    public void setDataUltimaAtividade(String dataUltimaAtividade) {
        this.dataUltimaAtividade = dataUltimaAtividade;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
