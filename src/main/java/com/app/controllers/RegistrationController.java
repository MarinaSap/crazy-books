package com.app.controllers;

import com.app.model.Account;
import com.app.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private AccountServices accountServices;

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("newAccount", new Account());
        return "registration";
    }

    @PostMapping("/registration")
    public String storeNewAccount(@ModelAttribute Account account, Model model) {
        accountServices.storeNewAccount(account);
        model.addAttribute("login", account.getLogin());
        model.addAttribute("nameSurname", account.getNameSurname());
        return "successRegistration";

    }
}
