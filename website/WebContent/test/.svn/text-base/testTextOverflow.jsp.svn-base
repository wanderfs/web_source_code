<%-- 
    Document   : testThreeDots
    Created on : 2010-12-8, 17:38:36
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.IUser"%>

<%@page import="logic.IChannel"%>
<%@page import="logic.Global"%>
<%@page import="logic.Video"%>
<%@page import="logic.User"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.datatype.*"%>
<%@page import="logic.IEvent"%>
<%@page import="logic.datatype.JoinChannelEvent"%>

<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>

<%
// host: owner of this page.
            int uid = 39;
            IUser host = EntityFactory.getUser(uid);
            String sname = host.getName();

// user: the one who is currently viewing the page.
            IUser user = ServletCommon.getCurrentUser(session);
            String prop = "TA";
            if (user.getUserid() == uid) // user is viewing his/her own home
            {
                prop = "我";
            }

            List channellist = host.getJoinedChannel(WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS);
            Iterator<JoinChannelEvent> channelit = channellist.iterator();
            int cid = 0;

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
     <link href="../CSS/userhomepage_enter.css" rel="stylesheet" type="text/css" />

        <script src="../jquery_plugins/jquery.text-overflow.min.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(document).ready(function(){
               $('ul.ulDropdown li.album_item').textOverflow();});


        </script>
    </head>
    <body>
        <ul class="ulDropdown" style="display: none;">
                                                    <li class="selected unpost" id="unpost">未放入任何专辑的收藏视频</li>
                                                    <%
                                                                String album_name = "";
                                                                StringBuilder album_short_name = new StringBuilder();
                                                                while (channelit.hasNext()) {
                                                                    cid = channelit.next().getGroupid();
                                                                    album_name = EntityFactory.getGroup(cid).getName();
                                                                    if (album_name.length() > 40) {
                                                                        album_short_name.append(album_name.substring(0, 40)).append("...");
                                                    %>
                                                    <li id='<%="cid" + cid%>' class="album_item" title="<%= album_name%>"><%= album_short_name.toString()%></li>
                                                    <%
                                                                                                                        } else {
                                                    %>
                                                    <li id='<%="cid" + cid%>' class="album_item" ><%= album_name%></li>

                                                    <%                                                                                    }
                                                                album_short_name.delete(0, album_name.length());
                                                                }
                                                                if (user.getUserid() == uid) {
                                                    %>
                                                    <li class="create_album">新建专辑</li>
                                                    <% }%>
                                                </ul>

    </body>
</html>
