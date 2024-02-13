package com.luv2code.ecommerce.dto;

import com.luv2code.ecommerce.entity.Cliente;
import com.luv2code.ecommerce.entity.Endereco;
import com.luv2code.ecommerce.entity.ItemPedido;
import com.luv2code.ecommerce.entity.Pedido;
import lombok.Data;

import java.util.Set;

@Data
public class Compra {

    private Cliente cliente;
    private Endereco enderecoEntrega;
    private Endereco enderecoCobranca;
    private Pedido pedido;
    private Set<ItemPedido> itemPedidos;
}
