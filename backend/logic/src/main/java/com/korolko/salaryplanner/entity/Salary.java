package com.korolko.salaryplanner.entity;

public class Salary implements Income {

    private double value;

    private Salary(double value) {
        this.value = value;
    }

    public static Salary valueOf(double value) {
        return new Salary(value);
    }

    @Override
    public double getValue() {
        return value;
    }
}
