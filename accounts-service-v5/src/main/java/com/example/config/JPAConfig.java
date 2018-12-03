package com.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JPAConfig {

	// JPA ==> dataSource ==> EMF ==> EM

	@Autowired
	private DataSource dataSource;

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan("com.example.model");
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		entityManagerFactoryBean.setJpaProperties(props);
		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf().getObject());
		return tm;
	}

}
