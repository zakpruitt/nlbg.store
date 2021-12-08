package com.nlbg.store.controller;

import com.nlbg.store.domain.Token.RegistrationRequest;
import com.nlbg.store.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/r")
    public String renderSignUp(Model model) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        model.addAttribute("registrationRequest", registrationRequest);
        return "register";
    }

    @GetMapping("/success")
    public String renderSuccess() {
        return "r_success";
    }

    @PostMapping("/")
    public String register(@ModelAttribute("registrationRequest") RegistrationRequest registrationRequest) {
        System.out.println(registrationRequest.getPassword());
        registrationService.register(registrationRequest);
        return "redirect:/registration/success";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "t_success";
    }
}
