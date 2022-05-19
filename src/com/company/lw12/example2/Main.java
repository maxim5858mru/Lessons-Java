package com.company.lw12.example2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessInputFile = null, accessOutputFile = null;
        var inputFile = new File("E:\\InputText.txt");
        var outputFile = new File("E:\\Output.txt");

        // Пересоздание файла Output.txt
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        try {
            accessInputFile = new RandomAccessFile(inputFile, "r");
            accessOutputFile = new RandomAccessFile(outputFile, "rw");

            var line = accessInputFile.readLine();
            var smallLetter = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8).toLowerCase().charAt(0);
            var bigLetter = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8).charAt(0);
            var counters = new ArrayList<Integer>();

            // Поиск и запись найденных слов
            while (line != null) {
                line = new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8);
                var words = line.split("[\s.!?\"«»;,]");
                var counter = 0;

                for (var word : words) {
                    if (word == "") continue;
                    else if (word.charAt(0) == smallLetter || word.charAt(0) == bigLetter) {
                        // $НОМЕР_СТРОКИ: $СЛОВО
                        accessOutputFile.writeUTF((counters.size() + 1) + ":\t" + word + "\n");
                        counter++;
                    }
                }

                counters.add(counter);
                line = accessInputFile.readLine();
            }

            // Запись количества найденных слов для каждой строки
            accessOutputFile.writeUTF("\n");
            for (int i = 0; i < counters.size(); i++) {
                accessOutputFile.writeUTF("### В строке №" + i + " найдено " + counters.get(i) + " слов.\n");
            }

            // Считывание записанного
            accessOutputFile.seek(2);
            line = accessOutputFile.readLine();
            while (line != null) {
                System.out.println(new String(line.getBytes("ISO-8859-1"), StandardCharsets.UTF_8));
                accessOutputFile.skipBytes(2);
                line = accessOutputFile.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            // Закрытие потоков
            if (accessOutputFile != null) {
                accessOutputFile.close();
            }
            if (accessInputFile != null) {
                accessInputFile.close();
            }
        }
    }
}
