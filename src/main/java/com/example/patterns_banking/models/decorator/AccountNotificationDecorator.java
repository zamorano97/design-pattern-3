package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class AccountNotificationDecorator extends AccountDecorator {
  public AccountNotificationDecorator(Account account) {
    super(account);
  }

  @Override
  public void deposit(Double amount) {
    super.deposit(amount);
    System.out.println("Se ha realizado un deposito de: " + amount + " en la cuenta de: " + getAccountNumber());
  }
}
