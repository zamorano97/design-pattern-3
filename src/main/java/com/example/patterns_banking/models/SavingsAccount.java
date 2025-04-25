package com.example.patterns_banking.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class SavingsAccount extends Account {
  private static final double MANAGEMENT_FEE = 5.0; // Monthly management fee
  private static final double TRANSFER_FEE_RATE = 0.01; // 1% of the amount
  private static final double DEPOSIT_FEE_RATE = 0.03; // 3% of the amount
  private static final double WITHDRAWAL_FEE_RATE = 0.005; // 0.5% of the amount

  @Override
  public Double calculateDepositFee(Double amount) {
    return amount * DEPOSIT_FEE_RATE;
  }

  @Override
  public double calculateWithdrawalFee(double amount) {
    return amount * WITHDRAWAL_FEE_RATE;
  }
}
