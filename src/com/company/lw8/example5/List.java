package com.company.lw8.example5;

import java.util.Objects;

public class List<T> {
    /**
     * Используется для определения способа реализации конструктора,
     * принимающего массив значений
     */
    private final boolean USE_DIRECT_ORDER = true;

    // --------------------------------------------------------------
    // --- Public методы
    // --------------------------------------------------------------

    /**
     * Первый узел в списке
     */
    private ListNode<T> head;

    /**
     * конструктор для инициализации пустого списка
     */
    public List() {
        head = null;
    }

    /**
     * Конструктор для инициализации списка с одним элементом
     *
     * @param value Значение первого элемента списка
     */
    public List(T value) {
        head = new ListNode<>(value);
    }

    /**
     * Конструктор для инициализации списка по массиву данных
     *
     * @param array Исходный массив данных
     */
    public List(T[] array) {
        if (USE_DIRECT_ORDER) {
            createHead(array);
        } else {
            createTail(array);
        }
    }

    /**
     * Создание (или пересоздание) списка по массиву данных.
     * Данный метод заполняет список начиная с первого элемента
     *
     * @param array Исходный массив данных
     */
    public void createHead(T[] array) {
        head = new ListNode<>(array[0]);                  // Инициализация первого элемента списка

        var node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode<>(array[i]);
            node = node.next;
        }
    }

    /**
     * Создание (или пересоздание) списка по массиву данных.
     * Данный метод заполняет список начиная с последнего элемента
     *
     * @param array Исходный массив данных
     */
    public void createTail(T[] array) {
        /*
         * Инициализация первого элемента списка последним
         * значением массива. В дальнейшем, по мере продвижения
         * к началу исходного списка, данное значение будет в
         * конце списка.
         */

        head = new ListNode<>(array[array.length - 1]);

        for (int i = array.length - 2; i >= 0; i--) {
            head = new ListNode<>(array[i], head);
        }
    }

    /**
     * Вставка элемента в начало списка
     *
     * @param value Значение создаваемого элемента списка
     */
    public void addFirst(T value) {
        head = new ListNode<>(value, head);
    }

    /**
     * Вставка элемента в конец списка
     *
     * @param value Значение создаваемого списка
     */
    public void addLast(T value) {
        var node = head;

        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode<>(value);
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index Индекс удаляемого элемента
     */
    public void remove(int index) {
        var node = head;

        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 1; i < index - 2; i++) {
            node = node.next;
        }
        node.next = null;
    }

    /**
     * Удаление элемента в начале списка
     */
    public void removeFirst() {
        head = head.next;
    }

    /**
     * Удаление последнего элемента в списке
     */
    public void removeLast() {
        var node = head;

        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
    }

    /**
     * Вставка элемента согласно номеру указанного индекса
     *
     * @param value Значение вставляемого элемента
     * @param index Индекс, по которому производится вставка элемента в список
     */
    public void insert(T value, int index) {
        var node = head;

        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 1; i < index - 1; i++) {
            node = node.next;
        }
        node.next = new ListNode<>(value, node.next);
    }

    /**
     * Получение объекта узла списка по его индексу
     *
     * @param index Индекс искомого элемента
     * @return Узел списка по указанному индексу
     */
    public ListNode getByIndex(int index) {
        var node = head;

        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    /**
     * Получение значение узла по
     *
     * @param index Индекс искомого элемента
     * @return Значение узла списка по указанному индексу
     */
    public T getValueByIndex(int index) {
        var node = head;

        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        return node.value;
    }

    /**
     * Получение массива объектов списка
     *
     * @return Массив объектов исходного списка
     */
    public ListNode<T>[] getItems() {
        var result = new ListNode[length()];

        if (result.length != 0) {
            result[0] = head;
            for (int i = 1; i < result.length; i++) {
                result[i] = ((ListNode) result[i - 1]).next;
            }
        }

        return result;
    }

    /**
     * Изменение значение узла списка
     *
     * @param index Индекс сходного узла
     * @param value Новое значение узла списка
     */
    public void set(int index, T value) {
        var node = head;

        if (index >= length() || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 1; i < index; i++) {
            node = node.next;
        }
        node.value = value;
    }

    /**
     * Получение длины списка
     *
     * @return Целочисленное значение длины списка
     */
    public int length() {
        var node = head;
        int result = 0;

        while (node != null) {
            node = node.next;
            result++;
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List<?> list = (List<?>) o;
        return Objects.equals(head, list.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }

    @Override
    public String toString() {
        var result = "List{" + ((head == null) ? "" : "\n\r");
        var node = head;

        if (node != null) {
            int i = 0;

            do {
                result += "\titem[" + i + "]=" + node + ((node.next != null) ? ",\n\r" : "\n\r");
                node = node.next;
                i++;
            } while (node != null);
        }
        result += "}";

        return result;
    }

    /**
     * Рекурсивный метода создание (или пересоздание)
     * списка по массиву данных. Данный метод заполняет список
     * начиная с первого элемента
     *
     * @param array Исходный массив данных
     */
    public void createHeadRec(T[] array) {
        if (array.length != 0) {
            head = new ListNode<>(array[0]);
            createHeadRec(array, 1, head);
        }
    }

    /**
     * Рекурсивный метод создания (или пересоздание)
     * списка по массиву данных. Данный метод заполняет список
     * начиная с последнего элемента
     *
     * @param array Исходный массив данных
     */
    public void createTailRec(T[] array) {
        if (array.length != 0) {
            head = new ListNode<>(array[array.length - 1]);
            createTailRec(array, array.length - 2, head);
        }
    }

    /**
     * Рекурсивный метод <code>toString()</code>
     *
     * @return Многострочное текстовое представление списка
     */
    public String toStringRec() {
        return "List{" + ((head == null) ? "" : "\n\r" + toStringRec(head, 0) + "\n\r") + "}";
    }

    // --------------------------------------------------------------
    // --- Private методы
    // --------------------------------------------------------------

    /**
     * Рекурсивная реализация метода <code>createHeadRec(T[] array)</code>
     *
     * @param array Исходный массив данных
     * @param index Текущий индекс
     * @param node  Последний созданный узел
     */
    private void createHeadRec(T[] array, int index, ListNode node) {
        if (array.length > index) {
            node.next = new ListNode<>(array[index]);
            createHeadRec(array, index + 1, node.next);
        }
    }

    /**
     * Рекурсивная реализация метода <code>createTailRec(T[] array)</code>
     *
     * @param array Исходный массив данных
     * @param index Текущий индекс
     * @param node  Последний созданный узел
     */
    private void createTailRec(T[] array, int index, ListNode node) {
        if (index >= 0) {
            head = new ListNode<>(array[index], head);
            createTailRec(array, index - 1, head);
        }
    }

    /**
     * Рекурсивная реализация метода <code>toStringRec()</code>
     *
     * @param node Текущий узел списка
     * @param index Порядковый номер узла
     * @return Многострочное текстовое представление списка
     */
    private String toStringRec(ListNode node, int index) {
        return "\titem[" + index + "]=" + node + ((node.next != null) ? (",\n\r" + toStringRec(node.next, index + 1)) : "");
    }
}
