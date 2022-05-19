package com.company.lw11.example2;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        final int STRING_COUNT = 2, DOUBLE_COUNT = 5;

        // Создание файла Output.txt
        File output = new File("E:\\Output.txt");
        if (!output.exists()) output.createNewFile();

        // Работа со строками
        var bufferedInput = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Input.txt")));
        var bufferedOutput = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output, false)));
        var selectedStrings = new ArrayList<String>();

        System.out.println("В исходном файле записаны следующие строки:");
        for (int i = 0; i < STRING_COUNT; i++) {
            String temp = bufferedInput.readLine();
            System.out.println("\t" + temp);
            if (i == 1) {
                bufferedOutput.append(temp + "\n\r");
                selectedStrings.add(temp);
            }
        }
        bufferedInput.close();
        bufferedOutput.flush();
        bufferedOutput.close();

        // Работа с числами
        var dataInput = new DataInputStream(new FileInputStream("E:\\Input.txt"));
        var dataOutput = new DataOutputStream(new FileOutputStream(output, true));
        var selectedDoubles = new ArrayList<Double>();

        System.out.println("\n\rВ исходном файле записаны следующие числа:");
        for (int i = 0; i < STRING_COUNT; i++) {
            dataInput.readLine();
        }
        for (int i = 0; i < DOUBLE_COUNT; i++) {
            double temp = dataInput.readDouble();
            System.out.println("\t" + temp);
            if (temp >= 0) {
                dataOutput.writeDouble(temp);
                selectedDoubles.add(temp);
            }
        }
        dataInput.close();
        dataOutput.flush();
        dataOutput.close();

        System.out.println("\n\rВ результирующий файл записано:");
        for (int i = 0; i < selectedStrings.size(); i++) {
            System.out.println("\t" + selectedStrings.get(i));
        }
        System.out.println();
        for (int i = 0; i < selectedDoubles.size(); i++) {
            System.out.println("\t" + selectedDoubles.get(i));
        }
    }
}
