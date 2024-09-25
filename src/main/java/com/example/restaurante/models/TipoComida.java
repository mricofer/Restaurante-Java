package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipo_comida", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class TipoComida {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column(name = "factor_precio")
    private Double factorPrecio;
}
