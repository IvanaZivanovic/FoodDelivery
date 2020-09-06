package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Meal implements BaseDomain{
	private int idMeal;
	private String name;
	private double price;
	private String size;
	private Cuisine cuisine;
	private Category category;
	
	
	public Meal(String name, double price, Cuisine cuisine, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.cuisine = cuisine;
		this.category = category;
	}

	public Meal() {
		super();
	}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
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
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " meal ";
	}

	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (name_meal, price, size, id_cuisine, id_category) ";
	}

	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?, ?, ?, ?, ?)";
	}

	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, size);
			preparedStatement.setInt(4, getCuisine().getIdCuisine());
			preparedStatement.setInt(5, getCategory().getIdCategory());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		
		return null;
	}

	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " name_meal = ?, price = ?, size = ?, id_cuisine = ?, id_category = ?";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_meal ";
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setString(3, size);
			preparedStatement.setInt(4, getCuisine().getIdCuisine());
			preparedStatement.setInt(5, getCategory().getIdCategory());
			preparedStatement.setInt(6, idMeal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idMeal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
