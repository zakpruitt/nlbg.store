package com.nlbg.store.service;

import com.nlbg.store.domain.Token.ConfirmationToken;
import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerService implements UserDetailsService {

    private final String USER_NOT_FOUND = "User with email %s not found.";
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email))
        );
    }

    public String signUpUser(Customer customer) {
        boolean userExists = customerRepository
                .findByEmail(customer.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        customerRepository.save(customer);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                customer
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public int enableCustomer(String email) {
        return customerRepository.enableCustomer(email);
    }
}
