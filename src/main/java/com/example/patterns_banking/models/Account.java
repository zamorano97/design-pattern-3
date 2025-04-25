package com.example.patterns_banking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String accountNumber;
  private Double balance;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  @JsonBackReference
  private Customer customer;

  public abstract Double calculateDepositFee(Double amount);
  public abstract double calculateWithdrawalFee(double amount);

  public void deposit(Double amount) {
    double fee = calculateDepositFee(amount);
    this.balance += amount - fee;
  }

  public void withdraw(double amount) {
    if (amount > this.balance) {
      throw new IllegalArgumentException("Insufficient funds");
    }
    double fee = calculateWithdrawalFee(amount);
    this.balance -= (amount + fee);
  }
}
