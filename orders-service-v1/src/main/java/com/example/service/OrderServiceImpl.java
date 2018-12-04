package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Order;
import com.example.model.OrderStatus;
import com.example.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order placeNewOrder(List<Item> items) {

		
		double totalAmount=items
							.stream()
							.mapToDouble(Item::getPrice)
							.sum();
		
		
		Order newOrder = new Order();
		newOrder.setStatus(OrderStatus.ACTIVE);
		newOrder.setTotalAmount(totalAmount);

		return orderRepository.save(newOrder);
		
	}

}
