package com.payment.controller;

import com.payment.dto.PaymentResponse;
import com.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public PaymentResponse createOrder() {

        return paymentService.createOrder();
    }
}