package com.example.Restaurante.controlador;

import com.example.Restaurante.models.Cliente;
import com.example.Restaurante.services.ClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor

public class ClienteControlador {
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Cliente> getClientes() {
        List<Cliente> clientes = clienteServicio.getClientes();
        return clientes;
    }

    @GetMapping("/byId")
    public Cliente getClienteById(Integer id) {
        return clienteServicio.getClienteById(id);
    }


}
