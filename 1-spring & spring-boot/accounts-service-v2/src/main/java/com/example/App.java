package com.example;

import org.apache.log4j.Logger;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.NEFTTxrServiceImpl;
import com.example.service.TransferService;

public class App {

	private static Logger logger = Logger.getLogger("accounts-service");

	public static void main(String[] args) {
		
		// third-party / vendor ==> container, who can create our application-context

		// ------------
		// Init / booting phase
		// ------------

		System.out.println("------------------------------------");
		AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
		AccountRepository jpaAccountRepository=new JpaAccountRepository();
		TransferService txrService = new NEFTTxrServiceImpl(jdbcAccountRepository); // DI
		System.out.println("------------------------------------");

		// ------------
		// Use phase
		// ------------

		//
		System.out.println("------------------------------------");
		txrService.transfer(100.00, "1", "2");
		System.out.println();
		txrService.transfer(100.00, "2", "1");
		System.out.println("------------------------------------");

		// ------------
		// Destroy phase
		// ------------

		//
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");

	}

}
