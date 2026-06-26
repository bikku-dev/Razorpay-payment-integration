package com.payment.service;

import com.payment.dto.PaymentResponse;
import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;
import com.razorpay.*;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl
        implements PaymentService {

    private final PaymentRepository repository;

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    @Override
    public PaymentResponse createOrder() {

        try {

            RazorpayClient client =
                    new RazorpayClient(
                            keyId,
                            keySecret
                    );

            JSONObject options =
                    new JSONObject();

            options.put("amount", 100);
            options.put("currency", "INR");
            options.put("receipt", "receipt_1");

            Order order =
                    client.orders.create(options);

            Payment payment =
                    new Payment();

            payment.setOrderId(
                    order.get("id")
                            .toString());

            payment.setAmount(100);

            payment.setStatus("CREATED");

            repository.save(payment);

            return new PaymentResponse(
                    order.get("id").toString(),
                    100
            );

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}