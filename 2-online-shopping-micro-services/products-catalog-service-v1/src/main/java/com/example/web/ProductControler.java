package com.example.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/api/v1/products")
public class ProductControler {

	private ProductRepository productRepository;

	public ProductControler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		List<Product> products = productRepository.findAll();
		return ResponseEntity.ok(products);
	}
	// ..

}
