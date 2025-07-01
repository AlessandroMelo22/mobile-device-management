package com.alessandromelo.controller;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



//ListarUsuarios: CONSERTAR
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(this.usuarioService.listarUsuarios());
    }

//Buscar Usuario por Id:
    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long usuarioId){
        return this.usuarioService.buscarUsuarioPorId(usuarioId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//Cadastrar novo Usuario:
    @PostMapping
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody Usuario novoUsuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.usuarioService.cadastrarNovoUsuario(novoUsuario));
    }

//Atualizar Usuario:
    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long usuarioId,
                                                    @RequestBody Usuario atualizado){

        return this.usuarioService.atualizarUsuario(usuarioId, atualizado)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


//Remover Usuario por Id:
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> removerUsuarioPorId(@PathVariable Long usuarioId){

        this.usuarioService.removerUsuarioPorId(usuarioId);
        return ResponseEntity.noContent().build(); //204
    }

//Listar Dispositivos cadastrados em um determinado Usuario:
    @GetMapping("/{usuarioId}/dispositivos")
    public ResponseEntity<List<Dispositivo>> listarDispositivosCadastradosEmUmUsuario(@PathVariable Long usuarioId){

        return this.usuarioService.listarDispositivosCadastradosEmUmUsuario(usuarioId).
                map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//Setar Dispositivos a um Usuario:




//Setar Departamento a um Usuario:


//Buscar Departamento do Usuario:
    @GetMapping("/{usuarioId}/departamento")
    public ResponseEntity<Departamento> buscarDepartamentoDoUsuario(@PathVariable Long usuarioId){

        return this.usuarioService.buscarDepartamentoDoUsuario(usuarioId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
