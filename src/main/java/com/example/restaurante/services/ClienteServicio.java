package com.example.restaurante.services;

import com.example.restaurante.models.Cliente;
import com.example.restaurante.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    /**
     * Buscar clientes por id
     *
     * @param id
     * @return
     */

    public Cliente getClienteById(Integer id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    /**
     * Buscar todos los clientes
     *
     * @return
     */

    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    /**
     * Crear un cliente o modificar uno existente
     *
     * @param cliente
     * @return
     */

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    /**
     * Eliminar un cliente
     */

    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }

    /**
     * Eliminar un cliente por id
     *
     * @param id
     */

    public void eliminarClienteById(Integer id) {
        clienteRepositorio.deleteById(id);
    }
}

