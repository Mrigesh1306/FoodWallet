package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection {

	public Connection connect() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=FoodWallet", "SA",
				"myPassw0rd");

		return conn;
	}

}
