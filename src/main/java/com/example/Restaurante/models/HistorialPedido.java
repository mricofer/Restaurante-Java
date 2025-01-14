package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial_pedido", schema = "restaurante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HistorialPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_cambio")
    private LocalDate fechaCambio;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}