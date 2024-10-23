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


    // Contar la cantidad de pedidos realizados por un cliente
    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.cliente.id = :clienteId")
    long countPedidosByClienteId(Integer clienteId);

    // Calcular el total gastado por un cliente
    @Query("SELECT SUM(p.totalFinal) FROM Pedido p WHERE p.cliente.id = :clienteId")
    Double sumTotalGastadoByClienteId(Integer clienteId);
}
