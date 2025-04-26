package com.example.patterns_banking.services.proxy;

import org.springframework.stereotype.Component;

@Component
public class CustomerOperationsProxy implements ICustomerOperations {

    @Override
    public boolean isValidEmail(String email) {
        return !email.toLowerCase().contains("@yahoo");
    }
}