package com.korolko.salaryplanner.entity;

import com.korolko.salaryplanner.entity.CommunalPayment;
import com.korolko.salaryplanner.entity.CommunalType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommunalPaymentTest {

    private CommunalPayment payment;

    @Before
    public void init() {
        payment = new CommunalPayment();

        payment.changeMetric(CommunalType.WATER, 200);
        payment.changeMetric(CommunalType.GAS, 50);
        payment.changeMetric(CommunalType.LIGHT, 200);
        payment.changeMetric(CommunalType.ELECTRICITY, 300);
    }

    @Test
    public void testGetAmount() {
        Assert.assertEquals(750, payment.getAmount(), 0);
    }

    @Test
    public void testChangeMetric() {
        payment.changeMetric(CommunalType.ELECTRICITY, 0);

        Assert.assertEquals(450, payment.getAmount(), 0);
    }
}
