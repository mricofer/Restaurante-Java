package com.example.Restaurante.services;

import com.example.Restaurante.models.PedidoDetalles;
import com.example.Restaurante.models.Plato;
import com.example.Restaurante.models.TipoComida;
import com.example.Restaurante.repositories.PedidoDetallesRepositorio;
import com.example.Restaurante.repositories.TipoComidaRepositorio;
import com.example.Restaurante.repositories.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoComidaServicio {
    @Autowired
    private TipoComidaRepositorio tipoComidaRepositorio;

    /**
     * Buscar tipos de comida por id
     *
     * @param id
     * @return
     */

    public TipoComida getTipoComidaById(Integer id) {
        return tipoComidaRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear un tipo de comida o modificar uno existente
     *
     * @param tipoComida
     * @return
     */

    public TipoComida crearTipoComida(TipoComida tipoComida) {
        return tipoComidaRepositorio.save(tipoComida);
    }

    /**
     * Eliminar un tipo de comida
     */

    public void eliminarTipoComida(TipoComida tipoComida) {
        tipoComidaRepositorio.delete(tipoComida);
    }

    /**
     * Eliminar un tipo de comida por id
     *
     * @param id
     */

    public void eliminarTipoComidaById(Integer id) {
        tipoComidaRepositorio.deleteById(id);
    }

    /**
     * Buscar todos los tipos de comida
     *
     * @return
     */

    public Iterable<TipoComida> getTiposComida() {
        return tipoComidaRepositorio.findAll();
    }

}
