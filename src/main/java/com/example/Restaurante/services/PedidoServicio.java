package com.example.Restaurante.services;

import com.example.Restaurante.models.Pedido;
import com.example.Restaurante.repositories.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    /**
     * Buscar pedidos por id
     *
     * @param id
     * @return
     */

    public Pedido getPedidoById(Integer id) {
        return pedidoRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear un pedido o modificar uno existente
     *
     * @param pedido
     * @return
     */

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    /**
     * Eliminar un pedido
     */

    public void eliminarPedido(Pedido pedido) {
        pedidoRepositorio.delete(pedido);
    }

    /**
     * Eliminar un pedido por id
     *
     * @param id
     */

    public void eliminarPedidoById(Integer id) {
        pedidoRepositorio.deleteById(id);
    }

    /**
     * Buscar todos los pedidos
     *
     * @return
     */

    public List<Pedido> getPedidos() {
        return pedidoRepositorio.findAll();
    }
}
