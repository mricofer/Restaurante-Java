package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
