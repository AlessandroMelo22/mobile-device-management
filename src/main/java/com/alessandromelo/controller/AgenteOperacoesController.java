package com.alessandromelo.controller;

import com.alessandromelo.dto.agenteoperacoes.atualizarstatus.AtualizarStatusRequestDTO;
import com.alessandromelo.dto.agenteoperacoes.atualizarstatus.AtualizarStatusResponseDTO;
import com.alessandromelo.dto.agenteoperacoes.buscarcomandospendentes.BuscarComandosPendentesResponseDTO;
import com.alessandromelo.entity.Agente;
import com.alessandromelo.enums.AgenteStatus;
import com.alessandromelo.service.AgenteOperacoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/agentes/operacoes")
public class AgenteOperacoesController {

    private AgenteOperacoesService agenteOperacoesService;

    public AgenteOperacoesController(AgenteOperacoesService agenteOperacoesService) {
        this.agenteOperacoesService = agenteOperacoesService;
    }


    /*

- Talvez  criar um DTO especifico para cada endpoint (metodo)


 */
//Atualiza status, dataUltimaAtividade, ipUltimo, versao.
    @PutMapping("/{agenteId}")
    public ResponseEntity<AtualizarStatusResponseDTO> atualizarStatus(@PathVariable Long agenteId,
                                                                                 @RequestBody AtualizarStatusRequestDTO requestDTO){

        return ResponseEntity.ok(this.agenteOperacoesService.atualizarStatus(agenteId,requestDTO));
    }


// O agente consulta quais ordens precisa executar (ex: bloquear tela).
    @GetMapping("/{agenteId}")
    public ResponseEntity<BuscarComandosPendentesResponseDTO> buscarComandosPendentes(@PathVariable Long agenteId){

        return ResponseEntity.ok(this.agenteOperacoesService.buscarComandosPendentes(agenteId));
    }

    // POST
// O agente envia mensagens ou erros para o servidor.
    public ResponseEntity<Agente> enviarLogsDeExecução(){

        return null;
    }





}
