package com.example.shirojwt2.exception;

public class TokenErrorException extends RuntimeException {

    public TokenErrorException() {
        super();
    }

    public TokenErrorException(String message) {
        super(message);
    }

    public TokenErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenErrorException(Throwable cause) {
        super(cause);
    }

    protected TokenErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
