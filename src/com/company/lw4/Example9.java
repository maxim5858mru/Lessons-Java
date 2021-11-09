package com.company.lw4;

import java.util.Scanner;

public class Example9 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        char[] text, alphabet;
        int key;

        // 0 часть: получение символов алфавита
        System.out.print("Введите последовательно символы алфавита: ");
        alphabet = input.nextLine().toCharArray();

        // 1 часть: шифрование сообщения
        System.out.print("Введите текст для шифрования: ");
        text = input.nextLine().toCharArray();

        System.out.print("Введите ключ: ");
        key = input.nextInt();
        input.nextLine();

        encrypt(alphabet, text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
        System.out.println();

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

        decrypt(alphabet, text, key);
        System.out.println("Текст после преобразования: '" + new String(text) + "'");
    }

    private static void encrypt(char[] alphabet, char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            /* Если символ не существует в алфавите, то вызывается исключение.
             * Для отслеживания этого используется флаг, в виде boolean переменной.
             */
            boolean isCharChanged = false;

            // Поиск текущего символа в массиве алфавита.
            for (int j = 0; j < alphabet.length; j++) {
                if (text[i] == alphabet[j]) {
                    /* Вычисление порядково номера нового символа и
                     * замена исходного символа в массиве.
                     */
                    j = (j + key) % alphabet.length;
                    text[i] = alphabet[j];

                    isCharChanged = true;
                    break;
                }
            }

            if (!isCharChanged)
                throw new IllegalArgumentException("В заданном алфавите нет символа '" + text[i] +"'.");
        }
    }

    private static void decrypt(char[] alphabet, char[] text, int key) {
        for (int i = 0; i < text.length; i++) {
            boolean isCharChanged = false;

            for (int j = 0; j < alphabet.length; j++) {
                if (text[i] == alphabet[j]) {
                    /* Для вычисления нового символа необходимо дополнить
                     * порядковы номер исходного, до значения больше key.
                     */
                    while (j < key) {
                        j += alphabet.length;
                    }

                    text[i] = alphabet[j - key];

                    isCharChanged = true;
                    break;
                }
            }

            if (!isCharChanged)
                throw new IllegalArgumentException("В заданном алфавите нет символа '" + text[i] + "'.");
        }
    }
}
