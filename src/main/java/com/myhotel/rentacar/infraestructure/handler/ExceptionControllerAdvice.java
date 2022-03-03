package com.myhotel.rentacar.infraestructure.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(WebRequest webRequest, Exception exception) {
        return new ResponseEntityBuilder<>(HttpStatus.INTERNAL_SERVER_ERROR).addError(new ErrorDetails(exception)).build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> exception(WebRequest webRequest, DataIntegrityViolationException exception) {
        return new ResponseEntityBuilder<>(HttpStatus.BAD_REQUEST).addError(new ErrorDetails(exception.getCause().getCause().getMessage())).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> exception(WebRequest webRequest, HttpMessageNotReadableException exception) {
        return new ResponseEntityBuilder<>(HttpStatus.BAD_REQUEST).addError(new ErrorDetails(exception.getMessage())).build();
    }

    @ExceptionHandler(ApiResponseException.class)
    public ResponseEntity<?> apiException(WebRequest webRequest, ApiResponseException exception) {
        if (exception.getErrors().isEmpty()) {
            exception.addError(new ErrorDetails(exception.getReason()));
        }
        return new ResponseEntityBuilder<>(exception.getStatus()).headers(exception.getResponseHeaders()).errors(exception.getErrors()).build();
    }
}