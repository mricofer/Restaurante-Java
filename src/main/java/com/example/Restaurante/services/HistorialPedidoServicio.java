package com.example.Restaurante.services;

import com.example.Restaurante.models.HistorialPedido;
import com.example.Restaurante.repositories.HistorialPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialPedidoServicio {
    @Autowired
    private HistorialPedidoRepositorio historialPedidoRepositorio;

    /**
     * Buscar historial de pedidos por id
     *
     * @param id
     * @return
     */

    public HistorialPedido getHistorialPedidoById(Integer id) {
        return historialPedidoRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear un historial de pedido o modificar uno existente
     *
     * @param historialPedido
     * @return
     */

    public HistorialPedido crearHistorialPedido(HistorialPedido historialPedido) {
        return historialPedidoRepositorio.save(historialPedido);
    }

    /**
     * Eliminar un historial de pedido
     */

    public void eliminarHistorialPedido(HistorialPedido historialPedido) {
        historialPedidoRepositorio.delete(historialPedido);
    }

    /**
     * Eliminar un historial de pedido por id
     *
     * @param id
     */

    public void eliminarHistorialPedidoById(Integer id) {
        historialPedidoRepositorio.deleteById(id);
    }
}
