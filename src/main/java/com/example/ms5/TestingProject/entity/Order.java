package com.example.ms5.TestingProject.entity;

import java.util.Date;

public class Order {

	private int id;
	private String name;
	private float amount;
	private Date orderDate;

	public Order() {

	}

	public Order(int id, String name, float amount, Date orderDate) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
