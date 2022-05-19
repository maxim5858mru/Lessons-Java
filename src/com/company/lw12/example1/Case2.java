package com.company.lw12.example1;

import java.io.*;

/**
 * ПРИМЕР №2
 * Чтение из одного файла и запись в другой файл данных
 * построчно с использованием буфера в 1 килобайт.
 */
public class Case2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // Создание файловых символьных потоков для чтения и записи
            br = new BufferedReader(new FileReader("E:\\FileOld.txt"), 1024);
            bw = new BufferedWriter(new FileWriter("E:\\FileNew.txt"));

            int lineCount = 0;                      // Счётчик строк
            String s;

            // Переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(s);
                bw.newLine();                       // Перевод на новую строку
            }
        } catch (IOException exception) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
