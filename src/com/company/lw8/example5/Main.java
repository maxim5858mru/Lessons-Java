package com.company.lw8.example5;

public class Main {
    public static void main(String[] args) {
        // 1. Создание пустого списка
        var list = new List<Integer>();
        System.out.println("1: " + list.toString() + "\n\r");

        // 2. Создание списка, с указанием значения первого элемента
        list = new List<Integer>(5);
        System.out.println("2: " + list.toString() + "\n\r");

        // 3. Добавление значения 100 в начало списка
        list.addFirst(100);
        System.out.println("3: " + list.toString() + "\n\r");

        // 4. Добавление значения VALUE = 100 в конец списка
        list.addLast(100);
        System.out.println("4: " + list.toString() + "\n\r");

        // 5. Вставка значения 150 в ячейку с индексом 2
        list.insert(150, 2);
        System.out.println("5: " + list.toString() + "\n\r");

        // 6. Удаление элемента в начале списка
        list.removeFirst();
        System.out.println("6: " + list.toString() + "\n\r");

        // 7. Удаление элемента в конце списка
        list.removeLast();
        System.out.println("7: " + list.toString() + "\n\r");

        // 8. Удаление элемента по индексу 1
        list.remove(1);
        System.out.println("8: " + list.toString() + "\n\r");

        // 9. Создание списка, с головы по указанным значениям
        list.createHead(new Integer[] {1, 5, 10, 15, 20, 25});
        System.out.println("9: " + list.toString() + "\n\r");

        // 10. Создание списка, с хвоста по указанным значениям
        list.createTail(new Integer[] {1, 5, 10, 15, 20, 25});
        System.out.println("10: " + list.toString() + "\n\r");

        // 11: Рекурсивная реализация метода создания списка с головы
        var list1 = new List<Integer>();
        list1.createHeadRec(new Integer[] {1, 5, 10, 15, 20, 25});
        System.out.println("11: " + list1.toString() + "\n\r");

        // 12: Рекурсивная реализация метода создания списка с хвоста
        var list2 = new List<Integer>();
        list2.createTailRec(new Integer[] {1, 5, 10, 15, 20, 25});
        System.out.println("12: " + list2.toString() + "\n\r");

        // 13: Рекурсивная реализация метода toString()
        System.out.println("13: " + list.toStringRec() + "\n\r");
    }
}
