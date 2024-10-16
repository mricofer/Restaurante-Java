package com.example.Restaurante.controlador;

import com.example.Restaurante.models.Mesa;
import com.example.Restaurante.services.MesaServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@AllArgsConstructor

public class MesaControlador {
    private MesaServicio mesaServicio;
    @GetMapping("/all")
    public List<Mesa> getMesas() {
        List<Mesa> mesas = mesaServicio.getMesas();
        return mesas;
    }
}
