package com.alessandromelo.service;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.DepartamentoRepository;

import java.util.List;
import java.util.Optional;

public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    public DepartamentoService() {
    }
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }




    //Listar Departamentos:
    public List<Departamento> listarTodosDepartamentos(){
        return this.departamentoRepository.findAll();
    }

    //Buscar Departamento por Id:
    public Optional<Departamento> buscarDepartamentoPorId(Long departamentoId){
        return this.departamentoRepository.findById(departamentoId);
    }

    //Criar Departamento:
    public void criarDepartamento(Departamento departamento){
        this.departamentoRepository.save(departamento);
    }

    //Atualizar Departamento: (CONSERTAR O PROBLEMA DE CAMPOS NULOS)
    public Departamento atualizarDepartamento(Long departamentoId, Departamento atualizado){
        Departamento existente = this.departamentoRepository.getReferenceById(departamentoId);

        existente.setNome(atualizado.getNome());
        existente.setSigla(atualizado.getSigla());
        existente.setUsuarios(atualizado.getUsuarios());

        return this.departamentoRepository.save(existente);
    }

    //Remover Departamento: (REALIZAR VERIFICAÇÃO)
    public void removerDepartamentoPorId(Long departamentoId){
        this.departamentoRepository.deleteById(departamentoId);
    }


    //Listar Usuarios que pertencem ao Departamento:
    public List<Usuario> listarUsuariosDoDepartamento(Long departamentoId){
        return this.departamentoRepository.getReferenceById(departamentoId).getUsuarios();
    }

}
