package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido_item")
@Getter
@Setter
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "produto_id")
    private Long produtoId;
}
