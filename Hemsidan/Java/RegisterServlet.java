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

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseLogin login = new DatabaseLogin();
		String uname = request.getParameter("txtName");
		String pass1 = request.getParameter("txtPass1");
		String pass2 = request.getParameter("txtPass2");
		String email = request.getParameter("txtEmail");
		String ctry = request.getParameter("txtCon");
		
		HttpSession session = request.getSession();

//		session.setAttribute(uname, uname);
//kalla login-servlet istället
		if (pass1.equals(pass2)) {
			System.out.println("kom hit");
			try {
				Connection con = DriverManager.getConnection(login.getJdbUrl(), login.getUsername(),
						login.getPassword());
				PreparedStatement stmt = con.prepareStatement("select username from users where username=?");
				stmt.setString(1, uname);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					if (uname.equals(rs.getString(1))) {
						System.out.println("username exists!");
						System.out.println(rs.next());
						response.sendRedirect("login.html");
					} 
				} else {
					System.out.println("username free like dobby, but not for long...");
					System.out.println("registering user...");
					PreparedStatement stmt2 = con.prepareStatement("insert into users values (?,?)");
					stmt2.setString(1, uname);
					stmt2.setString(2, pass1);
					stmt2.executeUpdate();
					
					//loggar in användare och skickar till index
					session.setAttribute("loginName", uname);
					response.sendRedirect("index.jsp");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("kom hit");
			response.sendRedirect("login.html");
		}
	}

}
