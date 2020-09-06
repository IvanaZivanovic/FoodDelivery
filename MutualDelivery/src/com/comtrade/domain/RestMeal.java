package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class RestMeal implements BaseDomain{
	private int idRestMeal;
	private int idRest;
	private int idMeal;
	private String nameMeal;
	private String sizeMeal;
	private double priceMeal;
	

	public RestMeal(int idRestMeal, int idRest, int idMeal, String nameMeal) {
		super();
		this.idRestMeal = idRestMeal;
		this.idRest = idRest;
		this.idMeal = idMeal;
		this.nameMeal = nameMeal;
	}


	public RestMeal() {
		super();
	}


	public int getIdRestMeal() {
		return idRestMeal;
	}


	public void setIdRestMeal(int idRestMeal) {
		this.idRestMeal = idRestMeal;
	}


	public int getIdRest() {
		return idRest;
	}


	public void setIdRest(int idRest) {
		this.idRest = idRest;
	}


	public int getIdMeal() {
		return idMeal;
	}


	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}


	public String getNameMeal() {
		return nameMeal;
	}


	public void setNameMeal(String nameMeal) {
		this.nameMeal = nameMeal;
	}

	

	public String getSizeMeal() {
		return sizeMeal;
	}


	public void setSizeMeal(String sizeMeal) {
		this.sizeMeal = sizeMeal;
	}


	public double getPriceMeal() {
		return priceMeal;
	}


	public void setPriceMeal(double priceMeal) {
		this.priceMeal = priceMeal;
	}


	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " meal_restaurant ";
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
		return " id_meal_restaurant ";
	}


	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idRestMeal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	

}
