package com.github.dhslrl321.payment.application.usecase;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class PayResult {
    long orderId;
    long userId;
    long paidAmount;
    LocalDateTime paidAt;
}
