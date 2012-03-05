<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.Global"%>
<%@page import="logic.EntityFactory"%>
<%@page import="utility.Misc"%>
<%@page import="utility.Pair"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="logic.datatype.JoinChannelEvent" %>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            if (user != ServletCommon.nobody) {
                response.sendRedirect("user_index.jsp");
            }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视是网络视频的集散地" />

        <link rel="stylesheet" type="text/css" media="all" href="CSS/IE6Test2.css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />
        <link href="CSS/Left_push_video.css" rel="stylesheet" type="text/css" />
        <link href="CSS/homepage_header_none_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/tabs.css" rel="stylesheet" type="text/css" />
        <link href="CSS/videos_hot.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />
        <link href="CSS/activity.css" rel="stylesheet" type="text/css" />
        <link href="CSS/top10videos.css" rel="stylesheet" type="text/css" />
        <link href="CSS/footer.css" rel="stylesheet" type="text/css" />

        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>


        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>

        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/videolist.js" type="text/javascript"></script>
        <script src="JS/tab.js" type="text/javascript"></script>
        <script src="JS/push_frame.js" type="text/javascript"></script>

        <script src="JS/head_last.js" type="text/javascript"></script>
        <!--[if gte IE 6]>

        <script src="JS/ie7-squish.js" type="text/javascript"></script>

            <script src="JS/ie6.js" type="text/javascript"></script>
            <link href="CSS/ie6.css" rel="stylesheet" type="text/css" />
        <![endif]-->

        <!--[if gte IE 6]><script src="JS/hover.js" type="text/javascript"></script><![endif]-->
    </head>

    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">

                    <%@include file="../jspf/top_menu_nobody.jspf"%>

                    <div id="cap" ><!--[if gte IE 6]><img src="pic/top_cap.png" /><![endif]--></div>
                    <div id="main">

                        <div id="header">

                            <h1>欢迎你</h1>
                            <div id="intro">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱微视是网络视频的集散地，在这里你可以收藏和发现众多视频分享网站上的视频，在这里你也可以分享视频到众多社区网站，在这里你还可以加入视频小组结识志同道合的朋友！还在犹豫什么？现在就<a
                                    href="Join.jsp" rel="nofollow">加入</a>吧！
                                此外为了更好地服务用户，我们希望占用你一点点时间以获得你珍贵的<a target="_blank" href="http://www.askform.cn/96374-126152.aspx" rel="nofollow">用户体验</a>。
                            </div>
                        </div>

                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>

                                <%@include file="../jspf/push_frame.jspf"%>
                                <div  style="height: 20px;"></div>
                                <div class="tabs">
                                    <ul>
                                        <li id="hot_tab" class="active">
                                            <!--[if gte IE 6]><div class="tableft"><div class="tableft_tl"></div><div class="tableft_bottom"></div></div><![endif]-->

                                            <div  class="tab">微视箱</div>
                                            <!--[if gte IE 6]> <div class="tabright"><div class="tabright_tr"></div><div class="tabright_bottom"></div></div><div class="clear"></div><![endif]-->
                                        </li>
                                        <li id="new_tab">
                                            <!-- <v:roundrect style="top:127px;" class="roundrect_tab_4" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect>-->
                                            <!--[if gte IE 6]>  <div class="tableft"><div class="tableft_tl"></div><div class="tableft_bottom"></div></div><![endif]-->
                                            <div  class="tab"  > 最新收藏</div>
                                            <!--[if gte IE 6]> <div class="tabright"><div class="tabright_tr"></div><div class="tabright_bottom"></div></div><div class="clear"></div>
                                             <![endif]--></li>
                                        <li id="explore_tab">
                                            <!--   <v:roundrect style="top:127px;"
                                                            class="roundrect_tab_3" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect> -->
                                            <!--[if gte IE 6]><div class="tableft"><div class="tableft_tl"></div><div class="tableft_bottom"></div></div><![endif]-->
                                            <div  class="tab" > 随处看看</div>
                                            <!--[if gte IE 6]><div class="tabright"><div class="tabright_tr"></div><div class="tabright_bottom"></div></div><div class="clear"></div><![endif]-->
                                        </li>

                                    </ul>
                                    <div class="clear"></div>
                                </div>

                                <div id="content_wrapper" class="softcorner native">
                                    <div  id="loading" class="loading mask">
                                        加载中......
                                    </div>
                                    <div id="video_hotlist" class="videos_content">
                                        <div class="videos_meat">
                                            <div class="clips">
                                                <jsp:include page="jspf/hotlist.jsp" />

                                                <a id="more_hot" class="next" href="#nogo">更多</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="video_newlist" class="videos_content mask">
                                        <div class="videos_meat">
                                            <div class="clips">
                                                <a id="more_new" class="next" href="#nogo">更多</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="global_activity" class="activity_content softcorner native activity_bubble mask" >
                                        <div id="global_activity_insides" class="activity_content_insides">
                                            <div class="activity">
                                            </div>
                                            <a id="more_activity" class="activity_next" href="#nogo">更多</a>
                                            <div class="clear"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <jsp:include page="jspf/index_columnB.jsp" />
                            <div class="clear"></div>
                        </div>

                        <%@include file="../jspf/footer.jspf"%>

                    </div>
                </div>
            </div>
        </div>
        <img style="top: -3px;" class="sun" alt="" src="pic/land_sun.gif"/>
        <img alt="" style="position: fixed; *position: absolute; z-index: 20; top: 45px; right: -60px;*right: 0px;" id="cloud" src="pic/land_cloud.gif"/>
        <img alt="" style="top: 322px;" id="cloud2" src="pic/land_cloud2.gif"/>

    </body>
</html>
