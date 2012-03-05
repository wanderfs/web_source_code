<%-- 
    Document   : testUser
    Created on : 2011-3-18, 0:05:14
    Author     : Administrator
--%>

<%@page import="logic.IUser"%>
<%@page import="logic.EntityFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
            IUser user = EntityFactory.getUser(31);
            user.setPhoto("pic/face/faceS160.png");
            user.commit();
            System.out.println(user.getPhoto());
            System.out.println(EntityFactory.getUser(31).getPhoto());
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>Hello World!</h1>
        <h1>Hello World!</h1>
    </body>
</html>
