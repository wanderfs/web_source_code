<%-- 
    Document   : leave_message
    Created on : 2011-3-28, 23:19:08
    Author     : Administrator
--%>

<%@page import="logic.EntityFactory"%>
<%@page import="logic.datatype.CommentEvent"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="logic.IUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            IUser user = ServletCommon.getCurrentUser(request.getSession());
            int hostid = Integer.parseInt(ServletCommon.ajaxChineseTranscoder(request, "hostid"));
            String comment = ServletCommon.ajaxChineseTranscoder(request, "comment");
            CommentEvent ce = user.leaveUserComment(user.getUserid(), comment, hostid);
            IUser cuser = EntityFactory.getUser(ce.getUserid());
%>

<div class="lifl">
    <div class="li">
        <a class="float" href="#nogo">
            <img src="<%= cuser.getPhotoMini()%>" width="25px" height="25px" alt="photo"/>
        </a>
        <div id="<%= cuser.getName()%>" class="float reply_byline">
            <a href="#nogo"><%= cuser.getName()%></a>
            <span><%= ce.getTime()%></span>
            <div class="reply">
                <%= ce.getComment()%>
                <a class="reply_other" href="#nogo">回复</a>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>