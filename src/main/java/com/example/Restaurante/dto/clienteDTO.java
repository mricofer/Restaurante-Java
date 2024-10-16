package com.example.Restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class clienteDTO {
    private int id;
    private String nombreCliente;
    private String esFrecuente;
    private String direccion;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    private String fechaRegistro;
}
