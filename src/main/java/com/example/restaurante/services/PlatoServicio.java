package com.example.restaurante.services;

import com.example.restaurante.models.Plato;
import com.example.restaurante.repositories.PlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServicio {
    @Autowired
    private PlatoRepositorio platoRepositorio;

    /**
     * Buscar platos por id
     *
     * @param id
     * @return
     */

    public Plato getPlatoById(Integer id) {
        return platoRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear un plato o modificar uno existente
     *
     * @param plato
     * @return
     */

    public Plato crearPlato(Plato plato) {
        return platoRepositorio.save(plato);
    }

    /**
     * Eliminar un plato
     */

    public void eliminarPlato(Plato plato) {
        platoRepositorio.delete(plato);
    }

    /**
     * Eliminar un plato por id
     *
     * @param id
     */

    public void eliminarPlatoById(Integer id) {
        platoRepositorio.deleteById(id);
    }

    /**
     * Buscar todos los platos
     *
     * @return
     */

    public List<Plato> getPlatos() {
        return platoRepositorio.findAll();
    }
}
