package com.app.services;

import com.app.dao.AccountDAO;
import com.app.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServices {
    @Autowired
    private AccountDAO accountDAO;

    public void storeNewAccount(Account account) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(account.getPassword());
        account.setPassword(encodedPassword);

        accountDAO.storeNewAccount(account);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }
}
