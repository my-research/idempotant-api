package com.github.dhslrl321.payment.presenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayRequest {
    private long orderId;
    private long userId;
    private long amount;
}
