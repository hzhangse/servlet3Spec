<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>include指令的使用</title>
<head>
<body>
当前日期是：<!-- <%@ include file='showDate.jsp' %> -->
<jsp:include page="showDate.jsp">
  <jsp:param name="name"  value= "aaa"/>
</jsp:include>
</body>
</html>
