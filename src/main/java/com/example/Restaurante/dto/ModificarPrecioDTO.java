package com.example.Restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModificarPrecioDTO {
    private Integer platoId;
    private Double nuevoPrecio;
}
