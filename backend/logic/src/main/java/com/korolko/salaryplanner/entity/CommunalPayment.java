package com.korolko.salaryplanner.entity;

import java.util.HashMap;
import java.util.Map;

public class CommunalPayment implements Payment {

    private Map<CommunalType, Double> payments = new HashMap<>();
    private final static double EMPTY_VALUE = 0;

    public CommunalPayment() {
        initPayments();
    }

    @Override
    public double getAmount() {
        return payments.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void changeMetric(CommunalType type, double newValue) {
        payments.put(type, newValue);
    }

    private void initPayments() {
        payments.put(CommunalType.ELECTRICITY,  EMPTY_VALUE);
        payments.put(CommunalType.LIGHT,        EMPTY_VALUE);
        payments.put(CommunalType.GAS,          EMPTY_VALUE);
        payments.put(CommunalType.WATER,        EMPTY_VALUE);
        payments.put(CommunalType.RENT,         EMPTY_VALUE);
    }
}
