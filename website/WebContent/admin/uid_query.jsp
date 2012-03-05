<%-- 
    Document   : vid_query.jsp
    Created on : Aug 18, 2010, 4:43:20 PM
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
IUser adminUser = ServletCommon.getCurrentUser(session);
if (ServletCommon.isAdmin(adminUser.getUserid())) {
    String suid = request.getParameter("uid");
    int uid = 0;
    IUser user = null;
    String errorm = null;
    boolean flag = false;
    try {
        uid = Integer.parseInt(suid);
    } catch (NumberFormatException e) {
        errorm = e.getMessage();
        flag = true;
    }
    if(!flag) user = EntityFactory.getUser(uid);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uid Query</title>
    </head>
    <body>
        <h1>uid query</h1>
        <%
        if(!flag) { %>
            <a href="admin_logout.jsp"><strong>Log out here!</strong></a><br /><br />
            <% if(user != null) { %>
                <div>
                    <a href="../home.jsp?uid=<%=uid%>">
                        <img src="../<%=user.getPhoto()%>" align=left
                             title="<%=user.getName()%>" class="portrait"/>
                    </a>
                </div><br>
                <div> Uid: <%=suid%> </div><br>
                <div>
                     User Name: <a href="../home.jsp?uid=<%=uid%>">
                         <strong><%= user.getName()%></strong></a>
                </div><br>
                <div><strong>User Information</strong>: <%= user.toString() %></div>

            <% } else { %>
                <div> Uid: <%=suid%> </div><br>
                <div>This user doesn't exist!</div>
            <% }
        } else { %>
            <div>The input is invalid: <%=errorm%></div>
        <% } %>
    </body>
</html>

<% } else {
    response.sendRedirect("admin.jsp");
} %>

