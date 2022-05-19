package com.company.lw12.example1;

import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №6
 * Работа с числовыми данными в файле с произвольным доступом.
 * Выполнить следующие подзадачи:
 * - записать в файл заданное количество чисел с плавающей точкой (1 число = 8 байта);
 * - прочитать данные в прямом и обратном порядке;
 * - получить информацию о файле и указателе до ввода и после ввода данных;
 * - отсортировать по возрастанию числа непосредственно в файле.
 */
public class Case6 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            File folder = new File("E:\\Folder");
            if (!folder.exists()) {             // Создание папки на диске, если она не существует
                folder.mkdir();
            }

            File file = new File("E:\\Folder\\num1Mart.txt");
            file.createNewFile();               // Создание файла в папке

            System.out.print("Сколько чисел надо записать в файл? => ");
            int count = scanner.nextInt();      // Введение количества чисел

            // Открытие файла одновременно для чтения и записи "rw"
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            System.out.println("Исходный размер файла в байтах = " + randomAccessFile.length() + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте.");
            System.out.println("Введите числа: ");
            for (int i = 0; i < count; i++) {
                // Запись числа в файл
                System.out.print("\t");
                randomAccessFile.writeDouble(scanner.nextDouble());
            }
            System.out.println("\n\rНовый размер файла в байтах = " + randomAccessFile.length() + ", указатель стоит на " + randomAccessFile.getFilePointer() + "-м байте");
            System.out.println("Количество байт на 1 число = " + randomAccessFile.length() / count);
            randomAccessFile.close();

            // Открыть файл только для чтения "r"
            randomAccessFile = new RandomAccessFile(file, "r");

            // Прочитать числа из файла и вывести на экран
            System.out.println("\n\rЧисла в файле:");
            for (int i = 0; i < count; i++) {       // i – текущий номер числа
                randomAccessFile.seek(i * 8);   /* Перевод указателя на текущее число i * 8 байта
                                                        в данной ситуации при последовательном считывании
                                                        операцию seek() можно было не использовать
                                                     */
                System.out.println("Число " + i + ": " + randomAccessFile.readDouble());
            }

            System.out.println("\n\rЧисла в обратном порядке:");
            for (int i = count - 1; i >= 0; i--) {
                randomAccessFile.seek(i * 8);   // Операцию использовать обязательно!
                System.out.println("Число " + i + ": " + randomAccessFile.readDouble());
            }
            // Перевод указателя на последнее число
            randomAccessFile.seek(randomAccessFile.getFilePointer() - 8);
            System.out.println("\n\rКоличество чисел в файле = " + randomAccessFile.length() / 8 + ", последнее число= " + randomAccessFile.readInt());

            // Поиск заданного числа в файле и определение его номера (номеров)
            System.out.print("\n\rВведите число, которое нужно найти в файле => ");
            double x = scanner.nextDouble();
            int kol = 0;                            // Количество искомых чисел в файле
            for (int i = 0; i < count; i++) {
                randomAccessFile.seek(i * 8);
                double number = randomAccessFile.readDouble();
                if (number == x) {
                    kol++;
                    System.out.print("Номер " + i + ", ");
                }
            } System.out.println("количество искомых чисел = " + kol);
            randomAccessFile.close();

            // Сортировка чисел в файле методом "Пузырька"
            randomAccessFile = new RandomAccessFile(file, "rw");
            for (int k = 0; k < count; k++) {               // k – номер просмотра
                for (int i = 0; i < count - k - 1; i++) {   // i – номер числа
                    randomAccessFile.seek(i * 8);       // Переход к i-тому числу
                    double number1 = randomAccessFile.readDouble();
                    double number2 = randomAccessFile.readDouble();

                    if (number1 > number2) {                // Условие для сортировки по возрастанию
                        randomAccessFile.seek(i * 8);
                        randomAccessFile.writeDouble(number2);
                        randomAccessFile.writeDouble(number1);
                    }
                }
            }

            System.out.println("\n\rЧисла, отсортированные в файле:");
            for (int i = 0; i < count; i++) {
                randomAccessFile.seek(i * 8);
                System.out.println("\t" + randomAccessFile.readDouble());
            }

            randomAccessFile.close();
        } catch (IOException exception) {
            System.err.println("Конец файла " + exception);
        }
    }
}
