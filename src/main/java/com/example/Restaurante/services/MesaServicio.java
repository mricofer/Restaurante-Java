package com.example.Restaurante.services;

import com.example.Restaurante.models.Mesa;
import com.example.Restaurante.repositories.MesaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServicio {
    @Autowired
    private MesaRepositorio mesaRepositorio;

    /**
     * Buscar mesas por id
     *
     * @param id
     * @return
     */

    public Mesa getMesaById(Integer id) {
        return mesaRepositorio.findById(id).orElse(null);
    }

    /**
     * Buscar todas las mesas
     *
     * @return
     */

    public List<Mesa> getMesas() {
        return mesaRepositorio.findAll();
    }

    /**
     * Crear una mesa o modificar una existente
     *
     * @param mesa
     * @return
     */

    public Mesa crearMesa(Mesa mesa) {
        return mesaRepositorio.save(mesa);
    }

    /**
     * Eliminar una mesa
     */

    public void eliminarMesa(Mesa mesa) {
        mesaRepositorio.delete(mesa);
    }

    /**
     * Eliminar una mesa por id
     *
     * @param id
     */

    public void eliminarMesaById(Integer id) {
        mesaRepositorio.deleteById(id);
    }
}
