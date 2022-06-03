package com.ovolaks.simpletodo.controllers;

import com.ovolaks.simpletodo.application.services.authentication.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @GetMapping("/login")
    public String login() {
        if (authenticationFacade.isAuthenticated()) {
            return "redirect:/";
        }
        return "/login/login";
    }
}
