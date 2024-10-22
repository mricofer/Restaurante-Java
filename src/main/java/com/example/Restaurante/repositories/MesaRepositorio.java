package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepositorio extends JpaRepository<Mesa, Integer> {
}
