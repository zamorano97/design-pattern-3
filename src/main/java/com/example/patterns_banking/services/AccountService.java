package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.AccountDTO;
import com.example.patterns_banking.factory.AccountFactoryProvider;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.IAccountRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.commands.CreateAccountCommand;
import com.example.patterns_banking.services.commands.DepositCommand;
import com.example.patterns_banking.services.commands.ICommand;
import com.example.patterns_banking.services.commands.WithdrawCommand;
import com.example.patterns_banking.services.proxy.IAccountOperations;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private final IAccountOperations proxy;

  public AccountService(IAccountOperations proxy) {
    this.proxy = proxy;
  }

  public Account createAccount(AccountDTO accountDTO) {
    return proxy.createAccount(accountDTO);
  }

  public Account deposit(Long accountId, Double amount) {
    return proxy.deposit(accountId, amount);
  }

  public Account withdraw(Long accountId, Double amount) {
    return proxy.withdraw(accountId, amount);
  }
}
