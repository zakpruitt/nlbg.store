package com.nlbg.store.service;

import com.nlbg.store.domain.User.Customer;
import com.nlbg.store.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String USER_NOT_FOUND = "User with email %s not found.";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
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
       return "it works" + customer.getPassword();
    }
}
