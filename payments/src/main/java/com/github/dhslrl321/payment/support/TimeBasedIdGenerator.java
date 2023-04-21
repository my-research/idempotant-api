package com.github.dhslrl321.payment.support;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.stream.IntStream;

public class TimeBasedIdGenerator {
    private final static Random random = new Random();


    public static synchronized long gen() {
        return Long.parseLong(String.valueOf(Instant.now().toEpochMilli()) + random());
    }

    private static int random() {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, 5).forEach(i -> builder.append(random.nextInt(9)));
        return Integer.parseInt(builder.toString());
    }
}
