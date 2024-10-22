package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
