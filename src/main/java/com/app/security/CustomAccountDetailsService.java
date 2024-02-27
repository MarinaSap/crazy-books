package com.app.security;

import com.app.dao.AccountDAO;
import com.app.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomAccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<Account> accounts = accountDAO.getAccountByLogin(username);

        if (accounts.isEmpty()) {
            throw new UsernameNotFoundException("Account " + username + " not found");
        }

        return new CustomAccountDetails(accounts.get(0));
    }
}
