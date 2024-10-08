package com.example.restaurante.repositories;

import com.example.restaurante.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
