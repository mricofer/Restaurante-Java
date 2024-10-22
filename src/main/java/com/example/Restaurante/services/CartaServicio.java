package com.example.Restaurante.services;

import com.example.Restaurante.models.Carta;
import com.example.Restaurante.repositories.CartaRepositorio;
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
}