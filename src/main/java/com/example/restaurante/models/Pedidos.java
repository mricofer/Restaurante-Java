package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pedidos", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Pedidos {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "estado")
    private String estado;

    @Column(name= "total_final")
    private Double totalFinal;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Column(name = "hora_entrega")
    private String horaEntrega;

    @Column(name = "tiempo_preparacion")
    private String tiempoPreparacion;

    // AÑADIR FK
}
