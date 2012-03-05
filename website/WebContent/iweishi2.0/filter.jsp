<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
--%>

<%@page import="utility.Pair"%>
<%@page import="java.util.Iterator"%>
<%@page import="logic.Global"%>
<%@page import="java.util.Random"%>
<%@page import="utility.Misc"%>
<%@page import="logic.datatype.SubmitEvent"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="logic.IUser"%>
<%@page import="logic.datatype.CollectEvent"%>
<%@page import="java.util.List"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.EntityFactory"%>
<%@page import="cms.IndexContentManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi 你的视频私生活</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视 你的视频私生活" />
        <link href="CSS/all.css" rel="stylesheet" tsype="text/css" />
        <!--[if lte IE 6]>
        <link href="../CSS/ie6.css" rel="stylesheet" type="text/css" />
        <script src="../JS/ie6.js" type="text/javascript"></script>
        <![endif]-->
        <link rel="shortcut icon" href="pic/slogo.png" type="image/x-icon"/>

        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>-->
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
        <script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js" type="text/javascript"></script>
        <link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/themes/cupertino/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var user_id = <%= user.getUserid()%>;
            var user_name = "<%= user.getName()%>";
            var user_photo_small = "<%=user.getPhotoSmall()%>";
            var f_a_vids = [];
        </script>
        <script src="js/common.js" type="text/javascript"></script>
        <script src="js/filter.js" type="text/javascript"></script>
        <script src="js/head_last.js" type="text/javascript"></script>
    </head>

    <body class="green_background">
        <div id="black_mask" class="mask"></div>
        <div id="filterbox" class="">
            <div class="bgleft"></div>

            <div class="filter_p">
                <div class="filter_tag">
                    <div class="tag_home"></div>
                    <a class="tags">搞笑</a>
                    <a class="tags">创意</a>
                    <a class="tags">国产</a>
                    <a class="tags">感人</a>
                    <a class="tags">经典</a>
                    <a class="tags">音乐</a>
                    <a class="tags">游戏</a>
                    <a class="tags">电影</a>
                    <div class="tag_end"></div>
                    <div class="clear"></div>
                </div>
                <div id="filter_panel">
                    <div class="videobox">
                        <%
                                    List<IVideo> vlist = Global.getNewVideo(6);
                                    Iterator<IVideo> vit = vlist.iterator();
                                    int i = 1;
                                    while (vit.hasNext()) {
                                        IVideo video = vit.next();
                        %>
                        <script type="text/javascript">f_a_vids[<%= i - 1%>] = <%= video.getVideoid()%>;</script>
                        <div id="hvb_<%= i++%>" class="hot_video_box">
                            <div class="video_discription_box mask">
                                <div class="f_d_video_discription"><%= video.getSummary()%></div>
                                <div class="video_discription_bg"></div>
                            </div>
                            <div class="f_d_hot_video">
                                <div style="background-image:url('<%= video.getSnapshotURL()%>')" title="<%= video.getTitle()%>" class="thumbnail">
                                    <a href="#nogo" class="play">"&gt;</a>
                                </div>
                                <div class="video_info">
                                    <div class="video_title">
                                        <a href="#nogo" title="<%= video.getTitle()%>"><%= video.getTitle()%></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% }%>
                        <div class="clear"></div>
                    </div>
                    <div id="mouth">22/222</div>
                </div>
            </div>
            <div class="bgright"></div>
        </div>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <div class="video mask">
                        <div class="video_t">
                            <a target="_blank" href="#nogo" title=""></a>
                        </div>
                        <div class="video_c">
                            <div id="f_d_flash_container" class="swf_holder">
                            </div>
                        </div>
                        <div class="share_icon2">
                            <a href="#nogo"></a>
                        </div>
                        <div class="collect_icon2">
                            <a href="#nogo"></a>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <%@include file="../iweishi1.5clean/jspf/top_filter_nobody.jspf"%>

                    <div id="top_hover" class="top_p mask">
                    </div>
                    <div id="filterbox_hover" class="filter_pl mask" align="center">
                        <div class="packup">
                            <a class="packup_txt">继续筛</a>
                        </div>
                        <div class="packup_bg"></div>
                    </div>
                    <div id="f_d_main"  class="">
                        <div class="columns">
                            <div class="f_d_columnA">
                                <div class="header">
                                    <div class="txtbox">
                                        <span class="size18">筛视频——</span>
                                        <span class="size15">快来</span>
                                        <span class="size18">拯救</span>
                                        <span class="size15">那些正在消失的视频吧！</span>
                                    </div>
                                    <div class="ruler">
                                        <div class="rulebox">
                                            <span class="size18">筛视频规则：</span>
                                            <div class="rule1">
                                                <span class="size15 txt1">第一点：这其实更像一款游戏。</span>
                                            </div>
                                            <div class="rule1">
                                                <span class="size15">第二点：</span>
                                                <span class="size18 txt2" >爱微视</span>
                                                <span class="size15">会根据你的使用为你</span>
                                                <span class="size18 txt3" >筛选</span>
                                                <span class="size15">最新的优质视频。</span>
                                            </div>
                                            <div class="rule1">
                                                <span class="size15">第三点：注意，下面的每个视频只会存在</span>
                                                <span class="size18 txt3" >12秒</span>
                                                <span class="size15">，平均</span>
                                                <span class="size18 txt3" >每2秒</span>
                                                <span class="size15">就会有一个视频从此消失。</span>
                                            </div>
                                            <div class="rule1">
                                                <span class="size15">第四点：来吧，</span>
                                                <span class="size18 txt2" >收藏</span>
                                                <span class="size15">或是</span>
                                                <span class="size18 txt4" >分享</span>
                                                <span class="size15">你喜欢的视频，不要让它擦肩而过哦。</span>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                            <div class="columnB">
                                <div class="f_d_settop"><span>今日筛榜</span></div>
                                <div class="f_d_setcont">
                                    <ul>
                                        <li class="hotpeople_info">视频数</li>
                                        <%
                                                    List<Pair<IUser, Integer>> list = Global.getTopRecentFolloweeUser(-1, 5);
                                                    Iterator<Pair<IUser, Integer>> it = list.iterator();
                                                    while (it.hasNext()) {
                                                        Pair<IUser, Integer> p = it.next();
                                        %>
                                        <li class="hotpeople_maging">
                                            <a href="home.jsp?uid=<%= p.getKey().getUserid()%>" target="_blank" ><big class="hotpeople_img" style="background:url(<%= p.getKey().getPhotoMini()%>) no-repeat;"></big><big class="hotpeople_txt"><b><%= p.getKey().getName()%></b></big></a><big class="hotpeople_fnum"><%= p.getValue()%></big>
                                        </li>
                                        <% }%>
                                        <li class="more"><a href="#">更多</a></li>
                                    </ul>
                                </div>
                                <div class="f_d_setfommtbg"></div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="columnlogo"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
