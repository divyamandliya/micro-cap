package com.example.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication(scanBasePackages= {"com.example.repository","com.example.service"})
//or
@Configuration
@EnableAutoConfiguration
//@PropertySource("classpath:foo.properties")
@ComponentScan(basePackages= {"com.example.config","com.example.repository","com.example.service"})
@EntityScan(basePackages= {"com.example.model"})
public class AccountsServiceConfig {

	
}
