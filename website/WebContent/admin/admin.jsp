<%--
    Document   : newjsp
    Created on : Aug 18, 2010, 4:31:39 PM
    Author     : senhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="logic.EntityFactory"%>
<%@page import="logic.IUser"%>
<%@page import="servlet.ServletCommon"%>

<%
boolean adminFlag = false;
IUser user = ServletCommon.getCurrentUser(session);
if (ServletCommon.isAdmin(user.getUserid())) {
    adminFlag = true;
}
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <% if(!adminFlag) { %>
            <h1>管理员登录:</h1><br>
            <form name="admin_login" method="post" action="admin_query.jsp">
                邮箱: <input type="text" name="email"><br /><br />
                密码: <input type="password" name="password"><br /><br />
                <input type="submit" value="登录">
                <input type="reset" value="清空">
            </form>
        <% } else { %>
            <h1>Administrator Page</h1>
            <form name="uid_query" action="uid_query.jsp" method="get">
                uid: <input type="text" name="uid"> <input type="submit" value="Submit">
            </form>
            <p><strong>OR</strong></p>
            <form name="vid_query" action="vid_query.jsp" method="get">
                vid: <input type="text" name="vid"> <input type="submit" value="Submit">
            </form>
         <% } %>
    </body>
</html>

