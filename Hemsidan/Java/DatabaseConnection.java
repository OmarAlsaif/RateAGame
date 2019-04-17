package com.login;

import java.sql.*;
import java.util.List;

import domain.Product;

public class DatabaseConnection {
	
	/*- variables
	 * 
	 * 
	 */

	String jdbUrl = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "password";
//	
//	// 
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
//	
	public DatabaseConnection() {
		
	}
//	
	public void connect() {
		try {
			conn = DriverManager.getConnection(jdbUrl, username, password);
			
			System.out.println("Database connection established");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	
	public void disconnect() {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			
			if (rs!=null) {
				rs.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
		}
				catch (Exception e) {
					e.printStackTrace();
				}
	

}
	
	public static void main(String[] args) {
		System.out.println("Welcome!");
//		
		DatabaseController ctrl = new DatabaseController();
//		
		ctrl.connect();
//		
		ctrl.createTables();
//		.setup();
//		
//		List<Product> allProducts = ctrl.selectAllProducts();
//		int i = 0;
//		
//		while (i < allProducts.size()) {
//			System.out.print("ID = " + allProducts.get(i).getProductId());
//			System.out.print("Name= " + allProducts.get(i).getProductName());
//			System.out.println("Price= " + allProducts.get(i).getProductPrice());
//			i++;
//		}
		
//		
//		ctrl.updateProduct(2, "asdasd", 1.30);
//		
//		ctrl.updateProduct(5, "asd", -1.0);
//		
		ctrl.disconnect();

	}
}
	
	
