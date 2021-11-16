package com.company.lw5.example4;

import java.util.Objects;

public class IntCharFields {
    private int number;
    private char symbol;

    public IntCharFields(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public IntCharFields(double data) {
        number = (int) data;
        symbol = (char) (int) (data % 1 * 100);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("{'%s', %d}", symbol, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntCharFields that = (IntCharFields) o;
        return number == that.number && symbol == that.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, symbol);
    }
}
