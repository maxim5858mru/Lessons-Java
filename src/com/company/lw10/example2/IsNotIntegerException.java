package com.company.lw10.example2;

public class IsNotIntegerException extends RuntimeException {
    public IsNotIntegerException() {
        super();
    }

    public IsNotIntegerException(String message) {
        super(message);
    }
}
