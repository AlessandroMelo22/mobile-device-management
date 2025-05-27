package com.alessandromelo.controller;

import com.alessandromelo.service.UsuarioService;

public class UsuarioController {

    private UsuarioService usuarioService;


    public UsuarioController() {
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



}
