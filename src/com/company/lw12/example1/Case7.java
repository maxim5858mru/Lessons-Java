package com.company.lw12.example1;

import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №7
 * Выполнить запись строк и чтение их из файла с произвольным доступом.
 */
public class Case7 {
    public static void main(String[] args) {
        try {
            File folder = new File("E:\\Folder");
            if (!folder.exists()) folder.mkdir();

            File file = new File("E:\\Folder\\strokiRand.txt");
            file.createNewFile();

            Scanner scanner = new Scanner(System.in, "cp1251");
            System.out.print("Сколько строк надо записать в файл? => ");
            int count = scanner.nextInt();
            scanner.nextLine();                                         // Очистка буфера после ввода числа

            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw"); // Чтение/запись
            randomAccessFile.setLength(0);
            long length = randomAccessFile.length();
            System.out.println("\n\rОткрыт файл размером " + length + " байт");
            System.out.println("Введите строки:");
            int countSymbol = 0;                                        // Счётчик букв

            // Записать строки в файл
            for (int i = 0; i < count; i++) {
                String s = scanner.nextLine();
                randomAccessFile.writeUTF(s);
                countSymbol += s.length();
            }
            length = randomAccessFile.length();

            System.out.println("\n\rРазмер файла в байтах = " + length);
            randomAccessFile.close();

            // Открыть файл для чтения "r"
            randomAccessFile = new RandomAccessFile(file, "r");

            // Вывод строк из файла на экран
            System.out.println("\n\rСтроки из файла:");

            // Перевести указатель в начало файла (на первое слово)
            randomAccessFile.seek(0);
            for (int i = 0; i < count; i++) {
                System.out.println("Строка " + i + " начинается с байта " +
                        randomAccessFile.getFilePointer() + " - " +
                        randomAccessFile.readUTF() + " - заканчивается байтом " +
                        (randomAccessFile.getFilePointer() - 1)
                );
            }
            randomAccessFile.close();
        } catch (IOException exception) {
            System.err.println("Конец файла " + exception);
        }
    }
}
