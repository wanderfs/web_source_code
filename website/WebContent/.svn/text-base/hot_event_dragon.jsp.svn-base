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

<%
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
            var page_type = "dragon.log";
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
                            <h1>爱微视活动广场</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div><img alt="海报" src="pic/hot_event/hot_event_poster_square.png" width="620px"/></div>
                                <div class="clips_head">
                                    <span>近期专辑活动 集锦</span>
                                </div>
                                <div class="clips">
                                    <ol>
                                        <%
                                                    int albumuserid = 23;
                                                    IUser album_user = EntityFactory.getUser(albumuserid);
                                                    int chosen_aid = 198;
                                                    IChannel chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    List alist = chosen_album.getPosts(0, 1);
                                                    Iterator ait = alist.iterator();
                                                    PostEvent pe = (PostEvent) ait.next();
                                                    IVideo fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top">
                                            <div title="<%= chosen_album.getName() %>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>"><%= chosen_album.getName() %></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1541;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 202;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top">
                                            <div title="<%= chosen_album.getName() %>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>"><%= chosen_album.getName() %></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1538;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 192;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top end">
                                            <div title="<%= chosen_album.getName() %>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>"><%= chosen_album.getName() %></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <li class="top">
                                            <div title="萧敬腾MV" class="image">
                                                <a href="home.jsp?uid=1500#cimported_tab">
                                                    <img width="125" height="94" alt="hot event" src="http://g2.ykimg.com/0100641F46489D2009C83300998D950B607473-E333-B742-1BE1-A9C9651A58A1">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=1500#cimported_tab">萧敬腾MV</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=1500#cimported_tab">萧敬腾MV</a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1538;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 190;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName() %>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>"><%= chosen_album.getName() %></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1538;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 191;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName() %>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>"><%= chosen_album.getName() %></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                    </ol>
                                    <div class="clear"></div>
                                </div>

                                <div class="description_container">
                                    <div id="description"></div>
                                </div>
                                <div class="comment_module">
                                    <ul id="comments" class="comments">
                                        <li id="hc_template" class="parent mask">
                                            <a href="home.jsp?uid=">
                                                <img width="75" height="75" class="portrait" title="" alt="" src="pic/portrait/d.75.jpg">
                                            </a>
                                            <div class="rightside">
                                                <div class="name">
                                                    <a href="home.jsp?uid="></a>
                                                </div>
                                                <div class="text">
                                                    <a style="float: right;" href="#new_comment" class="replylink">
                                                        <img style="position: relative; top: 2px;" alt="+" src="pic/msg_reply.gif"> 回复
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </li>
                                        <%
                                                    List<HotEventInfo> comments = HotEventCommentManager.getComments("dragon.log");
                                                    Iterator<HotEventInfo> coit = comments.iterator();
                                                    while (coit.hasNext()) {
                                                        HotEventInfo hei = coit.next();
                                                        int cuid = hei.userid;
                                                        String cuname = EntityFactory.getUser(cuid).getName();

                                        %>
                                        <li  class="parent">
                                            <a href=<%="home.jsp?uid=" + cuid%>>
                                                <img width="75" height="75" class="portrait" title="<%= cuname%>" alt="" src="pic/portrait/d.75.jpg">
                                            </a>
                                            <div class="rightside">
                                                <div class="name">
                                                    <a href=<%= "home.jsp?uid=" + cuid%>><%= cuname + " "%></a><%= hei.time%>
                                                </div>
                                                <div class="text">
                                                    <%= hei.comment%>
                                                    <a style="float: right;" href="#new_comment" class="replylink">
                                                        <img style="position: relative; top: 2px;" alt="+" src="pic/msg_reply.gif"> 回复
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </li>
                                        <%
                                                    }
                                        %>
                                    </ul>
                                    <div class="new_comment" id="new_comment">
                                        <img class="portrait" title="" alt="" src="pic/portrait/d.75.jpg">
                                        <div class="isay">
                                            <strong>添加新评论</strong>
                                        </div>
                                        <form id="frmNewComment">
                                            <textarea name="text" id="new_comment_text"></textarea>
                                            <br>
                                            <input type="button" value="确   定 " id="new_comment_btn" class="blue_button">
                                        </form>
                                    </div>
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
                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>近期活动家原来是他们</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div id="top5_module">
                                            <ul class="top5_ul">
                                                <%
                                                            int top_uid = 23;
                                                            IUser top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">1</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=23"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1541;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">2</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=23"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1500;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">3</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=23"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1538;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">4</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=23"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                            </ul>
                                        </div>
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
