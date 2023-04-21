package com.github.dhslrl321.payment.presenter;

import com.github.dhslrl321.payment.application.exception.PayFailedException;
import com.github.dhslrl321.payment.application.exception.PaymentAlreadyExistsException;
import com.github.dhslrl321.payment.application.usecase.PayResult;
import com.github.dhslrl321.payment.application.usecase.PayService;
import com.github.dhslrl321.payment.domain.PaymentRepository;
import com.github.dhslrl321.payment.presenter.model.ExceptionResponse;
import com.github.dhslrl321.payment.presenter.model.PayRequest;
import com.github.dhslrl321.payment.presenter.model.PayResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RestControllerAdvice
@RequiredArgsConstructor
public class PayController {

    private final PayService service;

    @ExceptionHandler(PaymentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> paymentAlreadyExists() {
        return ResponseEntity
                .status(CONFLICT)
                .body(ExceptionResponse.of("이미 결제 처리가 완료되었습니다"));
    }

    @ExceptionHandler(PayFailedException.class)
    public ResponseEntity<ExceptionResponse> payFailed() {
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.of("외부 vendor 로 결제 요청에 실패하였습니다"));
    }

    @PostMapping("/payments")
    @SneakyThrows
    public ResponseEntity<PayResponse> pay(@RequestBody PayRequest body) {
        PayResult result = service.pay(body.getOrderId(), body.getUserId(), body.getAmount());
        return ResponseEntity.ok(getBody(result));
    }

    private static PayResponse getBody(PayResult result) {
        return new PayResponse(result.getOrderId(), result.getUserId(), result.getPaidAmount(), result.getPaidAt());
    }
}
