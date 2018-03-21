package com.phenix.study.exception;

public class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message, new Throwable(message));
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}
