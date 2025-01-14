package com.example.Restaurante.services;

import com.example.Restaurante.dto.PedidoDTO;
import com.example.Restaurante.models.*;
import com.example.Restaurante.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private PlatoRepositorio platoRepositorio;

    @Autowired
    private TipoComidaRepositorio tipoComidaRepositorio;

    @Autowired
    private PedidoDetallesRepositorio pedidoDetallesRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private MesaRepositorio mesaRepositorio;

    @Autowired
    private FormaPagoRepositorio formaPagoRepositorio;

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
        if (pedido.getFechaPedido() == null) {
            pedido.setFechaPedido(LocalDate.now());
        }
        if (pedido.getEstado() == null) {
            pedido.setEstado("pendiente");
        }
        if (pedido.getTotalFinal() < 0) {
            throw new IllegalArgumentException("El total del pedido no puede ser negativo.");
        }
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

    public void crearPedido(PedidoDTO pedidoDTO) {
        // 1. Buscar el cliente
        Cliente cliente = clienteRepositorio.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // 2. Buscar la mesa
        Mesa mesa = mesaRepositorio.findById(pedidoDTO.getMesaId())
                .orElseThrow(() -> new IllegalArgumentException("Mesa no encontrada"));

        // 3. Buscar la forma de pago
        FormaPago formaPago = formaPagoRepositorio.findById(pedidoDTO.getFormaPagoId())
                .orElseThrow(() -> new IllegalArgumentException("Forma de pago no encontrada"));

        // 4. Crear el pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setMesa(mesa);
        pedido.setFormaPago(formaPago);
        pedido.setFechaPedido(LocalDate.now());
        pedido.setEstado("pendiente");
        pedido = pedidoRepositorio.save(pedido); // Guardamos el pedido para generar su ID

        // 5. Agregar los detalles del pedido (productos)
        for (PedidoDTO.ProductoPedidoDTO productoDTO : pedidoDTO.getProductos()) {
            Plato plato = platoRepositorio.findById(productoDTO.getPlatoId())
                    .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"));

            TipoComida tipoComida = tipoComidaRepositorio.findById(productoDTO.getTipoComidaId())
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de comida no encontrado"));

            // Calcular el coste del pedido
            double coste = plato.getPrecioBase() * tipoComida.getFactorPrecio();

            PedidoDetalles detalle = new PedidoDetalles();
            detalle.setPedido(pedido);
            detalle.setPlato(plato);
            detalle.setTipoComida(tipoComida);
            detalle.setCantidad(productoDTO.getCantidad());
            detalle.setCoste(coste * productoDTO.getCantidad());

            // Guardar el detalle del pedido
            pedidoDetallesRepositorio.save(detalle);
        }

        // Actualizar el total del pedido
        double totalPedido = pedidoDetallesRepositorio.sumTotalByPedidoId(pedido.getId());
        pedido.setTotalFinal(totalPedido);
        pedidoRepositorio.save(pedido);
    }

    public long contarPedidosPorCliente(Integer clienteId) {
        if (clienteRepositorio.findById(clienteId).isEmpty()) {
            throw new IllegalArgumentException("El cliente no existe");
        }
        return pedidoRepositorio.countPedidosByClienteId(clienteId);
    }

    public Double obtenerTotalGastadoPorCliente(Integer clienteId) {
        return pedidoRepositorio.sumTotalGastadoByClienteId(clienteId);
    }
}
