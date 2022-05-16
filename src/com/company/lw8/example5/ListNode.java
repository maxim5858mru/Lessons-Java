package com.company.lw8.example5;

import java.util.Objects;

public class ListNode<T> {
    public T value;
    public ListNode next;

    /**
     * Конструктор для создания узла списка, без указания ссылки на следующий узел в списке
     *
     * @param value Значение узла списка
     */
    public ListNode(T value) {
        this.value = value;
    }

    /**
     * Конструктор для создания узла списка, с указанием ссылки на следующий узел в списке
     *
     * @param value Значение узла списка
     * @param next  Следующий элемент в списке
     */
    protected ListNode(T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(value, listNode.value) && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "hashCode()=" + hashCode() +
                ", value=" + value +
                (next != null ? (", next.hashCode()=" + next.hashCode()) : ", next=null") +
                '}';
    }
}
