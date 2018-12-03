package com.example.repository;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.example.model.Account;

public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	private DataSource dataSource;

	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String num) {
		logger.info("loading account -" + num);
		// ..
		return null;
	}

	public Account updateAccount(Account account) {
		logger.info("updating account -");
		// ..
		return null;
	}

}
