package com.alessandromelo.controller;

import com.alessandromelo.entity.Agente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agentes/operacoes")
public class AgenteOperacoesController {








/*

- Talvez  criar um DTO especifico para cada endpoint (metodo)


 */

// PATCH
//Atualiza status, dataUltimaAtividade, ipUltimo, versao.
    public ResponseEntity<Agente> atualizarStatusDispositivo(){

        return null;
    }

// POST
// O agente envia mensagens ou erros para o servidor.
    public ResponseEntity<Agente> enviarLogsDeExecução(){

        return null;
    }

// GET
// O agente consulta quais ordens precisa executar (ex: bloquear tela).
    public ResponseEntity<Agente> buscarComandosPendentes(){

        return null;
    }






}
