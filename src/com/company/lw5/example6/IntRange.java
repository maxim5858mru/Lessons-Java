package com.company.lw5.example6;

import java.util.Objects;

public class IntRange {
    private int min, max;

    public IntRange(int a, int b) {
        change(a, b);
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void change(int a, int b) {
        if (a <= b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
    }

    public void print() {
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", min, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntRange intRange = (IntRange) o;
        return min == intRange.min && max == intRange.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
