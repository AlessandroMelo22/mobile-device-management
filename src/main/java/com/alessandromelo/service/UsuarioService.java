package com.alessandromelo.service;

import com.alessandromelo.model.Departamento;
import com.alessandromelo.model.Dispositivo;
import com.alessandromelo.model.Usuario;
import com.alessandromelo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
    }
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


//Listar todos os usuarios: (CERTO)
    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.findAll();
    }

//Buscar Usuario por id: (CERTO)
    public Optional<Usuario> buscarUsuarioPorId(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId);
    }

//Cadastrar Usuario: (CERTO)
    public Usuario cadastrarUsuario(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

//Atualizar Usuario: (Está correto porem futuramente deve ser corrigido o problema dos possiveis campos nulos)
    public Optional<Usuario> atualizarUsuario(Long usuarioId, Usuario atualizado){

        return this.usuarioRepository.findById(usuarioId)
                .map(usuario -> {
                    usuario.setNome(atualizado.getNome());
                    usuario.setCargo(atualizado.getCargo());
                    usuario.setDepartamento(atualizado.getDepartamento());
                    usuario.setMatricula(atualizado.getMatricula());
                    usuario.setEmail(atualizado.getEmail());
                    usuario.setDispositivos(atualizado.getDispositivos());
                    usuario.setAtivo(atualizado.getAtivo());
                    return this.usuarioRepository.save(usuario);
        } );
    }

//Remover Usuario:
    public void removerUsuario(Long usuarioId){
        this.usuarioRepository.deleteById(usuarioId);
    }

//Listar Dispositivos cadastrados em um determinado Usuario   (CERTO)
    public Optional<List<Dispositivo>> listarDispositivosCadastradosEmUmUsuario(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId).map(Usuario::getDispositivos);
    }

//Buscar Departamento do Usuario (CERTO)
    public Optional<Departamento> buscarDepartamentoDoUsuario(Long usuarioId){
        return this.usuarioRepository.findById(usuarioId).map(Usuario::getDepartamento);
    }


}
