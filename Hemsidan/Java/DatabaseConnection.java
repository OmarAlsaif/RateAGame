package sys;

import java.sql.*;
import java.util.List;


public class DatabaseConnection {

	// inlogg till databas

	DatabaseLogin login = new DatabaseLogin();

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public DatabaseConnection() {
	}

	public void connect() {
		try {
			conn = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(), login.getPassword());

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
		
//		ctrl.updateItem(1, 0, "Live the epic odyssey of a legendary Spartan hero, write your own epic odyssey and become a legendary Spartan hero in Assassin's Creed Odyssey, an inspiring adventure where you must forge your destiny and define your own path in a world on the brink of tearing itself apart. Influence how history unfolds as you experience a rich and ever-changing world shaped by your decisions.");

//		try {
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
//					"password");
//			PreparedStatement stmt = con.prepareStatement("insert into games values (?,?,?)");
//			stmt.setString(1, "Test");
//			stmt.setLong(2, 0);
//			stmt.setString(3, "Live the epic odyssey of a legendary Spartan hero, write your own epic odyssey and become a legendary Spartan hero in Assassin's Creed Odyssey, an inspiring adventure where you must forge your destiny and define your own path in a world on the brink of tearing itself apart. Influence how history unfolds as you experience a rich and ever-changing world shaped by your decisions.");
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		ctrl.disconnect();

	}
}
