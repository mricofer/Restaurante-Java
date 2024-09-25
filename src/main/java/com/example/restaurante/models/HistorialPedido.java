package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial_pedido", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class HistorialPedido {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    //AÑADIR FK
}
