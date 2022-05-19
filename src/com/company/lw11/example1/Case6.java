package com.company.lw11.example1;

import java.io.*;

/**
 * ПРИМЕР №6
 * Чтение из одного файла и запись в другой файл данных посимвольно.
 */
public class Case6 {
    public static void main(String[] args) throws IOException {
        Reader in = null;
        Writer out = null;
        try {
            in = new FileReader("E:\\FileOld.txt"); // Файл для чтения
            out = new FileWriter("E:\\FileNew.txt");   // Файл для записи

            // Данные считываются и записываются побайтно, как и для InputStream/OutputStream
            int oneByte;
            while ((oneByte = in.read()) != -1) {
                // out.write((char) oneByte);               // Запись с уничтожением существующих данных
                out.append((char) oneByte);
            }
        } catch (IOException exception) {
            System.err.println("Ошибка!");
        } finally {
            in.close();
            out.close();
        }
    }
}
