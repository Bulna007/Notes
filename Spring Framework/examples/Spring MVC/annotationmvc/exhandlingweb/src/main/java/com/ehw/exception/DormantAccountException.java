package com.ehw.exception;

public class DormantAccountException extends RuntimeException {
    public DormantAccountException(String message) {
        super(message);
    }
}
