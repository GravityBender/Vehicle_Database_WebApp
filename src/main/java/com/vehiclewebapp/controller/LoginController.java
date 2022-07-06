package com.vehiclewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "admin-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";
    }

}
