package com.comtrade.domain;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import java.util.Set;

public class Restaurant implements BaseDomain{
	private int idRestaurant;
	private String name;
	private String city;
	private String municipallity;
	private double minOrder;
	private LocalTime openTime;
	private LocalTime closeTime;
	private Set<Cuisine> cuisines;
	private Set<Category> categories;
	private Set<Meal> meals;
	private User user;
	private String photo;
	
	
	public Restaurant(String name, String city, String municipallity, double minOrder, LocalTime openTime,
			LocalTime closeTime, User user) {
		super();
		this.name = name;
		this.city = city;
		this.municipallity = municipallity;
		this.minOrder = minOrder;
		this.openTime = openTime;
		this.closeTime = closeTime;
		
		this.user = user;
	}
	
	

	public Restaurant(String name, String city, String municipallity, double minOrder) {
		super();
		this.name = name;
		this.city = city;
		this.municipallity = municipallity;
		this.minOrder = minOrder;
	}



	public Restaurant() {
		super();
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMunicipallity() {
		return municipallity;
	}

	public void setMunicipallity(String municipallity) {
		this.municipallity = municipallity;
	}

	public double getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(double minOrder) {
		this.minOrder = minOrder;
	}
	
	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}
	
	public Set<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(Set<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Meal> getMeals() {
		return meals;
	}

	public void setMeals(Set<Meal> meals) {
		this.meals = meals;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " restaurant ";
	}

	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (name_restaurant, min_order, city, municipality, open_time, close_time, photo_restaurant, id_user) ";
	}

	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?, ?, ?, ?, ?, ?, ?, ?) ";
	}

	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, minOrder);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, municipallity);
			preparedStatement.setTime(5, Time.valueOf(openTime));
			preparedStatement.setTime(6, Time.valueOf(closeTime));
			preparedStatement.setString(7, photo);
			preparedStatement.setInt(8, getUser().getIdUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		
		return null;
	}
//OVDE SI STALA
	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " name_restaurant = ?, min_order = ?, city = ?, municipality = ?, open_time = ?, close_time = ?, photo_restaurant = ?, id_user = ? ";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_restaurant ";
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, minOrder);
			preparedStatement.setString(3, city);
			preparedStatement.setString(4, municipallity);
			preparedStatement.setTime(5, Time.valueOf(getOpenTime()));
			preparedStatement.setTime(6, Time.valueOf(getCloseTime()));
			preparedStatement.setString(7, photo);
			preparedStatement.setInt(8, getUser().getIdUser());
			preparedStatement.setInt(9, idRestaurant);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idRestaurant);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

}
