package com.example.Restaurante.repositories;

import com.example.Restaurante.models.CategoriaPlato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaPlatoRepositorio extends JpaRepository<CategoriaPlato, Integer> {
}
