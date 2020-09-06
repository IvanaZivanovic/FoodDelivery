package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Order implements BaseDomain {
	private int idOrder;
	private double amount;
	private LocalDate date;
	private LocalTime time;
	private String status;
	private User user;
	private Restaurant restaurant;
	private Address address;
	private List<MealOrder> mealOrdersList = new CopyOnWriteArrayList<MealOrder>();
	private String message;
	
	

	public Order(double amount, LocalDate date, LocalTime time, String status, User user, Restaurant restaurant,
			Address address, List<MealOrder> mealOrdersList) {
		super();
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.status = status;
		this.user = user;
		this.restaurant = restaurant;
		this.address = address;
		this.mealOrdersList = mealOrdersList;
	}

	public Order() {
		super();
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<MealOrder> getMealOrdersList() {
		return mealOrdersList;
	}

	public void setMealOrdersList(List<MealOrder> mealOrdersList) {
		this.mealOrdersList = mealOrdersList;
	}
	public void addMealOrder(MealOrder mealOrder) {
		
		mealOrdersList.add(mealOrder);
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " `order` ";
	}

	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (status, message_order) ";
	}

	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?) ";
	}

	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " status = ?, message_order = ? ";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_order ";
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, status);
			preparedStatement.setString(2, message);
			preparedStatement.setInt(3, idOrder);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}
	
	

}
