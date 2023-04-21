package com.github.dhslrl321.payment;

import com.github.dhslrl321.payment.model.PayRequest;
import com.github.dhslrl321.payment.model.PayResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

class PayTest {

    RestTemplate restTemplate = new RestTemplate();

    private static final String PAY_URL = "http://localhost:8080/payments";

    @Test
    @DisplayName("동기 요청에 대해서 멱등한 api 제공")
    void test() {
        PayRequest requestBody = PayRequest.of(98765, 1004, 9900);
        ResponseEntity<PayResponse> actual = restTemplate.postForEntity(PAY_URL, requestBody, PayResponse.class);

        System.out.println("actual = " + actual);
    }

    @Test
    @DisplayName("비동기 요청에 대해서 멱등한 api 제공")
    void test2() {
        PayRequest requestBody = PayRequest.of(98765, 1004, 9900);
        ResponseEntity<PayResponse> actual = restTemplate.postForEntity(PAY_URL, requestBody, PayResponse.class);

        System.out.println("actual = " + actual);
    }
}
