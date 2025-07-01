package com.alessandromelo.controller;

import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.service.DispositivoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    private DispositivoService dispositivoService;


    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }


//Listar todos os Dispositivos:
    @GetMapping
    public ResponseEntity<List<Dispositivo>> listarTodosDispositivos(){
        return ResponseEntity.ok(this.dispositivoService.listarTodosDispositivos());
    }

//Buscar dispositivo por Id:
    @GetMapping("/{dispositivoId}")
    public ResponseEntity<Dispositivo> buscarDispositivoPorId(@PathVariable Long dispositivoId){

        return this.dispositivoService.buscarDispositivoPorId(dispositivoId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//Cadastrar Dispositivo:
    @PostMapping()
    public ResponseEntity<Dispositivo> cadastrarNovoDispositivo(@RequestBody Dispositivo novoDispositivo){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.dispositivoService.cadastrarNovoDispositivo(novoDispositivo));
    }

//Atualizar Dispositivo:
    @PutMapping("/{dispositivoId}")
    public ResponseEntity<Dispositivo> atualizarDispositivo(@PathVariable Long dispositivoId,
                                                            @RequestBody Dispositivo atualizado){

        return this.dispositivoService.atualizarDispositivo(dispositivoId,atualizado)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

//Remover Dispositivo por id:
    @DeleteMapping("/{dispositivoId}")
    public ResponseEntity<Void> removerDispositivoPorId(@PathVariable Long dispositivoId){

        this.dispositivoService.removerDispositivoPorId(dispositivoId);
        return ResponseEntity.noContent().build(); //204
    }

//Buscar Usuario que está cadastrado no dispositivo:
    @GetMapping("/{dispositivoId}/usuarios")
    public ResponseEntity<Usuario> buscarUsuarioCadastradoNoDispositivo(@PathVariable Long dispositivoId){

        return this.dispositivoService.buscarUsuarioCadastradoNoDispositivo(dispositivoId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
