package com.company.lw12.example1;

import java.io.*;

/**
 * ПРИМЕР №1
 * Чтение из одного файла и запись в другой файл данных посимвольно.
 */
public class Case1 {
    public static void main(String[] args) throws IOException {
        Reader in = null;       // Можно сразу записать FileReader in = null;
        Writer out = null;      // Можно сразу записать FileWriter out = null;

        try {
            in = new FileReader("E:\\File1.txt");                 // Файл для чтения
            out = new FileWriter("E:\\File2.txt", true);

            /* Данные считываются и записываются побайтно, как и для
               InputStream/OutputStream
             */
            int oneByte;                            // Переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
                // Запись с уничтожением ранее существующих данных
                // out.write((char)oneByte);

                // Запись с добавлением данных в конец
                out.append((char) oneByte);
                System.out.print((char) oneByte);
            }
        } catch (IOException e) {
            System.err.println("Ошибка! ");
        } finally {
            in.close();
            out.close();
        }
    }
}
