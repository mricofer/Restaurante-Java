package com.example.restaurante.repositories;

import com.example.restaurante.models.TipoComida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoComidaRepositorio extends JpaRepository<TipoComida, Integer> {
}
