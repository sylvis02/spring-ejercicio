package com.spring.rest.springrest.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;

    public AppException(Integer code, String message) {
        this.code = code;
        this.message = message;

    }

}
