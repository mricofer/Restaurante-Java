package com.example.Restaurante.repositories;

import com.example.Restaurante.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
    @Query("SELECT p.coste " +
            "FROM PedidoDetalles p WHERE p.pedido.id = :idPedido")
    List<Map<String, Object>> findPedidoDetallesById(Integer idPedido);
}
