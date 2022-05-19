package com.company.lw12.example3.task1;

import java.io.*;
import java.util.Scanner;

/**
 * Через файл с произвольным доступом
 */
public class Main {
    public static void main(String[] args) throws IOException {
        final int NAME_SIZE = 25, COUNTRY_SIZE = 15, GENRE_SIZE = 10;
        RandomAccessFile accessOutputFile = null;
        var scanner = new Scanner(System.in);
        var outputFile = new File("E:\\Output.txt");

        // Пересоздание файла Output.txt
        if (outputFile.exists()) {
            outputFile.delete();
        }
        outputFile.createNewFile();

        System.out.print("Введите количество фильмов: ");
        var count = scanner.nextInt();
        scanner.nextLine();                         // Очистка буфера

        try {
            accessOutputFile = new RandomAccessFile(outputFile, "rw");

            // Запись
            for (int i = 0; i < count; i++) {
                String name, country, genre;
                double cost;
                int year;

                do {
                    System.out.print((i + 1) + ":\t Название фильма [< 25 символов]: ");
                    name = scanner.nextLine();
                } while (name.length() > NAME_SIZE);
                accessOutputFile.writeUTF(name);
                for (int j = 0; j < NAME_SIZE - name.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Год выпуска [>= 1895]: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                } while (year < 1895);
                accessOutputFile.writeInt(year);

                do {
                    System.out.print((i + 1) + ":\t Страна [< 15 символов]: ");
                    country = scanner.nextLine();
                } while (country.length() > COUNTRY_SIZE);
                accessOutputFile.writeUTF(country);
                for (int j = 0; j < COUNTRY_SIZE - country.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Жанр [< 10 символов]: ");
                    genre = scanner.nextLine();
                } while (genre.length() > GENRE_SIZE);
                accessOutputFile.writeUTF(genre);
                for (int j = 0; j < GENRE_SIZE - genre.length(); j++) {
                    accessOutputFile.writeByte(1);
                }

                do {
                    System.out.print((i + 1) + ":\t Стоимость [>= 0]: ");
                    cost = scanner.nextDouble();
                    scanner.nextLine();
                } while (cost < 0);
                accessOutputFile.writeDouble(cost);

                System.out.println();
            }

            // Проверка записанного
            var i = accessOutputFile.length() / (NAME_SIZE + 4 + COUNTRY_SIZE + GENRE_SIZE + 8 + 6);
            System.out.println("Количество записей в файле: " + i);

            accessOutputFile.seek(0);
            for (int j = 0; j < i; j++) {
                var name = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tНазвание фильма: " + name);
                accessOutputFile.skipBytes(NAME_SIZE - name.length());

                System.out.println((j + 1) + ":\tГод выпуска: " + accessOutputFile.readInt());

                var country = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tСтрана: " + country);
                accessOutputFile.skipBytes(COUNTRY_SIZE - country.length());

                var genre = accessOutputFile.readUTF();
                System.out.println((j + 1) + ":\tЖанр: " + genre);
                accessOutputFile.skipBytes(GENRE_SIZE - genre.length());

                System.out.println((j + 1) + ":\tСтоимость: " + accessOutputFile.readDouble());

                System.out.println();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            // Закрытие потоков
            if (accessOutputFile != null) {
                accessOutputFile.close();
            }
        }
    }
}
