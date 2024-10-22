package com.example.Restaurante.controlador;

import com.example.Restaurante.models.Carta;
import com.example.Restaurante.services.CartaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartaControlador {

    @Autowired
    private CartaServicio cartaServicio;

    @GetMapping("/carta")
    public List<Carta> getCarta() {
        return cartaServicio.getCarta();
    }

    @GetMapping("/productoFormato")
    public List<Carta> getCartaByIdTipoComida(@RequestParam Integer idTipoComida) {
        return cartaServicio.getCartaByIdTipoComida(idTipoComida);
    }
}
