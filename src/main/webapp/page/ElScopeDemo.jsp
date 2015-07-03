<%@ page language="java" pageEncoding="UTF-8"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
  <head> 

    <title>My JSP 'elExample1.jsp' starting page</title> 

    <meta http-equiv="pragma" content="no-cache"> 
    <meta http-equiv="cache-control" content="no-cache"> 
    <meta http-equiv="expires" content="0"> 
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
    <meta http-equiv="description" content="This is my page"> 
    <!-- 
  <link rel="stylesheet" type="text/css" href="styles.css"> 
  --> 

  </head> 

  <body> 
    <% 
      pageContext.setAttribute("username","meixin"); 
      request.setAttribute("username","meixinRequest"); 
      session.setAttribute("username","meixinSession"); 
      application.setAttribute("username","meixinApplication"); 
     %> 
     <!-- 输出meixin --> 
     ${pageScope.username }<br> 
     ${pageScope['username'] }<br> 
     <!-- 输出值为meixinSession --> 
     ${sessionScope.username }<br> 
      ${sessionScope["username"] }<br> 
     <!-- 输出值为meixinRequest --> 
     ${requestScope.username }<br> 
     <!-- 输出值为meixinApplication --> 
     ${applicationScope.username }<br> 
     <!-- 输出值为meixin，此变量系统根据pageContext,request,session,application依次查找 --> 
     ${username }<br> 
     
  </body> 
</html> 
