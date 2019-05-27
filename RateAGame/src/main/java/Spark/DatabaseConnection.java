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
		ctrl.insertGame(4, "Diablo III", "Diablo III is a dungeon crawler hack-and-slash action role-playing game developed and published by Blizzard Entertainment as the third installment in the Diablo franchise. It was released for Microsoft Windows and OS X in May 2012, the PlayStation 3 and Xbox 360 in September 2013, the PlayStation 4 and Xbox One in August 2014, and the Nintendo Switch in November 2018", "15 May 2012", "Blizzard Entertainment", "Action role-playing, Hack and Slash", "Multiplayer, Singleplayer", "Third Person", "https://us.diablo3.com/en/", "https://www.youtube.com/embed/Q17FDfU7-ds", "https://bogku.com/wp-content/uploads/2017/07/Diablo-3-Reaper-of-Souls-Cover.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Diablo_III_cover.png/220px-Diablo_III_cover.png", "https://i.ytimg.com/vi/sPsRuu9OQQM/maxresdefault.jpg", "https://images2.alphacoders.com/249/249110.jpg", "https://wallpapercave.com/wp/mxWIeqB.jpg");
		ctrl.insertGame(5, "Far Cry New Dawn", "Far Cry New Dawn is an action-adventure first-person shooter developed by Ubisoft Montreal and published by Ubisoft. The game is a spin-off of the Far Cry series and a narrative sequel to Far Cry 5. It was released for Microsoft Windows, PlayStation 4 and Xbox One on February 15, 2019, and received generally mixed reviews from critics.", "15 February 2019", "Ubisoft", "Action-adventure, first-person shooter", "Multiplayer, Singleplayer", "First Person", "https://far-cry.ubisoft.com/game/en-us/home", "https://www.youtube.com/embed/6eLHk2Eug78", "https://news.xbox.com/en-us/wp-content/uploads/FCB_UCS10605_FarcryWebsite_Webbanner_US_1920x1080-hero.jpg", "https://images.g2a.com/newlayout/323x433/1x1x0/500eecae0f44/5c6185b8ae653a52054cd5a3", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-1.jpg", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-2.jpg", "https://gameranx.com/wp-content/uploads/2019/01/Far-Cry-New-Dawn-394P-Wallpaper-4.jpg");
		ctrl.insertGame(6, "Battlefield V", "Battlefield V is a first-person shooter video game developed by EA DICE and published by Electronic Arts. Battlefield V is the sixteenth installment in the Battlefield series. It was released worldwide for Microsoft Windows, PlayStation 4, and Xbox One on November 20, 2018.", "20 November 2018", "Electronic Arts", "First-person shooter, Battle Royale", "Single-player, Multiplayer", "First Person", "https://www.origin.com/swe/en-us/store/battlefield/battlefield-v", "https://www.youtube.com/embed/4WB_0nRxVnY", "http://www.battlefieldcp.com/wp-content/uploads/2018/05/14obq7n.jpg", "https://images-na.ssl-images-amazon.com/images/I/51tG-Li9QnL.jpg", "https://thewallpaper.co/wp-content/uploads/2016/03/battlefield-second-high-definition-wallpaper-desktop-background-download-images-free-hd-wallpaper-desktop-wallpaper-cool-1920x1080.jpg", "https://data4.origin.com/content/dam/originx/web/app/games/battlefield/battlefield-v/screenshots/BFV_pdp_media_1920x1080_en_ww_10_v1.jpg", "https://cdn.gamerant.com/wp-content/uploads/Battlefield-5-world-premiere-date-announced.jpg.optimal.jpg");
		ctrl.insertGame(7, "Apex Legends", "Apex Legends is a free-to-play battle royale game developed by Respawn Entertainment and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4, and Xbox One on February 4, 2019, without any prior announcement or marketing", "4 February 2019", "Electronic Arts", "Battle Royale, First-person shooter", "Multiplayer", "First Person", "https://www.ea.com/games/apex-legends", "https://www.youtube.com/embed/cEReUkZjjN4", "https://media.contentapi.ea.com/content/dam/apex-legends/common/embed-images/apex-embed-legends-lineup.png", "https://images.igdb.com/igdb/image/upload/t_cover_big/co1j3t.jpg", "https://media.contentapi.ea.com/content/dam/apex-legends/common/legend-wallpapers/apex-concept-art-wallpaper-wraith.png", "https://media.contentapi.ea.com/content/dam/apex-legends/common/legend-wallpapers/apex-concept-art-wallpaper-mirage.png", "https://media.contentapi.ea.com/content/dam/apex-legends/images/2019/03/apex-screenshot-octane-execution.jpg.adapt.crop16x9.818p.jpg");
		ctrl.insertGame(8, "Mortal Combat XI", "Mortal Kombat 11 is a fighting video game developed by NetherRealm Studios and published by Warner Bros. Interactive Entertainment. Running on the Unreal Engine 3,[7][8] it is the eleventh main installment in the Mortal Kombat series and a sequel to 2015's Mortal Kombat X.", "23 April 2019", "Warner Bros. Interactive Entertainment", "Fighting", "Single-player, Multiplayer", "Third Person", "https://www.mortalkombat.com/", "https://www.youtube.com/embed/7zwQPJmg-Kg", "https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_MortalKombat11_image1600w.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/7/7e/Mortal_Kombat_11_cover_art.png/220px-Mortal_Kombat_11_cover_art.png", "https://static.gamespot.com/uploads/original/1591/15918215/3525992-foisxhrr_preview_screenshot1_172944.jpg", "https://cdn.gamerant.com/wp-content/uploads/mortal-kombat-11-character-gameplay-reveal-date-time.jpg.optimal.jpg", "https://i.pinimg.com/originals/d2/e9/27/d2e927b30d4b31b106c889d3adaa348b.gif");
		ctrl.insertGame(9, "Metro Exodus", "Metro Exodus is a first-person shooter video game developed by 4A Games and published by Deep Silver in 2019. It is the third installment in the Metro video game series based on Dmitry Glukhovsky's novels, following the events of Metro 2033 and Metro: Last Light. The game received generally positive reviews from critics.", "15 February 2019", "Deep Silver", "First-person shooter", "Single-player", "First Person", "https://www.metrothegame.com/en-gb/", "https://www.youtube.com/embed/tKemIJ0G1C8", "https://www.deepsilver.com/wp-content/uploads/sites/3/2018/06/MetroExodus_DeepSilver_1920x810.jpg", "https://ih0.redbubble.net/image.650892678.3599/flat,550x550,075,f.u3.jpg", "https://weplay-cdn.azureedge.net/weplay-public/2019-02-18/7f4a41eebd7b57f18f560960ac508000_big_cover.jpeg", "https://thumbs.gfycat.com/UnlawfulCornyDugong-small.gif", "https://cdn.wccftech.com/wp-content/uploads/2018/02/WCCFmetroexodus-740x429.jpg");
		ctrl.insertGame(10, "Halo", "Halo is a military science fiction first-person shooter video game franchise managed and developed by 343 Industries, a subsidiary of Xbox Game Studios. Halo was originally developed by Bungie Studios. The series centers on an interstellar war between humanity and an alliance of aliens known as the Covenant.", "15 November 2001", "Xbox Game Studios", "Action", "Multiplayer", "First Person", "https://www.microsoft.com/sv-se/p/halo-combat-evolved-anniversary/c1xfhqsgwgd1?activetab=pivot:overviewtab", "https://www.youtube.com/embed/v0kHiEME0Vk", "https://m.media-amazon.com/images/M/MV5BYzQwNWRlYTctNTcwZS00ZDUxLWI3YzctOGFjNWI5M2U5MDI0XkEyXkFqcGdeQXVyNjkzMjQ1NDQ@._V1_.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Halo_-_Combat_Evolved_%28XBox_version_-_box_art%29.jpg/220px-Halo_-_Combat_Evolved_%28XBox_version_-_box_art%29.jpg", "http://mygaming.co.za/news/wp-content/uploads/2012/11/halo-combat-evolved.jpg", "https://dotesports-media.nyc3.cdn.digitaloceanspaces.com/wp-content/uploads/2018/08/08151129/d055c34c-4719-4855-a48c-d66cf113824d.jpg", "https://images.askmen.com/recess/fun_lists/best-video-game-soundtracks-141781788788.jpg");
		ctrl.insertGame(11, "Horizon Zero Dawn", "Horizon Zero Dawn is an action role-playing game developed by Guerrilla Games and published by Sony Interactive Entertainment. It was released for the PlayStation 4 in early 2017. The plot follows Aloy, a hunter in a world overrun by machines, who sets out to uncover her past", "28 February 2017", "Sony Interactive Entertainment", "Action role-playing", "Singleplayer", "Third Person", "https://www.guerrilla-games.com/play/horizon", "https://www.youtube.com/embed/wzx96gYA8ek", "https://d1z4o56rleaq4j.cloudfront.net/images/assets/Play-Horizon/_heroXL/website-HZD.jpg?mtime=20171207152814", "https://ih0.redbubble.net/image.642889923.0671/flat,550x550,075,f.u6.jpg", "https://images-na.ssl-images-amazon.com/images/I/81aZ9HsqJtL.jpg", "https://i.ytimg.com/vi/Dh_muRtr6iM/maxresdefault.jpg", "https://i.ytimg.com/vi/CVdtQaXmSPc/maxresdefault.jpg");
		ctrl.insertGame(12, "Red Dead Redemption 2", "Red Dead Redemption 2 is a Western-themed action-adventure game developed and published by Rockstar Games. It was released on October 26, 2018, for the PlayStation 4 and Xbox One consoles. The third entry in the Red Dead series, it is a prequel to the 2010 game Red Dead Redemption.", "26 October 2018", "Rockstar Games", "Action-adventure", "Singleplayer, Multiplayer", "Third Person", "https://www.rockstargames.com/reddeadredemption2/", "https://www.youtube.com/embed/Dw_oH5oiUSE", "http://hdqwalls.com/wallpapers/red-dead-redemption-2-4k-8d.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/4/44/Red_Dead_Redemption_II.jpg/220px-Red_Dead_Redemption_II.jpg", "https://cdn.vox-cdn.com/thumbor/tzV6bCrM85xUdWBsKijIuJ4j5Jw=/0x0:3840x2160/1200x675/filters:focal(1613x773:2227x1387)/cdn.vox-cdn.com/uploads/chorus_image/image/60781977/red_dead_redemption_2_dutchs_gang_3840.0.png", "https://cdn.vox-cdn.com/thumbor/tzV6bCrM85xUdWBsKijIuJ4j5Jw=/0x0:3840x2160/1200x675/filters:focal(1613x773:2227x1387)/cdn.vox-cdn.com/uploads/chorus_image/image/60781977/red_dead_redemption_2_dutchs_gang_3840.0.png", "https://static.altchar.com/live/media/images/950x633_ct/10958_RDR2_D_091ace4ec1246946f002fc803869ea4a.jpg");
		ctrl.insertGame(13, "Fallout 76", "Fallout 76 is an online action role-playing game in the Fallout series developed by Bethesda Game Studios and published by Bethesda Softworks. Released for Microsoft Windows, PlayStation 4, and Xbox One on November 14, 2018, it is a prequel to previous series games.", "14 November 2018", "Bethesda Softworks", "Action role-playing", "Multiplayer", "First Person, Third Person", "https://fallout.bethesda.net/", "https://www.youtube.com/embed/5IcqE8kT3KA", "https://media.playstation.com/is/image/SCEA/fallout-76-listing-thumb-01-ps4-us-06aug18?$native_md_nt$", "https://images.g2a.com/newlayout/1080x1080/1x1x0/19154f55ae1a/5b2d06a95bafe3b3e236f834", "https://cdn.vox-cdn.com/thumbor/K8p0MHupjDRzKtftuqZiNxSWcH8=/0x0:3840x2160/1200x675/filters:focal(1613x773:2227x1387)/cdn.vox-cdn.com/uploads/chorus_image/image/61668269/Fallout76_E3_Vault76_1528639331.0.png", "http://www.cinelinx.com/wp-content/uploads/2018/06/k2_items_cache_4dfa0954e35daf476df778fbc3b82728_XL.jpg", "https://gamenator.com/wp-content/uploads/2018/08/fallout76_gameplay-trailer-1800x1012.jpg");
		ctrl.insertGame(14, "God of War", "Living as a man outside the shadow of the gods, Kratos must adapt to unfamiliar lands, unexpected threats, and a second chance at being a father. Together with his son Atreus, the pair will venture into the brutal Norse wilds and fight to fulfill a deeply personal quest.", "20 april 2018", "SCE Studios Santa Monica", "Action, Adventure", "Singleplayer", "Third-person", "https://godofwar.playstation.com", "https://www.youtube.com/embed/K0u_kAWLJOA", "https://images8.alphacoders.com/710/710329.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/a/a7/God_of_War_4_cover.jpg/220px-God_of_War_4_cover.jpg", "https://media-mercury.cursecdn.com/attachments/8/413/kratos-atreus-godofwar.png", "https://cdn.segmentnext.com/wp-content/uploads/2018/11/5-6.jpg", "https://ewedit.files.wordpress.com/2017/12/god-of-war-20181.jpg");
		ctrl.insertGame(15, "League Of Legends", "League of Legends (abbreviated LoL) is a multiplayer online battle arena video game developed and published by Riot Games for Microsoft Windows and macOS. The game follows a freemium model and is supported by microtransactions, and was inspired by the Warcraft III: The Frozen Throne mod, Defense of the Ancients.", "27 October 2009", "Riot Games", "Multiplayer online battle arena", "Multiplayer", "Third Person", "https://na.leagueoflegends.com/en/", "https://www.youtube.com/embed/zF5Ddo9JdpY", "https://s3.dexerto.com/thumbnails/_thumbnailLarge/league-of-legends-ranked-play-season-9-how-explained.jpg", "https://haste.net/wp-content/uploads/2017/11/Haste-LoL-Cover.jpg", "http://hdqwalls.com/wallpapers/cyberpop-zoe-league-of-legends-z4.jpg","https://thumbs.gfycat.com/IlliterateOddDobermanpinscher-size_restricted.gif", "http://www.lol-wallpapers.com/wp-content/uploads/2018/05/Playmaker-Lee-Sin-Sweeper-Rammus-Splash-Art-HD-Wallpaper-Background-Official-Art-Artwork-League-of-Legends-lol-1-400x236.jpg");
		ctrl.insertGame(16, "Counter-Strike: Global Offensive", "Counter-Strike: Global Offensive (CS:GO) is a multiplayer first-person shooter video game developed by Hidden Path Entertainment and Valve Corporation. It is the fourth game in the Counter-Strike series and was released for Microsoft Windows, OS X, Xbox 360, and PlayStation 3 on August 21, 2012, while the Linux version was released in 2014.", "21 August 2012", "Valve Corporation", "First-person shooter", "Multiplayer", "First Person", "https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/", "https://www.youtube.com/embed/edYCtaNueQY", "https://paperpull.com/wp-content/uploads/2018/09/cool-counter-strike-global-offensive-wallpaper.jpg", "https://images-na.ssl-images-amazon.com/images/I/81L8-mjNlrL._SX385_.jpg", "https://steamcdn-a.akamaihd.net/steam/apps/730/ss_34090867f1a02b6c17652ba9043e3f622ed985a9.1920x1080.jpg?t=1554409309", "https://steamcdn-a.akamaihd.net/steam/apps/730/ss_ccc4ce6edd4c454b6ce7b0757e633b63aa93921d.600x338.jpg?t=1554409309", "https://steamcdn-a.akamaihd.net/steam/apps/730/ss_36f82c71ee2180159b060b155bf3d06dd8167327.600x338.jpg?t=1554409309");
		ctrl.insertGame(17, "Overwatch", "Overwatch is a team-based multiplayer first-person shooter developed and published by Blizzard Entertainment and released on May 24, 2016 for PlayStation 4, Xbox One, and Windows. Described as a hero shooter, Overwatch assigns players into two teams of six, with each player selecting from a roster of 31 characters, known as heroes, each with a unique style of play whose roles are divided into three general categories that fit their role.", "24 May 2016", "Blizzard Entertainment", "First-person shooter", "Multiplayer", "First Person", "https://playoverwatch.com/en-us/", "https://www.youtube.com/embed/FqnKB22pOC0", "https://static.playoverwatch.com/media/wallpaper/lineup-wide.jpg", "https://imgc.allpostersimages.com/img/print/posters/overwatch-game-cover_a-G-14417944-0.jpg", "https://static.playoverwatch.com/media/wallpaper/soldier-wallpaper-wide.jpg", "https://static.playoverwatch.com/media/wallpaper/mercy-theatrical-wide.jpg", "https://static.playoverwatch.com/media/wallpaper/tracer-wallpaper-wide.jpg");
		ctrl.updateGame(18, "Fifa 19", "FIFA 19 is a football simulation video game developed by EA Vancouver as part of Electronic Arts' FIFA series. Announced on 6 June 2018 for its E3 2018 press conference, it was released on 28 September 2018 for PlayStation 3, PlayStation 4, Xbox 360, Xbox One, Nintendo Switch, and Microsoft Windows.", "28 September 2018", "EA Sports", "Sports", "Single-player, Multiplayer", "Third Person", "https://www.ea.com/games/fifa/fifa-19", "https://www.youtube.com/embed/zX0AV6yxyrQ", "https://i0.wp.com/glitched.africa/wp-content/uploads/2019/02/blog-fifa-19-cover-new-big.jpg?fit=1920%2C1080&ssl=1", "https://upload.wikimedia.org/wikipedia/en/thumb/7/71/FIFA_19_cover.jpg/220px-FIFA_19_cover.jpg", "https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-19/images/2019/02/fifa19-mosaic-4up-features-01-1x1.png.adapt.crop1x1.png", "https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-19/images/2019/02/fifa19-mosaic-4up-features-02-1x1.png.adapt.crop1x1.png", "https://media.contentapi.ea.com/content/dam/ea/fifa/fifa-19/images/2019/02/fifa19-mosaic-4up-features-1x1.png.adapt.crop1x1.png");
		ctrl.updateGame(19, "Assassin's Creed Odyssey", "Assassin's Creed Odyssey is an action role-playing video game developed by Ubisoft Quebec and published by Ubisoft. It is the 11th major installment, and 21st overall, in the Assassin's Creed series and the successor to 2017's Assassin's Creed Origins. Set in the year 431 BC, the plot tells a fictional history of the Peloponnesian War between Athens and Sparta", "5 October 2019", "Ubisoft", "Action role-playing, Stealth", "Single-player", "Third Person", "https://assassinscreed.ubisoft.com/game/en-us/home", "https://www.youtube.com/embed/s_SJZSAtLBA", "https://wallpapersite.com/images/wallpapers/kassandra-3840x2160-assassins-creed-odyssey-4k-15456.jpg", "https://images.g2a.com/newlayout/323x433/1x1x0/3d2d9022872a/5b1fcc2c5bafe3ba4d26dbb4", "https://www.xboxwallpapers.net/1920x1080/assassins-creed-odyssey-action.jpg", "https://wallpapershome.com/images/wallpapers/assassin-039-s-creed-odyssey-3840x2160-assassins-creed-odyssey-e3-2018-screenshot-4k-19099.jpg", "https://twinfinite.net/wp-content/uploads/2018/09/4kwallpaper9.jpg");
		ctrl.insertGame(20, "Rocket League", "Rocket League is a vehicular soccer video game developed and published by Psyonix. The game was first released for Microsoft Windows and PlayStation 4 in July 2015, with ports for Xbox One, macOS, Linux, and Nintendo Switch being released later on. In June 2016, 505 Games began distributing a physical retail version for PlayStation 4 and Xbox One, with Warner Bros. Interactive Entertainment taking over those duties by the end of 2017.", "7 July 2015", "Psyonix", "Sports", "Single-player, Multiplayer", "Third Person", "https://www.rocketleague.com/", "https://www.youtube.com/embed/Vawwy2eu5sA", "https://stmed.net/sites/default/files/rocket-league-hd-wallpapers-33579-2383215.jpg", "https://upload.wikimedia.org/wikipedia/en/thumb/e/e8/Rocket_League.jpg/220px-Rocket_League.jpg", "https://rocketleague.media.zestyio.com/rl_gameplay_june-2018_3_26.f44ca8609585ba611e1277fc600f5cc1.jpg", "https://rocketleague.media.zestyio.com/rl_cross-play_asset_no-text.f44ca8609585ba611e1277fc600f5cc1.jpg", "https://rocketleague.media.zestyio.com/rumble-key-art.f44ca8609585ba611e1277fc600f5cc1.jpg");
		//för att uppdatera ett spel
