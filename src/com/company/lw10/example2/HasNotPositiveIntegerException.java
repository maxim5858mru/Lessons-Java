package com.company.lw10.example2;

public class HasNotPositiveIntegerException extends RuntimeException {
    private int[] causeArray = null;

    public HasNotPositiveIntegerException() {
        super();
    }

    public HasNotPositiveIntegerException(int[] causeArray) {
        super();
        this.causeArray = causeArray;
    }

    public HasNotPositiveIntegerException(String message) {
        super(message);
    }
}
