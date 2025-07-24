package com.alessandromelo.dto.dispositivo;

public class DispositivoResumoResponseDTO {

    private Long id;
    private String modelo;
    private String status;

    public DispositivoResumoResponseDTO() {
    }

    public DispositivoResumoResponseDTO(Long id, String modelo, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
