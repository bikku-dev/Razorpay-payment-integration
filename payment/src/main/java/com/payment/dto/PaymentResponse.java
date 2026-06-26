package com.payment.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    private String orderId;
    private Integer amount;
}