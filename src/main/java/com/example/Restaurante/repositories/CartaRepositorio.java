package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaRepositorio extends JpaRepository<Carta, Integer> {
    Carta findFirstByPlatoId(Integer platoId);
}
