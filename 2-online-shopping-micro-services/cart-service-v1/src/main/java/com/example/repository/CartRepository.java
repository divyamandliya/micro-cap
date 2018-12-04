package com.example.repository;

import java.util.List;

import com.example.model.Item;

public interface CartRepository {
	
	public void addToCart(String userId,Item item);
	public List<Item> findAll(String userId);
	public void clearAll(String userId);

}
