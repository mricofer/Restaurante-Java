package com.example.restaurante.repositories;

import com.example.restaurante.models.PedidoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetallesRepositorio extends JpaRepository<PedidoDetalles, Integer> {
}
