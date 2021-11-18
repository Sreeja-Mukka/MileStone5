package com.example.ms5.TestingProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.ms5.TestingProject.Controller.OrderController;
import com.example.ms5.TestingProject.Service.OrderService;
import com.example.ms5.TestingProject.entity.Order;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	OrderService service;

	@InjectMocks
	OrderController controller;

	@Test
	void OrderDateNullTest() {
		{
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
			Order or = null;

			ResponseEntity<Order> responseEntity = controller.addOrder(or);

			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(400);
		}
	}

	@Test
	void saveOrder() {
		{
			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
			Order order = new Order(101, "Key Chain", 110, new Date());

			when(service.saveOrder(any(Order.class))).thenReturn(order);

			ResponseEntity<Order> responseEntity = controller.addOrder(order);

			assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		}
	}

	@Test
	public void testFindAll() {
		Order order1 = new Order(10, "O1", 100, new Date());
		Order order2 = new Order(11, "O2", 100, new Date());
		Order order3 = new Order(12, "O3", 100, new Date());
		Order order4 = new Order(13, "O4", 100, new Date());
		List<Order> orders = new ArrayList<>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		when(service.showAllOrders()).thenReturn(orders);

		List<Order> result = service.showAllOrders();

		assertThat(result.size()).isEqualTo(4);
		assertThat(result.get(0).getId()).isEqualTo(order1.getId());
		assertThat(result.get(1).getName()).isEqualTo(order2.getName());
		assertThat(result.get(2).getAmount()).isEqualTo(order3.getAmount());
		assertThat(result.get(3).getOrderDate()).isEqualTo(order4.getOrderDate());
	}

}
