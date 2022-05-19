package com.company.lw11.example1;

import java.io.File;

/**
 * ПРИМЕР №1
 * Создание файлов и папок
 */
public class Case1 {
    public static void main(String[] args) {
        try {
            // Создание файла в текущей папке (где расположен файл Case1.java)
            File f1 = new File("File1.txt");
            f1.createNewFile();
            if (f1.exists()) {
                System.out.println("Создан!");
                System.out.println("Полный путь 1: " + f1.getAbsolutePath());
            }

            // Создание файла на диске E и вывод полного пути
            File f2 = new File("E:\\File2.txt");
            f2.createNewFile();
            System.out.println("Полный путь 2: " + f2.getAbsolutePath());

            // Создание нескольких вложенных папок
            File f3 = new File("E:\\Folder1\\Folder2\\Folder3");
            f3.mkdirs();
            System.out.println("Полный путь 3: " + f3.getAbsolutePath());

            f1.delete();
        } catch (Exception e) {
            System.err.println("Ошибка! " + e);
        }
    }
}