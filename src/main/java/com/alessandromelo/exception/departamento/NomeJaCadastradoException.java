package com.alessandromelo.exception.departamento;

public class NomeJaCadastradoException extends RuntimeException {

    public NomeJaCadastradoException() {
        super("O nome informado já existe no sistema!");
    }
}
