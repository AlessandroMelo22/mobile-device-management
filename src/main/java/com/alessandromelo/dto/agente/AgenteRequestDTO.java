package com.alessandromelo.dto.agente;

import com.alessandromelo.enums.AgenteStatus;

public class AgenteRequestDTO {

    private String versao;
    private AgenteStatus status;
    private String log;
    private String dataUltimaAtividade;
    private Long dispositivoId; // FK



    public AgenteRequestDTO() {
    }

    public AgenteRequestDTO(String versao, AgenteStatus status, String log, String dataUltimaAtividade, Long dispositivoId) {
        this.versao = versao;
        this.status = status;
        this.log = log;
        this.dataUltimaAtividade = dataUltimaAtividade;
        this.dispositivoId = dispositivoId;
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

    public Long getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(Long dispositivoId) {
        this.dispositivoId = dispositivoId;
    }
}
