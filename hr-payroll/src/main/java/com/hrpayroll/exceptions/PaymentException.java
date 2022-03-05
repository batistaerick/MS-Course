package com.hrpayroll.exceptions;

public class PaymentException extends RuntimeException {
    public PaymentException(String msg) {
        super(msg);
    }
}
