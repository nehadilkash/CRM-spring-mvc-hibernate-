package com.neha.springdemo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";

		String user = "springApp";
		String password = "springApp";

		try {

			System.out.println("connection to :" + jdbcUrl);

			System.out.println("connection succesful");
			java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
