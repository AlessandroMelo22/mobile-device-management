package com.alessandromelo.service;

import com.alessandromelo.exception.departamento.DepartamentoNaoEncontradoException;
import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;


    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }




    //Listar Departamentos:
    public List<Departamento> listarTodosDepartamentos(){
        return this.departamentoRepository.findAll();
    }

    //Buscar Departamento por Id:
    public Departamento buscarDepartamentoPorId(Long departamentoId){
        return this.departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));
    }

    //Criar Departamento: (CERTO)
    public Departamento criarNovoDepartamento(Departamento novoDepartamento){
        return this.departamentoRepository.save(novoDepartamento);
    }

    //Atualizar Departamento: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public Departamento atualizarDepartamento(Long departamentoId, Departamento atualizado){

        return this.departamentoRepository.findById(departamentoId)
                .map(departamento -> {
                    departamento.setNome(atualizado.getNome());
                    departamento.setSigla(atualizado.getSigla());
                    departamento.setUsuarios(atualizado.getUsuarios());
                    return this.departamentoRepository.save(departamento);
                }).orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));
    }

    //Remover Departamento: (CERTO)
    public void removerDepartamentoPorId(Long departamentoId){
        this.departamentoRepository.deleteById(departamentoId);
    }

    //Listar Usuarios que pertencem ao Departamento: (CERTO)
    public List<Usuario> listarUsuariosDoDepartamento(Long departamentoId){
        return this.departamentoRepository.findById(departamentoId).map(Departamento::getUsuarios)
                .orElseThrow(() -> new DepartamentoNaoEncontradoException(departamentoId));
    }

}
