package com.alessandromelo.exception.dispositivo;

public class DispositivoNaoEncontradoException extends RuntimeException {

    public DispositivoNaoEncontradoException(Long dispositivoId) {
        super("Dispositivo com o id " + dispositivoId + " não encontrado!");
    }
}
