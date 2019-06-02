package Spark;

import static spark.Spark.get;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

/**
 * Controller hanterar hemsidans olika URI och URL. 
 */
public final class Controller {

	public static String render(Map<String, Object> model, String templatePath) {
		return new VelocityTemplateEngine().render(new ModelAndView(model, templatePath));
	}

	public static void main(final String[] args) {

		DatabaseLogin login = new DatabaseLogin();

		//berättar för spark vart den ska leta efter filer som används.
		staticFileLocation("/public");

		//get route för startsidan, d.v.s. "localhost:4567/"
		get("/", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			//If-sats som skickar information till index.html om användaren är inloggad eller inte.
			String user = request.session().attribute("loginName");
			if (null != user) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(), login.getPassword());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from games");
			ArrayList<Game> games = new ArrayList<Game>();
			
			//Skapar objekt av den information som hämtas från databasen för att visa på startsidan
			while (rs.next()) {
				Game game = new Game(rs.getInt("gameid"), rs.getString("linkcover"), rs.getString("gametitle"));
				games.add(game);
			}
			
			rs.close();
			st.close();
			con.close();
			model.put("games", games);
			return new ModelAndView(model, "templates/index.html");
		}, new VelocityTemplateEngine());

		
		/**
		 * route till spelens sidor. Fyller en template med information från databasen beroende på 
		 * vilket spel användaren söker/trycker på
		 * Ex. "/game/2" letar i databasen efter spel med ID 2 och fyller hemsidan med information från denna.
		 */
		get("/game/:id", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			int id = Integer.parseInt(request.params("id"));
			model.put("id", request.params("id"));

			String userID = request.session().attribute("loginName");

			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			//if-sats för att skapa felmeddelande om detta behövs, så att användare inte kan rösta 0 (nullRating)
			String nullRating = request.session().attribute("nullRating");
			if (nullRating == "true") {
				model.put("nullRating", "true");
			} else {
				model.put("nullRating", "false");
			}
			request.session().attribute("nullRating", "false");

			Game game = null;
			Connection con = null;

			try {
				con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(), login.getPassword());
				PreparedStatement st = con.prepareStatement("select * from ratings where gameID=?");
				st.setInt(1, id);
				ResultSet rs2 = st.executeQuery();

				double column2 = 0;
				int increment = 0;
				double rating = 0;

				// Samlar ihop spelets betyg
				while (rs2.next()) {
					column2 += rs2.getInt(2);
					increment++;
				}
				rs2.close();
				st.close();

				// Ser till att värde inte delas med noll
				if (increment != 0) {
					rating = column2 / increment;
				} else {
					rating = 0;
				}

				PreparedStatement stmt = con.prepareStatement("select * from games where gameID=?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();

				model.put("rating", rating);
				while (rs.next()) {
					game = new Game(rs.getInt("gameid"), rs.getString("gametitle"), rs.getString("gameinfo"),
							rs.getString("releasedate"), rs.getString("publishers"), rs.getString("genre"),
							rs.getString("gamemodes"), rs.getString("playerperspective"),
							rs.getString("linkofficialsite"), rs.getString("linktrailer"), rs.getString("linkposter"),
							rs.getString("linkcover"), rs.getString("linkpicture1"), rs.getString("linkpicture2"),
							rs.getString("linkpicture3"));
				}
				con.close();
				rs.close();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				if (con != null) {
					con.close();
				}
			}
			model.put("game", game);
			return new ModelAndView(model, "templates/Template.html");
		}, new VelocityTemplateEngine());

		get("/news1.html", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			System.out.println(request.pathInfo());

			String userID = request.session().attribute("loginName");
			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			return new ModelAndView(model, "templates/news1.html");
		}, new VelocityTemplateEngine());

		get("/login.html", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			String userID = request.session().attribute("loginName");
			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			//två if-satser nedan skickar med information som behövs i login.html för att skicka ut felmeddelanden
			String userExists = request.session().attribute("userExists");
			if (userExists == "true") {
				model.put("userExists", "true");
			}

			String wrongPassword = request.session().attribute("wrongPassword");
			if (wrongPassword == "true") {
				model.put("wrongPassword", "true");
			}

			request.session().attribute("wrongPassword", "false");
			request.session().attribute("userExists", "false");
			return new ModelAndView(model, "templates/login.html");
		}, new VelocityTemplateEngine());

		get("/top10.html", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			String userID = request.session().attribute("loginName");
			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			try {
				//hämtar värden som behövs skrivas ut på top10.html
				String query = "SELECT gameID, (SELECT gameTitle FROM games games WHERE gameid = ratings.gameid) as query2, (SELECT gameInfo FROM games games WHERE gameid = ratings.gameid) as query3, (SELECT linkcover FROM games games WHERE gameid = ratings.gameid) as query4, AVG(CAST(vote AS FLOAT)) AS avg_score FROM ratings GROUP BY gameID ORDER BY avg_score DESC;";
				Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
						login.getPassword());
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();

				ArrayList<Game> games = new ArrayList<Game>();
				
				//gör objekt av informationen som ska skickas och lägger till det i en arraylist
				while (rs.next()) {
					Game game = new Game(rs.getFloat("avg_score"), rs.getInt(1), rs.getString("query2"),
							rs.getString("query3"), rs.getString("query4"));
					games.add(game);
				}

				model.put("games", games);
				con.close();
				rs.close();

			} catch (Exception e) {
				System.out.println(e);
			}

			return new ModelAndView(model, "templates/top10.html");
		}, new VelocityTemplateEngine());

		get("/index.html", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			String user = request.session().attribute("loginName");
			if (null != user) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(), login.getPassword());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from games");
			ArrayList<Game> games = new ArrayList<Game>();

			while (rs.next()) {
				Game game = new Game(rs.getInt("gameid"), rs.getString("linkcover"), rs.getString("gametitle"));
				games.add(game);
			}

			rs.close();
			st.close();
			con.close();
			model.put("games", games);
			return new ModelAndView(model, "templates/index.html");
		}, new VelocityTemplateEngine());

		//metod för att registrera användare
		get("/RegisterServlet", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			String username = request.queryParams("txtName");
			String pass1 = request.queryParams("txtPass1");
			String pass2 = request.queryParams("txtPass2");

			if (pass1.equals(pass2)) {
				try {
					Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
							login.getPassword());
					PreparedStatement stmt = con.prepareStatement("select username from users where username=?");
					stmt.setString(1, username);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						if (username.equals(rs.getString(1))) {
							System.out.println("username exists!");
							System.out.println(rs.next());
							model.put("userExists", "true");
							request.session().attribute("userExists", "true");
							response.redirect("login.html");
						}
					} else {
						System.out.println("registering user...");
						PreparedStatement stmt2 = con.prepareStatement("insert into users values (?,?)");
						stmt2.setString(1, username);
						stmt2.setString(2, pass1);
						stmt2.executeUpdate();
						request.session(true);
						request.session().attribute("loginName", username);
						response.redirect("index.html");
					}
					con.close();
					rs.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				response.redirect("login.html");
			}
			return render(model, "templates/index.html");
		});

		
		//metod som loggar in användare
		get("/LoginServlet1", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			
			String loginName = request.queryParams("loginName");
			String loginPass = request.queryParams("loginPass");
			
			try {
				Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
						login.getPassword());
				PreparedStatement stmt = con.prepareStatement("select password from users where username=?");
				stmt.setString(1, loginName);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					if (loginPass.equals(rs.getString(1))) {
						request.session(true);
						request.session().attribute("loginName", loginName);
						System.out.println("Lösenord stämmer, loggar in användare");
						request.session().attribute("loginName");
						response.redirect("index.html");
					} else {
						model.put("wrongPassword", "true");
						request.session().attribute("wrongPassword", "true");
						response.redirect("login.html");
					}
				} else {
					System.out.println("Lösenord stämmer inte");
					model.put("wrongPassword", "true");
					request.session().attribute("wrongPassword", "true");
					response.redirect("login.html");
				}
				con.close();
				rs.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			return new ModelAndView(model, "templates/index.html");
		}, new VelocityTemplateEngine());

		
		//metod som loggar ut användaren
		get("/logout", (request, response) -> {

			String userID = request.session().attribute("loginName");

			if (null != userID) {
				request.session().removeAttribute("loginName");
			}

			response.redirect("index.html");
			return "templates/index.html";
		});

		get("/game/:id/RatingServlet", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			int rate = 0;
			if (request.queryParams("rate") != null) {
				rate = Integer.parseInt(request.queryParams("rate"));
			}

			String userID = request.session().attribute("loginName");
			int gameID = Integer.parseInt(request.params("id"));

			System.out.println("rating: " + rate);
			if (rate >= 1 && rate <= 10) {
				try {
					Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
							login.getPassword());
					PreparedStatement stmt = con
							.prepareStatement("select * from ratings where username=? and gameID=?");
					stmt.setString(1, userID);
					stmt.setInt(2, gameID);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						System.out.println("Already voted, updating vote");
						PreparedStatement stmt3 = con
								.prepareStatement("UPDATE ratings SET vote=? WHERE username=? and gameID=?");
						stmt3.setInt(1, rate);
						stmt3.setString(2, userID);
						stmt3.setInt(3, gameID);
						stmt3.executeUpdate();
						response.redirect("../../game/" + gameID);
					} else {
						if (userID != null) {
							System.out.println("Insert to db");
							PreparedStatement stmt2 = con.prepareStatement("insert into ratings values (?,?,?)");
							stmt2.setString(1, userID);
							stmt2.setInt(2, rate);
							stmt2.setInt(3, gameID);
							stmt2.executeUpdate();
							response.redirect("../../game/" + gameID);
						} else {
							System.out.println("Ej inloggad, logga in först innan du röstar");
							response.redirect("../../game/" + gameID);
						}
					}
					con.close();
					rs.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				
			//om användaren ej väljer röst mellan 1-10 så kommer koden hit
			//metoden skickar med ett värde som hanteras i html-filen för att skicka ut felmeddelande
			} else {
				model.put("nullRating", "true");
				request.session().attribute("nullRating", "true");
				response.redirect("../../game/" + gameID);
			}
			return new ModelAndView(model, "templates/Template.html");
		}, new VelocityTemplateEngine());

		// sökfunktion
		get("/Search", (request, response) -> {
			Map<String, Object> model = new HashMap<>();
			
			//det användaren skriver in i sökrutan sparas i userSearch
			String userSearch = request.queryParams("searchbar");

			String userID = request.session().attribute("loginName");
			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			try {
				Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
						login.getPassword());
				PreparedStatement stmt = con.prepareStatement("select * from games where LOWER(gametitle) like ?");
				stmt.setString(1, "%" + userSearch.toLowerCase() + "%");
				ResultSet rs = stmt.executeQuery();
				ArrayList<Game> games = new ArrayList<Game>();
				while (rs.next()) {
					Game game = new Game(rs.getInt("gameid"), rs.getString("gametitle"), rs.getString("gameinfo"),
							rs.getString("releasedate"), rs.getString("publishers"), rs.getString("genre"),
							rs.getString("gamemodes"), rs.getString("playerperspective"),
							rs.getString("linkofficialsite"), rs.getString("linktrailer"), rs.getString("linkposter"),
							rs.getString("linkcover"), rs.getString("linkpicture1"), rs.getString("linkpicture2"),
							rs.getString("linkpicture3"));

					games.add(game);
				}
				model.put("games", games);
				con.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return render(model, "templates/search.html");
		});

		get("/about.html", (request, response) -> {
			Map<String, Object> model = new HashMap<>();

			String userID = request.session().attribute("loginName");
			if (null != userID) {
				model.put("loggedIn", "true");
			} else {
				model.put("loggedIn", "false");
			}

			return new ModelAndView(model, "templates/about.html");
		}, new VelocityTemplateEngine());

	}
}