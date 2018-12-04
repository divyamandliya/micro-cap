package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;
import com.example.repository.CartRepository;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping(value = "/api/v1/cart/{userId}")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@PostMapping
	public void addToCart(@PathVariable String userId, @RequestBody Item item) {
		cartRepository.addToCart(userId, item);
	}

	@GetMapping
	public List<Item> get(@PathVariable String userId) {
		return cartRepository.findAll(userId);
	}
	
	@DeleteMapping
	public void clear(@PathVariable String userId) {
		cartRepository.clearAll(userId);
	}

}
