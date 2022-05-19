package com.company.lw9.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static final int COUNTER = 10000000;

    public static void main(String[] args) {
        try {
            HashSet<Integer> hashSet = new HashSet<Integer>();

            System.out.println("Время выполнения операции добавления HashSet<Long> = " + getRunningTimeAdd(hashSet));
            System.out.println("Время выполнения операции поиска HashSet<Long> = " + getRunningTimeFind(hashSet));
            System.out.println("Время выполнения операции удаление HashSet<Long> = " + getRunningTimeRemove(hashSet));
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        try {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            System.out.println("\n\rВремя выполнения операции добавления Map<Long, Long> = " + getRunningTimeAdd(map));
            System.out.println("Время выполнения операции поиска Map<Long, Long> = " + getRunningTimeFind(map));
            System.out.println("Время выполнения операции удаление Map<Long, Long> = " + getRunningTimeRemove(map));
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        try {
            LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();

            System.out.println("\n\rВремя выполнения операции добавления LinkedHashMap<Long, Long> = " + getRunningTimeAdd(linkedHashMap));
            System.out.println("Время выполнения операции поиска LinkedHashMap<Long, Long> = " + getRunningTimeFind(linkedHashMap));
            System.out.println("Время выполнения операции удаление LinkedHashMap<Long, Long> = " + getRunningTimeRemove(linkedHashMap));
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }
    }

    //--------------------------------------------------------
    //--------------------------------------------- ДОБАВЛЕНИЕ

    private static long getRunningTimeAdd(HashSet<Integer> list) {
        // Точка начала отсчёта времени выполнения программы
        long start = System.currentTimeMillis();

        // Блок кода в котором выполняется операция добавления
        for (int i = 0; i < COUNTER; i++) {
            list.add(i);
        }

        // Точка окончания отсчёта времени выполнения программы
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeAdd(Map<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.put(i, i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeAdd(HashMap<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.put(i, i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    //--------------------------------------------------------
    //-------------------------------------------------- ПОИСК

    private static long getRunningTimeFind(HashSet<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.contains(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeFind(Map<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.get(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeFind(HashMap<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.containsKey(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    //--------------------------------------------------------
    //----------------------------------------------- УДАЛЕНИЕ

    private static long getRunningTimeRemove(HashSet<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeRemove(Map<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long getRunningTimeRemove(HashMap<Integer, Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < COUNTER; i++) {
            list.remove(i);
        }

        long end = System.currentTimeMillis();
        return end - start;
    }
}
