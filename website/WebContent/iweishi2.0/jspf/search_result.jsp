<%-- 
    Document   : search_result
    Created on : 2011-3-11, 19:13:54
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="utility.Searcher" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
<%@page import="logic.IVideo" %>
<%@page import="logic.EntityFactory" %>

<%
            if (request.getParameter("type").equals("video")) {
                Searcher searcher = new Searcher();
                ArrayList<IVideo> vurls = searcher.iweishiSearch(request.getParameter("keyword"));
                Iterator<IVideo> it = vurls.iterator();
                while (it.hasNext()) {
                    IVideo video = it.next();
%>
<div class="s_d_video_clip" id="search_vid<%=video.getVideoid()%>">
    <div class="s_d_detail">
        <div class="s_d_video_pic">
            <a target="_blank" href="video.jsp?vid=<%= video.getVideoid()%>">
                <img height="90px" width="120px" src="<%= video.getSnapshotURL()%>" alt="<%= video.getTitle()%>" title="<%= video.getTitle()%>"/>
            </a>
        </div>
        <div class="s_d_video_des">
            <div class="s_d_vtitle">
                <a target="_blank" href="video.jsp?vid=<%= video.getVideoid()%>"><%= video.getTitle()%></a>
            </div>
            <div>
                <span>发现者</span>
                <a target="_blank" href="home.jsp?uid=<%= video.getFirstSubmitUserid()%>"><%= EntityFactory.getUser(video.getFirstSubmitUserid()).getName()%></a>
                <span>&nbsp;&nbsp;<%= video.getTime()%></span>
            </div>
            <div class="s_d_content">
                <span><%= video.getSummary()%></span>
            </div>
            <div>
                <div class="s_d_play_count_img"></div>
                <div class="float_left">观看（<%= video.getWatchUserCount()%>）</div>
                <div class="share_count_img"></div>
                <div class="float_left">分享<span>(<%= video.getShareCount()%>)</span></div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="s_d_play">
            <a href="#nogo"></a>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<%
                }
            }
%>

<div class="mask">

    <div class="pagination ">
        <ul>
            <li><a href="#nogo">上一页</a></li>
            <li class="selected"><a href="#nogo">1</a></li>

            <li><a href="#nogo">2</a></li>

            <li><a href="#nogo">3</a></li>

            <li><a href="#nogo">4</a></li>

            <li><a href="#nogo">5</a></li>

            <li><a href="#nogo">6</a></li>

            <li><a href="#nogo">7</a></li>

            <li><a href="#nogo">8</a></li>

            <li><a href="#nogo">9</a></li>

            <li><a href="#nogo">10</a></li>

            <li><a href="#nogo">11</a></li>

            <li><a href="#nogo">12</a></li>

            <li class="dots">...</li>
            <li><a href="#nogo">20</a></li>

            <li><a href="#nogo">下一页</a></li>
            <li class="page_now">（第1页）</li>
            <div class="clear"></div>
        </ul>
        <div class="clear"></div>
    </div>
</div>