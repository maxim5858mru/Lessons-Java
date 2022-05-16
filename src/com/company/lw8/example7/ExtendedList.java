package com.company.lw8.example7;

import com.company.lw8.example5.List;

import java.util.Scanner;

public class ExtendedList extends List<Integer> {
    public ExtendedList() {
        super();
    }

    public ExtendedList(Integer value) {
        super(value);
    }

    public ExtendedList(Integer[] array) {
        super(array);
    }

    public void readFromConsole() {
        var scanner = new Scanner(System.in);
        Integer[] data;

        System.out.print("Введите количество значений: ");
        data = new Integer[scanner.nextInt()];

        for (int i = 0; i < data.length; i++) {
            System.out.printf("[%d] = ", i);
            data[i] = scanner.nextInt();
        }

        createHead(data);
    }

    public int sum() {
        Integer result = 0;

        for (var item : getItems()) {
            result += item.value;
        }
        return result;
    }

    public int meanEven() {
        int result = 0, y = 1;
        var data = getItems();

        for (int i = 0; i < data.length; i += 2) {
            result += data[i].value;
            y++;
        }
        return result / y;
    }

    public void changePositionPositiveEvenNumbers() {
        var data = getItems();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int indexMin = 0, indexMax = 0;

        for (int i = 0; i < data.length; i += 2) {
            if (data[i].value % 2 == 1) continue;

            if (data[i].value < min) {
                min = data[i].value;
                indexMin = i;
            }
            if (data[i].value > max) {
                max = data[i].value;
                indexMax = i;
            }
        }

        System.out.printf("Минимальное: [%d]=%d\n\r", indexMin, min);
        System.out.printf("Максимальное: [%d]=%d\n\r", indexMax, max);

        set(indexMin, max);
        set(indexMax, min);
    }
}
