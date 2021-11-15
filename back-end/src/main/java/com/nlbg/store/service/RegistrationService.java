package com.nlbg.store.service;

import com.nlbg.store.domain.Token.ConfirmationToken;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.domain.Token.RegistrationRequest;
import com.nlbg.store.security.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class RegistrationService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

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

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("Token not found."));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email already confirmed.");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token has expired.");
        }

        confirmationTokenService.setConfirmedAt(token);
        customerService.enableCustomer(
                confirmationToken.getCustomer().getEmail());
        return "confirmed";
    }
}
