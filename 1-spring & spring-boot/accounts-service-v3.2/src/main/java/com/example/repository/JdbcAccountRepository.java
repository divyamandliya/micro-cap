package com.example.repository;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

//@Component
@Repository
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	private DataSource dataSource;

	@Autowired
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
