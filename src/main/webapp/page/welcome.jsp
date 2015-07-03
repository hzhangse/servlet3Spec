 <%@ page language="java" pageEncoding="utf-8"%>
 <body>
    欢迎<%=request.getParameter("username") %>：<br>
    	<h1>您已成功登录！</h1>
  </body>
${requestScope.name} ||
${param.username} ||${requestScope.contextPath}