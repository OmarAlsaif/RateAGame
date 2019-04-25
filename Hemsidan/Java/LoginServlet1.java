package sys;

import java.io.IOException;
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
 * Servlet implementation class LoginServlet1
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginName = request.getParameter("loginName");
		String loginPass = request.getParameter("loginPass");

		HttpSession session = request.getSession();

		session.setAttribute(loginName, loginName);

		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"password");
			PreparedStatement stmt = con.prepareStatement("select password from users where username=?");
			stmt.setString(1, loginName);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (loginPass.equals(rs.getString(1))) {
					System.out.println(session);
					session.setAttribute("loginName", loginName);
					response.sendRedirect("index.html");
					String str = (String) session.getAttribute(loginName);
					System.out.println(str);
				}
			}
			 else{
				 response.sendRedirect("login.html");
			 }
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
