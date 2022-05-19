package com.company.lw12.example1;

import java.io.*;
import java.net.URL;

/**
 * ПРИМЕР №3
 * Прочитать и вывести на экран информацию из трёх источников: файла
 * на диске, интернет-страницы и массива данных типа byte. Указать кодировку,
 * поддерживающую кириллицу.
 */
public class Case3 {
    public static void readAllByByte(Reader in) throws IOException {
        while (true) {
            int oneByte = in.read();                // Читает 1 байт
            if (oneByte != -1) {                    // Признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\FileOld.txt");    // Байтовый поток
            Reader rFile = new InputStreamReader(inFile, "cp1251");         // Символьный поток
            readAllByByte(rFile);
            System.out.print("\n\n\n");
            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница
            InputStream inUrl = new URL("https://google.com").openStream();  // Байтовый поток
            Reader rUrl = new InputStreamReader(inUrl, "cp1251");            // Символьный поток
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[]{5, 8, 3, 9, 11});
            Reader rArray = new InputStreamReader(inArray, "cp1251");  // Символьный поток
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.err.println("Ошибка: " + e);
        }
    }
}
