<%--
    Document   : forget_password.jsp
                sends an email containing user's password. User is identified by looking up email
                in user database. If can not find a user with given email address, show error and
                redirect to index.jsp after a few seconds.
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="utility.email.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.EntityFactory"%>
<%@page import="utility.email.EmailTask"%>
<%@page import="utility.Misc"%>
<%@page import="utility.background.NoCallbackExecutor"%>
<%@page import="servlet.ServletCommon"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>忘记密码 - 爱微视 iweishi</title>
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

        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/push_frame.js" type="text/javascript"></script>
        <link href="CSS/footer.css" rel="stylesheet" type="text/css">

        <script src="JS/head_last.js" type="text/javascript"></script>
    <!--[if IE 6]><script src="JS/hover.js" type="text/javascript"></script><![endif]-->

    </head>

    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <%@include file="jspf/top_menu_nobody.jspf"%>

                    <div id="cap" ><!--[if gte IE 6]><img src="pic/top_cap.png"><![endif]--></div>
                    <div id="main">

                        <%
                                    String email = request.getParameter("email");
                                    if (email != null) {
                                        IUser user = EntityFactory.getUser(email);
                                        if (user == null) {%>
                                        <div id="header">
                                            <h1>该用户尚未注册</h1><br>
                                            <h2>还没有人用邮箱<%=email%>注册过。返回<a href="index.jsp">首页</a></h2>
                                        </div>
                                        <%} else {
                                            NoCallbackExecutor.submit(new EmailTask(new PasswordReminderEmail(email)));
                                        %>
                                        <div id="header">
                                            <h1>邮件已发出</h1><br>
                                            <h2>一封含有iweishi账号密码的邮件已发送到邮箱<%=email%>，由于网络原因，可能会有延迟，请注意查收。返回<a href="index.jsp">首页</a></h2>
                                        </div>
                                            <%
                                        }
                                    } else {
                                %>
                                        <div id="header">
                                            <h1>忘记密码？</h1><br>
                                            <form action="forget_password.jsp" method="post">
                                                <h2><label for="email">输入注册用邮箱</label></h2>
                                                <input type="text" name="email"/>
                                                <input class="blue_button" type="submit" value="确定"/>
                                            </form>
                                        </div>
                                <%}%>
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
