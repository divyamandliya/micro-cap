package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Service
@Component("txrService")
public class NEFTTxrServiceImpl implements TransferService {

	private AccountRepository accountRepository;

	@Autowired
	public NEFTTxrServiceImpl(@Qualifier(value = "jpa") AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {

		// step-1 : load accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// step-2 : debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// step-3 : update accounts
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		return true;

	}

}
