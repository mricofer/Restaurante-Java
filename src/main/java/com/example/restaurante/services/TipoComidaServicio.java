package com.example.restaurante.services;

import com.example.restaurante.repositories.TipoComidaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoComidaServicio {
    @Autowired
    private TipoComidaRepositorio tipoComidaRepositorio;
}
