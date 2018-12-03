package com.example.auto.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "property", prefix = "your")
public class YourAutoConfig {

	// ..

	@Bean
	public String yourBean() {
		return "YOUR_BEAN";
	}

}
