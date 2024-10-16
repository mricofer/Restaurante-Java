package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pedido_detalles", schema = "restaurante", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PedidoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "coste")
    private Double coste;

    @Column(name = "comentarios")
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_plato")
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comida")
    private TipoComida tipoComida;
}