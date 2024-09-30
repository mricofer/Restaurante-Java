package com.example.restaurante.repositories;

import com.example.restaurante.models.CategoriaPlato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaPlatoRepositorio extends JpaRepository<CategoriaPlato, Integer> {
}
