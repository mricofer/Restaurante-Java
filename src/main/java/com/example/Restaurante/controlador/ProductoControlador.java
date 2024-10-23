package com.example.Restaurante.controlador;

import com.example.Restaurante.dto.ModificarPrecioDTO;
import com.example.Restaurante.services.CartaServicio;
import com.example.Restaurante.services.PedidoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductoControlador {

    @Autowired
    private CartaServicio cartaServicio;
    @PostMapping("/producto/formato")
    public ResponseEntity<String> modificarPrecio(@RequestBody ModificarPrecioDTO modificarPrecioDTO) {
        // lógica para modificar el precio
        try {
            // Se asume que el método modificarPrecio de CartaServicio solo necesita el platoId y nuevoPrecio
            cartaServicio.modificarPrecio(modificarPrecioDTO.getPlatoId(), modificarPrecioDTO.getNuevoPrecio());
            return ResponseEntity.ok("Precio modificado con éxito.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
