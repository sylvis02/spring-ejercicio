package com.spring.rest.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AppException.class})
    public ResponseEntity<ResponseException> handleException(AppException e) {
        ResponseException responseException = new ResponseException(e.getCode(), e.getMessage());
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ResponseException> handleException(IllegalArgumentException e) {
        ResponseException responseException = new ResponseException(500, e.getMessage());
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
