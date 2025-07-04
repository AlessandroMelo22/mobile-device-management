package com.alessandromelo.exception.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(Long usuarioId) {
        super("Usuário com o id " + usuarioId + " não encontrado!");
    }
}
