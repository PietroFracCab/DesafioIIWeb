package com.desenvolvimentoWeb.desafioII.repository;

import com.desenvolvimentoWeb.desafioII.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DestinoRepositorio extends JpaRepository<Destino, Long> {

    Destino atualizar(Long id, Destino destino);
}

