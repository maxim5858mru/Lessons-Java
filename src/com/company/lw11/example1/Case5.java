package com.company.lw11.example1;

import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №5
 * Создать файл на диске, ввести заданное с клавиатуры количество
 * строк текста и записать их в файл в формате UTF-8
 */
public class Case5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите имя файла => ");
        String fname = sc.nextLine();
        try {
            File f1 = new File(fname);
            f1.createNewFile();                 // Файл создан
            System.out.println("Полный путь файла: " + f1.getAbsolutePath());

            System.out.print("Введите количество строк для записи в файл => ");
            int n = sc.nextInt();

            /* Создаётся поток для записи с учётом типа данных - DataOutputStream,
               и ему в качестве параметра передаётся поток FileOutputStream
             */
            DataOutputStream dOut = new DataOutputStream(new FileOutputStream(f1));
            sc.nextLine();                      // Очистка буфера
            for (int i = 0; i < n; i++) {
                System.out.print("Введите строку для записи в файл => ");
                String s = sc.nextLine();

                dOut.writeUTF(s);
            }
            dOut.flush();                       // Дописываем несохранённые данные на диск
            dOut.close();                       // Закрываем поток

            // Чтение и вывод данных из созданного файла
            DataInputStream dIn = new DataInputStream(new FileInputStream(f1));
            while (true) {
                System.out.println(dIn.readUTF());
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }
}
