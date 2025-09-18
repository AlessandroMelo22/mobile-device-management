package com.alessandromelo.dto.agenteoperacoes.atualizarstatuscomando;

import com.alessandromelo.enums.ComandoStatus;

public class AtualizarStatusComandoRequestDTO {

    private ComandoStatus status;
    private String mensagem; //opcional, pode ser usado para logs ou detalhes adicionais
    // private LocalDateTime dataExecucao; //opcional, pode ser usado para registrar quando o comando foi executado

}
