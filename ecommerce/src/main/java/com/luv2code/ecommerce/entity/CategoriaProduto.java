package com.luv2code.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categoria_produto")
@Getter
@Setter
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_categoria")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Set<Produto> produtos;
}
