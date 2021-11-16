package com.company.lw5.example2;

public class Main {
    public static void main(String[] args) {
        final char FROM = 'Z', TO = 'A';
        var range = new CharRange(FROM, TO);

        range.printSequence();
    }
}
