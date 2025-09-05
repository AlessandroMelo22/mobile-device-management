package com.alessandromelo.exception.comando;

public class ComandoNaoEncontradoException extends RuntimeException {

    public ComandoNaoEncontradoException(Long comandoId) {
        super("Comando com id " + comandoId + " não encontrado!");
    }
}
