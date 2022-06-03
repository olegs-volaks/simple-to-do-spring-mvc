package com.ovolaks.simpletodo.controllers;

import com.ovolaks.simpletodo.application.dto.user.CreateUserDto;
import com.ovolaks.simpletodo.application.services.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private CreateUserService createUserService;

    @GetMapping("/register")
    public String index(CreateUserDto createUserDto) {

        return "/register/register";
    }

    @PostMapping("/register")
    public String create(@Valid CreateUserDto createUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register/register";
        }
        createUserService.execute(createUserDto);
        return "redirect:/login";
    }
}
