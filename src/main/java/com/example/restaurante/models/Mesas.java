package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mesas", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Mesas {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_mesa")
    private Integer numeroMesa;
}
