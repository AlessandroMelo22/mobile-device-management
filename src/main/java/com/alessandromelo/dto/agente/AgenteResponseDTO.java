package com.alessandromelo.dto.agente;

import com.alessandromelo.dto.dispositivo.DispositivoResumoResponseDTO;
import com.alessandromelo.enums.AgenteStatus;

public class AgenteResponseDTO {


    private Long id;
    private String versao;
    private AgenteStatus status;
    private String log;
    private String dataUltimaAtividade;
    private DispositivoResumoResponseDTO dispositivoResumoResponseDTO; // FK

    public AgenteResponseDTO() {
    }

    public AgenteResponseDTO(Long id, String versao, AgenteStatus status, String log, String dataUltimaAtividade, DispositivoResumoResponseDTO dispositivoResumoResponseDTO) {
        this.id = id;
        this.versao = versao;
        this.status = status;
        this.log = log;
        this.dataUltimaAtividade = dataUltimaAtividade;
        this.dispositivoResumoResponseDTO = dispositivoResumoResponseDTO;
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

    public DispositivoResumoResponseDTO getDispositivoResumoResponseDTO() {
        return dispositivoResumoResponseDTO;
    }

    public void setDispositivoResumoResponseDTO(DispositivoResumoResponseDTO dispositivoResumoResponseDTO) {
        this.dispositivoResumoResponseDTO = dispositivoResumoResponseDTO;
    }
}
