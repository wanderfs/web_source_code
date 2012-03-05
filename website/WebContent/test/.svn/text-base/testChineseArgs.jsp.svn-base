<%-- 
    Document   : testChineseArgs
    Created on : Jan 12, 2011, 3:14:00 PM
    Author     : Sen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
String ch = request.getParameter("ch");
String tch = new String(ch.getBytes("iso-8859-1"), "utf-8");
String tch2 = new String(ch.getBytes("gbk"));
String tch3 = new String(ch.getBytes("utf-8"));
System.out.println(ch);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=ch%></h1>
        <h1><%=tch%></h1>
        <h1><%=tch2%></h1>
        <h1><%=tch3%></h1>
    </body>
</html>
