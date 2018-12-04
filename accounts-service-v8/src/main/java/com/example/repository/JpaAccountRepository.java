package com.example.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;

//@Component
@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Account loadAccount(String num) {
		return em.find(Account.class, num);

	}

	@Transactional
	public Account updateAccount(Account account) {
		return em.merge(account);
	}

}
