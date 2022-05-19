package com.company.lw12.example3.task2;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream objOutput = null;
        ObjectInputStream objInput = null;
        Film film;
        var scanner = new Scanner(System.in);
        var file = new File("E:\\Output.txt");

        // Пересоздание файла Output.txt
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // Запись данных
        try {
            String name, country, genre;
            int year;
            double cost;

            objOutput = new ObjectOutputStream(new FileOutputStream(file));

            System.out.print("Имя фильма: ");
            name = scanner.nextLine();

            System.out.print("Год выпуска: ");
            year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Страна: ");
            country = scanner.nextLine();

            System.out.print("Жанр: ");
            genre = scanner.nextLine();

            System.out.print("Стоимость: ");
            cost = scanner.nextDouble();
            scanner.nextLine();

            film = new Film(name, year, country, genre, cost);
            objOutput.writeObject(film);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (objOutput != null) {
                objOutput.flush();
                objOutput.close();
            }
        }

        // проверка записанного
        System.out.println("\n\rПроверка:");
        try {
            objInput = new ObjectInputStream(new FileInputStream(file));

            film = (Film) objInput.readObject();
            System.out.println(film.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objInput != null) {
                objInput.close();
            }
        }
    }
}
