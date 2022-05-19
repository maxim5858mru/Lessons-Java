package com.company.lw12.example1;

import java.io.*;

/**
 * ПРИМЕР №5
 * Выполнить чтение из одного файла и запись в другой
 * файл с использованием класса PrintWriter
 */
public class Case5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            // Создание потоков
            br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\FileOld.txt"), "cp1251"));
            out = new PrintWriter("E:\\FileNew.txt", "cp1251");

            // Переписывание информации из одного файла в другой
            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        } catch (IOException e) {
            System.err.println("Ошибка!");
        } finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
