Register.jsp

<%@page contentType="text/html" import="java.sql.*"%>
<html><body>
        <h1>Registration JSP Page</h1>
    <%
        String uname=request.getParameter("txtName");
        String pass1 = request.getParameter("txtPass1");
        String pass2 = request.getParameter("txtPass2");
        String email = request.getParameter("txtEmail");
        String ctry = request.getParameter("txtCon");
  if(pass1.equals(pass2)){
        try{
//    Class.forName("com.postgresql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
    PreparedStatement stmt = con.prepareStatement("insert into users values (?,?)");
    stmt.setString(1, uname);    stmt.setString(2, pass1);
    int row = stmt.executeUpdate();
    if(row==1) { out.println("Registration successful"); }
    else {    
        out.println("Registration unsuccessful!");
        %>
            <jsp:include page="login.html" ></jsp:include>
        <%
    
        }
    }catch(Exception e){out.println(e);}
  }
  else 
  {
  out.println("<h1>Password not same</h1>");
  %>
  <jsp:include page="login.html" ></jsp:include>
<%  }
    %>
    </body>
</html>