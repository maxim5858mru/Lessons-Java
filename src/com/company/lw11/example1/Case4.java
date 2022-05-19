package com.company.lw11.example1;

import java.io.*;
import java.util.Scanner;

/**
 * ПРИМЕР №4
 * Создать первый файл на диске и записать в него заданное количество
 * вещественных чисел. Далее создать второй файл и переписать в него
 * все числа из первого файла.
 */
public class Case4 {
    public static void main(String[] args) {
        try {
            // Создание исходного файла numIsh.txt и запись в него чисел типа float
            File f1 = new File("E:\\numIsh.txt");
            f1.createNewFile();
            Scanner sc = new Scanner(System.in, "cp1251");

            DataOutputStream wr = new DataOutputStream(new FileOutputStream(f1.getAbsolutePath()));
            System.out.print("Сколько вещественных чисел записать в файл? ");
            int count = sc.nextInt();

            System.out.println("Введите числа:");
            for (int i = 0; i < count; i++) {
                wr.writeFloat(sc.nextFloat());
            }

            wr.flush();
            wr.close();

            // Создание файла numRez.txt и переписывание в него чисел из numIsh.txt
            File f2 = new File("E:\\numRez.txt");
            f2.createNewFile();

            // Поток для чтения из исходного файла numIsh.txt
            DataInputStream rd = new DataInputStream(new FileInputStream(f1.getAbsolutePath()));

            // Поток для записи в результирующий файл numRez.txt
            wr = new DataOutputStream(new FileOutputStream(f2.getAbsolutePath()));

            try {
                while (true) {
                    float number = rd.readFloat();
                    wr.writeFloat(number);
                }
            } catch (EOFException e) { }
            wr.flush();
            wr.close();
            rd.close();
        } catch (IOException e) {
            System.err.println("End of file");
        }
    }
}
