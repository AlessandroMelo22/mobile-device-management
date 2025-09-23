package com.alessandromelo.controller;


import com.alessandromelo.dto.agente.AgenteRequestDTO;
import com.alessandromelo.dto.agente.AgenteResponseDTO;
import com.alessandromelo.service.AgenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Operações CRUD de Agente, operações essas que serão chamadas
 * por algum adminstrador e não pelo Agente em sí.
 */
@RestController
@RequestMapping("/agentes")
public class AgenteController {

    private AgenteService agenteService;

    public AgenteController(AgenteService agenteService) {
        this.agenteService = agenteService;
    }

//Buscar todos:
    @GetMapping
    public ResponseEntity<List<AgenteResponseDTO>> buscarTodosAgentes(){
       return ResponseEntity.ok(this.agenteService.listarTodosAgentes());
    }

//Buscar por Id
    @GetMapping("/{agenteId}")
    public ResponseEntity<AgenteResponseDTO> buscarAgentePorId(@PathVariable Long agenteId){
        return ResponseEntity.ok(this.agenteService.buscarAgentePorId(agenteId));
    }

//Cadastrar novo Agente:
    @PostMapping
    public ResponseEntity<AgenteResponseDTO> cadastrarNovoAgente(@RequestBody AgenteRequestDTO novoAgenteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.agenteService.cadastrarNovoAgente(novoAgenteDTO));
    }

//Atualizar:
    @PutMapping("/{agenteId}")
    public ResponseEntity<AgenteResponseDTO> atualizarAgente(@PathVariable Long agenteId,
                                                             @RequestBody AgenteRequestDTO atualizado){

        return ResponseEntity.ok(this.agenteService.atualizarAgente(agenteId,atualizado));
    }

//Deletar por id: TEMPORÁRIO
    @DeleteMapping("/{agenteId}")
    public ResponseEntity<Void> deletarAgente(@PathVariable Long agenteId){
        return ResponseEntity.noContent().build(); //204
    }
}
