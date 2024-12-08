package com.train.app.model.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
public class AppException extends RuntimeException {

    private final ExceptionResponses applicationError;

    private final String messageParameter;
}
