package com.example.restaurante.repositories;

import com.example.restaurante.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepositorio extends JpaRepository<Pedidos, Integer> {
}
