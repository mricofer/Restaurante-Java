package com.example.restaurante.repositories;

import com.example.restaurante.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesasRepositorio extends JpaRepository<Mesa, Integer> {
}
