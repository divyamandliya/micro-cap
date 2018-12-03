package com.example.repository;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

//@Component
@Repository
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String num) {
		logger.info("loading account -" + num);
		String sql = "select * from my_bank.ACCOUNTS where num=?";
		return jdbcTemplate.queryForObject(sql, (rs, ronNum) -> {
			Account account = new Account();
			account.setNum(rs.getString(1));
			account.setBalance(rs.getDouble(3));
			return account;
		}, num);
	}

	public Account updateAccount(Account account) {
		logger.info("updating account -" + account.getNum());
		String sql = "update my_bank.ACCOUNTS set balance=? where num=?";
		jdbcTemplate.update(sql, account.getBalance(), account.getNum());
		return account;
	}

}
