package com.github.dhslrl321.payment.application.usecase;

import com.github.dhslrl321.payment.application.client.VendorPayResult;
import com.github.dhslrl321.payment.application.client.VendorPayRequestClient;
import com.github.dhslrl321.payment.application.exception.PayFailedException;
import com.github.dhslrl321.payment.application.exception.PaymentAlreadyExistsException;
import com.github.dhslrl321.payment.domain.Payment;
import com.github.dhslrl321.payment.domain.PaymentRepository;
import com.github.dhslrl321.payment.support.TimeBasedIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PayService implements PayUseCase {

    private final VendorPayRequestClient client;
    private final PaymentRepository repository;

    @Override
    @Transactional
    public PayResult pay(long orderId, long userId, long amount) throws
            PaymentAlreadyExistsException,
            PayFailedException {

        validate(orderId, userId);

        Payment payment = Payment.newInstance(TimeBasedIdGenerator.gen(), userId, orderId);

        VendorPayResult result = client.requestPay(orderId, userId, amount);

        if (!result.isSuccess()) {
            onFail(payment);
        }
        onSuccess(amount, payment, result);
        return PayResult.of(orderId, userId, payment.getPaidAmount(), payment.getPaidAt());
    }

    private void validate(long orderId, long userId) throws PaymentAlreadyExistsException {
        if (repository.existBy(userId, orderId)) {
            throw new PaymentAlreadyExistsException();
        }
    }

    private void onFail(Payment payment) throws PayFailedException {
        payment.failed();
        repository.save(payment);
        throw new PayFailedException();
    }

    private void onSuccess(long amount, Payment payment, VendorPayResult result) {
        payment.paid(amount, result.getPaidAt());
        repository.save(payment);
    }
}
