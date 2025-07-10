package com.alessandromelo.service;

import com.alessandromelo.exception.dispositivo.DispositivoNaoEncontradoException;
import com.alessandromelo.exception.dispositivo.NumeroDeSerieJaCadastradoException;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {

    private DispositivoRepository dispositivoRepository;



    public DispositivoService(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }



    //Listar todos os dispositivos: (CERTO)
    public List<Dispositivo> listarTodosDispositivos(){
        return this.dispositivoRepository.findAll();
    }

    //Buscar Dispositivo por Id: (CERTO)
    public Dispositivo buscarDispositivoPorId(Long dispositivoId){
        return this.dispositivoRepository.findById(dispositivoId)
                .orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));
    }

    //Cadastrar Dispositivo: (CERTO)
    public Dispositivo cadastrarNovoDispositivo(Dispositivo novoDispositivo){

        boolean numeroSerieExistente = this.dispositivoRepository.existsByNumeroSerie(novoDispositivo.getNumeroSerie());

        if(numeroSerieExistente){

            throw new NumeroDeSerieJaCadastradoException();
        }
        return this.dispositivoRepository.save(novoDispositivo);
    }

    //Atualizar Dispositivo: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public Dispositivo atualizarDispositivo(Long dispositivoId, Dispositivo atualizado){

       return this.dispositivoRepository.findById(dispositivoId)
               .map(dispositivo -> {

                   boolean numeroSerieExistente = this.dispositivoRepository.existsByNumeroSerieAndIdNot(atualizado.getNumeroSerie(), dispositivoId);

                   if (numeroSerieExistente){

                       throw new NumeroDeSerieJaCadastradoException();
                   }

                   dispositivo.setModelo(atualizado.getModelo());
                   dispositivo.setMarca(atualizado.getMarca());
                   dispositivo.setNumeroSerie(atualizado.getNumeroSerie());
                   dispositivo.setSistemaOperacional(atualizado.getSistemaOperacional());
                   dispositivo.setVersaoSO(atualizado.getVersaoSO());
                   dispositivo.setDataUltimaAtualizacao(atualizado.getDataUltimaAtualizacao());
                   dispositivo.setDataAquisicao(atualizado.getDataAquisicao());
                   dispositivo.setUsuario(atualizado.getUsuario());
                   dispositivo.setObservacoes(atualizado.getObservacoes());
                   dispositivo.setStatus(atualizado.getStatus());
                   return this.dispositivoRepository.save(dispositivo);

               }).orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));
    }

    //Remover Dispositivo: (CERTO)
    public void removerDispositivoPorId(Long dispositivoId){
        this.dispositivoRepository.deleteById(dispositivoId);
    }


    //Buscar Usuario cadastrado em um determinado Dispositivo: (CERTO)
    public Usuario buscarUsuarioCadastradoNoDispositivo(Long dispositivoId){
        return this.dispositivoRepository.findById(dispositivoId)
                .map(Dispositivo::getUsuario)
                .orElseThrow(() -> new DispositivoNaoEncontradoException(dispositivoId));
    }

}
