<%@ page isErrorPage="true" %>
<%=exception.getMessage() %> 
<%=exception.getClass().getName() %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'exceptiondemo.jsp' starting page</title>
  </head>
  <body>
    <h1>这是一张错误处理页面。</h1>
    错误信息如下：</br>
    <%=exception.getMessage() %></br>
    错误处理类如下：</br>
    <%=exception.getClass().getName() %>
  </body>
</html>
