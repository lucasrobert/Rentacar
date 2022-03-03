package com.myhotel.rentacar.infraestructure.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class ApiResponseException extends ResponseStatusException {
    protected List<ErrorDetails> errors = new ArrayList();

    public ApiResponseException(HttpStatus status) {
        super(status);
    }

    public ApiResponseException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public ApiResponseException addError(ErrorDetails error) {
        this.errors.add(error);
        return this;
    }

    public ApiResponseException addErrors(List<ErrorDetails> errors) {
        this.errors.addAll(errors);
        return this;
    }

    public List<ErrorDetails> getErrors() {
        return new ArrayList(this.errors);
    }
}