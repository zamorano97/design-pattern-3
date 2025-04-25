package com.example.patterns_banking.services.proxy;

import com.example.patterns_banking.dtos.AccountDTO;
import com.example.patterns_banking.models.Account;

public interface IAccountOperations {
  Account createAccount(AccountDTO accountDTO);
  Account deposit(Long accountId, Double amount);
  Account withdraw(Long accountId, Double amount);
}
