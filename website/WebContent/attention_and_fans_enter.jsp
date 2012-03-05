<%-- 
    Document   : attention_and_fans_enter
    Created on : 2010-4-30, 19:30:23
    Author     : xiaoxiao
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.IUser"%>
<%@page import="servlet.ServletCommon"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// host: owner of this page.
            String suid = request.getParameter("uid");
            IUser host = EntityFactory.getUser(Integer.parseInt(suid));

// user: the one who is currently viewing the page.
            IUser user = ServletCommon.getCurrentUser(session);
            String prop = "TA";
            if (user.getUserid() == Integer.parseInt(suid)) // user is viewing his/her own home
            {
                prop = "我";
            }

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视是视频集散地..." />
        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>

        <link rel="stylesheet" type="text/css" media="all" href="CSS/global.css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />
        <link href="CSS/footer.css" rel="stylesheet" type="text/css" />
        <link href="CSS/attention_and_fans_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/ignite.css" rel="stylesheet" type="text/css" />
        <script src="JS/head_last.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />
        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>
        <script src="JS/common.js" type="text/javascript"></script>
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

                    <div id="cap" ><!--[if gte IE 6]><img src="pic/top_cap.png" /><![endif]--></div>
                    <div id="main">
                        <div id="header">
                            <div class="header_image"><img src="pic/portrait/d.75.jpg" alt=""
                                                           title="" class="portrait"  /></div>
                            <div class="header_text">
                                <h1><%= prop%>的友邻</h1>
                                <%
                                            IUser u;
                                            int uid, lnum;
                                            String s = null;
                                            Iterator<Integer> it;

                                            List<Integer> ferList = host.getFollower();
                                            List<Integer> feeList = host.getFollowee();
                                %>
                                <ul class="filter">
                                    <li ><%= prop%>关注了<%= feeList.size()%>个人</li>
                                    <li>/</li>
                                    <li><%= prop%>有<%= ferList.size()%>个粉丝</li>
                                </ul>
                            </div>
                            <div class="clear"></div>
                        </div>

                        <div class="columns">
                            <div class="column" id="columnA">
                                <div class="attention">
                                    <h1><%= prop%>关注的人</h1>

                                    <% if (feeList.size() == 0) {%>
                                    <div class="count">全部 0 人</div>
                                    <% } else {%>
                                    <div class="count">全部<%= feeList.size()%>人中的1-<%= feeList.size()%></div>
                                    <% }%>


                                    <%
                                                it = feeList.iterator();
                                                lnum = 0;
                                                while (it.hasNext()) {
                                                    ++lnum;
                                                    uid = it.next().intValue();
                                                    u = EntityFactory.getUser(uid);
                                                    s = "contact";
                                                    /*
                                                    if (lnum % 2 != 0)
                                                    s = "contact";
                                                    else s = "contact end";
                                                     */
                                    %>
                                    <div class=<%= s%> >
                                        <img src="<%= u.getPhoto()%>" alt=""
                                             title="<%= u.getName()%>" class="portrait"  height="100" width="100" />
                                        <div>
                                            <span class="undertaker">×</span>
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

                                <div class="fans">
                                    <h1><%=prop%>的粉丝</h1>

                                    <% if (ferList.size() == 0) {%>
                                    <div class="count">全部 0 人</div>
                                    <% } else {%>
                                    <div class="count">全部<%= ferList.size()%>人中的1-<%= ferList.size()%></div>
                                    <% }%>
                                    <div class="clear"></div>

                                    <%
                                                it = ferList.iterator();
                                                lnum = 0;
                                                while (it.hasNext()) {
                                                    ++lnum;
                                                    uid = it.next().intValue();
                                                    u = EntityFactory.getUser(uid);
                                                    s = "contact";
                                                    /*
                                                    if (lnum % 2 != 0)
                                                    s = "contact";
                                                    else s = "contact end";
                                                     */
                                    %>
                                    <div class=<%= s%> >
                                        <img src="<%= u.getPhoto()%>" alt=""
                                             title="<%= u.getName()%>" class="portrait"  height="100" width="100" />
                                        <div>
                                            <span class="undertaker">×</span>
                                            <a href="home.jsp?uid=<%= uid%>" class="username"><%= u.getName()%></a>
                                            <div class="info">
                                                <a href="attention_and_fans_enter.jsp?uid=<%= uid%>"
                                                   class="contacts"><%= u.getFollowee().size()%> 个关注</a><br/>
                                                <a href="attention_and_fans_enter.jsp?uid=<%= uid%>"
                                                   class="contacts"><%= u.getFollower().size()%> 个粉丝</a><br/>
                                                <a href="home.jsp?uid=<%= uid%>" class="videos"><%= u.getSubmitedVideoNumber()%> 个发现视频</a><br/>
                                                <a href="home.jsp?uid=<%= uid%>" class="videos"><%= u.getCollectedVideoNumber()%> 个收藏视频</a>
                                            </div>
                                        </div>
                                    </div>
                                    <% }%>

                                    <div class="clear"></div>
                                </div>                    
                            </div>


                            <div class="column" id="columnB">
                                <div class="nippleBox pickleTickle">
                                    <div class="bar">
                                        <h4>点亮你的周边</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div class="nippy people">
                                            <div class="left">
                                                <div class="top">
								寻找朋友
                                                </div>
                                                <div class="yurt">
                                                    <span class="none">在校内，Gmail上寻找同在爱微视的朋友</span>
                                                </div>
                                                <div>

                                                    <a id="ignite_renren" class="site_icon" href="#nogo">人人</a>
                                                    <a id="ignite_gmail" class="site_icon" href="#nogo">gmail</a>
                                                </div>

                                            </div>
                                            <div class="right">
                                                <div class="top">邀请</div>
                                                <div class="yurt">
                                                    <input id="auto_people" name="question" value="名字或邮箱"
                                                           maxlength="128"  type="text"/>

                                                </div>
                                                <p><a href="notready.jsp">邀请你的朋友来爱微视逛逛，与朋友一起分享视频的快乐</a>.</p>
                                            </div>
                                            <div class="clear"></div>
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
        <img style="top: -3px;" class="sun" alt="" src="pic/land_sun.gif"/>
        <img alt="" style="position: fixed; *position: absolute; z-index: 20; top: 45px; right: -60px;*right: 0px;" id="cloud" src="pic/land_cloud.gif"/>
        <img alt="" style="top: 322px;" id="cloud2" src="pic/land_cloud2.gif"/>
        <div class="mask">
            <%@include file="jspf/loginbox.jspf"%>
        </div>
    </body>
</html>