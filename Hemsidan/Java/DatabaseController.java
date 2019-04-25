package com.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Product;

public class DatabaseController extends DatabaseConnection {
	
	public void createTables() {
		try {
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS users (" +
					"username VARCHAR(25) NOT NULL, " +
					"password VARCHAR(25) NOT NULL" +
					 ")";
			
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
//	public void setup() {
//		//count rows
//		int numberOfRows = -1;
//		try {
//			PreparedStatement st = conn.prepareStatement(
//					"SELECT count (*) FROM products");
//			
//			ResultSet rs = st.executeQuery();
//			
//			while(rs.next()) {
//				numberOfRows = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(numberOfRows == 0) {
//		System.out.println("number of rows: " + numberOfRows);
//		
//		insertProduct("", 1.30);
//		insertProduct("", 1.20);
//		insertProduct("", 2.30);
//		insertProduct("", 2.10);
//		insertProduct("", 2.40);
//		
//		}
//	}
//	
//	
//	public void insertProduct (String productName, 	Double productPrice) {
//		
//		System.out.println("Insert product " + productName + "with price " + productPrice);
//		
//		try {
//			PreparedStatement st = conn.prepareStatement("INSERT INTO PRODUCTS (" +
//					 "product_name, product_price) " +
//					 "VALUES(?,?)");
//			st.setString(1, productName);
//			st.setDouble(2, productPrice);
//			st.executeUpdate();
//			st.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public List selectAllProducts() {
//		
//		List<Product> allProductsList = new ArrayList<>();
//		
//		try {
//			PreparedStatement st = conn.prepareStatement("SELECT product_id, product_name, product_price FROM products");
//			ResultSet rs = st.executeQuery();
//			
//			while (rs.next()) {
//				Long productId = rs.getLong(1);
//				String productName = rs.getString(2);
//				Double productPrice = rs.getDouble(3);
//				
//				Product tempProduct = new Product(productId, productName, productPrice);
//				
//				allProductsList.add(tempProduct);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return allProductsList;
//	}
//	
//	public void updateProduct(long productId, String productName, double productPrice) {
//		
//		System.out.println("Updating item number " + productId + " with name = " + productName + 
//				" price = " + productPrice);
//		
//		try {
//			
//			if(!(productName.equals(""))) {
//					
//			PreparedStatement st = conn.prepareStatement("UPDATE products SET product_name=? WHERE product_id=?");
//			
//			st.setString(1, productName);
//			st.setLong(2, productId);
//			st.executeUpdate();
//			st.close();
//			}
//			
//			if(productPrice != -1.0) {
//				PreparedStatement st = conn.prepareStatement("UPDATE products SET product_price=? WHERE product_id=?");
//
//						st.setDouble(1, productPrice);
//						st.setLong(2, productId);
//						st.executeUpdate();
//						st.close();
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
}
