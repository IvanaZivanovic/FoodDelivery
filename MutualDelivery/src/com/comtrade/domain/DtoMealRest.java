package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

public class DtoMealRest implements BaseDomain{
	private int idMeal;
	private int idRestMeal;
	private String name;
	private double price;
	private String size;
	private Cuisine cuisine;
	private Category category;
	private Restaurant restaurant;
	
	public DtoMealRest() {
		super();
	}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}
	
	
	public int getIdRestMeal() {
		return idRestMeal;
	}

	public void setIdRestMeal(int idRestMeal) {
		this.idRestMeal = idRestMeal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
