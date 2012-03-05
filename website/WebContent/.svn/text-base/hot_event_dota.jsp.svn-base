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
            var page_type = "dota.log";
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
                            <h1>Dota,我心中永远的大神</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div><img alt="海报" src="pic/hot_event/dota.png" width="620px"/></div>
                                <div class="clips_head">
                                    <span>Dota,我心中永远的大神 精选专辑</span>
                                </div>
                                <div class="clips">
                                    <ol>
                                        <%
                                                    int albumuserid = 1559;
                                                    IUser album_user = EntityFactory.getUser(albumuserid);
                                                    int chosen_aid = 211;
                                                    IChannel chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    List alist = chosen_album.getPosts(0, 1);
                                                    Iterator ait = alist.iterator();
                                                    PostEvent pe = (PostEvent) ait.next();
                                                    IVideo fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1559;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 210;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1559;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 209;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1559;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 208;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="top end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1561;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 212;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1561;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 213;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1561;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 214;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1561;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 215;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1562;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 216;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1562;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 217;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1562;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 218;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1562;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 219;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1563;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 220;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1563;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 221;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1563;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 222;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1563;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 223;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1564;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 224;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1564;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 225;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1564;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 226;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1564;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 227;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1565;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 228;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1565;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 229;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1565;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 231;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1565;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 232;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1566;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 233;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1566;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 234;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1567;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 235;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                          <%
                                                    albumuserid = 1567;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 236;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                          <%
                                                    albumuserid = 1567;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 238;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                          <%
                                                    albumuserid = 1567;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 239;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1568;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 240;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1568;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 241;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                        <%
                                                    albumuserid = 1568;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 242;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1568;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 243;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1569;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 244;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1569;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 245;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1569;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 246;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1569;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 247;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1570;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 248;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1570;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 249;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="end">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=<%= albumuserid%>"><%= album_user.getName()%></a>
                                            </div>
                                        </li>
                                         <%
                                                    albumuserid = 1570;
                                                    album_user = EntityFactory.getUser(albumuserid);
                                                    chosen_aid = 250;
                                                    chosen_album = EntityFactory.getGroup(chosen_aid);
                                                    alist = chosen_album.getPosts(0, 1);
                                                    ait = alist.iterator();
                                                    pe = (PostEvent) ait.next();
                                                    fv = EntityFactory.getVideo(pe.getVideoid());
                                        %>
                                        <li class="">
                                            <div title="<%= chosen_album.getName()%>" class="image">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>">
                                                    <img width="125" height="94" alt="hot event" title="<%= chosen_album.getName()%>" src="<%= fv.getSnapshotURL()%>">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=<%= albumuserid%>#caid<%= chosen_aid%>" title="<%= chosen_album.getName()%>"><%= chosen_album.getName()%></a>
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
                                                    List<HotEventInfo> comments = HotEventCommentManager.getComments("dota.log");
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
                                        <h4>Dota,我心中永远的大神</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <p>
                                            女妖魂舞，死亡之凋零，是谁？挥动，邪恶的镰刀，撕裂时间，驱逐光明；窒息灵刃，禁锢，人世之肮脏。<br/>是毁灭，还是守护？<br/>当夜来临，狩猎者的脚步，走去远方。<br/>沸血的长矛，点燃灵魂的遗望，牺牲的人啊，还能否回到过往？
                                            <br/><br/>那巨人，独自站立，刚毅如常。<br/>双刃的大剑，践踏谁的尊严，灰色的天空，有那山鹰，如风般飞翔。<br/>谁沉默？谁大吼？<br/>谁的沟壑拦住了谁的一跃？<br/>冰晶的墙，洪泽如汪洋，山崩瞬裂，回音犹响。<br/>去如那疾风，来若电光，残留的余影，只见夕阳。
                                            <br/><br/>枝蔓的缠绕，自然的放逐。<br/>神的力量，神的毁灭。<br/>闪电的风暴，划破黎明的沉默。<br/>谁的眼神，如此魅惑？<br/>你我的灵魂，因何相隔？<br/>天涯之末，传来海妖的歌。<br/>镜镜像像，假假真真，不变的，唯有传说。<br/>真正的支持，船长有说，吾已标记来过。
                                            <br/><br/>两极共生，以月之名，降下无尽的流星。<br/>救赎，众生。<br/>穿过云层的箭，薄葬天使的呼声。<br/>濒死的人啊，可知来生？<br/>发芽，长大，未来奇妙的旅程。<br/>莫沉睡，独清醒。<br/>虚弱奈何？衰老奈何？时间难锁定，紧紧行。地狱的火焰，已燃净。
                                            <br/><br/>望眼欲穿，你模糊的脸，如水起涟。<br/>一波未平，一波又散。<br/>黑暗的门，开向天边。<br/>尘与土，掩没不了岁月，又为何，空流连。<br/>我隐匿在那阴影间，渐渐消失，直到变淡。<br/>即便化做了小小的羊糕，这记忆，永生不变。<br/>信仰，将使我们重返人间。
                                            <br/><br/>暗暗的冲刺，却不知，她早已忘掉了你容颜。<br/>千杯的烈酒，让心被冰封，被焚化吧！<br/>可怜？可悲！可叹。<br/>墓碑处，道一声，再见。<br/>吾愿，以那血肉之躯，成死亡的防线。<br/>与我一起来感受黄泉的震颤，石化的触感！<br/>月圆，哀嚎漫天。
                                            <br/><br/>披着抖篷的守墓人，仿佛受到了野性的呼唤。<br/>荒野间，那狼儿飞驰如电。<br/>是诅咒？还是忠诚的考验？<br/>借上帝的手，施虐艰辛之磨练。<br/>忍受遏心的痛啊，忘却辉凰的昨天，尖叫吧，超越声音的极限！<br/>束身的枷锁，是欲望的傲慢。
                                            <br/><br/>谁的身体已腐烂？让被肢解的尸体烟消云散。<br/>贪婪，让神都为之震撼。<br/>那夜里，是谁，在舞动黑暗。<br/>恐惧无法自制，死亡的手指解脱屠戮的盛宴。<br/>瘟疫啊，席卷大地，直到处处荒芜，再无法感染。<br/>新月的弯痕，挂在天间，如梦般让人痴缠。
                                            <br/><br/>这人间的剧变，已让人们知道，神是如此的不可侵犯。<br/>与恶魔一起缩入深渊，将身体祭祀于上天。<br/>所有的憎恶，都不可转换。<br/>天上的星芒，陨落吧！<br/>让这世界化为焦土，断壁残垣。<br/>巨浪席卷，待重头，似水流年。
                                            <br/><br/>
                                        </p>
                                    </div>
                                </div>
                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>原来他们是大神</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div id="top5_module">
                                            <ul class="top5_ul">
                                                <%
                                                            int top_uid = 1559;
                                                            IUser top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">1</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1561;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">2</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1562;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">3</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1563;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">4</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1564;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">5</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%
                                                            top_uid = 1565;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">6</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                 <%
                                                            top_uid = 1566;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">7</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                 <%
                                                            top_uid = 1567;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">8</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                 <%
                                                            top_uid = 1568;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">9</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                 <%
                                                            top_uid = 1569;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">10</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo"><%= top_user.getSubmitedVideoNumber()%></a></strong> 个发现视频 /
                                                            <strong><a href="#nogo"><%= top_user.getFollower().size()%></a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                 <%
                                                            top_uid = 1570;
                                                            top_user = EntityFactory.getUser(top_uid);
                                                %>
                                                <li class="top5_li">
                                                    <div class="top5_num">11</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=<%= top_uid%>"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=<%= top_uid%>"><%= top_user.getName()%></a></h3>
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
