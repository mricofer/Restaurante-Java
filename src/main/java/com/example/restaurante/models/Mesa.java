package com.example.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "mesas", schema = "Sabores de Casa", catalog = "postgres")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesas", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;
}
