package com.github.dhslrl321.payment.application.client;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class VendorPayResult {
    boolean isSuccess;
    LocalDateTime paidAt;
}
