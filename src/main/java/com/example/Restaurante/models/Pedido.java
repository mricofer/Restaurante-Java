package com.example.Restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pedidos", schema = "restaurante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;  // Deja que el id se genere automáticamente

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "estado")
    private String estado;

    @Column(name= "total_final")
    private Double totalFinal;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    @Column(name = "hora_entrega")
    private String horaEntrega;

    @Column(name = "tiempo_preparacion")
    private String tiempoPreparacion;



    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_forma_pago")
    private FormaPago formaPago;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

}