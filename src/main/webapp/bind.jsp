<%@ page language="java" import="com.train.listener.Student" pageEncoding="UTF-8"%>
<% 
		Student student = new Student();
		out.println("学生年龄：" + student.getAge() + "<br>");
		session.setAttribute("st", student);
		out.println("存入session后，该学生年龄：" + student.getAge() + "<br>");
		session.removeAttribute("st");
		out.println("从session删除，该学生年龄：" + student.getAge() + "<br>");
%>
