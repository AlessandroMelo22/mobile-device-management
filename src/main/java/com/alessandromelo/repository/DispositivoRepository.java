package com.alessandromelo.repository;

import com.alessandromelo.entity.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    //Retorna um boolean se o numeroSerie já existe no banco
    boolean existsByNumeroSerie(String numeroSerie);

    //Retorna um boolean se o numeroSerie de um dispositivo especifico existe no banco
    boolean existsByNumeroSerieAndIdNot(String numeroSerie, Long id);

}
