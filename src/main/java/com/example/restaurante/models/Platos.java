package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "platos", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Platos {
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

    // AÑADIR FK

}
