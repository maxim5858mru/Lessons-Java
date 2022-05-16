package com.company.lw11.example1;

import java.io.File;

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

            // Создание файла на диске C (точнее в уже созданной папке, так создание
            // файла в C: требует прав администратора) и вывод полного пути
            File f2 = new File("C:\\Folder\\File2.txt");
            f2.createNewFile();
            System.out.println("Полный путь 2: " + f2.getAbsolutePath());

            // Создание нескольких вложенных папок
            File f3 = new File("C:\\Folder1\\Folder2\\Folder3");
            f3.mkdirs();
            System.out.println("Полный путь 3: " + f3.getAbsolutePath());

            // Удаление
            f1.delete();
            f2.delete();
            f3.delete();
            new File("C:\\Folder1\\Folder2").delete();
            new File("C:\\Folder1").delete();
        } catch (Exception e) {
            System.err.println("Ошибка! " + e);
        }
    }
}