package com.company.lw4;

import java.util.Scanner;

public class Example8 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        char[] text;
        int key;

        // 1 часть: шифрование сообщения
        System.out.print("Введите текст для шифрования: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();
        input.nextLine();

        encrypt(text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");

        // 2 часть: расшифровка сообщения
        while (true) {
            System.out.print("Выполнить обратное преобразование? (y/n) ");
            String answer = input.nextLine();

            if (answer.equals("y"))
                break;
            else if (answer.equals("n")) {
                System.out.println("До свидания!");
                return;
            }
            else
                System.err.println("Введите корректный ответ");
        }

        System.out.print("Введите текст для расшифровки: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();
        input.nextLine();

        decrypt(text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
    }

    /**
     * Шифрование строки с помощью метода шифрования "Шифр Цезаря",
     * точнее шифрование массива символов.
     *
     * Результат функции представлен в массиве text.
     * @param text Массив символов.
     * @param key Ключ шифрования.
     */
    private static void encrypt(char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] + key);
        }
    }

    /**
     * Дешифрование строки с зашифрованной с помощью "Шифра Цезаря".
     * @param text Массив символов.
     * @param key Ключ расшифровки.
     */
    private static void decrypt(char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] - key);
        }
    }
}
