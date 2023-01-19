package com.sunway.cms.exception;

public class OrderFlowException extends RuntimeException{


    public OrderFlowException(String message) {
        super(message);
    }

    public OrderFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
