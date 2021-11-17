package com.company.lw6.example2;

/* Т.к. класс содержит только статические методы и не подразумевает
создание объектов, используется ключевое слово final и единственный
private конструктор*/
final class Counter {
    private static int counter = 0;

    private Counter() {}

    /**
     * Вывод значения с последующим инкриминированием.
     */
    public static void printCounter() {
        System.out.println("Счётчик сейчас равен " + counter);
        counter++;
    }
}
