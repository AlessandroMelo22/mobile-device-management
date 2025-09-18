package com.alessandromelo.exception.global;

public class EntidadeEmUsoException extends RuntimeException {

    public EntidadeEmUsoException(Class<?> entidadeClasse, Long entidadeId) {
        super(entidadeClasse.getSimpleName() + " com o ID " + entidadeId + " não pode ser removido, pois está associado a outros registros.");
    }
}
