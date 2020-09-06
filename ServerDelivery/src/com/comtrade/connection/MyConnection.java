package com.comtrade.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private Connection connection;
	private volatile static MyConnection connectionMy;
	private MyConnection() {
		
	}
	public Connection getConnection() {
		return connection;
	}
	
	public static MyConnection getInstance() {
		if(connectionMy == null) {
			synchronized (MyConnection.class) {
				if(connectionMy == null) {
					connectionMy = new MyConnection();
				}
				
			}
			
		}
		return connectionMy;
	}
	
	public void closeConnectionMy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cancelTransaction() {
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void confirmTransaction() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startTransaction() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery", "root","");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
