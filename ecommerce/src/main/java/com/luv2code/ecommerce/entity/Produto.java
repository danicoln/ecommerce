package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produto")
@Data
@Getter
@Setter
public class Produto {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaProduto categoria;

    @Column(name = "sku")
    private String sku;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;

    @Column(name = "image_url")
    private String imagemUrl;

    @Column(name = "ativo")
    private boolean ativo;

    @Column(name = "em_estoque")
    private int emEstoque;

    @Column(name = "data_criacao")
    @CreationTimestamp
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private Date dataAtualizacao;
}
