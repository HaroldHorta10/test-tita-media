package com.test.titamedia.titamediatest.shared.exceptions;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class ValidationException extends Exception implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    private final List<ValidationError> validationErrors;

    public ValidationException(String message,
                               List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

}
