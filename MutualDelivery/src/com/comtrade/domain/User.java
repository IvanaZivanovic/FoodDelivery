package com.comtrade.domain;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

public class User implements BaseDomain{
	private int idUser;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private int status;
	private int idRole;
	
	
	public User(String firstName, String lastName, String email, String phoneNumber, String username, String password, int status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public User() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return " `user` ";
	}


	@Override
	public String getColumnNames() {
		// TODO Auto-generated method stub
		return " (first_name, last_name, email, phone_number) ";
	}


	@Override
	public String getValues() {
		// TODO Auto-generated method stub
		return " (?, ?, ?, ?) ";
	}


	@Override
	public void setValuesInsert(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, username);
			preparedStatement.setString(6, password);
			preparedStatement.setInt(7, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public Set<BaseDomain> selectAll(ResultSet resultSet) {
		Set<BaseDomain> users = new LinkedHashSet<BaseDomain>();
		try {
			while(resultSet.next()) {
				User user = new User();
				user.setIdUser(resultSet.getInt("id_user"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPhoneNumber(resultSet.getString("phone_number"));
				user.setPassword(resultSet.getString("password"));
				user.setStatus(resultSet.getInt("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}


	@Override
	public String setUpdateValues() {
		// TODO Auto-generated method stub
		return " first_name = ?, last_name = ?, email = ?, phone_number = ? ";
	}


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_user ";
	}


	@Override
	public void setUpdate(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setInt(5, idUser);
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
