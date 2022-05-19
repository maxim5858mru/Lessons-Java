package com.company.lw12.example1;

import java.io.*;

/**
 * ПРИМЕР №4
 * Чтение из одного файла и запись в другой файл данных
 * построчно с использованием буферизации символьных потоков основанных на
 * байтовых файловых потоках.
 */
public class Case4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // Создание потоков для чтения и записи с нужной кодировкой
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\FileOld.txt"), "cp1251"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\FileNew.txt"), "cp1251"));

            // Переписывание информации из одного файла в другой
            int lineCount = 0;                      // Счётчик строк
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s); // Запись без перевода строки
                bw.newLine();                       // Принудительный переход на новую строку
            }
        } catch (IOException e) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            bw.flush();
            bw.close();
        }
    }
}
