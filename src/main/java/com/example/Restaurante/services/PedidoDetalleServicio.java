package com.example.Restaurante.services;

import com.example.Restaurante.models.PedidoDetalles;
import com.example.Restaurante.repositories.PedidoDetallesRepositorio;
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

    public double calcularTotalPedido(Integer idPedido) {
        List<PedidoDetalles> detalles = pedidoDetallesRepositorio.findByPedidoId(idPedido);
        if (detalles.isEmpty()) {
            throw new IllegalArgumentException("El pedido no tiene detalles.");
        }

        double total = 0.0;
        for (PedidoDetalles detalle : detalles) {
            // Obtener el precio base del plato
            double precioBase = detalle.getPlato().getPrecioBase();

            // Obtener el factor de precio del tipo de comida
            double factorPrecio = detalle.getTipoComida().getFactorPrecio();

            // Calcular el precio ajustado
            double precioFinal = precioBase * factorPrecio;

            // Multiplicar por la cantidad en el pedido
            total += precioFinal * detalle.getCantidad();
        }

        return total;
    }
}
