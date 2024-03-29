package com.app.controllers;

import com.app.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountsController {
    @Autowired
    private AccountServices accountServices;

    @GetMapping("/allAccounts")
    public String getAllAccountsPage(Model model){
        model.addAttribute("accounts", accountServices.getAllAccounts());
        return "allAccounts";
    }
}
