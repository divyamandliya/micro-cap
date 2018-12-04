package com.example.service;

import org.apache.log4j.Logger;

import com.example.model.Account;
import com.example.repository.AccountRepository;

/*
 * 
 *  design & performance issues
 *  ---------------------------
 *  
 *  => tight-coupling b/w dependent & dependency
 *  	-> can't extend with new-features
 *  => too many duplicate dependency instances got created & discarded
 *  	-> slow, memory/resource use high
 *  => Unit-Testing Not possible
 *  	-> dev / bug-fix slow
 *  
 *  
 *  
 *  why these issues ?
 *  
 *  => dependent itself creating it's own dependency
 *  
 *  soln:
 *  
 *  => don't create dependency in dependent's class , do lookup on factory
 *  
 *  Limitation on factory-lookup:
 *  
 *  => location tight-coupling with factory
 *  
 *  best-soln:
 *  
 *  => don't create / lookup on factory , inject/get by 'third-party'   ( IOC => Inverting Of Control )
 * 
 * 
 * 
 *   principal:  => dependency inversion 
 *   
 *   how to implement this ?
 *   
 *   2 ways
 *   
 *   	-> dependency injection ( DI )  
 *   	-> Aspect Oriented Programming ( AOP )
 *   
 * 
 * 
 */

public class NEFTTxrServiceImpl implements TransferService {

	private static Logger logger = Logger.getLogger("accounts-service");

	private AccountRepository accountRepository;

	public NEFTTxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("NEFTTxrService instance created..");
	}

	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {

		logger.info("Txr-intiated..");

		// step-1 : load accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// step-2 : debit & credit

		// step-3 : update accounts
		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("Txr-completed..");

		return true;

	}

}
