package com.example.restaurante.repositories;

import com.example.restaurante.models.Platos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatosRepositorio extends JpaRepository<Platos, Integer> {
}
