package Spark;

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
					"username VARCHAR(25) NOT NULL PRIMARY KEY, " +
					"password VARCHAR(25) NOT NULL" +
					 ")";
			
			String sql2 = "CREATE TABLE IF NOT EXISTS ACOdyssey (" +
					"username VARCHAR(25) UNIQUE, " +
					"rating REAL NOT NULL" +
					 ")";
			
			String sql3 = "CREATE TABLE IF NOT EXISTS games (" +
					"GameID INT PRIMARY KEY, " +
					"GameTitle VARCHAR(50) UNIQUE, " +
					"GameInfo VARCHAR(2083), " +
					"ReleaseDate VARCHAR(50), " +
					"Publishers VARCHAR(100), " +
					"Genre VARCHAR(50), " +
					"GameModes VARCHAR(50), " +
					"PlayerPerspective VARCHAR(50), " +
					"LinkOfficialSite VARCHAR(2083), " +
					"LinkTrailer VARCHAR(2083), " +
					"LinkPoster VARCHAR(2083), " +
					"LinkCover VARCHAR(2083), " +
					"LinkPicture1 VARCHAR(2083), " +
					"LinkPicture2 VARCHAR(2083), " +
					"LinkPicture3 VARCHAR(2083)" +
					")";
			
			String sql4 = "CREATE TABLE IF NOT EXISTS ratings (" +
					"Username VARCHAR(25) NOT NULL, " +
					"Vote int not null check(vote >= 0 and vote <= 10), " +
					"GameID INT, " +
					"FOREIGN KEY (GameID) REFERENCES games(gameID), " + 
					"FOREIGN KEY (Username) REFERENCES users(username), " + 
					"PRIMARY KEY (GameID, Username)" +
					 ")";
			
		
			
			
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertGame (int GameID, String GameTitle, String GameInfo, String ReleaseDate, String Publishers, String Genre, String GameModes, String PlayerPerspective, String LinkOfficialSite, String LinkTrailer, String LinkPoster, String LinkCover, String LinkPicture1, String LinkPicture2, String LinkPicture3) {
		
		try {
			PreparedStatement st = conn.prepareStatement("INSERT INTO games (" +
					 "GameID, GameTitle, GameInfo, ReleaseDate, Publishers, Genre, GameModes, PlayerPerspective, LinkOfficialSite, LinkTrailer, LinkPoster, LinkCover, LinkPicture1, LinkPicture2, LinkPicture3) " +
					 "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			st.setInt(1, GameID);
			st.setString(2, GameTitle);
			st.setString(3, GameInfo);
			st.setString(4, ReleaseDate);
			st.setString(5, Publishers);
			st.setString(6, Genre);
			st.setString(7, GameModes);
			st.setString(8, PlayerPerspective);
			st.setString(9, LinkOfficialSite);
			st.setString(10, LinkTrailer);
			st.setString(11, LinkPoster);
			st.setString(12, LinkCover);
			st.setString(13, LinkPicture1);
			st.setString(14, LinkPicture2);
			st.setString(15, LinkPicture3);
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
