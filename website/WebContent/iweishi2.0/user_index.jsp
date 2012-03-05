<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : xiaoxiao Apr 21,2010, 17:00 beijing
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
<%@page import="logic.datatype.JoinChannelEvent"%>
<%@page import="java.util.Date" %>

<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="logic.Global"%>
<%@page import="utility.Pair" %>

<%
            IUser user = ServletCommon.getCurrentUser(session);

            if (user.getUserid() == ServletCommon.nobodyId) {
                response.sendRedirect("index.jsp");
            }

            String autologin = request.getParameter("autologin");
            if (autologin != null && autologin.equals("on")) {
                ServletCommon.generateAutoLoginCookies(response, session, user);
            }
%>

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
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.4.2.min.js"></script>

        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link href="colorbox/colorbox.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript">
            var user_id = <%= user.getUserid()%>;
            var user_name = "<%= user.getName()%>";
            var user_photo_small = "<%=user.getPhotoSmall()%>";
            var user_photo_mini = "<%=user.getPhotoMini()%>";
        </script>

        <script src="js/tools.js" type="text/javascript"></script>
        <script src="js/all.js" type="text/javascript"></script>
    </head>

    <body class="gray_background">
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">

                    <%@include file="jspf/top_menu.jspf"%>

                    <div id="main">
                        <div id="header">
                            <div id="push_video_box">
                                <div id="push_video_head">
                                </div>
                                <div id="push_video_body">
                                    <form method="post" action="" id="push_video_form">
                                        <textarea id="push_video_textarea" rows="3" cols="" name="push_video_textarea">直接输入视频的网址进行收藏，例如：http://v.youku.com/show/23.html</textarea>
                                        <span>支持的网站有：优酷，土豆，CNTV，酷6，我乐，六间房，新浪视频...</span>
                                        <a type="button" class="push_video_btn" id="push_video_btn" ></a>
                                    </form>
                                </div>
                            </div>

                            <div id="head_flash">
                                <embed height="100%" width="100%" type="application/x-shockwave-flash" src="flash/as1230.swf" bgcolor="#ffffff" quality="heigh" allowscriptaccess="always" wmode="transparent" scalemode="showAll"/>
                            </div>
                            <div class="clear"></div>
                        </div>

                        <div class="columns">

                            <div id="columnA" class="column">
                                <div class="tabs">
                                    <div id="hot_video" class="tab">
                                        &nbsp&nbsp&nbsp&nbsp所有动态
                                    </div>
                                    <div id="albumtab" class="tab mask">专辑动态</div>
                                    <div class="clear"></div>
                                </div>
                                <div class="hot_video_clips">
                                    <div class="wrap">
                                        <jsp:include page="jspf/hangaround.jsp?type=mine&time=<%= new Date().getTime()%>" />
                                    </div>
                                </div>
                            </div>
                            <div id="columnB" class="column right">
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

        <div id="vault" class="mask">
            <%@include file="jspf/push_frame.jspf"%>
        </div>
    </body>
</html>
