package com.alessandromelo.controller;

import com.alessandromelo.dto.dispositivo.DispositivoResumoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioDepartamentoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioDispositivoResponseDTO;
import com.alessandromelo.dto.usuario.UsuarioRequestDTO;
import com.alessandromelo.dto.usuario.UsuarioResponseDTO;
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
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        return ResponseEntity.ok(this.usuarioService.listarUsuarios());
    }

//Buscar Usuario por Id:
    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable Long usuarioId){
        return ResponseEntity.ok(this.usuarioService.buscarUsuarioPorId(usuarioId));

    }

//Cadastrar novo Usuario:
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarNovoUsuario(@RequestBody UsuarioRequestDTO novoUsuarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.usuarioService.cadastrarNovoUsuario(novoUsuarioDTO));
    }

//Atualizar Usuario:
    @PutMapping("/{usuarioId}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(@PathVariable Long usuarioId,
                                                               @RequestBody UsuarioRequestDTO usuarioAtualizadoDTO){
        return ResponseEntity.ok(this.usuarioService.atualizarUsuario(usuarioId, usuarioAtualizadoDTO));
    }


//Remover Usuario por Id:
    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> removerUsuarioPorId(@PathVariable Long usuarioId){

        this.usuarioService.removerUsuarioPorId(usuarioId);
        return ResponseEntity.noContent().build(); //204
    }


//Listar Dispositivos cadastrados em um determinado Usuario:
    @GetMapping("/{usuarioId}/dispositivos")
    public ResponseEntity<List<DispositivoResumoResponseDTO>> listarDispositivosCadastradosEmUmUsuario(@PathVariable Long usuarioId){
        return ResponseEntity.ok(this.usuarioService.listarDispositivosCadastradosEmUmUsuario(usuarioId));
    }


//Setar Dispositivo a um Usuario:
    @PutMapping("/{usuarioId}/dispositivos/{dispositivoId}")
    public ResponseEntity<UsuarioDispositivoResponseDTO> vincularDispositivoAoUsuario(@PathVariable Long usuarioId, @PathVariable Long dispositivoId){
        return ResponseEntity.ok(this.usuarioService.vincularDispositivoAoUsuario(usuarioId,dispositivoId));
    }


//Setar Usuario a um Departamento:
    @PutMapping("/{usuarioId}/departamentos/{departamentoId}")
    public ResponseEntity<UsuarioDepartamentoResponseDTO> vincularUsuarioAoDepartamento(@PathVariable Long usuarioId, @PathVariable Long departamentoId){
        return ResponseEntity.ok(this.usuarioService.vincularUsuarioAoDepartamento(usuarioId, departamentoId));
    }

////Buscar Departamento do Usuario:
//    @GetMapping("/{usuarioId}/departamento")
//    public ResponseEntity<Departamento> buscarDepartamentoDoUsuario(@PathVariable Long usuarioId) {
//        return ResponseEntity.ok(this.usuarioService.buscarDepartamentoDoUsuario(usuarioId));
//
//    }
}
