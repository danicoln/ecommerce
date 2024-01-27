package com.luv2code.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    private Long id;
    private String sku;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String imagemUrl;
    private boolean ativo;
    private int emEstoque;
    private Date dataCriacao;
    private Date dataAtualizacao;
}
