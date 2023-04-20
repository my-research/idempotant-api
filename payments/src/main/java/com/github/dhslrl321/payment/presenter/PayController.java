package com.github.dhslrl321.payment.presenter;

import com.github.dhslrl321.payment.presenter.model.PayRequest;
import com.github.dhslrl321.payment.presenter.model.PayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PayController {
    @PostMapping("/payments")
    public ResponseEntity<PayResponse> pay(@RequestBody PayRequest body) {
        return ResponseEntity.ok(null);
    }
}
