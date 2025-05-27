package com.alessandromelo.service;

import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DispositivoRepository;

import java.util.List;
import java.util.Optional;

public class DispositivoService {

    private DispositivoRepository dispositivoRepository;

    public DispositivoService() {
    }
    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }



    //Listar todos os dispositivos:
    public List<Dispositivo> listarTodosDispositivos(){
        return this.dispositivoRepository.findAll();
    }

    //Buscar Dispositivo por Id:
    public Optional<Dispositivo> buscarDispositivoPorId(Long dispositivoId){
        return this.dispositivoRepository.findById(dispositivoId);
    }

    //Cadastrar Dispositivo:
    public Dispositivo cadastrarDispositivo(Dispositivo dispositivo){
        return this.dispositivoRepository.save(dispositivo);
    }

    //Atualizar Dispositivo: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public Dispositivo atualizarDispositivo(Long dispositivoId, Dispositivo atualizado){

        Dispositivo existente = this.dispositivoRepository.getReferenceById(dispositivoId);
        existente.setModelo(atualizado.getModelo());
        existente.setMarca(atualizado.getMarca());
        existente.setDataAquisicao(atualizado.getDataAquisicao());
        existente.setObservacoes(atualizado.getObservacoes());
        existente.setDataUltimaAtualizacao(atualizado.getDataUltimaAtualizacao());
        existente.setNumeroSerie(atualizado.getNumeroSerie());
        existente.setSistemaOperacional(atualizado.getSistemaOperacional());
        existente.setStatus(atualizado.getStatus());
        existente.setUsuario(atualizado.getUsuario());
        existente.setVersaoSO(atualizado.getVersaoSO());

        return this.dispositivoRepository.save(existente);
    }

    //Remover Dispositivo:
    public void removerDispositivo(Long dispositivoId){
        this.dispositivoRepository.deleteById(dispositivoId);
    }


    //Listar Usuario cadastrado em um determinado Dispositivo
    public Usuario buscarUsuarioCadastradoNoDispositivo(Long dispositivoId){
        return this.dispositivoRepository.getReferenceById(dispositivoId).getUsuario();
    }

}
