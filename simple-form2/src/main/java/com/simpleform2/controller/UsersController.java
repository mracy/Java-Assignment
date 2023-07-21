package com.simpleform2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import com.simpleform2.model.UsersModel;
import com.simpleform2.service.UsersService;

@Controller
public class UsersController {

    private UsersService usersService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @PostMapping("/register")
    public String register(UsersModel usersModel) {
        UsersModel registeredUser = usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        if (registeredUser == null) {
            return "error_page";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/login")
    public String login(UsersModel usersModel) {
        UsersModel authenticate = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if (authenticate != null) {
            return "personal_page";
        } else {
            return "error_page";
        }
    }
}