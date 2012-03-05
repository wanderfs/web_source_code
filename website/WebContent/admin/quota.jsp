<%-- 
    Document   : quota
    Created on : 2010-11-15, 17:58:48
    Author     : Sen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.HashMap"%>

<%@page import="logic.IUser"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.user.UserRegisterServlet"%>

<%
    String icode = request.getParameter("icode");
    
    if (icode != null && request.getParameter("delta") != null) {
        UserRegisterServlet.icMgr.addQuota(icode, Integer.parseInt(request.getParameter("delta")));
        response.sendRedirect("quota.jsp");
    }
    
    IUser user = ServletCommon.getCurrentUser(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>邀请码控制台</title>
<!--
        <link href="../jquery_plugins/tablesorter/style.css" rel="stylesheet" type="text/css" />

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="../jquery_plugins/jquery.tablesorter.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#myTable").tablesorter();
            });
        </script>-->
    </head>
    <body>
        <h1>Hello iCode!</h1>
        <!--
        <table id="myTable" class="tablesorter">
        <thead>
        <tr>
            <th>icode name</th>
            <th>quota</th>
            <th>used</th>
            <th>created date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Smith</td>
            <td>John</td>
            <td>jsmith@gmail.com</td>
            <td>$50.00</td>
        </tr>
        </tbody>
        </table>-->
        <ul>
        <%
        HashMap<String, Integer> quota = UserRegisterServlet.icMgr.snapshot();

        for (String key : quota.keySet()) {
            %>
            <li><%=key%> : <%=quota.get(key)%>
                <form action="quota.jsp">
                    <input type="hidden" name="icode" value="<%=key%>"/>
                    adjust quota: <input type="text" name="delta" />
                    <input type="submit" value="submit" />
                </form>
            </li>
        <%
        }
        %>
        <li>add new icode:
            <form action="quota.jsp">
                icode name: <input type="text" name="icode"/>
                initial quota: <input type="text" name="delta" />
                <input type="submit" value="submit" />
            </form>
        </li>
        </ul>
    </body>
</html>
