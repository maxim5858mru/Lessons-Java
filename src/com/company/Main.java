package com.company;

import java.util.Scanner;
import com.company.lw1.LW1;
import com.company.lw2.LW2;
import com.company.lw3.LW3;
import com.company.lw4.LW4;
import com.company.lw5.LW5;
import com.company.lw6.LW6;
import com.company.lw7.LW7;
import com.company.lw8.LW8;

public class Main {
    final static int[] AMOUNT = new int[] {13, 10, 10, 9, 6, 10, 5, 7};
    final static String[] TOPICS = new String[] {
            "Знакомство с языком программирования Java",
            "Знакомство со средой разработки Eclipse",
            "Работа с операторами и одномерными массивами",
            "Работа с оператором цикла и массивами",
            "Введение в классы, часть 1",
            "Введение в классы, часть 2",
            "Введение в алгоритмы и структуры данных Java"/*,
                "Наследование. Обработка исключительных ситуаций",
                "Система ввода/вывода в Java. Работа с файлами через байтовые потоки",
                "Работа с текстовыми файлами. Файлы с произвольным доступом и файлы для записи объектов"*/
    };

    // TODO: Заполнить README.md проекта
    public static void main(String[] args) {
        if (args.length == 0) {
            var input = new Scanner(System.in);
            String inputString;

            showHelp();
            System.out.println("\n\rЛабораторные работы [количество заданий]:");
            showWorksList();

            System.out.print("\n\rВведите номера лабораторных работ и задания [Например: 1.1-3, 2.1, 3]: ");

            // TODO: Выбор заданий с помощью консоли
            inputString = input.nextLine();

            // ...
        } else if ((args.length == 1) && ((args[0] == "--all") || (args[0] == "-a"))) {
            int[] plag = new int[0];

            System.out.println("ВЫПОЛНЕНИЕ ВСЕХ ЛАБОРАТОРНЫХ РАБОТ И ЗАДАНИЙ:");
            for (int i = 0; i < TOPICS.length; i++) {
                System.out.println("\tЛабораторная работа №" + (i + 1) + " [" + AMOUNT[i] + "]" + "\t«" + TOPICS[i] + "»");

                switch (i) {
                    case 0 -> LW1.main(plag);
                    case 1 -> LW2.main(plag);
                    case 2 -> LW3.main(plag);
                    case 3 -> LW4.main(plag);
                    case 4 -> LW5.main(plag);
                    case 5 -> LW6.main(plag);
                    case 6 -> LW7.main(plag);
                    case 7 -> LW8.main(plag);
                }
            }
        } else {
            // TODO: Выбор заданий с помощью аргументов args[]

            // ...
        }
    }

    private static void showWorksList() {
        for (int i = 0; i < TOPICS.length; i++) {
            System.out.println("\tЛабораторная работа №" + (i + 1) + " [" + AMOUNT[i] + "]" + "\t«" + TOPICS[i] + "»");
        }
    }

    private static void showHelp() {
        System.out.println("Использование:");
        System.out.println("\tlessons-java ЛАБОРАТОРНАЯ_РАБОТА.С_НОМЕРА_ЗАДАНИЯ-ДО_НОМЕРА_ЗАДАНИЯ, ...");
        System.out.println("\tlessons-java ЛАБОРАТОРНАЯ_РАБОТА.ЗАДАНИЕ, ...");
        System.out.println("\tlessons-java ЛАБОРАТОРНАЯ_РАБОТА, ...");
        System.out.println("\tlessons-java ОПЦИИ");
        System.out.println("\n\rОпции:");
        System.out.println("\t-a, --all\tзапуск всех лабораторных работ");
    }
}
