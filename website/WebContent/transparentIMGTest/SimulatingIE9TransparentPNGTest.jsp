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

         <link rel="stylesheet" type="text/css" media="all" href="CSS/ieTest.css" />

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

        <!--[if lt IE 9]><script src="IEJS/IE9.js" type="text/javascript"></script><![endif]-->
   
    </head>

    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">


                    <div id="cap" ><!--[if gte IE 6]><img src="pic/top_cap.png" /><![endif]--></div>
                    <div id="main">

                        <div id="header">

                            <h1>欢迎你</h1>
                            <div id="intro">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;爱微视是网络视频的集散地，在这里你可以收藏和发现众多视频分享网站上的视频，在这里你也可以分享视频到众多社区网站，在这里你还可以通过视频结识志同道合的朋友！还在犹豫什么？现在就<a
                                    href="Join.jsp" rel="nofollow">加入</a>吧！
此外为了更好地服务用户，我们希望占用你一点点时间以获得你珍贵的<a target="_blank" href="http://www.askform.cn/96374-126152.aspx" rel="nofollow">用户体验</a>。
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <img style="top: -3px;" class="sun" alt="" src="pic/land_sun.gif"/>
        <img alt="" style="position: fixed;  z-index: 20; top: 45px; right: -60px;" id="cloud" src="pic/land_cloud.gif"/>
        <img alt="" style="top: 322px;" id="cloud2" src="pic/land_cloud2.gif"/>

    </body>
</html>
