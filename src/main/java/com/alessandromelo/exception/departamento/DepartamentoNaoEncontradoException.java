package com.alessandromelo.exception.departamento;

public class DepartamentoNaoEncontradoException extends RuntimeException {

    public DepartamentoNaoEncontradoException(Long departamentoId) {
        super("Departamento com o id " + departamentoId + " não encontrado!");
    }
}
