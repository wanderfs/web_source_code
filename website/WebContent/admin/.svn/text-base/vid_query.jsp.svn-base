<%-- 
    Document   : vid_query
    Created on : Aug 18, 2010, 4:43:08 PM
    Author     : senhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="logic.EntityFactory"%>
<%@page import="logic.IUser"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="servlet.ServletCommon"%>

<%
IUser adminUser = ServletCommon.getCurrentUser(session);
if (ServletCommon.isAdmin(adminUser.getUserid())) {
    String svid = request.getParameter("vid");
    int vid = 0;
    String errorm = null;
    IVideo video = null;
    boolean flag = false;
    video = EntityFactory.getVideo(vid);
    try {
        vid = Integer.parseInt(svid);
    } catch (NumberFormatException e) {
        errorm = e.getMessage();
        flag = true;
    }
    if(!flag) video = EntityFactory.getVideo(vid);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>vid query</title>
    </head>
    <body>
        <h1>Vid Query</h1>
        <% 
        if(!flag) { %>
            <a href="admin_logout.jsp"><strong>Log out here!</strong></a><br /><br />
            <% if(video != null) { %>
                
                <div>Vid: <%= svid%></div><br />
                <div>
                    Video Title: <a href="../video.jsp?vid=<%=vid%>">
                        <strong><%= video.getTitle()%></strong></a>
                </div><br />
                <div> <strong>Video Information</strong>: <%= video.toString()%> </div>
            
            <% } else { %>
                <div>Vid: <%=svid%></div><br />
                This video doesn't exist!
            <% }
        } else { %>
            <div>The input is invalid: <%=errorm%></div>
        <% } %>
    </body>
</html>

<% } else {
    response.sendRedirect("../user_index.jsp");
} %>
