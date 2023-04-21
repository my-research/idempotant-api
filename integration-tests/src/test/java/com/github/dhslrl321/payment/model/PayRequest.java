package com.github.dhslrl321.payment.model;


import lombok.Value;

@Value(staticConstructor = "of")
public class PayRequest {
    long orderId;
    long userId;
    long amount;
}
