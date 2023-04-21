package com.github.dhslrl321.payment.support;

import org.junit.jupiter.api.Test;

import java.time.Instant;

class TimeBasedIdGeneratorTest {

    @Test
    void name() {
        System.out.println("gen = " + TimeBasedIdGenerator.gen());
    }
}