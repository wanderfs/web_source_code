<%-- 
    Document   : adminlogou
    Created on : Aug 19, 2010, 9:07:18 PM
    Author     : senhu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="servlet.ServletCommon"%>

<%
    ServletCommon.clearAutoLogin(session);
    response.sendRedirect("admin.jsp");
%>


