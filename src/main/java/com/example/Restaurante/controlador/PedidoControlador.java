package com.example.Restaurante.controlador;

import com.example.Restaurante.dto.PedidoDTO;
import com.example.Restaurante.services.PedidoServicio;
import com.example.Restaurante.services.PedidoDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoControlador {

    @Autowired
    private PedidoDetalleServicio pedidoDetalleServicio;

    @Autowired
    private PedidoServicio pedidoServicio;

    @GetMapping("/cuenta")
    public double obtenerTotalPedido(@RequestParam Integer id) {
        return pedidoDetalleServicio.calcularTotalPedido(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        try {
            pedidoServicio.crearPedido(pedidoDTO);
            return ResponseEntity.ok("Pedido creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el pedido: " + e.getMessage());
        }
    }
}