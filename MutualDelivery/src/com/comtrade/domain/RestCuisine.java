package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class RestCuisine implements BaseDomain{
	private int idRestCuisine;
	private int idRest;
	private int idCuisine;
	private String nameCuisine;
	public RestCuisine(int idRestCuisine, int idRest, int idCuisine, String nameCuisine) {
		super();
		this.idRestCuisine = idRestCuisine;
		this.idRest = idRest;
		this.idCuisine = idCuisine;
		this.nameCuisine = nameCuisine;
	}
	public RestCuisine() {
		super();
	}
	public int getIdRestCuisine() {
		return idRestCuisine;
	}
	public void setIdRestCuisine(int idRestCuisine) {
		this.idRestCuisine = idRestCuisine;
	}
	public int getIdRest() {
		return idRest;
	}
	public void setIdRest(int idRest) {
		this.idRest = idRest;
	}
	public int getIdCuisine() {
		return idCuisine;
	}
	public void setIdCuisine(int idCuisine) {
		this.idCuisine = idCuisine;
	}
	public String getNameCuisine() {
		return nameCuisine;
	}
	public void setNameCuisine(String nameCuisine) {
		this.nameCuisine = nameCuisine;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " restaurant_cuisine ";
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
		return " id_restaurant_cuisine ";
	}
	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idRestCuisine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
