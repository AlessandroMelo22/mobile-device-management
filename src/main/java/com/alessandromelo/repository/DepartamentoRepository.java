package com.alessandromelo.repository;

import com.alessandromelo.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    boolean existsByNome(String nome);
    boolean existsBySigla(String sigla);

    boolean existsByNomeAndIdNot(String nome, Long id);
    boolean existsBySiglaAndIdNot(String sigla, Long id);
}
