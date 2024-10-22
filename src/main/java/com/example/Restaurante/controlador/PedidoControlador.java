package com.example.Restaurante.controlador;

import com.example.Restaurante.services.PedidoDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoControlador {

    @Autowired
    private PedidoDetalleServicio pedidoService;

    @GetMapping("/cuenta")
    public double obtenerTotalPedido(@RequestParam Integer id) {
        return pedidoService.calcularTotalPedido(id);
    }
}