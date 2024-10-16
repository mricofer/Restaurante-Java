package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Table(name = "plato", schema = "restaurante", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_plato")
    private String nombrePlato;

    @Column(name = "precio_base")
    private Double precioBase;

    @Column(name = "ingrediente")
    private String ingrediente;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaPlato categoria;
}