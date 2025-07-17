package com.alessandromelo.dto.dispositivo;

public class DispositivoResumoDTO {

    private Long id;
    private String modelo;

    public DispositivoResumoDTO() {
    }

    public DispositivoResumoDTO(Long id, String modelo) {
        this.id = id;
        this.modelo = modelo;
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
}
