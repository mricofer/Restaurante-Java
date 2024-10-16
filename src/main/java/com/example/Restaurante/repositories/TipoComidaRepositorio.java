package com.example.Restaurante.repositories;

import com.example.Restaurante.models.TipoComida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoComidaRepositorio extends JpaRepository<TipoComida, Integer> {
}
