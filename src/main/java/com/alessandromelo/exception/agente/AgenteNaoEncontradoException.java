package com.alessandromelo.exception.agente;

public class AgenteNaoEncontradoException extends RuntimeException {

    public AgenteNaoEncontradoException(Long agenteId) {
        super("Agente com o id " + agenteId + " não encontrado!");
    }
}
