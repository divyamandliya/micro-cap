package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

//@Component
@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	private static Logger logger = Logger.getLogger("accounts-service");

	@PersistenceContext
	private EntityManager em;

	@Autowired
	public JpaAccountRepository() {
		logger.info("JdbcAccountRepository instance created");
	}

	public Account loadAccount(String num) {
		logger.info("loading account -" + num);
		return em.find(Account.class, num);

	}

	public Account updateAccount(Account account) {
		logger.info("updating account -" + account.getNum());
		return em.merge(account);
	}

}
