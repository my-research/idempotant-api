package com.github.dhslrl321.payment.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Payment {

    public static Payment newInstance(long id, long userId, long orderId) {
        return new Payment(id, userId, orderId);
    }

    private Payment(long id, long userId, long orderId) {
        this.id = id;
        this.userId = userId;
        this.orderId = orderId;
        this.status = "CREATED";
    }

    private final long id;
    private final long userId;
    private final long orderId;
    private String status;
    private long paidAmount;
    private LocalDateTime paidAt;

    public void paid(long amount, LocalDateTime paidAt) {
        this.paidAmount = amount;
        this.paidAt = paidAt;

        this.status = "PAID";
    }

    public void failed() {
        this.status = "FAILED";
    }
}
