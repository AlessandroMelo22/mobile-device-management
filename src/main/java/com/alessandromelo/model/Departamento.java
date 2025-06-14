package com.alessandromelo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;

    @OneToMany(mappedBy = "departamento")
    private List<Usuario> usuarios;

    public Departamento() {
    }

    public Departamento(String nome, String sigla, List<Usuario> usuarios) {
        this.nome = nome;
        this.sigla = sigla;
        this.usuarios = usuarios;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
