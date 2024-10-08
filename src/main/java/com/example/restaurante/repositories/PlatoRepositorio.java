package com.example.restaurante.repositories;

import com.example.restaurante.models.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepositorio extends JpaRepository<Plato, Integer> {
}
