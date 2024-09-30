package com.example.restaurante.repositories;

import com.example.restaurante.models.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesasRepositorio extends JpaRepository<Mesas, Integer> {
}
