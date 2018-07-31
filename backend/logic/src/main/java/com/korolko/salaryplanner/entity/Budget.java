package com.korolko.salaryplanner.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Budget {

    private List<Income> incomes;
    private List<Payment> payments;
    private User user;
    private Year year;
    private Month month;

    private Budget(User user) {
        this.incomes = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.user = user;
        this.year = Year.now();
        this.month = LocalDate.now().getMonth();
    }

    public static Budget createForUser(User user) {
        return new Budget(user);
    }

    public void addIncome(Income income) {
        this.incomes.add(income);
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public BigDecimal getBalance() {
        return countAmountOfBudget().subtract(countAmountOfPayments());
    }

    private BigDecimal countAmountOfBudget() {
        double amountOfBudget = this.incomes.stream()
                .mapToDouble(Income::getValue)
                .sum();

        return BigDecimal.valueOf(amountOfBudget);
    }

    private BigDecimal countAmountOfPayments() {
        double amountOfPayments = this.payments.stream()
                .mapToDouble(Payment::getAmount)
                .sum();

        return BigDecimal.valueOf(amountOfPayments);
    }
}
