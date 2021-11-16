package com.company.lw5.example3;

import java.util.Objects;

class TwoIntFields {
    private Integer a, b;

    public TwoIntFields() {
    }

    public TwoIntFields(int a) {
        this.a = a;
    }

    public TwoIntFields(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("(%s; %s)", (a != null) ? a : "NULL", (b != null) ? b : "NULL");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoIntFields that = (TwoIntFields) o;
        return Objects.equals(a, that.a) && Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
