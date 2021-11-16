package com.company.lw5.example1;

public class Main {
    public static void main(String[] args) {
        final char CHAR_1 = 'A', CHAR_2 = 'Q';

        // Инициализация с помощью конструктора
        var field = new CharField(CHAR_1);

        // Получение значения закрытого поля, с помощью геттера
        System.out.println("Получение значения поля: " + field.getValue());

        // Изменение значения закрытого поля с помощью сеттера
        field.setValue(CHAR_2);

        // Вывод значения в консоль с помощью метода экземпляра класса
        System.out.print("\n\rНовое значение поля: ");
        field.printField();
        System.out.println();
    }
}
