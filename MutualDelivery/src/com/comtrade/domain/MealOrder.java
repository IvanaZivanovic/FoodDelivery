package com.comtrade.domain;

import java.io.Serializable;

public class MealOrder implements Serializable {
	private int idMealOrder;
	private int quantity;
	private double amount;
	private String comment;
	private Order order;
	private Meal meal;
	
	public MealOrder(int quantity, double amount, String comment, Order order, Meal meal) {
		super();
		this.quantity = quantity;
		this.amount = amount;
		this.comment = comment;
		this.order = order;
		this.meal = meal;
	}

	public MealOrder() {
		super();
	}

	public int getIdMealOrder() {
		return idMealOrder;
	}

	public void setIdMealOrder(int idMealOrder) {
		this.idMealOrder = idMealOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	
	

}
