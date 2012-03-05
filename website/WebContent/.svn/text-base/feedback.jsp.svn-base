<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : voenix
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
        <link href="CSS/feedback.css" rel="stylesheet" type="text/css" />


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
        <script src="JS/feedback.js" type="text/javascript"></script>
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
                            <h1>爱微视用户体验</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>

                                <div id="feedback_template" class="taste_text" >
                                    <a href="#nogo">
                                        <img src="pic/portrait/d.75.jpg" alt="" title="" class="portrait"  height="75" width="75" />
                                    </a>
                                    <div class="rightside">
                                        <div class="name">
                                            <a href="#nogo">用户名/匿名</a> 反馈时间
                                        </div>
                                        <div class="text">提交后，您的反馈就出现在这里，爱微视将尽快向您报告我们的进展。
                                        </div>
                                    </div>
                                    <div class="clear"></div>
                                </div>

                                <div id="new_comment" class="new_comment">
                                    <img src="pic/portrait/d.75.jpg" alt="" title="wanderfs"
                                         class="portrait"  height="75" width="75" />
                                    <div class="isay"><strong>我的用户体验</strong></div>
                                    <form id="frmNewComment">
                                        <textarea id="feedback_text" name="text"></textarea>
                                        <br />
                                        <input class="blue_button" id="feedback_btn"
                                               value="  确  定 " type="button" />
                                    </form>
                                </div>
                            </div>
                            <div class="column" id="columnB">
                                <div class="nippleBox arousedBaboon">
                                    <div class="bar">
                                        <h4>用户体验</h4>	</div>
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
