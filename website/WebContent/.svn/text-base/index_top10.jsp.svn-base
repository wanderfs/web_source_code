<%--
    Document   : hot_event_starcraft
    Created on : Dec 23, 2010
    Author     : sen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.IChannel"%>
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="utility.alpha.*"%>
<%@page import="logic.datatype.PostEvent"%>
<%@page import="servlet.WebpageLayoutParam"%>

<%
            response.sendRedirect("iweishi2.0/index.jsp");
            IUser user = ServletCommon.getCurrentUser(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视是网络视频的集散地" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/global.css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/hot_event.css"/>
        <link href="CSS/homepage_header_none_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/join_login.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var page_type = "square.log";
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>

        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/push_frame.js" type="text/javascript"></script>
        <script src="JS/custom_search.js" type="text/javascript"></script>
        <script src="JS/hot_event.js" type="text/javascript"></script>
        <link href="CSS/footer.css" rel="stylesheet" type="text/css">

        <script src="JS/head_last.js" type="text/javascript"></script>

    </head>

    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <% if (user.getUserid() == ServletCommon.nobodyId) {%>
                    <%@include file="jspf/top_menu_nobody.jspf"%>
                    <%} else {%>
                    <%@include file="jspf/top_menu.jspf"%>
                    <%}%>

                    <div id="cap" ><!--[if gte IE 6]><img src="pic/top_cap.png"><![endif]--></div>
                    <div id="main">
                        <div id="header">
                            <h1>今日十大视频</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div class="clips_head">
                                    <img height="35" width="159" src="http://s.xnimg.cn/imgpro/logo/logo-rr-159.png?f=trunk" title="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" alt="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" />
                                    <span>人人今日十大视频</span>
                                </div>
                                <div class="clips">

                                    <ol>
                                        <%
                                                    int chosen_aid = 211;
                                                    IChannel chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    List alist = chosen_album.getPosts(0, 10);
                                                    Iterator ait = alist.iterator();
                                                    int vnum_end = 1;
                                                    int vnum_top = 0;
                                                    while (ait.hasNext()) {
                                                        PostEvent pe = (PostEvent) ait.next();
                                                        int vid = pe.getVideoid();
                                                        IVideo video = EntityFactory.getVideo(vid);
                                        %>
                                        <li  class="<% if (vnum_top < 4) {%>top <% }%> <% if (vnum_end % 4 == 0 && vnum_end != 0) {%> end <% }%>" >
                                            <div title="<%= video.getTitle()%>" class="image">
                                                <a href="video.jsp?vid=<%= vid%>" target="_blank">
                                                    <img width="125" height="94" alt="hot event" src="<%= video.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="video.jsp?vid=<%= vid%>" title="<%= video.getTitle()%>" target="_blank"><%= video.getTitle()%></a>
                                            </div>
                                        </li>
                                        <%
                                                        ++vnum_top;
                                                        ++vnum_end;
                                                    }%>

                                    </ol>
                                    <div class="clear"></div>
                                </div>
                                <div class="clips_head">
                                    <img height="35" width="159" src="http://s.xnimg.cn/imgpro/logo/logo-rr-159.png?f=trunk" title="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" alt="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" />
                                    <span>人人今日十大视频</span>
                                </div>
                                <div class="clips">

                                    <ol>
                                        <%
                                                    chosen_aid = 211;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 10);
                                                    ait = alist.iterator();
                                                    vnum_end = 1;
                                                    vnum_top = 0;
                                                    while (ait.hasNext()) {
                                                        PostEvent pe = (PostEvent) ait.next();
                                                        int vid = pe.getVideoid();
                                                        IVideo video = EntityFactory.getVideo(vid);
                                        %>
                                        <li  class="<% if (vnum_top < 4) {%>top <% }%> <% if (vnum_end % 4 == 0 && vnum_end != 0) {%> end <% }%>" >
                                            <div title="<%= video.getTitle()%>" class="image">
                                                <a href="video.jsp?vid=<%= vid%>" target="_blank">
                                                    <img width="125" height="94" alt="hot event" src="<%= video.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="video.jsp?vid=<%= vid%>" title="<%= video.getTitle()%>" target="_blank"><%= video.getTitle()%></a>
                                            </div>
                                        </li>
                                        <%
                                                        ++vnum_top;
                                                        ++vnum_end;
                                                    }%>

                                    </ol>
                                    <div class="clear"></div>
                                </div>
                                <div class="clips_head">
                                    <img height="35" width="159" src="http://s.xnimg.cn/imgpro/logo/logo-rr-159.png?f=trunk" title="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" alt="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" />
                                    <span>人人今日十大视频</span>
                                </div>
                                <div class="clips">

                                    <ol>
                                        <%
                                                    chosen_aid = 211;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 10);
                                                    ait = alist.iterator();
                                                    vnum_end = 1;
                                                    vnum_top = 0;
                                                    while (ait.hasNext()) {
                                                        PostEvent pe = (PostEvent) ait.next();
                                                        int vid = pe.getVideoid();
                                                        IVideo video = EntityFactory.getVideo(vid);
                                        %>
                                        <li  class="<% if (vnum_top < 4) {%>top <% }%> <% if (vnum_end % 4 == 0 && vnum_end != 0) {%> end <% }%>" >
                                            <div title="<%= video.getTitle()%>" class="image">
                                                <a href="video.jsp?vid=<%= vid%>" target="_blank">
                                                    <img width="125" height="94" alt="hot event" src="<%= video.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="video.jsp?vid=<%= vid%>" title="<%= video.getTitle()%>" target="_blank"><%= video.getTitle()%></a>
                                            </div>
                                        </li>
                                        <%
                                                        ++vnum_top;
                                                        ++vnum_end;
                                                    }%>

                                    </ol>
                                    <div class="clear"></div>
                                </div>
                                <div class="clips_head">
                                    <img height="35" width="159" src="http://s.xnimg.cn/imgpro/logo/logo-rr-159.png?f=trunk" title="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" alt="人人网 renren.com - 人人网校内是一个真实的社交网络，联系朋友，一起玩游戏" />
                                    <span>人人今日十大视频</span>
                                </div>
                                <div class="clips">

                                    <ol>
                                        <%
                                                    chosen_aid = 211;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 10);
                                                    ait = alist.iterator();
                                                    vnum_end = 1;
                                                    vnum_top = 0;
                                                    while (ait.hasNext()) {
                                                        PostEvent pe = (PostEvent) ait.next();
                                                        int vid = pe.getVideoid();
                                                        IVideo video = EntityFactory.getVideo(vid);
                                        %>
                                        <li  class="<% if (vnum_top < 4) {%>top <% }%> <% if (vnum_end % 4 == 0 && vnum_end != 0) {%> end <% }%>" >
                                            <div title="<%= video.getTitle()%>" class="image">
                                                <a href="video.jsp?vid=<%= vid%>" target="_blank">
                                                    <img width="125" height="94" alt="hot event" src="<%= video.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="video.jsp?vid=<%= vid%>" title="<%= video.getTitle()%>" target="_blank"><%= video.getTitle()%></a>
                                            </div>
                                        </li>
                                        <%
                                                        ++vnum_top;
                                                        ++vnum_end;
                                                    }%>

                                    </ol>
                                    <div class="clear"></div>
                                </div>

                                <div class="description_container">
                                    <div id="description"></div>
                                </div>
                            </div>
                            <div class="column" id="columnB">
                                <div class="nippleBox manateeCloud instruction">
                                    <div class="bar">
                                        <h4>爱微视活动广场</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <p>
                                            &nbsp;&nbsp;嗨，看看爱微视最近的火热专题！<br/><br/>
                                            &nbsp;&nbsp;有更潮更in的活动主题？联系<a href="mailto:iweishi2010@gmail.com?Subject=Topic%20Idea">&nbsp;爱微视</a>，自己做主角~
                                            <br/><br/>
                                        </p>
                                    </div>
                                </div>

                            </div>
                            <div class="clear"></div>
                        </div>
                        <%@include file="jspf/footer.jspf"%>

                    </div>
                </div>
            </div>
        </div>
        <img style="top: -3px;" class="sun"
             src="pic/land_sun.gif"><img
             style="position: fixed;*position: absolute; z-index: 20; top: 45px; right: -60px;*right: 0px;"
             id="cloud"
             src="pic/land_cloud.gif"><img
             style="top: 322px;" id="cloud2"
             src="pic/land_cloud2.gif">
        <div class="mask">
            <%@include file="jspf/loginbox.jspf"%>
        </div>
    </body>
</html>
