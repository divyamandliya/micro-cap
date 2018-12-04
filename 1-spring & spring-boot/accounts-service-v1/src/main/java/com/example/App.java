package com.example;

import org.apache.log4j.Logger;

import com.example.service.NEFTTxrServiceImpl;

public class App {

	private static Logger logger = Logger.getLogger("accounts-service");

	public static void main(String[] args) {

		// ------------
		// Init / booting phase
		// ------------

		System.out.println("------------------------------------");
		NEFTTxrServiceImpl txrService = new NEFTTxrServiceImpl();
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
