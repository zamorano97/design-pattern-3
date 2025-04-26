package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final ICustomerRepository customerRepository;
  private final ICustomerOperations proxy;

  public Customer create(CustomerDTO customerDTO) {
    Customer customer = Customer
      .builder()
      .name(customerDTO.getName())
      .email(customerDTO.getEmail())
      .build();
    // Implementar proxy para verificar que el correo no sea del dominio yahoo
  if (!proxy.isValidEmail(customer.getEmail())) {
      throw new IllegalArgumentException("The domain is not allowed.");
   }
    return customerRepository.save(customer);
  }
}
