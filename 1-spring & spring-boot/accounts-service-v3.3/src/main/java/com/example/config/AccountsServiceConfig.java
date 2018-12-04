package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {DataSourceConfig.class})
@ComponentScan(basePackages= {"com.example.repository","com.example.service","com.example.config"})
public class AccountsServiceConfig {

}
