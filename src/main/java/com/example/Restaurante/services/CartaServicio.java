package com.example.Restaurante.services;

import com.example.Restaurante.models.Carta;
import com.example.Restaurante.repositories.CartaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaServicio {

    @Autowired
    private CartaRepositorio cartaRepositorio;

    public List<Carta> getCarta() {
        return cartaRepositorio.findAll();
    }

    public List<Carta> getCartaByIdTipoComida(Integer idTipoComida) {
        return cartaRepositorio.findAll().stream().filter(carta -> carta.getTipoComidaId().equals(idTipoComida)).collect(Collectors.toList());
    }

    @Transactional
    public Carta modificarPrecio(Integer platoId, Double nuevoPrecio) {
        Carta carta = cartaRepositorio.findFirstByPlatoId(platoId);

        if (nuevoPrecio < 0){
            throw new RuntimeException("El precio no puede ser negativo.");
        }
        try{
            carta.setPrecioTotal(nuevoPrecio);
            cartaRepositorio.save(carta);
            return carta;
        } catch (Exception e){
            throw new RuntimeException("El producto no se encontró.");
        }
    }
}
