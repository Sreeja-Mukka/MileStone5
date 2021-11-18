package com.example.ms5.TestingProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms5.TestingProject.Service.OrderService;
import com.example.ms5.TestingProject.entity.Order;

@RestController
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping(value = "/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order o) {
		try {
			if (o == null) {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
			Order order = service.saveOrder(o);
			if (order == null) {
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/showOrders")
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
			List<Order> listOfOrders = service.showAllOrders();
			if (listOfOrders.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(listOfOrders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
