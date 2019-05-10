package sys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DatabaseController extends DatabaseConnection {
	
	public void createTables() {
		try {
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS users (" +
					"username VARCHAR(25) NOT NULL, " +
					"password VARCHAR(25) NOT NULL" +
					 ")";
			
			String sql2 = "CREATE TABLE IF NOT EXISTS ACOdyssey (" +
					"username VARCHAR(25) UNIQUE, " +
					"rating REAL NOT NULL" +
					 ")";
			
			String sql3 = "CREATE TABLE IF NOT EXISTS games (" +
					"game VARCHAR(25) UNIQUE, " +
					"rating REAL," +
					"gameinfo VARCHAR(2000)" +
					 ")";
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	//nedan bör antagligen tas bort
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
//		insertProduct("", 1.30);
//		insertProduct("", 1.20);
//		insertProduct("", 2.30);
//		insertProduct("", 2.10);
//		insertProduct("", 2.40);
//		
//		}
//	}
	
	
	public void insertProduct (String productName, 	Double productPrice) {
		
		System.out.println("Insert product " + productName + "with price " + productPrice);
		
		try {
			PreparedStatement st = conn.prepareStatement("INSERT INTO PRODUCTS (" +
					 "product_name, product_price) " +
					 "VALUES(?,?)");
			st.setString(1, productName);
			st.setDouble(2, productPrice);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateItem(long rating, int pos, String gameInfo) {
		
		System.out.println("Updating item number " + rating + " with name = " + pos + 
				" price = " + gameInfo);
		
		try {
			

					
			PreparedStatement st = conn.prepareStatement("UPDATE games SET gameinfo=? WHERE game=?");
			
//			st.setString(1, productName);
			st.setString(3, gameInfo);
			st.executeUpdate();
			st.close();
			
//			if(productPrice != -1.0) {
//				PreparedStatement st = conn.prepareStatement("UPDATE products SET product_price=? WHERE product_id=?");
//
//						st.setDouble(1, productPrice);
//						st.setLong(2, productId);
//						st.executeUpdate();
//						st.close();
//			}
//			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
