package com.example.restaurante.repositories;

import com.example.restaurante.models.HistorialPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialPedidoRepositorio extends JpaRepository<HistorialPedido, Integer> {
}
