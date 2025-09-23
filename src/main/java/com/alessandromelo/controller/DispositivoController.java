package com.alessandromelo.controller;

import com.alessandromelo.dto.dispositivo.DispositivoRequestDTO;
import com.alessandromelo.dto.dispositivo.DispositivoResponseDTO;
import com.alessandromelo.service.DispositivoService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<DispositivoResponseDTO>> listarTodosDispositivos(){
        return ResponseEntity.ok(this.dispositivoService.listarTodosDispositivos());
    }

//Buscar dispositivo por Id:
    @GetMapping("/{dispositivoId}")
    public ResponseEntity<DispositivoResponseDTO> buscarDispositivoPorId(@PathVariable Long dispositivoId){
        return ResponseEntity.ok(this.dispositivoService.buscarDispositivoPorId(dispositivoId));
    }

//Cadastrar Dispositivo:
    @PostMapping
    public ResponseEntity<DispositivoResponseDTO> cadastrarNovoDispositivo(@RequestBody @Valid DispositivoRequestDTO novoDispositivoDTO){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.dispositivoService.cadastrarNovoDispositivo(novoDispositivoDTO));
    }

//Atualizar Dispositivo:
    @PutMapping("/{dispositivoId}")
    public ResponseEntity<DispositivoResponseDTO> atualizarDispositivo(@PathVariable Long dispositivoId,
                                                                       @RequestBody @Valid DispositivoRequestDTO atualizado){
        return ResponseEntity.ok(this.dispositivoService.atualizarDispositivo(dispositivoId, atualizado));
    }

//Remover Dispositivo por id:
    @DeleteMapping("/{dispositivoId}")
    public ResponseEntity<Void> removerDispositivoPorId(@PathVariable Long dispositivoId){

        this.dispositivoService.removerDispositivoPorId(dispositivoId);
        return ResponseEntity.noContent().build(); //204
    }


}
