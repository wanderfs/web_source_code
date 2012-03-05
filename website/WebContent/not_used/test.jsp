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
if(user != ServletCommon.nobody)
    getServletConfig().getServletContext().getRequestDispatcher(
            "/user_index.jsp").forward(request,response);
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
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_none_enter.css" />
        <link href="CSS/Left_push_video.css" rel="stylesheet" type="text/css" />
        <link href="CSS/ie_roundrect.css" rel="stylesheet" type="text/css" />
        <link href="CSS/homepage_header_none_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/tabs.css" rel="stylesheet" type="text/css" />
        <link href="CSS/videos_hot.css" rel="stylesheet" type="text/css" />
        <link href="CSS/join_login.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="fancybox/jquery.fancybox-1.3.1.pack.js"></script>
        <link rel="stylesheet" href="fancybox/jquery.fancybox-1.3.1.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var gUserid = <%= user.getUserid() %>;
            var gUsername = "<%= user.getName() %>";
        </script>
        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/videolist.js" type="text/javascript"></script>
        <script src="JS/tab.js" type="text/javascript"></script>
        <script src="JS/push_frame.js" type="text/javascript"></script>
        <link href="CSS/activity.css" rel="stylesheet" type="text/css">
    <link href="CSS/top10videos.css" rel="stylesheet" type="text/css">
    <link href="CSS/footer.css" rel="stylesheet" type="text/css">


    </head>

    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <div id="top">
                        <a id="logo" href="HomepageUserNoneenter.jsp">爱微视<span >iweishi</span></a>
                        <div id="newmenudo">
                            <div id="capright" class="menudo_image"></div>
                            <ul id="nav" class="grandpappy">
                                <li class="firstborn search" id="menudo_search_subtier">
                                    <div class="rounded_input">
                                        <div class="contain menudo_image">
                                            <form  action method="get" >
                                                <input name="search" id="menudo_search_field" value="搜索视频" class="field" autocomplete="off" maxlength="50"
                                                       type="text" />
                                                <input value="" class="button" type="submit" />
                                            </form>
                                        </div>

                                    </div>
                                    <ul class="dotted favoritechild menudo_subtier">
                                        <li id="menudo_search_videos" class="first selected first">
                                            <a >搜索视频</a>
                                            <div class="left_shoulder menudo_image"></div>
                                            <div class="right_shoulder menudo_image"></div>
                                        </li>
                                        <li id="menudo_search_people" class=""><a >搜索用户</a></li>

                                        <li id="menudo_search_groups" class="last"><a >搜索小组</a></li>

                                        <li style="margin-top: 0px; background: none repeat scroll 0% 0%
                                            transparent;">
                                            <div class="cheek_left menudo_image"></div>
                                            <div class="cheek_fill"></div>
                                            <div class="cheek_right menudo_image"></div>
                                        </li>
                                    </ul>
                                </li>

                                <li class="firstborn help">
                                    <a class="label" >帮助</a>
                                    <ul class="favoritechild dotted">
                                        <li class="first">
                                            <a href="help.jsp">视频收藏</a>
                                            <div class="left_shoulder menudo_image"></div>
                                            <div class="right_shoulder menudo_image"></div>
                                        </li>

                                        <li>
                                            <a href="help.jsp">视频分享</a>
                                        </li>
                                        <li class="last">
                                            <a href="help.jsp">视频小组</a>
                                        </li>

                                        <li style="margin-top: 0px; background: none repeat scroll 0% 0%
                                            transparent;">

                                            <div class="cheek_left menudo_image"></div>
                                            <div class="cheek_fill"></div>
                                            <div class="cheek_right menudo_image"></div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="firstborn explore">
                                    <a class="label" >探索</a>

                                    <ul class="favoritechild dotted">
                                        <li class="first">
                                            <a href="Group_Homepage_enter.jsp">小组</a>
                                            <div class="left_shoulder menudo_image"></div>
                                            <div class="right_shoulder menudo_image"></div>
                                        </li>
                                        <li class="last">
                                            <a href="stars.jsp">明星</a>

                                        </li>


                                        <li style="margin-top: 0px; background: none repeat scroll 0% 0%
                                            transparent;">
                                            <div class="cheek_left menudo_image"></div>
                                            <div class="cheek_fill"></div>
                                            <div class="cheek_right menudo_image"></div>
                                        </li>
                                    </ul>
                                </li>
                                <li class="firstborn tools">

                                    <a class="label" >工具</a>
                                    <ul class="favoritechild dotted">
                                        <li class="first">
                                            <a href="invite_find.jsp">寻找朋友</a>
                                            <div class="left_shoulder menudo_image"></div>
                                            <div class="right_shoulder menudo_image"></div>
                                        </li>
                                        <li class="last">

                                            <a href="invite_find.jsp">邀请朋友</a>
                                        </li>


                                        <li style="margin-top: 0px; background: none repeat scroll 0% 0%
                                            transparent;">
                                            <div class="cheek_left menudo_image"></div>
                                            <div class="cheek_fill"></div>
                                            <div class="cheek_right menudo_image"></div>
                                        </li>
                                    </ul>

                                </li>
                                <li class="firstborn me" id="menudo_me">
                                    <ul class="dotted favoritechild">
                                        <li class="first">
                                            <a href="userHomepage_enter.jsp">主页</a>
                                            <div class="left_shoulder menudo_image"></div>
                                            <div class="right_shoulder menudo_image"></div>
                                        </li>

                                        <li><a href="Group_Homepage_All_enter.jsp">小组</a></li>
                                        <li><a href="attention_and_fans_enter.jsp">友邻</a></li>
                                        <li><a href="user_settings.jsp">设置</a></li>
                                        <li class="last danger">
                                            <a href="HomepageUserNoneenter.jsp">退出</a>

                                        </li>




                                        <li style="margin-top: 0px; background: none repeat scroll 0% 0%
                                            transparent; position: relative;">

                                            <div class="cheek_left menudo_image"></div>
                                            <div class="cheek_fill"></div>
                                            <div class="cheek_right menudo_image"></div>
                                        </li>
                                    </ul>

                                    <a href="userHomepage_enter.jsp"><img
                                            src="pic/d.jpg" id="menudo_portrait" alt=""
                                            height="24" width="24"></a>
                                    <div class="runt">
                                        <a href="userHomepage_enter.jsp" class="label">用户</a>
                                    </div>

                                </li>
                                <li class="firstborn login">
                                    <a class="label" href="Login.jsp" rel="nofollow">登录</a>
                                </li>
                                <li class="firstborn join">
                                    <a  href="Join.jsp" title="加入 爱微视"><div class="joinimage loggedout"><span>注册</span><strong> 爱微视</strong></div></a>
                                </li>

                            </ul>
                            <div class="clear"></div>
                        </div>

                    </div>
                    <!--<v:roundrect id="roundrect_cap" arcsize="0.5" fillcolor="#fff" filled="t" stroked="f"></v:roundrect>-->
                    <div id="cap" ><img src="pic/top_cap.png"></div>
                    <div id="main">

                        <div id="header">
                            <h1>欢迎您</h1>
                            <div id="intro">
						爱微视是网络视频的集散地，在这里您可以收藏和发现众多分享网站上的视频，在这里您也可以分享视频到众多社区网站，在这里您还可以加入视频小组结识志同道合的朋友！还在犹豫什么？现在就<a
                                    href="Join.jsp" rel="nofollow">加入</a>吧！

                            </div>
                        </div>

                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div class="mask" id="push_frame_mask" >
                                    <div id="pre_submission_frame" class="mask">
                                        正在加载，请稍等……<img src="pic/loading.gif" height="162" width="162"/>
                                    </div>
                                    <div id="push_failure" style="display:none;">
                                        对不起，您的链接不正确，请重新推荐.
                                    </div>
                                    <div class="pushbtn_frame" id="pushbtn_frame">
                                        <!--<div class="pushbtn_tabs">
                                            <ul>
                                                <li class="active">

                                                    <div  class="tab">推荐给爱微视</div>
                                                </li>
                                                <li>

                                                    <div  class="tab">推荐给小组</div>
                                                </li>
                                                <li>

                                                    <div  class="tab" >推荐给我关注的人或粉丝</div>
                                                </li>

                                            </ul>
                                            <div class="clear"></div>

                                        </div> -->
                                        <div class="pushbtn_frame_wrapper" ><div class="pushbtn_frame_meat">
                                                <!--<div id="cancel_img"><img src="pic/icon_album_delete.gif" /><div class="clear"></div></div>-->
                                                <!-- <div class="pushbtn_frame_to_field" style="display:none;">
                                                     <label for="tofield" > 推荐给小组：</label> <input class="tofield" type="text" value="小组名称"  />
                                                 </div>
                                                 <div class="pushbtn_frame_to_field" style="display:none;">
                                                     <label for="tofield" > 推荐给我关注的人或粉丝：</label> <input class="tofield" type="text" value="我关注人或粉丝的名称"  />
                                                 </div> -->
                                                <div class="pushbtn_frame_content">

                                                    <div class="thumbnail"></div>
                                                    <div class="digest">

                                                        <h3><a href="Video_Homepage_none_enter.jsp">视频标题</a></h3>
                                                        <div class="byline">收藏者 <a href="userHomepage_none_enter.jsp">张三李四王麻子</a>
                                                            <span style="display:none;"> 1秒前</span></div>
                                                        <div class="description"><textarea class="pushbtn_usertalk" id="pushbtn_usertalk" cols="" rows="" >用户评论</textarea></div>
                                                        <div class="stat"><span class="comment">评分★★★★★</span><input id="collect_checkbox" type="checkbox" /><label id="collect_label" for="collect_checkbox">将本次收藏分享给友邻</label><span id="collect_success_span" style="display:none;">您已成功收藏此视频</span></div>
                                                    </div>

                                                    <div class="clear"></div>
                                                </div>

                                                <div class="pushbtn_frame_buttons" >
                                                    <span
                                                        class="cancel_span faux_link" id="push_frame_cancel">取消</span>
                                                    <input class="ok"  id="push_frame_ok" type="button" value="收藏" />
                                                    <input class="grey_button"  style="display:none;" type="button" value="收藏成功" />
                                                    <input class="grey_button" style="display:none;" type="button" value="收藏失败" />
                                                    <input class="grey_button" style="display:none;" type="button" value="正在收藏..." />
                                                    <div class="push_infback" style="display:none;">
                                                        <span  class="push_infback_text">您是第<a><strong>&nbsp;1&nbsp;</strong></a>位收藏此视频的人.</span>
                                                        <span class="push_infback_text"style="display:none;">对不起，您提供的视频链接不正确.</span>
                                                        <span class="faux_link">继续收藏？</span>或 <span class="faux_link">关闭</span>   </div>

                                                    <div class="clear">   </div>

                                                </div></div></div></div></div>
                                <div id="push_video">
                                   <!-- <v:roundrect id="roundrect_push_video_form"  arcsize="0.05" fillcolor="#e6e6dc" filled="t" stroked="f">
                                        <form id="push_video_form" action="" method="post" >

                                            <v:roundrect id="roundrect_push_video_textarea" arcsize="0.4" fillcolor="#fff" filled="t" stroked="f"><textarea id="push_video_textarea" cols="" rows="" > 请输入您要收藏的视频所在页面的网址。目前我们支持的网站有：优酷，土豆，CNTV...</textarea></v:roundrect>


                                            <a id="show_push_frame" href="#pushbtn_frame"><input id="push_video_btn" type="button" value="" /></a>
                                        </form>
                                  </v:roundrect> -->
                                   <form id="push_video_form" action="" method="post" >
                                     <textarea name="push_video_textarea" cols="" rows="" id="push_video_textarea" > 请输入您要收藏的视频所在页面的网址。目前我们支持的网站有：优酷，土豆，CNTV...</textarea>
                                     <a id="show_push_frame" href="#pushbtn_frame"><input id="push_video_btn" type="button" value="" /></a>
                                  </form>
                                </div>
                                <div  style="height: 20px;"></div>
                                <div class="tabs">
                                    <ul>
                                        <li id="hot_tab" class="active">
                                       <!-- <v:roundrect style="top:127px;" class="roundrect_tab_4" arcsize="0.8" fillcolor="#e6e6dc" filled="t" stroked="f"></v:roundrect> -->
                                        <div  class="tab">微视箱</div>
                                        </li>
                                        <li id="new_tab">
                                       <!-- <v:roundrect style="top:127px;" class="roundrect_tab_4" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect>-->
                                        <div  class="tab"  > 最新收藏</div>
                                        </li>
                                        <li id="activity_tab">
                                     <!--   <v:roundrect style="top:127px;"
                                                     class="roundrect_tab_3" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect> -->
                                        <div  class="tab" > 周边动态</div>
                                        </li>

                                    </ul>
                                    <div class="clear"></div>

                                </div>


                                <div id="content_wrapper" class="softcorner native"
                                     style="background-color: rgb(230, 230, 220); -moz-border-radius-topright: 15px; -moz-border-radius-bottomright: 15px; -moz-border-radius-bottomleft: 15px; padding: 10px;">

                                    <div id="videos_content">
                                        <div id="videos_meat">
                                            <div id="clips">
                                                <ul class="videos">
                                                    <%
                                                                List hotlist = user.GetHotVideo(15);
                                                                Iterator<IVideo> it = hotlist.iterator();
                                                                IVideo video = it.next();
                                                                int uid = video.getFirstSubmitUserid();
                                                                if(video != null) {
                                                    %>
                                                    <li class="videos_top">
                                                        <!--<div class="digg_label">
                                                            <div class="digg_count"><%= video.getWatchUserCount()%></div>

                                                            <div id="share"><a href="Login.jsp" style="height:15px; width:37px;display:block;" class="share">收藏+</a></div>
                                                        </div>-->
                                                        <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')"><a class="play">播放</a>
                                                            <div class ="embeded_code" id='<%= "vid" + video.getVideoid()%>' style="display:none;"><%= video.getEmbededUrl()%></div>
                                                        </div>
                                                        <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="<%= "video.jsp?vid="+ video.getVideoid()%>"><%= video.getTitle()%></a></h3>
                                                            <div class="byline">发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                                                                <%= Misc.pastTime(video.getTime())%> 前</div>
                                                            <div class="description"><%= video.getSummary()%></div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/><strong>  评论  </strong>  88</span></div>
                                                        </div>

                                                        <div class="clear"></div>
                                                    </li>
                                                    <%}          while (it.hasNext()) {
                                                                    video = it.next();
                                                                    uid = video.getFirstSubmitUserid();
                                                    %>
                                                    <li>
                                                        <!--<div class="digg_label">
                                                            <div class="digg_count"><%= video.getWatchUserCount()%></div>

                                                            <div id="share"><a href="Login.jsp" style="height:15px; width:37px;display:block;" class="share">收藏+</a></div>
                                                        </div>-->
                                                        <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')"><a class="play">播放</a>
                                                            <div class ="embeded_code" id='<%= "vid" + video.getVideoid()%>' style="display:none;"><%= video.getEmbededUrl()%></div>
                                                        </div>
                                                        <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="<%= "video.jsp?vid="+ video.getVideoid()%>"><%= video.getTitle()%></a></h3>
                                                            <div class="byline">发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                                                                <%= Misc.pastTime(video.getTime())%> 前</div>
                                                            <div class="description"><%= video.getSummary()%></div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/><strong>  评论  </strong>  88</span></div>
                                                        </div>

                                                        <div class="clear"></div>
                                                    </li>
                                                    <% }%>
                                                </ul>
                                                <div class="next"><h2>更多</h2></div>
                                            </div>
                                        </div>
                                    </div>

                                    <div id="activity_content" class="softcorner native activity_bubble background_softcorner mask" >
                                        <div id="activity_content_insides">

                                            <div class="activity">
                                                <ul id="log" >

                                                    <li class="action">					<div class="icon"><img
                                                                src="pic/icon_act_like.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="Video_Homepage_enter.jsp"><img
                                                                    src="pic/26744652_100.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 收藏了 <strong><a href="userHomepage_enter.jsp">张三 </a></strong>推荐的视频 <strong><a href="Video_Homepage_enter.jsp">星象仪 大冢爱</a></strong></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="action">					<div class="icon"><img
                                                                src="pic/icon_act_upload.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="Video_Homepage_enter.jsp"><img
                                                                    src="pic/26744652_100.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 看过了视频 （加星星）<strong><a href="Video_Homepage_enter.jsp">星象仪 大冢爱</a></strong></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="action">					<div class="icon"><img
                                                                src="pic/icon_act_tag.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="userHomepage_enter.jsp"><img
                                                                    src="pic/69842679_100.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 关注了 <a href="userHomepage_enter.jsp"><strong>张三</strong></a></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="action">					<div class="icon"><img
                                                                src="pic/icon_groups.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="Group_Homepage_enter.jsp"><img
                                                                    src="pic/manlian8060.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 加入了小组 <strong><a href="Group_Homepage_enter.jsp">曼联</a></strong></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="action">					<div class="icon"><img
                                                                src="pic/icon_act_comment_forum.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="Video_Homepage_enter.jsp"><img
                                                                    src="pic/26744652_100.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 评论了视频 <strong><a href="Video_Homepage_enter.jsp">星象仪 大冢爱</a></strong></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="action last">					<div class="icon"><img
                                                                src="pic/icon_act_channel.gif" alt="收藏"></div>
                                                        <div class="thumb_clip"><a href="Group_Homepage_enter.jsp"><img
                                                                    src="pic/manlian8060.jpg" alt="" height="60" width="80"></a></div>
                                                        <div class="thumb_user">
                                                            <a href="userHomepage_enter.jsp"><img
                                                                    src="pic/littleul4594619-5.jpg" alt="wanderfs" title="wanderfs" height="30" width="30"></a></div>
                                                        <div class="text">
                                                            <div class="time">1 分钟以前</div>
                                                            <div class="message"><a href="userHomepage_enter.jsp"><strong>wanderfs</strong></a> 创建了小组 <strong><a href="Video_Homepage_enter.jsp">曼联</a></strong></div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                </ul>
                                            </div>
                                            <div class="activity_next"><h2>更多</h2></div>
                                            <div class="clear"></div></div></div>
                                </div>
                            </div>

                            <div class="column" id="columnB">
                                <div class="join_login">用户通道</div>
                                <div  id="lightbox">
                                    <div
                                        id="world">
                                        <div id="sun">

                                            <div id="nav_login" class="nav" >
                                                <a id="login_link" class="active">登录</a> 或 <a
                                                    id="join_link">注册</a>
                                            </div>

                                            <div id="nav_join" class="nav" style="display: none;">
                                                <a  rel="nofollow" id="join_link"
                                                    class="active">注册</a> 或 <a
                                                    rel="nofollow" id="login_link" >登录</a>
                                            </div>
                                        </div>

                                        <div id="sky">
                                            <form id="login" action="login" method="post">
                                                <label for="login_email">邮箱</label>
                                                <div class="rounded_input"><input id="login_email" name="email" type="text"></div>

                                                <label for="login_password">密码</label>
                                                <div class="rounded_input"><input id="login_password" name="password"
                                                                                  type="password"></div>
                                                <input type="checkbox" id="remember" name="autologin"/><label id="remember_label" for="remember">记住登陆状态</label> <a
                                                    id="forgot_link" >忘记密码？</a>

                                                <input id="login_button" class="button" type="submit" value="登录">

                                            </form>

                                            <form id="join" class="mask" action="join" method="post">
                                                <label for="join_email">邮箱</label>
                                                <div class="rounded_input"><input id="join_email" name="email" type="text"></div>

                                                <label for="join_password">密码</label>
                                                <div class="rounded_input">
                                                    <input id="join_password" name="password" type="password">
                                                </div>
                                                <label for="join_password_check">确认密码</label>
                                                <div class="rounded_input">
                                                    <input id="join_password_check" type="password">
                                                </div>
                                                <input type="checkbox" id="tos"/><label id="tos_lable" for="tos">我已经阅读并同意了 <a
                                                        target="_blank">用户条例</a></label>

                                                <input id="join_button" class="button" type="submit" value="注册">

                                            </form>


                                        </div>

                                        <div id="land">

                                        </div>

                                        <!--<div id="land_bottom">
			<img src="pic/world_land_bottom300.gif" alt="">
		</div>-->
                                    </div></div>

                                <div class="nippleBox arousedBaboon">
                                    <div class="bar">
                                        <h4>特色</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div class="products">
                                            <ul class="dottedlist">
                                                <li class="first">
                                                    <a href="HomepageUserNoneenter.jsp" id="product_first">
                                                        <div class="home_icon"></div>
                                                        <h3>收藏视频</h3>
                                                        <p>在这里您可以便捷地收藏众多网络视频分享网站上您所喜爱的视频</p>
                                                    </a>
                                                    <div class="clear"></div>
                                                </li>
                                                <li>
                                                    <a  href="Login.jsp" id="product_second">
                                                        <div class="home_icon"></div>
                                                        <h3>发现视频</h3>
                                                        <p>在这里您可以通过爱微视个人推荐系统，友邻，视频小组等发现喜爱却不曾观看的视频</p>
                                                    </a>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="last">
                                                    <a  href="Group_Homepage_All_Noneenter.jsp" id="product_third">
                                                        <div class="home_icon"></div>
                                                        <h3>分享视频</h3>
                                                        <p>在这里您可以分享喜爱的视频给世界，欢迎把视频分享到爱微视，或从这里分享到站外</p>
                                                    </a>
                                                    <div class="clear"></div>
                                                </li>



                                            </ul>
                                        </div>	</div>
                                </div>

                                <div class="nippleBox">
                                    <div class="bar" style="border-top-color: rgb(78, 186, 255);">
                                        <h4>广告</h4>	</div>
                                    <div class="nipple" style="border-top-color: rgb(78, 186, 255);"></div>
                                    <div class="content">
                                        <div class="ad" id="dfp-ad-1" style="width: 300px; height: 250px;">
                                            <img src="pic/200952217331896.jpg" />

                                        </div>	</div>
                                </div>

                                <div class="nippleBox arrogantSunflower">
                                    <div class="bar">
                                        <h4>本周视频Top5</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content" >
                                    <div id="top_week_videos">
                                                <ul class="top_week_videos_ul">

                                                    <li class="top_week_videos_li top_week_videos_topvideo">
                                                 <div class="top_week_videos_num">1</div>
                                                        <div class="top_week_videos_thumbnail" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>



                                                            <div class="top_week_videos_stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="top_week_videos_comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;</span></div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">2</div>
                                                        <div class="top_week_videos_thumbnail" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>



                                                            <div class="top_week_videos_stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="top_week_videos_comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;</span></div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">3</div>
                                                        <div class="top_week_videos_thumbnail" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>



                                                            <div class="top_week_videos_stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="top_week_videos_comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;</span></div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                      <div class="top_week_videos_num">4</div>
                                                        <div class="top_week_videos_thumbnail" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>



                                                            <div class="top_week_videos_stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="top_week_videos_comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;</span></div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">5</div>
                                                        <div class="top_week_videos_thumbnail" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>



                                                            <div class="top_week_videos_stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  9999&nbsp;&nbsp;<span class="top_week_videos_comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>★★★★★&nbsp;&nbsp;</span></div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>

                                                </ul>
                                      </div>




                                    </div>
                                </div>

                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>本周收藏家Top5</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content" >
                                    <div id="top_week_videos">
                                                <ul class="top_week_videos_ul">

                                                    <li class="top_week_videos_li top_week_videos_topvideo">
                                                 <div class="top_week_videos_num">1</div>
                                                        <div class="top_week_videos_thumbnail" style="background-image:url('pic/ul4594619-48.jpg');" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="userHomepage_enter.jsp">wanderfs</a></h3>



                                                            <div class="top_week_videos_stat"><strong><a>999</a></strong>
