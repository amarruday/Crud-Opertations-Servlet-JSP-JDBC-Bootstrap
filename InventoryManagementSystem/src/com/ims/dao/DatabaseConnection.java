package com.ims.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management_systemdb?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	private static Connection connection = null;

	protected static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
