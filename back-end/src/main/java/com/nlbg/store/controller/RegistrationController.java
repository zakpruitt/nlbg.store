package com.nlbg.store.controller;

import com.nlbg.store.domain.User.RegistrationRequest;
import com.nlbg.store.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
