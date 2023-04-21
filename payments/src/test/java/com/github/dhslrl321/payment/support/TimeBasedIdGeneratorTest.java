package com.github.dhslrl321.payment.support;

import org.junit.jupiter.api.Test;

import java.time.Instant;

class TimeBasedIdGeneratorTest {

    @Test
    void name() {
        long gen = TimeBasedIdGenerator.gen();

        System.out.println("gen = " + gen);
    }
}