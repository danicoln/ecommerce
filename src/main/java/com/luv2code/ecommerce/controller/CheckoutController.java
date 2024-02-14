package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.Compra;
import com.luv2code.ecommerce.dto.CompraResponse;
import com.luv2code.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/compra")
    public CompraResponse realizarPedido(@RequestBody Compra compra){

        CompraResponse compraResponse = checkoutService.realizarPedido(compra);

        return compraResponse;
    }

}
