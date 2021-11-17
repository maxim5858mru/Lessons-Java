package com.company.lw6.example1;

import java.util.Objects;

class CharStringField {
    private String text;
    private Character symbol;

    public CharStringField(char symbol) {
        set(symbol);
    }

    public CharStringField(String text) {
        set(text);
    }

    public CharStringField(char symbol, String text) {
        this.symbol = symbol;
        this.text = text;
    }

    public CharStringField(char[] array) {
        set(array);
    }

    /**
     * Метод для присваивания значения символьному полю.
     *
     * @param symbol Присваиваемый полю символ.
     */
    public void set(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Метод для присваивания значения строковому полю.
     *
     * @param text Присваиваемая полю строка.
     */
    public void set(String text) {
        this.text = text;
    }

    /**
     * Метод присваивающий значение полю по массиву.
     * Если массив имеет только 1 элемент, то он будет
     * присвоен символьному полю. В случае, если массив
     * имеет более одного символа, значение присваивается
     * текстовому полю.
     *
     * @param array Массив с символом(ми).
     */
    public void set(char[] array) {
        if (array.length == 0) return;
        else if (array.length == 1) set(array[0]);
        else set(new String(array));
    }

    public char getSymbol() {
        return symbol;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return String.format("{'%s'; \"%s\"}",
                (symbol == null) ? "NULL" : symbol,
                (text == null) ? "NULL" : text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharStringField that = (CharStringField) o;
        return Objects.equals(text, that.text) && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, symbol);
    }
}
