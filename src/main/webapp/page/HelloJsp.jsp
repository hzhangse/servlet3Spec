<%@ page language = "java" pageEncoding="utf-8" %>
	<html>
	<head>
	<title>JSP声明</title>
</head>
<body>
<%--声明方法--%>
	<%!
		public String output(String name){
			return "Hello"+name;
		} 
%>
<%--声明变量--%>
<%! String name = "JSP爱好者"; %>
		<%= output(name)%>
	</body>
	</html>
