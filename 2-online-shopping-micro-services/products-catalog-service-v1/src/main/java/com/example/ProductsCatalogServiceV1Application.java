package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories
public class ProductsCatalogServiceV1Application {
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${service.name}")
	private String serviceName;
	
	@Value("${id}")
	private int id;

	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductsCatalogServiceV1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner test(ProductRepository productRepository) {
		return args -> {

//			Optional<Product> optional = productRepository.findById(111);
//			if (optional.isPresent()) {
//				System.out.println(optional.get());
//			} 

//			productRepository.findAll()
//			.forEach(System.out::println);
			
//
//			productRepository.findByPrice(10)
//			.forEach(System.out::println);
			
			System.out.println("-------------------------------------");
			System.out.println("app-name : "+appName);
			System.out.println("service-name : "+serviceName);
			System.out.println("ID : "+id);
			System.out.println("-------------------------------------");
			

		};
	}
}
