package com.github.dhslrl321.payment.model;


import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PayResponse {
    private long orderId;
    private long userId;
    private long paidAmount;
    private LocalDateTime paidAt;
}
