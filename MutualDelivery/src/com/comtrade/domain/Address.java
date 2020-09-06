package com.comtrade.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Address implements BaseDomain{
	private int idAddress;
	private String city;
	private String zipCode;
	private String municipality;
	private String streetName;
	private String streetNo;
	private String appNumber;
	private String appLastName;
	private User user;
	public Address(String city, String zipCode, String municipality, String streetName, String streetNo,
			String appNumber, String appLastName, User user) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.municipality = municipality;
		this.streetName = streetName;
		this.streetNo = streetNo;
		this.appNumber = appNumber;
		this.appLastName = appLastName;
		this.user = user;
	}
	public Address() {
		super();
	}
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getAppNumber() {
		return appNumber;
	}
	public void setAppNumber(String appNumber) {
		this.appNumber = appNumber;
	}
	public String getAppLastName() {
		return appLastName;
	}
	public void setAppLastName(String appLastName) {
		this.appLastName = appLastName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " address ";
	}
	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (city_a, zip_code, municipality_a, street_name, street_number, appartment_number, last_name_a, id_user) ";
	}
	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?, ?, ?, ?, ?, ?, ?, ?) ";
	}
	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, city);
			preparedStatement.setString(2, zipCode);
			preparedStatement.setString(3, municipality);
			preparedStatement.setString(4, streetName);
			preparedStatement.setString(5, streetNo);
			preparedStatement.setString(6, appNumber);
			preparedStatement.setString(7, appLastName);
			preparedStatement.setInt(8, getUser().getIdUser());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " city_a = ?, zip_code = ?, municipality_a = ?, street_name = ?, street_number = ?,"
				+ " appartment_number = ?, last_name_a = ?, id_user = ? ";
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_address ";
	}
	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, city);
			preparedStatement.setString(2, zipCode);
			preparedStatement.setString(3, municipality);
			preparedStatement.setString(4, streetName);
			preparedStatement.setString(5, streetNo);
			preparedStatement.setString(6, appNumber);
			preparedStatement.setString(7, appLastName);
			preparedStatement.setInt(8, getUser().getIdUser());
			preparedStatement.setInt(9, idAddress);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void setDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, idAddress);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
