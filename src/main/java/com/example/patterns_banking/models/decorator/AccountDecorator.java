package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AccountDecorator extends Account {
  private Account account;

//  Crear un nuevo decorador para controlar qué tanto dinero se le puede prestar a una persona en un retiro
//  LIMITE sobre retiros: 20.000
//  Vamos a mostrar el valor excedido y vamos a dejar la cuenta en 0
//  I: 50k
//  W: 60k
//  T: 70k
//  Se hizo el retiro y el excedente fue de 10k
//  La cuenta me queda vacíá

  @Override
  public Long getId() {
    return account.getId();
  }

  @Override
  public String getAccountNumber() {
    return account.getAccountNumber();
  }

  @Override
  public Double getBalance() {
    return account.getBalance();
  }

  @Override
  public Customer getCustomer() {
    return account.getCustomer();
  }

  @Override
  public void setId(Long id) {
    account.setId(id);
  }

  @Override
  public void setAccountNumber(String accountNumber) {
    account.setAccountNumber(accountNumber);
  }

  @Override
  public void setBalance(Double balance) {
    account.setBalance(balance);
  }

  @Override
  public void setCustomer(Customer customer) {
    account.setCustomer(customer);
  }

  @Override
  public Double calculateDepositFee(Double amount) {
    return account.calculateDepositFee(amount);
  }

  @Override
  public double calculateWithdrawalFee(double amount) {
    return account.calculateWithdrawalFee(amount);
  }

  @Override
  public void withdraw(double amount) {
    account.withdraw(amount);
  }

  @Override
  public void deposit(Double amount) {
    account.deposit(amount);
  }
}
