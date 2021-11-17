package com.company.lw6.example1;

public class Main {
    public static void main(String[] args) {
        final char[] ARRAY_1 = new char[]{'H', 'i', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
        final char[] ARRAY_2 = new char[]{'H'};
        final char SYMBOL = 'Z';
        final String TEXT = "Hello World!";
        CharStringField object;

        // Инициализация по символьному массиву с length > 1
        object = new CharStringField(ARRAY_1);
        System.out.println("Инициализация по массиву " +
                "{'H', 'i', ' ', 'W', 'o', 'r', 'l', 'd', '!'}: " + object);

        // Вызов метода изменения поля по массиву с length == 1
        object.set(ARRAY_2);
        System.out.println("Изменение значения поля по массиву {'H'}:" + object);

        // Вызов метода изменения поля по символу
        object.set(SYMBOL);
        System.out.println("Изменение значения поля символа на 'Z': " + object);

        // Вызов метода изменения поля по строке
        object.set(TEXT);
        System.out.println("Изменение значения текстового поля: " + object);
    }
}
