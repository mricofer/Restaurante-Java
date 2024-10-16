package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "mesa", schema = "restaurante", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Mesa {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_mesa")
    private Integer numeroMesa;
}