个收藏视频 /
				<strong><a>999</a></strong>
位粉丝</div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">2</div>
                                                        <div class="top_week_videos_thumbnail" style="background-image:url('pic/ul4594619-48.jpg');" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="userHomepage_enter.jsp">wanderfs</a></h3>



                                                            <div class="top_week_videos_stat"><strong><a>999</a></strong>
个收藏视频 /

				<strong><a>999</a></strong>
位粉丝</div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">3</div>
                                                        <div class="top_week_videos_thumbnail" style="background-image:url('pic/ul4594619-48.jpg');" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="userHomepage_enter.jsp">wanderfs</a></h3>



                                                            <div class="top_week_videos_stat"><strong><a>999</a></strong>
个收藏视频 /

				<strong><a>999</a></strong>
位粉丝</div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                      <div class="top_week_videos_num">4</div>
                                                        <div class="top_week_videos_thumbnail" style="background-image:url('pic/ul4594619-48.jpg');">

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="userHomepage_enter.jsp">wanderfs</a></h3>



                                                            <div class="top_week_videos_stat"><strong><a>999</a></strong>
个收藏视频 /

				<strong><a>999</a></strong>
位粉丝</div>
                                                      </div>

                                                        <div class="clear"></div>
                                                  </li>
                                                  <li class="top_week_videos_li">
                                                       <div class="top_week_videos_num">5</div>
                                                        <div class="top_week_videos_thumbnail" style="background-image:url('pic/ul4594619-48.jpg');" >

                                                        </div>
                                                        <div class="top_week_videos_digest">

                                                          <h3><a href="userHomepage_enter.jsp">wanderfs</a></h3>



                                                            <div class="top_week_videos_stat"><strong><a>999</a></strong>
个收藏视频 /

				<strong><a>999</a></strong>
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

                        <div id="footer">
                            <div class="legal_container">
						© 2010 iweishi.cn, all rights reserved
                                <a >关于我们</a> /  <a >合作准则</a> / <a
                                    >博客</a> / <a  rel="nofollow">服务</a> / <a rel="nofollow">免责声明</a>
                                / <a >帮助中心</a>
                            </div>
                            <div class="clear"></div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <img style="top: -3px;" class="sun"
             src="pic/land_sun.gif"><img
             style="position: fixed;*position: absolute; z-index: 20; top: 45px; right: -60px;"
             id="cloud"
             src="pic/land_cloud.gif"><img
             style="top: 322px;" id="cloud2"
             src="pic/land_cloud2.gif">
    </body>
</html>
