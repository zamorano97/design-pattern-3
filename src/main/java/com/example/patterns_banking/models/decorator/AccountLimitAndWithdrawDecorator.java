package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountLimitAndWithdrawDecorator extends AccountDecorator {

    private static final double LIMIT = 20000.0;

    public AccountLimitAndWithdrawDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        double fee = super.calculateWithdrawalFee(amount);
        double balance = super.getBalance();

        if (amount > balance + LIMIT - fee) {
            throw new IllegalArgumentException("The amount exceeds the balance plus the allowed overdraft limit.");
        }

        System.out.println("Withdrawal of: " + amount + " from account: " + getAccountNumber() + " was successful.");

        if (amount >= balance) {
            double excess = amount - balance;
            System.out.println("The excess withdrawn was: " + excess);
            super.setBalance(0.0);
            amount = excess;
        } else {
            super.setBalance(balance - (amount + fee));
        }

        super.withdraw(amount);
    }
}
