package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedHashSet;

import java.util.Set;

public class Category implements BaseDomain {
	private int idCategory;
	private String name;
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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
		return " category ";
	}

	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (name_category) ";
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
		Set<BaseDomain> categories = new LinkedHashSet<BaseDomain>();
		try {
			while(resultSet.next()) {
				Category category = new Category(resultSet.getString("name_category"));
				category.setIdCategory(resultSet.getInt("id_category"));
				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " name_category = ? ";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_category ";
	}

	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, idCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setInt(1, idCategory);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
