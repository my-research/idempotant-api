package com.github.dhslrl321.payment.persistence;

import com.github.dhslrl321.payment.domain.Payment;
import com.github.dhslrl321.payment.domain.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentRepositoryTest {

    @Autowired
    PaymentRepository sut;

    @Test
    void name() {
        assertThat(sut.existBy(2, 3)).isFalse();

        sut.save(Payment.newInstance(1, 2, 3));

        assertThat(sut.existBy(2, 3)).isTrue();
    }
}