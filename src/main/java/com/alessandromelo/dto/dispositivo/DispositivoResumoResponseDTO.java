package com.alessandromelo.dto.dispositivo;

import com.alessandromelo.enums.DispositivoStatus;

public class DispositivoResumoResponseDTO {

    private Long id;
    private String modelo;
    private DispositivoStatus status;

    public DispositivoResumoResponseDTO() {
    }

    public DispositivoResumoResponseDTO(Long id, String modelo, DispositivoStatus status) {
        this.id = id;
        this.modelo = modelo;
        this.status = status;
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

    public DispositivoStatus getStatus() {
        return status;
    }

    public void setStatus(DispositivoStatus status) {
        this.status = status;
    }
}
