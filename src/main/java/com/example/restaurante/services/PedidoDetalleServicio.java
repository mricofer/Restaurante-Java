package com.example.restaurante.services;

import com.example.restaurante.models.PedidoDetalles;
import com.example.restaurante.repositories.PedidoDetallesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDetalleServicio {
    @Autowired
    private PedidoDetallesRepositorio pedidoDetallesRepositorio;

    /**
     * Buscar detalles de pedido por id
     *
     * @param id
     * @return
     */

    public PedidoDetalles getPedidoDetallesById(Integer id) {
        return pedidoDetallesRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear detalles de pedido o modificar uno existente
     *
     * @param pedidoDetalles
     * @return
     */

    public PedidoDetalles crearPedidoDetalles(PedidoDetalles pedidoDetalles) {
        return pedidoDetallesRepositorio.save(pedidoDetalles);
    }

    /**
     * Eliminar detalles de pedido
     */

    public void eliminarPedidoDetalles(PedidoDetalles pedidoDetalles) {
        pedidoDetallesRepositorio.delete(pedidoDetalles);
    }

    /**
     * Eliminar detalles de pedido por id
     *
     * @param id
     */

    public void eliminarPedidoDetallesById(Integer id) {
        pedidoDetallesRepositorio.deleteById(id);
    }

    /**
     * Buscar todos los detalles de pedido
     *
     * @return
     */

    public List<PedidoDetalles> getPedidoDetalles() {
        return pedidoDetallesRepositorio.findAll();
    }
}
