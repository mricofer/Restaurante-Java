package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_detalles", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class PedidoDetalles {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "coste")
    private Double coste;

    @Column(name = "comentarios")
    private String comentarios;
}
