package com.company.lw5.example5;

import java.util.Objects;

public class IntField {
    private int value;
    private boolean isOverflow = false;

    public IntField() {
        value = 0;
    }

    public IntField(int value) {
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value > 100) {
            this.value = 100;
            isOverflow = true;
        } else {
            this.value = value;
            isOverflow = false;
        }
    }

    public boolean isOverflow() {
        return isOverflow;
    }

    @Override
    public String toString() {
        return (isOverflow) ? "+" : "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntField intField = (IntField) o;
        return value == intField.value && isOverflow == intField.isOverflow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isOverflow);
    }
}
