package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tipo_comida", schema = "restaurante", catalog = "postgres")
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

    @Column(name = "tipo_nombre")
    private String tipoNombre;

    @Column(name = "factor_precio")
    private Double factorPrecio;

}
