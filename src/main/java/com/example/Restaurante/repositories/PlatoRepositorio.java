package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepositorio extends JpaRepository<Plato, Integer> {

}
