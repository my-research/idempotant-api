package com.github.dhslrl321.payment.application.client;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VendorPayRequestClient {
    public VendorPayResult requestPay(long orderId, long customerKey, long amount) {
        paymentProcessing();
        return VendorPayResult.of(true, LocalDateTime.now());
    }

    private static void paymentProcessing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
