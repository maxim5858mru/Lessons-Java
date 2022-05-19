package com.company.lw11.example1;

import java.io.*;
import java.util.Arrays;

/**
 * ПРИМЕР №3
 * Прочитать и вывести на экран информацию из предварительно \
 * созданного файла с использованием буфера в 5 байт.
 */
public class Case3 {
    public static void readAllByArray(InputStream in) throws IOException {
        byte[] buffer = new byte[5];
        while (true) {
            int count = in.read(buffer);
            if (count != -1) {                      // Если не конец файла
                System.out.println("Количество = " + count +
                        ", buffer = " + Arrays.toString(buffer) +
                        ", str = " +
                        new String(buffer, 0, count, "cp1251"));
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName = "E:\\FileOld.txt";
        InputStream inFile = null;

        try {
            inFile = new FileInputStream(fileName);
            readAllByArray(inFile);
        } catch (IOException exception) {
            System.err.println("Ошибка открытия-закрытия файла " + fileName + exception);
        } finally {
            if (inFile != null) {
                try {
                    inFile.close();
                } catch (IOException ignore) {
                    /*NOP*/                         // NOP - No OPeration - ничего не делать
                }
            }
        }
    }
}
