package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(value= {DataSourceConfig.class,JPAConfig.class})
@ComponentScan(basePackages= {"com.example.repository","com.example.service","com.example.config"})
@EnableTransactionManagement
public class AccountsServiceConfig {

}
