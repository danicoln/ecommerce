package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dto.Compra;
import com.luv2code.ecommerce.dto.CompraResponse;

public interface CheckoutService {

    CompraResponse realizarPedido(Compra compra);
}
