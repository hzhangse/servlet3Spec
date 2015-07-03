<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page errorPage="exceptiondemo.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'byzero.jsp' starting page</title>
  </head>
  <body>
    <%
	 int i =0;
	//因为除数是0，当程序运行到此处时，会抛出一个异常    
out.print(5/i);
    %>
  </body>
</html> 
