package com.test.rippling.exceptions;

public class ValidationException extends ApiException{

    public String field;
    public ValidationException(String prop) {
        this.field = prop;
    }
}
