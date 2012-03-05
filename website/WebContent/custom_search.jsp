<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : xiaoxiao Apr 21,2010, 17:00 beijing
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
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            String input_keywords =
                    ServletCommon.formSubmitChineseTranscoder(request.getParameter("menudo_search_field"));
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

        <link href="CSS/homepage_header_none_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/attention_and_fans_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/join_login.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>

        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/push_frame.js" type="text/javascript"></script>
        <script src="JS/custom_search.js" type="text/javascript"></script>
        <link href="CSS/footer.css" rel="stylesheet" type="text/css">

        <script src="JS/head_last.js" type="text/javascript"></script>
        <!--[if IE 6]><script src="JS/hover.js" type="text/javascript"></script><![endif]-->

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
                            <h1>爱微视 站内搜索</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div class="attention">
                                    <%
                                    List<IUser> matched_users = EntityFactory.searchUser(input_keywords);
                                    %>
                                    <h1>搜索到的用户</h1>

                                    <% if (matched_users.size() == 0) {%>
                                    <div class="count">全部 0 人</div>
                                    <% } else {%>
                                    <div class="count">全部<%= matched_users.size()%>人中的1-<%= matched_users.size()%></div>
                                    <% }
                                                Iterator<IUser> it = matched_users.iterator();
                                                int lnum = 0;
                                                while (it.hasNext()) {
                                                    ++lnum;
                                                    IUser u = it.next();
                                                    int uid = u.getUserid();
                                    %>
                                    <div class="contact">
                                        <img src="<%= u.getPhoto()%>" alt=""
                                             title="<%= u.getName()%>" class="portrait"  height="100" width="100" />
                                        <div>
                                            <a href="home.jsp?uid=<%= uid%>" class="username"><%= u.getName()%></a>
                                            <div class="info">
                                                <a href="attention_and_fans_enter.jsp?uid=<%= uid%>"
                                                   class="contacts"><%= u.getFollowee().size()%> 个关注</a><br/>
                                                <a href="attention_and_fans_enter.jsp?uid=<%= uid%>"
                                                   class="contacts"><%= u.getFollower().size()%> 个粉丝</a><br/>
                                                <a href="home.jsp?uid=<%= uid%>" class="videos"> <%= u.getSubmitedVideoNumber()%> 个发现视频</a><br/>
                                                <a href="home.jsp?uid=<%= uid%>" class="videos"><%= u.getCollectedVideoNumber()%> 个收藏视频</a>
                                            </div>
                                        </div>
                                    </div>
                                    <% }%>
                                    <div class="clear"></div>
                                </div>

                                <h1>搜索到的视频</h1>
                                <%-- google custom search code --%>
                                <div id="cse" style="width: 100%;">Loading</div>
                                <script src="http://www.google.com/jsapi" type="text/javascript"></script>
                                <script type="text/javascript">
                                    google.load('search', '1', {language : 'zh-CN'});
                                    google.setOnLoadCallback(function() {
                                        var customSearchControl = new google.search.CustomSearchControl('011128675256854369181:xarjsky-dxm');
                                        customSearchControl.setResultSetSize(google.search.Search.FILTERED_CSE_RESULTSET);
                                        customSearchControl.draw('cse');
                                        customSearchControl.execute('<%=input_keywords%>');
                                    }, true);
                                </script>
                                <link rel="stylesheet" href="http://www.google.com/cse/style/look/default.css" type="text/css" />
                                <%-- google custom search code --%>
                                
                            </div>
                            <div class="column" id="columnB">
                                <div class="nippleBox arousedBaboon">
                                    <div class="bar">
                                        <h4>爱微视 站内搜索</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
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
