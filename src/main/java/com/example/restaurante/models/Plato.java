package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "platos", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Plato {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_plato")
    private String nombrePlato;

    @Column(name = "precio_base")
    private Double precioBase;

    @Column(name = "ingrediente")
    private String ingrediente;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platos", fetch = FetchType.LAZY)
    private Set<PedidoDetalles> pedidoDetalles;
}
