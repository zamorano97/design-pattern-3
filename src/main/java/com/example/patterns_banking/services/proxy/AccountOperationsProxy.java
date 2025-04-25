package com.example.patterns_banking.services.proxy;

import com.example.patterns_banking.dtos.AccountDTO;
import com.example.patterns_banking.factory.AccountFactoryProvider;
import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.repositories.IAccountRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.commands.CreateAccountCommand;
import com.example.patterns_banking.services.commands.DepositCommand;
import com.example.patterns_banking.services.commands.ICommand;
import com.example.patterns_banking.services.commands.WithdrawCommand;
import org.springframework.stereotype.Component;

@Component
public class AccountOperationsProxy implements IAccountOperations {
  private final IAccountRepository accountRepository;
  private final ICustomerRepository customerRepository;
  private final AccountFactoryProvider accountFactoryProvider;

  public AccountOperationsProxy(IAccountRepository accountRepository, ICustomerRepository customerRepository, AccountFactoryProvider accountFactoryProvider) {
    this.accountRepository = accountRepository;
    this.customerRepository = customerRepository;
    this.accountFactoryProvider = accountFactoryProvider;
  }

  @Override
  public Account createAccount(AccountDTO accountDTO) {
    ICommand<Account> command = new CreateAccountCommand(accountRepository, customerRepository, accountFactoryProvider, accountDTO);
    return command.execute();
  }

  @Override
  public Account deposit(Long accountId, Double amount) {
    validateTransaction(accountRepository.findById(accountId).get(), amount);
    ICommand<Account> command = new DepositCommand(accountRepository, accountId, amount);
    return command.execute();
  }

  @Override
  public Account withdraw(Long accountId, Double amount) {
    validateTransaction(accountRepository.findById(accountId).get(), amount);
    ICommand<Account> command = new WithdrawCommand(accountId, amount, accountRepository);
    return command.execute();
  }

  private void validateTransaction(Account account, Double amount) {
    if (amount > 999999999) {
      throw new IllegalArgumentException("La cuenta " + account.getAccountNumber() + " ha excedido el limite de 999999999 por transaccion");
    }
  }
}
