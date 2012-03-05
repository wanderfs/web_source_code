<%--
    Document   : user_index.jsp
    Created on : 2010-4-30, 19:25:29
    Author     : voenix
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%> 

<%@page import="logic.IVideo"%>
<%@page import="logic.IUser"%>
<%@page import="logic.Video"%>
<%@page import="logic.User"%>
<%@page import="logic.EntityFactory"%>

<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            if (user.getUserid() == ServletCommon.nobodyId) {
                response.sendRedirect("index.jsp");
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
        <link rel="stylesheet" type="text/css" media="all" href="CSS/global.css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />
        <link href="CSS/footer.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/homepage_header_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/settings.css" rel="stylesheet" type="text/css" />
        <link href="CSS/ignite.css" rel="stylesheet" type="text/css" />

        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script src="JS/jquery_plugins.js" type="text/javascript"></script>

        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>
        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/user_setting.js" type="text/javascript"></script>

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
                        <div id="header" >
                            <h1>个人设置</h1>

                        </div>

                        <div class="columns">
                            <div class="column" id="columnA">
                                <ul id="settings_options">
                                    <li id="info_tab" class="current">个人信息</li>
                                    <li id="portrait_tab">上传/更换头像</li>
                                    <li id="password_tab">密码</li>
                                    <li id="ignite">点亮你的周边</li>
                                </ul>
                            </div>

                            <div class="column" id="columnB">
                                <form name="personal-info" class="" id="info_form" method="post" action="uinfo">
                                    <ul class="personal">
                                        <li>
                                            <div class="settingsLable">用户名</div>
                                            <input name="name" value="<%=user.getName()%>" type="text"/>
                                        </li>
                                        <!--<li>
                                            <div>邮箱</div>
                                            <input name="email" value="" type="text"/>
                                        </li>-->
                                        <li>
                                            <div class="settingsLable">用户签名</div>
                                            <textarea name="motto" id="motto"><%=user.getDescription()%></textarea>
                                        </li>
                                    </ul>
                                    <input class="blue_button" value="更新设置"  type="submit"/>
                                </form>

                                <form class="mask" id="portrait_form" method="post" action="upload" enctype= "multipart/form-data">
                                    <div class="settingsLable">上传头像</div>
                                    <input type="hidden" name="category" value="portrait"/>
                                    <input type="hidden" name="uid" value="<%=user.getUserid()%>"/>
                                    <input type="file" name="upfile"/>
                                    <br></br>
                                    <input type="submit" value="确定" class="blue_button"/>
                                </form>

                                <form class="mask" id="default_portrait_form" method="post" action="default_portrait" enctype= "multipart/form-data">
                                    <div class="settingsLable">选择默认头像</div>
                                    <div class="ddp">                                        
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceA45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceB45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceC45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceD45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceE45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceF45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceG45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceH45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceI45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceJ45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceK45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceL45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceM45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceN45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceO45.png"/></div>
                                        <div class="dp_wrapper"><img alt="默认头像" src="iweishi2.0/pic1.5/face/faceP45.png"/></div>
                                        <div class="clear"></div>
                                    </div>
                                    
                                    <input type="submit" value="确定" class="blue_button"/>
                                </form>

                                <form  class="mask" id="password_form" action="uinfo" method="post">
                                    <ul class="password">
                                        <li>
                                            <div class="settingsLable">新密码</div>
                                            <input type="password" value="" name="password" id="password"/>
                                            <div class="settingsLable">确认密码</div>
                                            <input type="password" value="" name="rewrite_password" id="rewrite_password"/>
                                        </li>
                                    </ul>

                                    <input type="submit" value="更改密码" class="blue_button"/>

                                    <p><br/><a href="forget_password.jsp">忘记了密码？</a></p>
                                </form>
                            </div>

                            <div class="column" id="columnC">
                                <div id="info_notes" class="settings_notes">
                                    <div class="nippleBox manateeCloud instruction">
                                        <div class="bar">
                                            <h4>个人信息更改</h4>
                                        </div>
                                        <div class="nipple"></div>
                                        <div class="content">
                                            <div class="mask">
                                                <%@include file="jspf/ignite.jspf"%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clear"></div>     <%@include file="jspf/footer.jspf"%>
                    </div>

                </div>
            </div>
        </div>
        <img style="top: -3px;" class="sun"
             src="pic/land_sun.gif"/><img
             style="position: fixed;*position: absolute; z-index: 20; top: 45px; right: -60px;*right: 0px;"
             id="cloud"
             src="pic/land_cloud.gif"/><img
             style="top: 322px;" id="cloud2"
             src="pic/land_cloud2.gif"/>

    </body>
</html>
