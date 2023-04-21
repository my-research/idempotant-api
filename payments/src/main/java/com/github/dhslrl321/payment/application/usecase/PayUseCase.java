package com.github.dhslrl321.payment.application.usecase;

import com.github.dhslrl321.payment.application.exception.PayFailedException;
import com.github.dhslrl321.payment.application.exception.PaymentAlreadyExistsException;

public interface PayUseCase {
    PayResult pay(long orderId, long userId, long amount)
            throws
            PaymentAlreadyExistsException,
            PayFailedException;
}
