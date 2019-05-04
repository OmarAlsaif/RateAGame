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
	
		
//		try {
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
//					"password");
//			PreparedStatement stmt = con.prepareStatement("insert into ACOdyssey values (?,?)");
//			stmt.setString(1, userr);
//			stmt.setString(2, rating);
//		}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"password");
			PreparedStatement stmt = con.prepareStatement("insert into ACOdyssey values (?,?)");
			stmt.setString(1, userr);
			stmt.setInt(2, result);
			int row = stmt.executeUpdate();
			
			if (row != 0) {
				System.out.println("Rating submitted");
			}
			 else{
//			idk	 response.sendRedirect("index.html");
			 }
		} catch (Exception e) {
			System.out.println(e);
		}


	}

}
