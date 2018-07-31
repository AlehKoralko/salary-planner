package com.korolko.salaryplanner.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ConnectionPayment implements Payment {

    private Map<ConnectionType, Double> payments = new HashMap<>();
    private final static double EMPTY_VALUE = 0;
    private Logger logger = LoggerFactory.getLogger(ConnectionPayment.class);

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
        logger.info("Connection " + type + " payment changed to " + newValue);
        payments.put(type, newValue);
    }

    private void initPayments() {
        payments.put(ConnectionType.INTERNET,   EMPTY_VALUE);
        payments.put(ConnectionType.MOBILE,     EMPTY_VALUE);
        payments.put(ConnectionType.TV,         EMPTY_VALUE);
    }
}
