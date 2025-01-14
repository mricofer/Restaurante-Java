package com.example.Restaurante;

import com.example.Restaurante.models.Pedido;
import com.example.Restaurante.models.PedidoDetalles;
import com.example.Restaurante.models.Plato;
import com.example.Restaurante.models.TipoComida;
import com.example.Restaurante.repositories.PedidoDetallesRepositorio;
import com.example.Restaurante.repositories.PedidoRepositorio;
import com.example.Restaurante.repositories.PlatoRepositorio;
import com.example.Restaurante.repositories.TipoComidaRepositorio;
import com.example.Restaurante.services.PedidoDetalleServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureTestDatabase
public class PedidoDetalleServicioTest {

    @Autowired
    private PedidoDetalleServicio pedidoDetalleServicio;

    @Autowired
    private PedidoDetallesRepositorio pedidoDetallesRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private PlatoRepositorio platoRepositorio;

    @Autowired
    private TipoComidaRepositorio tipoComidaRepositorio;

    private Pedido pedido;

    @BeforeEach
    public void inicializar() {
        pedido = new Pedido();
        pedido.setEstado("En proceso");
        pedidoRepositorio.save(pedido);


        Plato plato = new Plato();
        plato.setPrecioBase(10.0);
        platoRepositorio.save(plato);

        TipoComida tipoComida = new TipoComida();
        tipoComida.setFactorPrecio(1.5);
        tipoComidaRepositorio.save(tipoComida);

        PedidoDetalles detalle = new PedidoDetalles();
        detalle.setPedido(pedido);
        detalle.setPlato(plato);
        detalle.setTipoComida(tipoComida);
        detalle.setCantidad(2);
        pedidoDetallesRepositorio.save(detalle);
    }

    @Test
    public void testCalcularTotalPedidoPositivo() {
        // GIVEN
        double total = pedidoDetalleServicio.calcularTotalPedido(pedido.getId().intValue());

        // THEN
        assertEquals(30.0, total);
    }

    @Test
    public void testCalcularTotalPedidoNegativo() {
        // GIVEN
        Pedido emptyPedido = new Pedido();
        emptyPedido.setEstado("En proceso");
        pedidoRepositorio.save(emptyPedido);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> {
            pedidoDetalleServicio.calcularTotalPedido(emptyPedido.getId().intValue());
        });
    }
}