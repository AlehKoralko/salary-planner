package com.korolko.salaryplanner.entity;

import java.util.HashMap;
import java.util.Map;

public class ConnectionPayment implements Payment {

    private Map<ConnectionType, Double> payments = new HashMap<>();
    private final static double EMPTY_VALUE = 0;

    public ConnectionPayment() {
        initPayments();
    }

    @Override
    public double getAmount() {
        return payments.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void changeMetric(ConnectionType type, double newValue) {
        payments.put(type, newValue);
    }

    private void initPayments() {
        payments.put(ConnectionType.INTERNET,   EMPTY_VALUE);
        payments.put(ConnectionType.MOBILE,     EMPTY_VALUE);
        payments.put(ConnectionType.TV,         EMPTY_VALUE);
    }
}
