package com.test.titamedia.titamediatest.shared.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundPersistenceException extends Exception{

    private static final long serialVersionUID = -574949957948141432L;

    private final HttpStatus statusCode;

    public DataNotFoundPersistenceException(HttpStatus statusCode) {
        super();
        this.statusCode = statusCode;
    }

    public DataNotFoundPersistenceException(HttpStatus statusCode, String message,
                                            Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }

    public DataNotFoundPersistenceException(HttpStatus statusCode, String message,
                                            Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public DataNotFoundPersistenceException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public DataNotFoundPersistenceException(HttpStatus statusCode, Throwable cause) {
        super(cause);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

}
