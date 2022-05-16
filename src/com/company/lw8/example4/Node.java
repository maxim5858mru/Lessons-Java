package com.company.lw8.example4;

/**
 * Класс Node - структура элемента списка
 */
class Node {
    public int value; // Значение
    public Node next; // Поле: ссылка на следующий узел

    /**
     * Конструктор класса Node - элемента списка
     */
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
