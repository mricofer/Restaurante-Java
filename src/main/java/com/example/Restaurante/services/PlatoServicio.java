package com.example.Restaurante.services;

import com.example.Restaurante.dto.PlatoDTO;
import com.example.Restaurante.models.Plato;
import com.example.Restaurante.repositories.CartaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServicio {
    @Autowired
    private CartaRepositorio cartaRepositorio;

}
