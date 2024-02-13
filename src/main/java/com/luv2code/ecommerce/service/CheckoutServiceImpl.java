package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ClienteRepository;
import com.luv2code.ecommerce.dto.Compra;
import com.luv2code.ecommerce.dto.CompraResponse;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private ClienteRepository clienteRepository;

    public CheckoutServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public CompraResponse realizarPedido(Compra compra) {
        return null;
    }
}
