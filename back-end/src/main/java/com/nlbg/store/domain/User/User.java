package com.nlbg.store.domain.User;

import lombok.Data;
import org.apache.tomcat.jni.Address;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotEmpty(message = "First Name is required.")
    protected String firstName;
    @NotNull(message = "Last Name is required.")
    protected String lastName;
    @NotNull(message = "Email is required.")
    @Email
    protected String email;
    @Pattern(regexp="(^$|[0-9]{10})")
    protected String phoneNumber;
    @NotNull(message = "Shipping Address is required.")
    protected String shippingAddress;
    @NotNull(message = "Billing Address is required.")
    protected String billingAddress;
}
