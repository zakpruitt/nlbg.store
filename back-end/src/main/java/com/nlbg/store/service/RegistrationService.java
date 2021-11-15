package com.nlbg.store.service;

import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.domain.User.RegistrationRequest;
import com.nlbg.store.security.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid.");
        }
        return customerService.signUpUser(
                new Customer(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getPassword(),
                        request.getEmail(),
                        request.getPhoneNumber(),
                        request.getShippingAddress(),
                        request.getBillingAddress()
                )
        );
    }
}
