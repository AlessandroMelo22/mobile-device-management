package com.alessandromelo.exception.usuario;

public class CpfJaCadastradoException extends RuntimeException {


    public CpfJaCadastradoException() {
        super("O CPF informado já existe no sistema!");
    }
}
