package com.app.dao;

import com.app.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewAccount(Account account) {
        jdbcTemplate.update("INSERT INTO accounts (login, password, name_surname, email) " +
                "VALUES (?, ?, ?, ?)", account.getLogin(), account.getPassword(),
                account.getNameSurname(), account.getEmail());
    }

    public List<Account> getAllAccounts() {
        RowMapper<Account> rowMapper = (rs, rowNumber) -> mapAccount(rs);
        return jdbcTemplate.query("SELECT * FROM accounts", rowMapper);
    }

    public List<Account> getAccountByLogin(String login){
        RowMapper<Account> rowMapper = (rs, rowNumber) -> mapAccount(rs);
        return jdbcTemplate.query("SELECT * FROM accounts WHERE account = ?", rowMapper, login);
    }

    private Account mapAccount(ResultSet rs) throws SQLException {
        Account account = new Account();

        account.setId(rs.getLong("id"));
        account.setLogin(rs.getString("login"));
        account.setNameSurname(rs.getString("name_surname"));
        account.setEmail(rs.getString("email"));
        account.setPassword(rs.getString("password"));

        return account;
    }
}
