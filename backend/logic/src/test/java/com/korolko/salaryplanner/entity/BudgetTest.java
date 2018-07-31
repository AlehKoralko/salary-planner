package com.korolko.salaryplanner.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BudgetTest {

    private Budget budget;

    @Before
    public void init() {
        User user = new User("Oleg");
        budget = Budget.createForUser(user);
    }

    @Test
    public void testGetBalance() {
        budget.addIncome(Salary.valueOf(2000));
        budget.addIncome(Salary.valueOf(400));

        CommunalPayment payment = new CommunalPayment();
        payment.changeMetric(CommunalType.ELECTRICITY, 30);
        payment.changeMetric(CommunalType.GAS, 5);
        payment.changeMetric(CommunalType.WATER, 10);
        payment.changeMetric(CommunalType.RENT, 200);
        payment.changeMetric(CommunalType.LIGHT, 50);

        budget.addPayment(payment);

        Assert.assertEquals("2105.0", budget.getBalance().toString());
    }

}
