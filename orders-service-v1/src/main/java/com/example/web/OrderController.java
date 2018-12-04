package com.example.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Item;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1/orders/{userId}")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderRepository orderRepository;

	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping
	public List<Order> getAll(@PathVariable String userId) {
		return orderRepository.findAll();
	}

	@PostMapping
	public Order newOrder(@PathVariable String userId) {

		// cart-service
		String cartServiceUrl = "http://localhost:8383/api/v1/cart/" + userId;
		ResponseEntity<Item[]> response = restTemplate.getForEntity(cartServiceUrl, Item[].class);
		Item[] items = response.getBody();

		// accounts-service
		double totalAmount = Arrays.stream(items).mapToDouble(Item::getPrice).sum();
		String accountsServiceUrl = "http://localhost:8181/txr";

		TxrRequest request = new TxrRequest();
		request.setAmount(totalAmount);
		request.setFromAccNum("1");
		request.setToAccNum("2");
		ResponseEntity<TxrResponse> responseEntity = restTemplate.postForEntity(accountsServiceUrl, request,
				TxrResponse.class);
		TxrResponse txrResponse = responseEntity.getBody();
		// ..

		Order order = orderService.placeNewOrder(Arrays.asList(items));
		
		restTemplate.delete(cartServiceUrl);

		return order;

	}

}
