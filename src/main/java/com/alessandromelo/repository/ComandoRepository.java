package com.alessandromelo.repository;

import com.alessandromelo.entity.Comando;
import com.alessandromelo.enums.ComandoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComandoRepository extends JpaRepository<Comando, Long> {

    //retorna todos os comandos de um tipo especifico de um Agente especifico, ordenados pela data de criação em ordem crescente
    List<Comando> findByAgenteIdAndStatusOrderByDataCriacaoAsc(Long agenteId, ComandoStatus status);

    //retorna todos os comandos de um tipo especifico
    List<Comando> findByStatus(ComandoStatus status);

    //Aparentemente não há necessidade de métodos de validação
}
