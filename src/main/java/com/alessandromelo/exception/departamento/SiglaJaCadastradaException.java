package com.alessandromelo.exception.departamento;

public class SiglaJaCadastradaException extends RuntimeException {

    public SiglaJaCadastradaException() {
        super("A sigla informada já existe no sistema!");
    }
}
