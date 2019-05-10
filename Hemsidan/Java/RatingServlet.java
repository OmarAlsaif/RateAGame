package sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RatingServlet
 */
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseLogin login = new DatabaseLogin();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("doGet kallades");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost kallades");
		String rating = request.getParameter("rate");
		String rating2 = request.getParameter("rating");
		System.out.println(rating);
		System.out.println(rating2);
		HttpSession session = request.getSession();
		System.out.println(session);
		String userr = (String)session.getAttribute("loginName");
		System.out.println(userr);
		int result = Integer.parseInt(rating);
		System.out.println(rating);
		
		try {
			Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
					login.getPassword());
			PreparedStatement stmt = con.prepareStatement("select username from acodyssey where username=?");
			stmt.setString(1, userr);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (userr.equals(rs.getString(1))) {
					System.out.println("username already rated, lets update it");
					PreparedStatement stmt3 = con.prepareStatement("UPDATE acodyssey SET rating=? WHERE username=?");				
					stmt3.setInt(1, result);
					stmt3.setString(2, userr);
					stmt3.executeUpdate();
					response.sendRedirect(request.getContextPath() + "/Titles/Assasins Creed Odyssey/assasinscreedodyssey.jsp");
				}
			} else {
				System.out.println("Inserting rating into database");
				PreparedStatement stmt2 = con.prepareStatement("insert into acodyssey values (?,?)");
				stmt2.setString(1, userr);
				stmt2.setInt(2, result);
				stmt2.executeUpdate();
				response.sendRedirect(request.getContextPath() + "/Titles/Assasins Creed Odyssey/assasinscreedodyssey.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

