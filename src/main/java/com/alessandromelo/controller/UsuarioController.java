package com.alessandromelo.controller;

import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;


    public UsuarioController() {
    }

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
                .map(ResponseEntity:: ok).orElse(ResponseEntity.notFound().build());
    }

//Cadastrar novo Usuario:
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.usuarioService.cadastrarUsuario(usuario));
    }

//Atualizar Usuario:
    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long usuarioId,
                                                    @RequestBody Usuario atualizado){

        return this.usuarioService.atualizarUsuario(usuarioId, atualizado)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


//Remover Usuario:
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long usuarioId){

        this.usuarioService.removerUsuario(usuarioId);
        return ResponseEntity.notFound().build();
    }

//Listar Dispositivos cadastrados em um determinado Usuario:
    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<Dispositivo>> listarDispositivosCadastradosEmUmUsuario(@PathVariable Long usuarioId){

        return this.usuarioService.listarDispositivosCadastradosEmUmUsuario(usuarioId).
                map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


}
