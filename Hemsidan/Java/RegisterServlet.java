package sys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("txtName");
		String pass1 = request.getParameter("txtPass1");
		String pass2 = request.getParameter("txtPass2");
		String email = request.getParameter("txtEmail");
		String ctry = request.getParameter("txtCon");
		
		HttpSession session = request.getSession();

		session.setAttribute(uname, uname);

		if (pass1.equals(pass2)) {
			try {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
						"password");
				PreparedStatement stmt = con.prepareStatement("insert into users values (?,?)");
				stmt.setString(1, uname);
				stmt.setString(2, pass1);
				int row = stmt.executeUpdate();
				if (row != 0) {
					System.out.println("Registration successful!");
					// l�gg till redirect
					session.setAttribute("uname", uname);
					response.sendRedirect("index.html");
				} else {
					System.out.println("Registration unsuccessful!");
					// l�gg till redirect
					response.sendRedirect("register.html");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			System.out.println("<h1>Password not same</h1>");
		}
	}

}
