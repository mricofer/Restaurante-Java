package com.example.Restaurante;

import com.example.Restaurante.models.*;
import com.example.Restaurante.repositories.*;
import com.example.Restaurante.services.PedidoDetalleServicio;
import com.example.Restaurante.services.PedidoServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class PedidoServicioTest {

    @Autowired
    private PedidoServicio servicioPedido;

    @Autowired
    private PedidoRepositorio repositorioPedido;

    @Autowired
    private ClienteRepositorio repositorioCliente;

    @Autowired
    private FormaPagoRepositorio repositorioFormaPago;

    @Autowired
    private MesaRepositorio repositorioMesa;

    @BeforeEach
    public void inicializarDatos(){
        repositorioPedido.deleteAll();
        repositorioCliente.deleteAll();
        repositorioFormaPago.deleteAll();
        repositorioMesa.deleteAll();

        Cliente c1 = new Cliente();
        c1.setCorreo("Juan@juan.com");
        c1.setDireccion("Calle 1");
        c1.setTelefono("123456789");
        c1.setEsFrecuente(true);
        c1.setFechaRegistro(LocalDate.now());
        c1.setFechaNacimiento(LocalDate.now());
        c1.setNombreCliente("Juan");
        repositorioCliente.save(c1);

        FormaPago formaPago = new FormaPago();
        formaPago.setDescripcion("Efectivo");
        repositorioFormaPago.save(formaPago);

        Mesa m1 = new Mesa();
        m1.setNumeroMesa(1);
        repositorioMesa.save(m1);
    }

    @Test
    public void testCrearPedidoPositivo(){
        //GIVEN
        Cliente cliente = repositorioCliente.findAll().get(0);
        Mesa mesa = repositorioMesa.findAll().get(0);
        FormaPago formaPago = repositorioFormaPago.findAll().get(0);

        Pedido p1 = new Pedido();
        p1.setCliente(cliente);
        p1.setMesa(mesa);
        p1.setEstado("En proceso");
        p1.setFormaPago(formaPago);
        p1.setTotalFinal(100.0);
        p1.setFechaCreacion(LocalDate.now());
        p1.setFechaActualizacion(LocalDate.now());
        p1.setFechaPedido(LocalDate.now());
        p1.setHoraEntrega("12:00");
        p1.setTiempoPreparacion("30 minutos");

        //WHEN
        //THEN
        assertEquals(p1, servicioPedido.crearPedido(p1));
    }

    @Test
    public void testCrearPedidoNegativo(){
        //GIVEN
        Cliente cliente = repositorioCliente.findAll().get(0);
        Mesa mesa = repositorioMesa.findAll().get(0);
        FormaPago formaPago = repositorioFormaPago.findAll().get(0);

        Pedido p1 = new Pedido();
        p1.setCliente(cliente);
        p1.setMesa(mesa);
        p1.setEstado("En proceso");
        p1.setFormaPago(formaPago);
        p1.setTotalFinal(-100.0);
        p1.setFechaCreacion(LocalDate.now());
        p1.setFechaActualizacion(LocalDate.now());
        p1.setFechaPedido(LocalDate.now());
        p1.setHoraEntrega("12:00");
        p1.setTiempoPreparacion("30 minutos");

        //WHEN
        //THEN
        Exception exception = assertThrows(Exception.class, ()-> servicioPedido.crearPedido(p1));
        assertEquals("El total del pedido no puede ser negativo.", exception.getMessage());
    }

    @Test
    public void testContarPedidosPorClientePositivo(){
        //GIVEN
        Cliente cliente = repositorioCliente.findAll().get(0);
        Mesa mesa = repositorioMesa.findAll().get(0);
        FormaPago formaPago = repositorioFormaPago.findAll().get(0);

        Pedido p1 = new Pedido();
        p1.setCliente(cliente);
        p1.setMesa(mesa);
        p1.setEstado("En proceso");
        p1.setFormaPago(formaPago);
        p1.setTotalFinal(100.0);
        p1.setFechaCreacion(LocalDate.now());
        p1.setFechaActualizacion(LocalDate.now());
        p1.setFechaPedido(LocalDate.now());
        p1.setHoraEntrega("12:00");
        p1.setTiempoPreparacion("30 minutos");
        servicioPedido.crearPedido(p1);

        //WHEN
        //THEN
        assertEquals(1, servicioPedido.contarPedidosPorCliente(cliente.getId()));
    }

    @Test
    public void testContarPedidosPorClienteNegativo(){
        //GIVEN
        //WHEN
        //THEN
        Exception exception = assertThrows(Exception.class, ()-> servicioPedido.contarPedidosPorCliente(3));
        assertEquals("El cliente no existe", exception.getMessage());
    }
}
