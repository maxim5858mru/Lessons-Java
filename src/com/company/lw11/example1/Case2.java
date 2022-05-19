package com.company.lw11.example1;

import java.io.*;
import java.net.URL;

/**
 * ПРИМЕР №2
 * Прочитать и вывести на экран информацию из трёх источников:
 *  - файла на диске;
 *  - интернет-страницы;
 *  - массива типа <code>byte</code>.
 */
public class Case2 {
    public static void readAllByByte(InputStream in) throws IOException {
        while (true) {
            int oneByte = in.read();        // Читает 1 байт
            if (oneByte != -1) {            // Признак отсутствия конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.println("\n" + "end");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("E:\\FileOld.txt");
            readAllByByte(inFile);
            System.out.println("\n\n\n");
            inFile.close();

            // С потоком связана интернет-страница
            InputStream inUrl = new URL("https://google.com").openStream();
            readAllByByte(inUrl);
            System.out.println("\n\n\n");
            inUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream(new byte[] {7, 9, 3, 7, 4});
            readAllByByte(inArray);
            System.out.println("\n\n\n");
            inArray.close();
        } catch (IOException exception) {
            System.err.println("Ошибка! " + exception);
        }
    }
}