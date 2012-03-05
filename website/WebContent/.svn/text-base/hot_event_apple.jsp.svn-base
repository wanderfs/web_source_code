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
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="utility.alpha.*"%>


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
            var page_type = "apple.log";
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
                            <h1>苹果·APPLE</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div><img alt="海报" src="pic/hot_event/apple_poster.png" width="620px"/></div>
                                <div class="clips_head">
                                    <span>苹果·APPLE 精选广告专辑</span>
                                </div>
                                <div class="clips">
                                    <ol>
                                        <li class="top">
                                            <div title="跟随心情，咬一口苹果" class="image">
                                                <a href="home.jsp?uid=1544#caid203">
                                                    <img width="125" height="94" alt="hot event" src="http://p4.v.iask.com/9/339/35457083_0.jpg">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=1544#caid203">跟随心情，咬一口苹果</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=1544#caid203">Apple</a>
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
                                            <a href="http://www.iweishi.cn/website/home.jsp?uid=">
                                                <img width="75" height="75" class="portrait" title="" alt="" src="pic/portrait/d.75.jpg">
                                            </a>
                                            <div class="rightside">
                                                <div class="name">
                                                    <a href="http://www.iweishi.cn/website/home.jsp?uid="></a>
                                                </div>
                                                <div class="text">
                                                    <a style="float: right;" href="#new_comment" class="replylink">
                                                        <img style="position: relative; top: 2px;" alt="+" src="video.jsp_files/msg_reply.gif"> 回复
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </li>
                                        <%
                                                    List<HotEventInfo> comments = HotEventCommentManager.getComments("apple.log");
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
                                        <h4>苹果·APPLE</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <p>
                                            &nbsp;&nbsp;还记得么，阿甘在电影《阿甘正传》中说到的：“别人说我应该投资入股，好让自己的财产有所保障，于是我仔细查看了股票的种类。我觉得应该投一个与渔业差不多的股票，比如说水果业。于是我就买了一个叫“苹果”的股票。然后这个股票就涨啊、涨啊、涨...”
                                            阿甘买的那个涨啊涨的“苹果”股票,就是著名的苹果电器的“苹果电脑”的股票，这否让你想起了的那些风靡整个世界的著名苹果电器，像apple的 ipod、iphone等...简洁明快的设计风格打动着你我的心！<br/><br/>

                                            苹果在希腊神话中，是智慧的象征，当初亚当和夏娃就是吃了苹果才变得有思想，在决定采用"苹果"这一名字时，创始人注意到他们品牌不遵守习俗的自然特性。有想到是引申为科技的未知领域的产品标志。<br/><br/>

                                            传说，1665年秋季,牛顿坐在自家院中的苹果树下苦思着行星绕日运动的原因.一只苹果恰巧落下来,牛顿顿悟出——引力的作用.这个故事据说是由牛顿的外甥女巴尔顿夫人告诉法国哲学家,作家伏尔泰之后流传起来的.伏尔泰将它写入《牛顿哲学原理》一书中.牛顿家乡的这棵苹果树后来被移植到剑桥大学中.<br/><br/>

                                            正是因为以上的两个原因，苹果电脑创建了著名的苹果股份有限公司，简称苹果电脑，英文名Apple Computer, Inc.，总部位于美国加利福尼亚州的库比提诺据说设计这个徽标花了苹果一大笔钱，苹果的总裁斯蒂夫•乔布斯称为“the most expensive bloody logo ever designed.”，苹果公司的标志是咬了一口的苹果，表明了他们勇于向科学进军，探索未知领域的理想。<br/><br/>
                                            <br/><br/>
                                        </p>
                                    </div>
                                </div>
                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>苹果·APPLE 专辑活动本周活动家原来是他们</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div id="top5_module">
                                            <ul class="top5_ul">
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">1</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="home.jsp?uid=1544#caid203"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="home.jsp?uid=1544#caid203">Apple</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="home.jsp?uid=1544#caid203">5</a></strong> 个发现视频 /
                                                            <strong><a href="home.jsp?uid=1544#caid203">3</a></strong> 位粉丝
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
