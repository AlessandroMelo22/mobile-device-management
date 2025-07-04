package com.alessandromelo.exception.usuario;

public class EmailJaCadastradoException extends RuntimeException {


    public EmailJaCadastradoException() {
        super("O email informado já existe no sistema!");
    }
}
