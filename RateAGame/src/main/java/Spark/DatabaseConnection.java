package Spark;

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
		ctrl.insertGame(1, "Star Wars Battlefront", "Star Wars™ Battlefront™ is the ultimate Star Wars battle experience, brought to life by the creators of Battlefield. Fight in epic Star Wars battles on iconic planets and rise through the ranks playing as the heroic Rebellion or the evil Galactic Empire.", "17 november 2015", "Electronic Arts", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "http://starwars.ea.com/starwars/battlefront", "https://www.youtube.com/embed/V2xp-qtUlsQ", "https://media.contentapi.ea.com/content/legacy/starwars-ea-com/en_US/starwars/battlefront/news-articles/future-of-battlefront-2017/_jcr_content/featuredImage/renditions/rendition1.img.jpg", "https://g2anewsprod02storage.s3.amazonaws.com/app/uploads/2018/10/star-wars-battlefront-2-cover-art.jpg", "https://miro.medium.com/max/836/1*2_SPNCD0hmTjcNU996NEMA.jpeg", "https://cdn.cdkeys.com/media/catalog/product/s/t/star_wars_battlefront_ii_2_pc_0a_0astar_wars_battlefront_ii_2_pc.jpg", "https://data3.origin.com/content/dam/originx/web/app/games/star-wars/star-wars-battlefront-2/screenshots/Walrus_pdp_screenhi_1920x1080_en_ww_KashyyykVista_v1.jpg");
		ctrl.insertGame(2, "Anthem", "Unleash Your Power. In a world left unfinished by the gods, a shadowy faction threatens all humankind. Only you stand between the Dominion and the ancient power they covet. Team up as heroes in this cooperative action-RPG from BioWare™ and EA.", "22 february 2019", "BioWare™ and EA", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "https://www.ea.com/en-gb/games/anthem", "https://www.youtube.com/embed/EL5GSfs9fi4", "https://i0.wp.com/maroonersrock.com/wp-content/uploads/2019/01/Anthem-Cover.jpg?fit=1280%2C720", "https://upload.wikimedia.org/wikipedia/en/thumb/4/49/Cover_Art_of_Anthem.jpg/220px-Cover_Art_of_Anthem.jpg", "https://cdn.vox-cdn.com/thumbor/PGiV0Y9O7bFH7Y7lLuRvH198rr0=/0x0:3840x2160/1200x800/filters:focal(1613x773:2227x1387)/cdn.vox-cdn.com/uploads/chorus_image/image/62869964/anthem_shooting_scar_3840.0.jpg", "https://i.ytimg.com/vi/EL5GSfs9fi4/sddefault.jpg#404_is_fine", "https://gamingbolt.com/wp-content/uploads/2018/06/anthem-1-12.jpg");
		ctrl.insertGame(3, "GTA V", "Los Santos is a city of bright lights, long nights and dirty secrets, and they don’t come brighter, longer or dirtier than in GTA Online: After Hours. The party starts now.", "17 september 2013", "Rockstar Games", "Action, Adventure", "Multiplayer, Singleplayer", "Third Person", "https://www.rockstargames.com/V/", "https://www.youtube.com/embed/QkkoHAzjnUs", "https://img-cache.coolshop.com/6457c217-80b1-492e-8664-3b5dd284b93c/grand-theft-auto-v-gta-5.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a5/Grand_Theft_Auto_V.png/220px-Grand_Theft_Auto_V.png", "https://www.geforce.com/sites/default/files-world/screenshots/RSG_GTAV_PC_Screenshot_002.jpg", "https://www.gameinformer.com/s3/files/styles/body_default/s3/legacy-images/imagefeed/Rockstar%20Reveals%20Why%20GTA%20V%20Didn%27t%20Get%20A%20Story%20Expansion%2C%20Reaffirms%20Commitment%20To%20Single-Player/GunCombat610.jpg", "https://media.comicbook.com/2018/08/gta-v-1127236.jpeg");
//		ctrl.insertGame(4, "Diablo III", "", "", "", "", "", "", "", "", "", "", "", "", "");
//		ctrl.insertGame(5, "Far Cry New Dawn", "", "", "", "", "", "", "", "", "", "", "", "", "");
//		ctrl.insertGame(6, "Battlefield V", "", "", "", "", "", "", "", "", "", "", "", "", "");
//		ctrl.insertGame(7, "Apex Legends", "", "", "", "", "", "", "", "", "", "", "", "", "");
//		ctrl.insertGame(8, "Mortal Combat XI", "", "", "", "", "", "", "", "", "", "", "", "", "");
//		ctrl.insertGame(8, "Metro Exodus", "", "", "", "", "", "", "", "", "", "", "", "", "");
		

		ctrl.disconnect();

	}
}