//		ctrl.updateGame(1, "Star Wars Battlefront", "Star Wars™ Battlefront™ is the ultimate Star Wars battle experience, brought to life by the creators of Battlefield. Fight in epic Star Wars battles on iconic planets and rise through the ranks playing as the heroic Rebellion or the evil Galactic Empire.", "17 november 2015", "Electronic Arts", "FPS", "Multiplayer, Singleplayer", "First Person/Third Person", "http://starwars.ea.com/starwars/battlefront", "https://www.youtube.com/embed/V2xp-qtUlsQ", "https://media.contentapi.ea.com/content/legacy/starwars-ea-com/en_US/starwars/battlefront/news-articles/future-of-battlefront-2017/_jcr_content/featuredImage/renditions/rendition1.img.jpg", "https://g2anewsprod02storage.s3.amazonaws.com/app/uploads/2018/10/star-wars-battlefront-2-cover-art.jpg", "https://miro.medium.com/max/836/1*2_SPNCD0hmTjcNU996NEMA.jpeg", "https://cdn.cdkeys.com/media/catalog/product/s/t/star_wars_battlefront_ii_2_pc_0a_0astar_wars_battlefront_ii_2_pc.jpg", "https://data3.origin.com/content/dam/originx/web/app/games/star-wars/star-wars-battlefront-2/screenshots/Walrus_pdp_screenhi_1920x1080_en_ww_KashyyykVista_v1.jpg");
		ctrl.disconnect();
		
	}
		
	}
		

