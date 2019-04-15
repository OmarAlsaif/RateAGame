Login.jsp
<%@page contentType="text/html" import="java.sql.*"%>
<html><body>
        <h1>Registration JSP Page</h1>
    <%
        String uname=request.getParameter("loginName");
        String pass = request.getParameter("loginPass");
       

        try{
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
    PreparedStatement stmt = con.prepareStatement("select password from products2 where username=?");
    stmt.setString(1, uname);  
    ResultSet rs = stmt.executeQuery();
    if(rs.next()){
        if(pass.equals(rs.getString(1)))
        {
            session.setAttribute("user", uname);
            response.sendRedirect("index.html");
        }
        }
    else{
    out.println("<h1>Username does not exist</h1>");
    %>
    <jsp:include page="Register.html" ></jsp:include>
        <%
    }
        }catch(Exception e){out.println(e);}
   %>
    </body>
</html>