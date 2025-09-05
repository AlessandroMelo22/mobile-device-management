package com.alessandromelo.service;


import com.alessandromelo.dto.agenteoperacoes.atualizarstatus.AtualizarStatusRequestDTO;
import com.alessandromelo.dto.agenteoperacoes.atualizarstatus.AtualizarStatusResponseDTO;
import com.alessandromelo.dto.agenteoperacoes.buscarcomandospendentes.BuscarComandosPendentesResponseDTO;
import com.alessandromelo.dto.agenteoperacoes.enviarlogs.EnviarLogsResponseDTO;
import com.alessandromelo.entity.Comando;
import com.alessandromelo.enums.ComandoStatus;
import com.alessandromelo.exception.agente.AgenteNaoEncontradoException;
import com.alessandromelo.mapper.agenteoperacoes.AtualizarStatusMapper;
import com.alessandromelo.mapper.agenteoperacoes.BuscarComandosMapper;
import com.alessandromelo.repository.AgenteRepository;
import com.alessandromelo.repository.ComandoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteOperacoesService {


    private AgenteRepository agenteRepository;
    private AtualizarStatusMapper atualizarStatusMapper;
    private ComandoRepository comandoRepository;
    private BuscarComandosMapper buscarComandosMapper;

    public AgenteOperacoesService(AgenteRepository agenteRepository, AtualizarStatusMapper atualizarStatusMapper, ComandoRepository comandoRepository, BuscarComandosMapper buscarComandosMapper) {
        this.agenteRepository = agenteRepository;
        this.atualizarStatusMapper = atualizarStatusMapper;
        this.comandoRepository = comandoRepository;
        this.buscarComandosMapper = buscarComandosMapper;
    }




    public AtualizarStatusResponseDTO atualizarStatus(Long agenteId, AtualizarStatusRequestDTO requestDTO){

        return this.agenteRepository.findById(agenteId)
                .map(agente -> {

                    agente.setVersao(requestDTO.getVersao());
                    agente.setStatus(requestDTO.getStatus());
                    agente.setDataUltimaAtividade(requestDTO.getDataUltimaAtividade());

                    this.agenteRepository.save(agente);

                    return this.atualizarStatusMapper.toResponseDTO(agenteId);
                }).orElseThrow(()-> new AgenteNaoEncontradoException(agenteId));
    }


    public BuscarComandosPendentesResponseDTO buscarComandosPendentes(Long agenteId){

        List<Comando> comandos = this.comandoRepository.findByAgenteIdAndStatusOrderByDataCriacaoAsc(agenteId, ComandoStatus.PENDENTE);
        return this.buscarComandosMapper.toResponseDTO(agenteId, comandos);
        
        //Depois criar algo para atualizar o status do comando para "EXECUTADO" ou "FALHA" quando o agente informar o resultado da execução
    }




    public EnviarLogsResponseDTO enviarLogs(){
        // logica para receber e armazenar os logs enviados pelo agente
        return null;
    }
}
