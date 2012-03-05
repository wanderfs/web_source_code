<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.EntityFactory"%>
<%@page import="cms.IndexContentManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.IUser"%>
<%@page import="logic.IChannel"%>
<%@page import="logic.Video"%>
<%@page import="logic.User"%>
<%@page import="logic.EntityFactory"%>
<%@page import="java.util.Date" %>

<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="logic.Global"%>
<%@page import="utility.Pair" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi 你的视频私生活</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视 你的视频私生活" />

        <link rel="shortcut icon" href="pic/slogo.png" type="image/x-icon"/>
        <link href="CSS/all.css" rel="stylesheet" type="text/css" media="all"  />

        <!--[if lte IE 6]>
        <link href="../CSS/ie6.css" rel="stylesheet" type="text/css" />
        <script src="../JS/ie6.js" type="text/javascript"></script>
        <![endif]-->

        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>-->
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>

        <script src="js/tools.js" type="text/javascript"></script>
        <script src="js/search.js" type="text/javascript"></script>
    </head>

    <body class="gray_background_2"> 
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">

                    <%@include file="jspf/top_small.jspf"%>

                    <div id="s_d_main">
                        <div class="s_d_columns">
                            <div id="s_d_columnA" class="s_d_column">
                                <div class="s_d_hot_video_clips">
                                    <div class="s_d_wrap">
                                        <% String keyword = request.getParameter("keyword");%>
                                        <jsp:include page="jspf/search_result.jsp?type=video&keyword=<%=keyword%>" />
                                    </div>
                                </div>
                            </div>
                            <div id="s_d_columnB" class="s_d_column right">
                                <div class="mask">
                                    <div class="lisettop"><span>专辑推荐</span></div>
                                    <div class="lisetcont">
                                        <ul>
                                            <li class="maging maging_top">
                                                <big class="img">xxxx</big><big class="txt"><b>星际之王降临</b>这是我第一个视频这是我第一个视频</big>
                                            </li>
                                            <li class="maging">
                                                <big class="img">xxxx</big><big class="txt"><b>星际之王降临</b>这是我第一个视频这是我第一个视频</big>
                                            </li>
                                            <li class="more"><a href="#">更多</a></li>
                                        </ul>
                                    </div>
                                    <div class="rlisetfommtbg"></div>
                                </div>
                                <%@include file="jspf/list_top_followee.jspf" %>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <%@include file="jspf/footer.jspf"%>
                </div>
            </div>
        </div>
        <div class="mask">
            <div class="s_d_right_bar">
                <div class="s_d_collect_img">
                    <a href="#nogo"></a>
                </div>
                <div class="s_d_share_img">
                    <a class="float_left" href="#nogo"></a>
                    <div class="s_d_share_hoverbox float_left mask">
                        <div class="s_d_share_hoverbox_inner">
                            <div class="s_d_innersite_share float_left">站内分享</div>
                            <div class="renren_share float_left s_d_shareclip">人人网</div>
                            <div class="kaixin001_share float_left s_d_shareclip">开心网</div>
                            <div class="tsina_share float_left s_d_shareclip">新浪微博</div>
                            <div class="qzone_share float_left s_d_shareclip">QQ空间</div>
                            <div class="tqq_share float_left s_d_shareclip">腾讯微博</div>
                            <div class="douban_share float_left s_d_shareclip">豆瓣</div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </body>
</html>
