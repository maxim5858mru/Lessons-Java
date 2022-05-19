package com.company.lw12.example3.task2;

import java.io.Serializable;

public class Film implements Serializable {
    /**
     * Название фильма
     */
    public String name;

    /**
     * Страна съёмки фильма
     */
    public String country;

    /**
     * Жанр фильма
     */
    public String genre;

    /**
     * Год выпуска
     */
    public int year;

    /**
     * Стоимость
     */
    public double cost;

    public Film(String name, int year, String country, String genre, double cost) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.genre = genre;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Film{\n\r" +
                "\tname = '" + name + "', \n\r" +
                "\tcountry = '" + country + "', \n\r" +
                "\tgenre = '" + genre + "', \n\r" +
                "\tyear = " + year + ", \n\r" +
                "\tcost = " + cost + "\n\r" +
                '}';
    }
}
