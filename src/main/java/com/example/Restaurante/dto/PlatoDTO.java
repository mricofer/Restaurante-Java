package com.example.Restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombrePlato;
    private Double precioBase;
}
