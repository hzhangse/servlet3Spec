<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.mysql.jdbc.Driver" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JDBC Demo</title>
</head>
<body>
<table>
<tr>
    <td>ID</td><td>Name</td>
</tr>    
<%
		Class.forName("com.mysql.jdbc.Driver");		
		Connection connection = null;
		connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/class3", "root", "");
        Statement stmt;
		if (connection != null) {
			stmt = connection.createStatement();
			String query = "select * from student";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				String id = rs.getString(1);
				System.out.println(rs.getString(1));
				String name = rs.getString("sname");
				System.out.println(rs.getString("sname"));
%> 
        <tr>
              <td><%= id %></td>    <td><%= name %></td>
        </tr>
<%	 			
			}
		} 
%>
</table>
</body>
</html>
