package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.config.AccountsServiceConfig;
import com.example.service.TransferService;

public class App {

	public static void main(String[] args) {

		// third-party / vendor ==> container, who can create our application-context

		// ------------
		// Init / booting phase
		// ------------

		System.out.println("------------------------------------");

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = SpringApplication.run(AccountsServiceConfig.class, args);

		System.out.println("------------------------------------");

		// ------------
		// Use phase
		// ------------

		TransferService txrService = applicationContext.getBean("txrService", TransferService.class);

		//
		System.out.println("------------------------------------");
		txrService.transfer(100.00, "1", "2");
		System.out.println("------------------------------------");

		System.out.println("------------------------------------");
		String myBean = applicationContext.getBean("myBean", String.class);
		System.out.println(myBean);
		System.out.println("------------------------------------");

		// ------------
		// Destroy phase
		// ------------

		//
		System.out.println("------------------------------------");
		applicationContext.close();
		System.out.println("------------------------------------");

	}

}
