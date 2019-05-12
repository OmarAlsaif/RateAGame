package sys;

import java.sql.*;
import java.util.List;


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
		
//		ctrl.updateItem(1, 0, "Live the epic odyssey of a legendary Spartan hero, write your own epic odyssey and become a legendary Spartan hero in Assassin's Creed Odyssey, an inspiring adventure where you must forge your destiny and define your own path in a world on the brink of tearing itself apart. Influence how history unfolds as you experience a rich and ever-changing world shaped by your decisions.");

		//GameID, Titel, Spelbeskrivning, Release Date, publishers, genre, gameModes, playerPerspective, linkOfficialSite, linkTrailer, linkPoster, linkCover, String linkPicture1, String linkPicture2, String linkPicture3
		ctrl.insertGame(1, "Star Wars Battlefront", "Star Wars™ Battlefront™ is the ultimate Star Wars battle experience, brought to life by the creators of Battlefield. Fight in epic Star Wars battles on iconic planets and rise through the ranks playing as the heroic Rebellion or the evil Galactic Empire.", "17 november 2015", "Electronic Arts", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "http://starwars.ea.com/starwars/battlefront", "https://www.youtube.com/watch?v=V2xp-qtUlsQ", "https://media.contentapi.ea.com/content/legacy/starwars-ea-com/en_US/starwars/battlefront/news-articles/future-of-battlefront-2017/_jcr_content/featuredImage/renditions/rendition1.img.jpg", "https://g2anewsprod02storage.s3.amazonaws.com/app/uploads/2018/10/star-wars-battlefront-2-cover-art.jpg", "https://miro.medium.com/max/836/1*2_SPNCD0hmTjcNU996NEMA.jpeg", "https://cdn.cdkeys.com/media/catalog/product/s/t/star_wars_battlefront_ii_2_pc_0a_0astar_wars_battlefront_ii_2_pc.jpg", "https://data3.origin.com/content/dam/originx/web/app/games/star-wars/star-wars-battlefront-2/screenshots/Walrus_pdp_screenhi_1920x1080_en_ww_KashyyykVista_v1.jpg");
		ctrl.insertGame(2, "Anthem", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(3, "GTA V", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(4, "Diablo III", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(5, "Far Cry New Dawn", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(6, "Battlefield V", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(7, "Apex Legends", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(8, "Mortal Combat XI", "", "", "", "", "", "", "", "", "", "", "", "", "");
		ctrl.insertGame(8, "Metro Exodus", "", "", "", "", "", "", "", "", "", "", "", "", "");
		

		ctrl.disconnect();

	}
}
