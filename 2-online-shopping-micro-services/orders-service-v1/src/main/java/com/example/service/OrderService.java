package com.example.service;

import java.util.List;

import com.example.model.Item;
import com.example.model.Order;

public interface OrderService {

	public Order placeNewOrder(List<Item> items);

}
