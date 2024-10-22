package com.example.Restaurante.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer clienteId;
    private Integer mesaId;
    private List<ProductoPedidoDTO> productos;
    private Integer formaPagoId;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductoPedidoDTO {
        private Integer platoId;
        private Integer tipoComidaId;
        private Integer cantidad;
    }
}
