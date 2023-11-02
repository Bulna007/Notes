package com.eh.exception;

public class SubscriptionNotActiveException extends RuntimeException {
    public SubscriptionNotActiveException() {
    }

    public SubscriptionNotActiveException(String message) {
        super(message);
    }

    public SubscriptionNotActiveException(String message, Throwable cause) {
        super(message, cause);
    }
}
