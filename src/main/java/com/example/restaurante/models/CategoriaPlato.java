package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categoria_plato", schema = "Sabores de Casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class CategoriaPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaPlato", fetch = FetchType.LAZY)
    private Set<Platos> platos;
}
