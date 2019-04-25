package com.login;

import java.sql.*;
import java.util.List;

import domain.Product;

public class DatabaseConnection {

	// inlogg till databas

	String jdbUrl = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "password";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public DatabaseConnection() {
	}

	public void connect() {
		try {
			conn = DriverManager.getConnection(jdbUrl, username, password);

			System.out.println("Database connection established");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (stmt != null) {
				stmt.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Startar!");

		DatabaseController ctrl = new DatabaseController();
		ctrl.connect();
		ctrl.createTables();
		ctrl.disconnect();

	}
}
