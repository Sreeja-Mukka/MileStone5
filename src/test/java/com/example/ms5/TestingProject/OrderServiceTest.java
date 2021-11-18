package com.example.ms5.TestingProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ms5.TestingProject.Service.OrderService;
import com.example.ms5.TestingProject.entity.Order;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@Autowired
	@InjectMocks
	OrderService oservice;

	@Test
	void addOrderTestCase() {
		Order or = new Order();
		or.setId(1);
		or.setName("Phones");
		or.setAmount(1234);
		or.setOrderDate(new Date());

		// when(oservice.saveOrder(any(Order.class))).thenReturn(or);

		Order savedOrder = oservice.saveOrder(or);
		assertThat(savedOrder.getName()).isNotNull();
	}

	@Test
	void getAllOrdersTest() {
		List<Order> orders = oservice.showAllOrders();
		assertThat(orders.size()).isEqualTo(3);
	}
}
