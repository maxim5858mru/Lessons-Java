package com.company.lw5.example1;

import java.util.Objects;

class CharField {
    /** Закрытое символьное поле. */
    private char value;

    /**
     * Конструктор для создания новых экземпляров класса, хранящего
     * одно символьное поле.
     *
     * @param value Символ для инициализации поля.
     */
    public CharField(char value) {
        this.value = value;
    }

    /**
     * Получение значения, хранящегося в закрытом поле.
     *
     * @return Номер символа поля.
     */
    public int getValue() {
        return value;
    }

    /**
     * Изменение значения закрытого поля.
     *
     * @param value Новое значение символьного поля.
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * Вывод в консоль символа и его кода.
     */
    public void printField() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return String.format("{%s = 0x%h}", value, (int) value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharField field = (CharField) o;
        return value == field.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
