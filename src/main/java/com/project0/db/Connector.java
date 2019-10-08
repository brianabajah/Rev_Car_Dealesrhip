package com.project0.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector extends LoginDetails{

	public Connection connection() {
		try {
			Connection conn= DriverManager.getConnection(getUrl(), getName(), getPassword());
			return conn;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
