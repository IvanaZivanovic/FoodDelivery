package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class RestCat implements BaseDomain{
	private int idRestCat;
	private int idRestaurant;
	private int idCategory;
	private String nameCategory;
	
	
	public RestCat() {
		super();
	}

	public int getIdRestCat() {
		return idRestCat;
	}

	public void setIdRestCat(int idRestCat) {
		this.idRestCat = idRestCat;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public RestCat(int idRestCat, int idRestaurant, int idCategory, String nameCategory) {
		super();
		this.idRestCat = idRestCat;
		this.idRestaurant = idRestaurant;
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " restaurant_category ";
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
		return " id_restaurant_category ";
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idRestCat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
