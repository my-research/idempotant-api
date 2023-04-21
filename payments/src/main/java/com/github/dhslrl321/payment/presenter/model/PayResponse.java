package com.github.dhslrl321.payment.presenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PayResponse {
    long orderId;
    long userId;
    long paidAmount;
    LocalDateTime paidAt;
}
