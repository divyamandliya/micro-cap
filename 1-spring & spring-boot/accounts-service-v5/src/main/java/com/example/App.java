package com.example;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AccountsServiceConfig;
import com.example.config.DataSourceConfig;
import com.example.service.TransferService;

public class App {

	private static Logger logger = Logger.getLogger("accounts-service");

	public static void main(String[] args) {

		// third-party / vendor ==> container, who can create our application-context

		// ------------
		// Init / booting phase
		// ------------

		System.out.println("------------------------------------");

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = new AnnotationConfigApplicationContext(AccountsServiceConfig.class);

		System.out.println("------------------------------------");

		// ------------
		// Use phase
		// ------------

		TransferService txrService = applicationContext.getBean("txrService", TransferService.class);

		//
		System.out.println("------------------------------------");
		txrService.transfer(100.00, "1", "2");
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
