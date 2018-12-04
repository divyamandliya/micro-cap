package com.example.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

//@Component
@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	public JpaAccountRepository() {
		logger.info("JpaAccountRepository instance created");
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
