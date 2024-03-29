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
@Table(name = "pedidos")
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
    private Set<ItemPedido> itemPedidos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_entrega_id", referencedColumnName = "id")
    private Endereco enderecoEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_cobranca_id", referencedColumnName = "id")
    private Endereco enderecoCobranca;

    public void adicionar(ItemPedido item){

        if(item != null) {
            if(itemPedidos == null) {
                itemPedidos = new HashSet<>();
            }

            itemPedidos.add(item);
            item.setPedido(this);
        }
    }
}
