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
<%@page import="logic.User"%>
<%@page import="servlet.ServletCommon"%>

<%
boolean noUserFlag = false;
boolean adminFlag = false;
boolean pwFlag = false;
String email = request.getParameter("email");
String password = request.getParameter("password");
IUser user = EntityFactory.getUser(email);
if (user == null) {
    noUserFlag = true;
} else {
    if (ServletCommon.isAdmin(user.getUserid())) {
        adminFlag = true;
        if (user.getPassword().equals(password)) {
            pwFlag = true;
            request.getSession(true).setAttribute("user", user);
        }
    }
}
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <script type="text/javascript" src="admin_query.js"></script>
    </head>
    <body>
        <% if(noUserFlag) { %>
            <p> You haven't signed up!</p>
        <% } else {
            if(pwFlag) { %>
            <a href="admin_logout.jsp"><strong>Log out here!</strong></a><br /><br />
            <h1>Administrator Page</h1>
            <form name="uid_query" action="uid_query.jsp" method="get">
                uid: <input type="text" name="uid"> <input type="submit" value="Submit">
            </form>
            <p><strong>OR</strong></p>
            <form name="vid_query" action="vid_query.jsp" method="get">
                vid: <input type="text" name="vid"> <input type="submit" value="Submit">
            </form>
            <% } else if (!adminFlag) {%>
                <p> You are not an administrator!</p>
            <% } else if (!pwFlag) { %>
                <p> Wrong password!</p>
            <% }
        } %>
    </body>
</html>

