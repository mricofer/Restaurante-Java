package com.example.Restaurante.repositories;

import com.example.Restaurante.models.PedidoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoDetallesRepositorio extends JpaRepository<PedidoDetalles, Integer> {
    List<PedidoDetalles> findByPedidoId(Integer idPedido);
}
