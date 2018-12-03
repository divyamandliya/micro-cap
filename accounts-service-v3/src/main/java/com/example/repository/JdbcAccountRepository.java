package com.example.repository;

import org.apache.log4j.Logger;

import com.example.model.Account;

public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	public JdbcAccountRepository() {
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
