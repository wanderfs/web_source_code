<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
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
                            <h1>变形金刚（活动名称 如变形金刚）</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div><img alt="海报" src="pic/hot_event/transformers.png"/></div>
                            </div>
                            <div class="column" id="columnB">
                                <div class="nippleBox manateeCloud instruction">
                                    <div class="bar">
                                        <h4>变形金刚（活动名称 如变形金刚）</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <p>
                                            活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动
                                            说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明
                                            活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动
                                            说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说
                                            明活动说明活动说明活动说明活动说明活动说明活动说明活动说明
                                        </p>
                                    </div>
                                </div>

                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>本周发现家Top5</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content" >
                                        <div id="top_week_videos">
                                            <ul class="top_week_videos_ul">

                                                <li class="top_week_videos_li top_week_videos_topvideo">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top_week_videos_li">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top_week_videos_li">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top_week_videos_li">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top_week_videos_li">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top_week_videos_li">
                                                    <div class="top_week_videos_num">1</div>
                                                    <a href="#nogo" class="top_week_videos_thumbnail" style="background-image:url('pic/portrait/d.48.jpg');" >
                                                    </a>
                                                    <div class="top_week_videos_digest">
                                                        <h3><a href="#nogo"></a>flash</h3>
                                                        <div class="top_week_videos_stat"><strong><a href="#nogo">99</a></strong>
                                                            个发现视频 /
                                                            <strong><a href="#nogo">99</a></strong>
                                                            位粉丝</div>
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
