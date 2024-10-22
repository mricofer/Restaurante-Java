package com.example.Restaurante.repositories;

import com.example.Restaurante.models.PedidoDetalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDetallesRepositorio extends JpaRepository<PedidoDetalles, Integer> {
    List<PedidoDetalles> findByPedidoId(Integer idPedido);

    @Query("SELECT SUM(d.coste) FROM PedidoDetalles d WHERE d.pedido.id = :pedidoId")
    Double sumTotalByPedidoId(@Param("pedidoId") Long pedidoId);
}
