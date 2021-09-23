package com.cts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection = null;
	private static final String url = "jdbc:mysql://localhost:3306/Employee";
	private static final String username = "root";
	private static final String password = "mysql";

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
		return connection;
	}

}
