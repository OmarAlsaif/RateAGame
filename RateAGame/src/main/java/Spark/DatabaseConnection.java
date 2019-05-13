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
//		ctrl.insertGame(1, "Star Wars Battlefront", "Star Wars™ Battlefront™ is the ultimate Star Wars battle experience, brought to life by the creators of Battlefield. Fight in epic Star Wars battles on iconic planets and rise through the ranks playing as the heroic Rebellion or the evil Galactic Empire.", "17 november 2015", "Electronic Arts", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "http://starwars.ea.com/starwars/battlefront", "https://www.youtube.com/embed/V2xp-qtUlsQ", "https://media.contentapi.ea.com/content/legacy/starwars-ea-com/en_US/starwars/battlefront/news-articles/future-of-battlefront-2017/_jcr_content/featuredImage/renditions/rendition1.img.jpg", "https://g2anewsprod02storage.s3.amazonaws.com/app/uploads/2018/10/star-wars-battlefront-2-cover-art.jpg", "https://miro.medium.com/max/836/1*2_SPNCD0hmTjcNU996NEMA.jpeg", "https://cdn.cdkeys.com/media/catalog/product/s/t/star_wars_battlefront_ii_2_pc_0a_0astar_wars_battlefront_ii_2_pc.jpg", "https://data3.origin.com/content/dam/originx/web/app/games/star-wars/star-wars-battlefront-2/screenshots/Walrus_pdp_screenhi_1920x1080_en_ww_KashyyykVista_v1.jpg");
//		ctrl.insertGame(2, "Anthem", "Unleash Your Power. In a world left unfinished by the gods, a shadowy faction threatens all humankind. Only you stand between the Dominion and the ancient power they covet. Team up as heroes in this cooperative action-RPG from BioWare™ and EA.", "22 february 2019", "BioWare™ and EA", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "https://www.ea.com/en-gb/games/anthem", "https://www.youtube.com/embed/EL5GSfs9fi4", "https://i0.wp.com/maroonersrock.com/wp-content/uploads/2019/01/Anthem-Cover.jpg?fit=1280%2C720", "https://upload.wikimedia.org/wikipedia/en/thumb/4/49/Cover_Art_of_Anthem.jpg/220px-Cover_Art_of_Anthem.jpg", "https://cdn.vox-cdn.com/thumbor/PGiV0Y9O7bFH7Y7lLuRvH198rr0=/0x0:3840x2160/1200x800/filters:focal(1613x773:2227x1387)/cdn.vox-cdn.com/uploads/chorus_image/image/62869964/anthem_shooting_scar_3840.0.jpg", "https://i.ytimg.com/vi/EL5GSfs9fi4/sddefault.jpg#404_is_fine", "https://gamingbolt.com/wp-content/uploads/2018/06/anthem-1-12.jpg");
//		ctrl.insertGame(3, "GTA V", "Los Santos is a city of bright lights, long nights and dirty secrets, and they don’t come brighter, longer or dirtier than in GTA Online: After Hours. The party starts now.", "17 september 2013", "Rockstar Games", "Action, Adventure", "Multiplayer, Singleplayer", "Third Person", "https://www.rockstargames.com/V/", "https://www.youtube.com/embed/QkkoHAzjnUs", "https://img-cache.coolshop.com/6457c217-80b1-492e-8664-3b5dd284b93c/grand-theft-auto-v-gta-5.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a5/Grand_Theft_Auto_V.png/220px-Grand_Theft_Auto_V.png", "https://www.geforce.com/sites/default/files-world/screenshots/RSG_GTAV_PC_Screenshot_002.jpg", "https://www.gameinformer.com/s3/files/styles/body_default/s3/legacy-images/imagefeed/Rockstar%20Reveals%20Why%20GTA%20V%20Didn%27t%20Get%20A%20Story%20Expansion%2C%20Reaffirms%20Commitment%20To%20Single-Player/GunCombat610.jpg", "https://media.comicbook.com/2018/08/gta-v-1127236.jpeg");
//		ctrl.insertGame(4, "Diablo III", "Diablo III is a dungeon crawler hack-and-slash action role-playing game developed and published by Blizzard Entertainment as the third installment in the Diablo franchise. It was released for Microsoft Windows and OS X in May 2012, the PlayStation 3 and Xbox 360 in September 2013, the PlayStation 4 and Xbox One in August 2014, and the Nintendo Switch in November 2018", "15 May 2012", "Blizzard Entertainment", "Action role-playing, Hack and Slash", "Multiplayer, Singleplayer", "Third Person", "https://us.diablo3.com/en/", "https://www.youtube.com/embed/Q17FDfU7-ds", "https://bogku.com/wp-content/uploads/2017/07/Diablo-3-Reaper-of-Souls-Cover.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Diablo_III_cover.png/220px-Diablo_III_cover.png", "https://i.ytimg.com/vi/sPsRuu9OQQM/maxresdefault.jpg", "https://images2.alphacoders.com/249/249110.jpg", "https://wallpapercave.com/wp/mxWIeqB.jpg");
//		ctrl.insertGame(5, "Far Cry New Dawn", "Far Cry New Dawn is an action-adventure first-person shooter developed by Ubisoft Montreal and published by Ubisoft. The game is a spin-off of the Far Cry series and a narrative sequel to Far Cry 5. It was released for Microsoft Windows, PlayStation 4 and Xbox One on February 15, 2019, and received generally mixed reviews from critics.", "15 February 2019", "Ubisoft", "Action-adventure, first-person shooter", "Multiplayer, Singleplayer", "First Person", "https://far-cry.ubisoft.com/game/en-us/home", "https://www.youtube.com/embed/6eLHk2Eug78", "https://news.xbox.com/en-us/wp-content/uploads/FCB_UCS10605_FarcryWebsite_Webbanner_US_1920x1080-hero.jpg", "https://images.g2a.com/newlayout/323x433/1x1x0/500eecae0f44/5c6185b8ae653a52054cd5a3", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-1.jpg", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-2.jpg", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-4.jpg");
//		ctrl.insertGame(6, "Battlefield V", "Battlefield V is a first-person shooter video game developed by EA DICE and published by Electronic Arts. Battlefield V is the sixteenth installment in the Battlefield series. It was released worldwide for Microsoft Windows, PlayStation 4, and Xbox One on November 20, 2018.", "20 November 2018", "Electronic Arts", "First-person shooter, Battle Royale", "Single-player, Multiplayer", "First Person", "https://www.origin.com/swe/en-us/store/battlefield/battlefield-v", "https://www.youtube.com/embed/4WB_0nRxVnY", "http://www.battlefieldcp.com/wp-content/uploads/2018/05/14obq7n.jpg", "https://images-na.ssl-images-amazon.com/images/I/51tG-Li9QnL.jpg", "https://thewallpaper.co/wp-content/uploads/2016/03/battlefield-second-high-definition-wallpaper-desktop-background-download-images-free-hd-wallpaper-desktop-wallpaper-cool-1920x1080.jpg", "https://data4.origin.com/content/dam/originx/web/app/games/battlefield/battlefield-v/screenshots/BFV_pdp_media_1920x1080_en_ww_10_v1.jpg", "https://cdn.gamerant.com/wp-content/uploads/Battlefield-5-world-premiere-date-announced.jpg.optimal.jpg");
//		ctrl.insertGame(7, "Apex Legends", "Apex Legends is a free-to-play battle royale game developed by Respawn Entertainment and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4, and Xbox One on February 4, 2019, without any prior announcement or marketing", "4 February 2019", "Electronic Arts", "Battle Royale, First-person shooter", "Multiplayer", "First Person", "https://www.ea.com/games/apex-legends", "https://www.youtube.com/embed/cEReUkZjjN4", "https://media.contentapi.ea.com/content/dam/apex-legends/common/embed-images/apex-embed-legends-lineup.png", "https://images.igdb.com/igdb/image/upload/t_cover_big/co1j3t.jpg", "https://media.contentapi.ea.com/content/dam/apex-legends/common/legend-wallpapers/apex-concept-art-wallpaper-wraith.png", "https://media.contentapi.ea.com/content/dam/apex-legends/common/legend-wallpapers/apex-concept-art-wallpaper-mirage.png", "https://media.contentapi.ea.com/content/dam/apex-legends/images/2019/03/apex-screenshot-octane-execution.jpg.adapt.crop16x9.818p.jpg");
//		ctrl.insertGame(8, "Mortal Combat XI", "Mortal Kombat 11 is a fighting video game developed by NetherRealm Studios and published by Warner Bros. Interactive Entertainment. Running on the Unreal Engine 3,[7][8] it is the eleventh main installment in the Mortal Kombat series and a sequel to 2015's Mortal Kombat X.", "23 April 2019", "Warner Bros. Interactive Entertainment", "Fighting", "Single-player, Multiplayer", "Third Person", "https://www.mortalkombat.com/", "https://www.youtube.com/embed/7zwQPJmg-Kg", "https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_MortalKombat11_image1600w.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/7/7e/Mortal_Kombat_11_cover_art.png/220px-Mortal_Kombat_11_cover_art.png", "https://static.gamespot.com/uploads/original/1591/15918215/3525992-foisxhrr_preview_screenshot1_172944.jpg", "https://cdn.gamerant.com/wp-content/uploads/mortal-kombat-11-character-gameplay-reveal-date-time.jpg.optimal.jpg", "https://i.pinimg.com/originals/d2/e9/27/d2e927b30d4b31b106c889d3adaa348b.gif");
//		ctrl.insertGame(9, "Metro Exodus", "Metro Exodus is a first-person shooter video game developed by 4A Games and published by Deep Silver in 2019. It is the third installment in the Metro video game series based on Dmitry Glukhovsky's novels, following the events of Metro 2033 and Metro: Last Light. The game received generally positive reviews from critics.", "15 February 2019", "Deep Silver", "First-person shooter", "Single-player", "First Person", "https://www.metrothegame.com/en-gb/", "https://www.youtube.com/embed/tKemIJ0G1C8", "https://www.deepsilver.com/wp-content/uploads/sites/3/2018/06/MetroExodus_DeepSilver_1920x810.jpg", "https://ih0.redbubble.net/image.650892678.3599/flat,550x550,075,f.u3.jpg", "https://weplay-cdn.azureedge.net/weplay-public/2019-02-18/7f4a41eebd7b57f18f560960ac508000_big_cover.jpeg", "https://thumbs.gfycat.com/UnlawfulCornyDugong-small.gif", "https://cdn.wccftech.com/wp-content/uploads/2018/02/WCCFmetroexodus-740x429.jpg");
		

		ctrl.disconnect();

	}
}
