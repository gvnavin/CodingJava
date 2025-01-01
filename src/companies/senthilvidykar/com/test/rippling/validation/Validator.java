package com.test.rippling.validation;

import com.test.rippling.exceptions.ValidationException;

public class Validator {

    public static void isNotEmpty(String field, String value) {
        if(value == null || value.trim().isEmpty()) {
            throw new ValidationException(field);
        }
    }
}
