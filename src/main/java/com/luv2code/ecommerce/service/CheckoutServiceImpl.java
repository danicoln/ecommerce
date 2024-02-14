package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ClienteRepository;
import com.luv2code.ecommerce.dto.Compra;
import com.luv2code.ecommerce.dto.CompraResponse;
import com.luv2code.ecommerce.entity.Cliente;
import com.luv2code.ecommerce.entity.ItemPedido;
import com.luv2code.ecommerce.entity.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private ClienteRepository clienteRepository;

    public CheckoutServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public CompraResponse realizarPedido(Compra compra) {

        //recuperar as informações do pedido do dto
        Pedido pedido = compra.getPedido();

        //gerar o numero de rastreio
        String rastreioPedido = generateRastreioPedido();
        pedido.setNumeroRastreio(rastreioPedido);

        //popular o pedido com item-pedidos
        Set<ItemPedido> itensPedidos = compra.getItemPedidos();
        itensPedidos.forEach(item -> pedido.adicionar(item));

        //popular o pedido com os enderecos de entrega e cobranca
        pedido.setEnderecoCobranca(compra.getEnderecoCobranca());
        pedido.setEnderecoEntrega(compra.getEnderecoEntrega());

        //popular cliente com pedido
        Cliente cliente = compra.getCliente();

        //salvar no banco de dados
        clienteRepository.save(cliente);

        //retornar uma resposta
        return new CompraResponse(rastreioPedido);
    }

    private String generateRastreioPedido() {

        // gerar um numero UUID aleatório (UUID version-4)
        return UUID.randomUUID().toString();
    }
}
