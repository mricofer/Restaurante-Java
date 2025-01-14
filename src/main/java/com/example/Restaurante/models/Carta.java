package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comida_tipo_precio", schema = "restaurante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_plato")
    private Integer platoId;

    @Column(name = "id_tipo_comida")
    private Integer tipoComidaId;

    @Column(name = "precio_total")
    private Double precioTotal;
}
