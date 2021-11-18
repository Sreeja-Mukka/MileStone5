package com.example.ms5.TestingProject.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ms5.TestingProject.entity.Order;

@Service
public class OrderService {

	private static List<Order> orders = new ArrayList<Order>();

	static {
		orders.add(new Order(1, "Books", 234, new Date()));
		orders.add(new Order(2, "Pens", 134, new Date()));
		orders.add(new Order(3, "Pencils", 452, new Date()));
	}

	public Order saveOrder(Order o) {
		orders.add(o);
		return o;
	}

	public List<Order> showAllOrders() {
		return orders;
	}
}
