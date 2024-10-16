package com.example.Restaurante.repositories;

import com.example.Restaurante.models.PedidoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetallesRepositorio extends JpaRepository<PedidoDetalles, Integer> {
}
