package com.example.restaurante.services;

import com.example.restaurante.models.CategoriaPlato;
import com.example.restaurante.repositories.CategoriaPlatoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaPlatoServicio {
    @Autowired
    private CategoriaPlatoRepositorio categoriaPlatoRepositorio;

    /**
     * Buscar categorias de platos por id
     *
     * @param id
     * @return
     */

    public CategoriaPlato getCategoriaPlatoById(Integer id) {
        return categoriaPlatoRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear una categoria de plato o modificar una existente
     *
     * @param categoriaPlato
     * @return
     */

    public CategoriaPlato crearCategoriaPlato(CategoriaPlato categoriaPlato) {
        return categoriaPlatoRepositorio.save(categoriaPlato);
    }

    /**
     * Eliminar una categoria de plato
     */

    public void eliminarCategoriaPlato(CategoriaPlato categoriaPlato) {
        categoriaPlatoRepositorio.delete(categoriaPlato);
    }

    /**
     * Eliminar una categoria de plato por id
     *
     * @param id
     */

    public void eliminarCategoriaPlatoById(Integer id) {
        categoriaPlatoRepositorio.deleteById(id);
    }

}
