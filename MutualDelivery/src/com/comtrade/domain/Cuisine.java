package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cuisine implements BaseDomain {
	private int idCuisine;
	private String name;
	public Cuisine(String name) {
		super();
		this.name = name;
	}
	public Cuisine() {
		super();
	}
	public int getIdCuisine() {
		return idCuisine;
	}
	public void setIdCuisine(int idCuisine) {
		this.idCuisine = idCuisine;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " cuisine ";
	}
	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (name_cuisine) ";
	}
	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?) ";
	}
	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		Set<BaseDomain> cuisines = new LinkedHashSet<BaseDomain>();
		try {
			while (resultSet.next()) {
				Cuisine c = new Cuisine(resultSet.getString("name_cuisine"));
				c.setIdCuisine(resultSet.getInt("id_cuisine"));
				cuisines.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuisines;
	}
	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " name_cuisine = ? ";
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_cuisine ";
	}
	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, idCuisine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idCuisine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
