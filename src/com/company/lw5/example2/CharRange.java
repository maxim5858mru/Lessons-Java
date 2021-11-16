package com.company.lw5.example2;

import java.util.Objects;

class CharRange {
    private char from, to;

    public CharRange(char from, char to) {
        this.from = from;
        this.to = to;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    /**
     * Вывод последовательности символов, согласно указанному
     * диапазону.
     *
     * @return Выводимый массив символов.
     */
    public char[] printSequence() {
        String array = "";
        String result = "[ ";

        // Вывод может осуществляться как от 'A' до 'Z', так и в обратную сторону
        if (from <= to) {
            for (int i = from; i <= to; i++) {
                result += String.format("'%s'; ", (char) i);
                array += (char) i;
            }
        } else {
            for (int i = from; i >= to; i--) {
                result += String.format("'%s'; ", (char) i);
                array += (char) i;
            }
        }
        result += "]";

        System.out.println(result);
        return array.toCharArray();
    }

    @Override
    public String toString() {
        return String.format("['%%', '%%']");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharRange range = (CharRange) o;
        return from == range.from && to == range.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
