package com.github.dhslrl321.payment.presenter.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class ExceptionResponse {
    String reason;
}
