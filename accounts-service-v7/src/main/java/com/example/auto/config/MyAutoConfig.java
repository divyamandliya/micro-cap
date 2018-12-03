package com.example.auto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.config.MyProperties;

@Configuration
//@ConditionalOnProperty(name = "property", prefix = "my")
public class MyAutoConfig {
	
	@Autowired
	private MyProperties myProperties;

	@Bean
	public String myBean() {
		return myProperties.getProperty();
	}

}
