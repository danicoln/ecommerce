package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_rastreio")
    private String numeroRastreio;

    @Column(name = "quantidade_total")
    private int quantidadeTotal;

    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    @Column(name = "status")
    private String status;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private Date dataAtualizacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<ItemPedido> itensPedidos = new HashSet<>();

    public void adicionar(ItemPedido item){

        if(item != null) {
            if(itensPedidos == null) {
                itensPedidos = new HashSet<>();
            }

            itensPedidos.add(item);
            item.setPedido(this);
        }
    }
}
