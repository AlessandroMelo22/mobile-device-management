package com.alessandromelo.exception.dispositivo;

public class NumeroDeSerieJaCadastradoException extends RuntimeException {

    public NumeroDeSerieJaCadastradoException() {
        super("Já existe um dispositivo cadastrado com o número de série informado!");
    }
}
