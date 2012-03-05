<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IEvent"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.IUser"%>
<%@page import="logic.Global"%>
<%@page import="logic.Video"%>
<%@page import="logic.User"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.datatype.*" %>
<%@page import="logic.datatype.CollectEvent" %>
<%@page import="logic.datatype.JoinChannelEvent"%>

<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            String svid = request.getParameter("vid");
            response.sendRedirect("iweishi2.0/video.jsp?vid=" + svid);
            int vid = Integer.parseInt(svid);
            IVideo video = EntityFactory.getVideo(vid);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title><%=video.getTitle()%> 爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content=<%=video.getSummary()%> />

        <link href="CSS/global.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />
        <link href="CSS/createAlbum.css" rel="stylesheet" type="text/css" />
        <link href="CSS/video_homepage_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/videos_hot.css" rel="stylesheet" type="text/css" />
        <link href="CSS/footer.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script src="JS/jquery_plugins.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />
        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
            var gVideoid = "<%= vid%>";
            var page_type = "video.jsp"
        </script>
        <script src="JS/common.js" type="text/javascript"></script>
        <script src="JS/move_view.js" type="text/javascript"></script>
        <script src="JS/video.js" type="text/javascript"></script>
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
                                <div class="portrait"><% IUser firstsubmituser = EntityFactory.getUser(video.getFirstSubmitUserid());
                                            int userid = firstsubmituser.getUserid();%><a href="home.jsp?uid=<%= userid%>"><img src="pic/portrait/d.75.jpg" alt=""  class="portrait" /></a></div>
                            <div class="rightside">
                                <div class="title"><%= video.getTitle()%></div>
                                <div class="byline">发现者 <a href="home.jsp?uid=<%= userid%>"><%= firstsubmituser.getName()%></a></div>
                                <div class="date">
                                    <span id="clip-timeago"><%= Misc.pastTime(video.getTime())%> 前</span>
                                </div>
                            </div>

                            <div class="clear"></div>

                        </div>
                        <div id="grid" class="columns">
                            <div id="columnA" class="column">


                                <div class="softcorner native">
                                    <div id="module">
                                        <!--[if gte IE 6]>   <div class="video_background_black_top"><div class="video_background_black_tl"></div><div class="video_background_black_tr"></div><div class="video_background_black_tm"></div></div><![endif]-->
                                        <div class="video_background_black">
                                            <div id="clip">
                                                <div class="video_holder">
                                                    <div  class="player" >
                                                        <div class="swf_holder"
                                                             ><%= video.getEmbededUrl()%>
                                                        </div></div></div>
                                            </div>

                                            <div id="details">
                                                <ul class="ul_details">
                                                    <li id="judge" class="li_details">
                                                        <img src="pic/icon_description.gif" />
                                                        <strong> 总评 </strong>
                                                        <span class="stars">
                                                            <%
                                                                        int numOfStars = (int) Math.round(video.getScore());
                                                            %>
                                                            <span class="<%=numOfStars >= 1 ? "star_rated full" : "star_rated"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="<%=numOfStars >= 2 ? "star_rated full" : "star_rated"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="<%=numOfStars >= 3 ? "star_rated full" : "star_rated"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="<%=numOfStars >= 4 ? "star_rated full" : "star_rated"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="<%=numOfStars >= 5 ? "star_rated full" : "star_rated"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                        </span>
                                                    </li>
                                                    <li class="look li_details"><a href="#nogo" class="faux_link" ><img src="pic/play.gif" alt="" /> <strong
                                                                id="looks_count"><%= video.getWatchUserCount()%> </strong> 人观看</a></li>
                                                    <li class="likes li_details"><img src="pic/icon_likes.gif"/> <strong
                                                            id="likes_count"><%= video.getSubmitUserCount()%></strong> 人收藏</li>
                                                    <li class="comments li_details"><a href="#nogo" class="faux_link" ><img src="pic/icon_comments.gif"
                                                                                                                            /> <strong id="comments_count"><%= video.getCommentCount()%></strong> 人评论</a></li>

                                                    <li class="comments myJudge li_details">
                                                        <strong >我的评价 </strong>
                                                        <span class="stars login_needed">
                                                            <span class="star blackStar"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="star blackStar"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="star blackStar"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="star blackStar"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                            <span class="star blackStar"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                                                        </span>
                                                    </li>

                                                    <li class="share_video li_details">
                                                        <div id="collect_this" class="share_video_btn">
                                                            <!--[if gte IE 6]>   <div class="share_video_btn_top"><div class="share_video_btn_tl"></div><div class="share_video_btn_tr"></div><div class="share_video_btn_tm"></div></div><![endif]--><div class="share_video_btn_mid"><!--<img src="pic/icon_act_like2125.png"   />--><strong>收藏</strong></div><!--[if gte IE 6]><div class="share_video_btn_bottom"><div class="share_video_btn_bl"></div><div class="share_video_btn_br"></div><div class="share_video_btn_bm"></div></div><![endif]-->
                                                            <div class="dAlbumItems video_ai mask">
                                                                <ul class="uAlbumItems">
                                                                    <%
                                                                                List clist = user.getJoinedChannel(WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS);
                                                                                Iterator<JoinChannelEvent> cit = clist.iterator();
                                                                                int cid_push_frame = 0;
                                                                                if (user != ServletCommon.nobody) {
                                                                                    while (cit.hasNext()) {
                                                                                        cid_push_frame = cit.next().getGroupid();
                                                                    %>
                                                                    <li id ='<%= "cid" + cid_push_frame%>'class="album_name"><a href="#nogo"><%= EntityFactory.getGroup(cid_push_frame).getName()%></a></li>
                                                                    <%
                                                                                    }
                                                                                }
                                                                    %>
                                                                    <li class="create_album">新建专辑</li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </li>
                                                    <div class="clear"></div>

                                                </ul>
                                                <!--[if gte IE 6]><div class="clear"></div><![endif]-->
                                                <ul class="ul_details mask">
                                                    <div class="floatleft">分享到&nbsp;&nbsp;&nbsp;|
                                                    </div>
                                                    <li class="xnshare li_details"><a name="xn_share" type="icon" href="#">人人</a><script src="http://xnimg.connect.renren.com/js/api/connect/share/share.js" type="text/javascript"></script></li>
                                                    <li class="doubanshare li_details"><a href="javascript:void(function(){var d=document,e=encodeURIComponent,s1=window.getSelection,s2=d.getSelection,s3=d.selection,s=s1?s1():s2?s2():s3?s3.createRange().text:'',r='http://www.douban.com/recommend/?url='+e(d.location.href)+'&title='+e(d.title)+'&sel='+e(s)+'&v=1',x=function(){if(!window.open(r,'douban','toolbar=0,resizable=1,scrollbars=yes,status=1,width=450,height=330'))location.href=r+'&r=1'};if(/Firefox/.test(navigator.userAgent)){setTimeout(x,0)}else{x()}})()"><img src="http://img2.douban.com/pics/fw2douban_s.png" alt="" />豆瓣</a></li>
                                                    <li class="kx001share li_details"><a href="javascript:d=document;t=d.selection?(d.selection.type!='None'?d.selection.createRange().text:''):(d.getSelection?d.getSelection():'');void(kaixin=window.open('http://www.kaixin001.com/~repaste/repaste.php?&rurl='+escape(d.location.href)+'&rtitle='+escape(d.title)+'&rcontent='+escape(d.title),'kaixin'));kaixin.focus();"><img src="http://img1.kaixin001.com.cn/i/favicon.ico" alt="" border="0" height="16" width="16"/>开心001</a></li>
                                                    <li class="sinawbshare li_details"><a href="javascript:(function(){window.open('http://v.t.sina.com.cn/share/share.php?title='+encodeURIComponent(document.title)+'&url='+encodeURIComponent(location.href)+'&source=bookmark','_blank','width=450,height=400');})()" title="新浪微博"><img src="http://t.sina.com.cn/favicon.ico"  alt="新浪微博" border="0"/>新浪微博</a></li>

                                                    <div class="clear"></div></ul>

                                            </div>
                                        </div>
                                    </div>
                                    <!--[if gte IE 6]><div class="video_background_black_bottom"><div class="video_background_black_bl"></div><div class="video_background_black_br"></div><div class="video_background_black_bm"></div></div><![endif]-->
                                    <div class="description_container">
                                        <div id="description"><%= video.getSummary()%></div>
                                    </div>
                                    <div class="columnAson">
                                        <div class="columnAB">
                                            <ul class="comments" id="comments">
                                                <li class="parent mask" id="vc_template">
                                                    <a href="home.jsp?uid=">
                                                        <img src="pic/portrait/d.75.jpg" alt="" title="" class="portrait"  height="75" width="75" />
                                                    </a>
                                                    <div class="rightside">
                                                        <div class="name">
                                                            <a href="home.jsp?uid="></a>
                                                        </div>
                                                        <div class="text">
                                                            <a class="replylink" href="#new_comment" style="float: right;">
                                                                <img src="pic/msg_reply.gif" alt="+" style="position:relative; top: 2px;"/> 回复
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>

                                                <%
                                                            List commentlist = video.getComment(WebpageLayoutParam.VIDEO_COMMENT_NUM);
                                                            Iterator<VideoCommentEvent> it = commentlist.iterator();
                                                            while (it.hasNext()) {
                                                                VideoCommentEvent vcomment = it.next();
                                                                int commentuserid = vcomment.getUserid();
                                                                IUser commentuser = EntityFactory.getUser(commentuserid);
                                                %>
                                                <li class="parent" id="vc<%=vcomment.getCommentid()%>">
                                                    <a href="home.jsp?uid=<%= commentuserid%>">
                                                        <img src="pic/portrait/d.75.jpg" alt="" title="" class="portrait"  />
                                                    </a>
                                                    <div class="rightside">
                                                        <div class="name">
                                                            <a href="home.jsp?uid=<%= commentuserid%>"><%= commentuser.getName()%></a> <%= vcomment.getTime()%>
                                                        </div>
                                                        <div class="text"><%= StringEscapeUtils.escapeHtml(vcomment.getComment())%>
                                                            <a class="replylink" href="#new_comment" style="float: right;">
                                                                <img src="pic/msg_reply.gif" alt="+" style="position:relative; top: 2px;"/> 回复
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <%}%>
                                            </ul>

                                            <div id="new_comment" class="new_comment">
                                                <img src="pic/portrait/d.75.jpg" alt="" title=""
                                                     class="portrait"   />
                                                <div class="isay"><strong>添加新评论</strong></div>
                                                <form id="frmNewComment">
                                                    <textarea id="new_comment_text" name="text"></textarea>
                                                    <br />
                                                    <input class="blue_button" id="new_comment_btn"
                                                           value="  确  定 " type="button" />

                                                </form>
                                            </div>
                                        </div>


                                    </div>
                                </div>



                            </div>

                            <div id="columnB" style="margin-top:0px;" class="column">
                                <div class="video_stuff">
                                    <div id="context_browser_1">



                                        <div class="brozar">
                                            <div class="tabs" >
                                                <!--[if gte IE 6]><div class="activetab" style="float:left;background-color: rgb(231, 231, 222);margin-right:5px;"> <div class="brozar_tableft"><div class="brozar_tableft_tl"></div><div class="brozar_tableft_bottom"></div></div><![endif]-->
                                                <%
                                                            String rtitle = "发现者的其他视频";
                                                %>
                                                <div id="brozar_tab_more_off"
                                                     class="softcorner native" style="background-color: rgb(231, 231, 222);                         
                                                     ">
                                                    <%=rtitle%></div>
                                                <!--[if gte IE 6]> <div class="brozar_tabright"><div class="brozar_tabright_tr"></div><div class="brozar_tabright_bottom"></div></div><div class="clear"></div></div><![endif]-->
                                                <!--[if gte IE 6]> <div style="float:left;background-color: rgb(244, 244, 238);"> <div class="brozar_tableft"><div class="brozar_tableft_tl"></div><div class="brozar_tableft_bottom"></div></div><![endif]-->
                                                <!--<div id="brozar_tab_add_on"
                                                       class="softcorner native" style="background-color: rgb(244, 244, 238); " >
                                                      <a href="#nogo" class="faux_link" >相关收藏视频</a></div>--><!--[if gte IE 6]> <div class="brozar_tabright"><div class="brozar_tabright_tr"></div><div class="brozar_tabright_bottom"></div></div><div class="clear"></div></div><![endif]-->

                                                <div class="clear"></div>
                                            </div>



                                            <!--[if gte IE 6]><div class="wrappertop"><div class="wrappertop_tr"><img src="pic/wraproundedcorners_tr.png"/></div><div class="clear"></div></div><![endif]-->
                                            <div  class="more">
                                                <!--[if gte IE 6]><div class="video_meat_top"><div class="video_meat_top_tl"></div><div class="video_meat_top_tr"></div><div class="video_meat_tm"></div></div><![endif]-->
                                                <div class="softcorner native scrolly_container"
                                                     style="background-color: rgb(255, 255, 255); ">

                                                    <div class="scrolly_area" style="width: 260px; height: 490px;">
                                                        <div class="content" style="width: 248px; height: 490px; overflow: hidden;">
                                                            <div >
                                                                <!--<div id="brozar_current_clip" class="clip current">
                                                                    <div class="style_wrap" >

                                                                        <img src="pic/26744652_100.jpg"/>
                                                                        <div class="info" style="width: 128px;">
                                                                            <span class="index">999.</span> 视频标题<div
                                                                                class="byline">来自 <a href="userHomepage_enter.jsp">视频标题李四王麻子</a></div>
                                                                            <div class="time">99 秒以前</div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>-->
                                                                <%
                                                                            List<VideoRelation> vrl = video.getRelatedVideo(WebpageLayoutParam.VIDEO_ON_RIGHT_NUM);
                                                                            Iterator<VideoRelation> vrit;

                                                                            if (vrl != null) {
                                                                                vrit = vrl.iterator();
                                                                                int videoid = 0;
                                                                                int index = 0;
                                                                                IVideo curvideo;
                                                                                //Date date = null;
                                                                                while (vrit.hasNext()) {
                                                                                    ++index;
                                                                                    VideoRelation vr = vrit.next();
                                                                                    videoid = vr.getRelatedVideoid();
                                                                                    curvideo = EntityFactory.getVideo(videoid);
                                                                                    //date = vr.
%>

                                                                <div class="clip">
                                                                    <div class="style_wrap" >
                                                                        <a href="video.jsp?vid=<%=videoid%>" title="<%=curvideo.getTitle()%>">
                                                                            <img src="<%=curvideo.getSnapshotURL()%>"/>
                                                                        </a>
                                                                        <div class="info" style="width: 130px;">
                                                                            <span class="index"><%=index%>.</span>
                                                                            <a href="video.jsp?vid=<%=videoid%>" title="<%=curvideo.getTitle()%>"><%=curvideo.getTitle()%></a>
                                                                            <!--<div class="time">1s 以前</div>-->
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                                <% }
                                                                            }%>

                                                            </div>
                                                        </div>

                                                        <div class="scrolly swf_holder" style="height: 100%;"><embed
                                                                type="application/x-shockwave-flash" src="swf/scrolly.swf"
                                                                bgcolor="#ffffff" quality="medium" allowscriptaccess="always"
                                                                wmode="transparent" scalemode="showAll"

                                                                height="100%" width="12"></div>
                                                        <div class="clear"></div>
                                                    </div>


                                                </div>  <!--[if gte IE 6]> <div class="video_meat_bottom"><div class="video_meat_bottom_bl"><img src="pic/blvideocontentroundedcorners.png" /></div><div class="video_meat_bottom_br"></div><div class="video_meat_bottom_bm"></div></div><![endif]-->	 </div><!--[if gte IE 6]> <div class="wrapper_bottom"><div class="wrpper_bottom_bl"></div><div class="wrapper_bottom_br"></div><div class="wrapper_bottom_bm"></div><div class="clear"></div></div><![endif]--></div></div>			</div>
                                <div class="clear"></div>
                                <div class="nippleBox abrahamLincoln">
                                    <div class="bar">
                                        <h4>最新收藏此视频的用户</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div class="profile_contacts">
                                            <ul>
                                                <%
                                                            List<CollectEvent> list = video.getCollect(WebpageLayoutParam.NUM_COLLECTERS);
                                                            Iterator<CollectEvent> uit = list.iterator();
                                                            while (uit.hasNext()) {
                                                                IUser collector = EntityFactory.getUser(uit.next().getUserid());
                                                                if (collector == null) {
                                                                    continue;
                                                                }
                                                %>
                                                <li><a href="home.jsp?uid=<%=collector.getUserid()%>"><img src="<%=collector.getPhotoMedium()%>"/><%=collector.getName()%></a></li>
                                                <%}%>
                                            </ul>

                                            <div class="clear"></div><p class="all"><a href="notready.jsp"><strong>全部</strong></a></p>
                                        </div>	</div>
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
             src="pic/land_sun.gif"/><img
             style="position: fixed;*position: absolute; z-index: 20; top: 45px; right: -60px;*right: 0px;"
             id="cloud"
             src="pic/land_cloud.gif"/><img
             style="top: 322px;" id="cloud2"
             src="pic/land_cloud2.gif"/>
        <div class="mask">
            <%@include file="jspf/loginbox.jspf"%>
            <%@include file="jspf/create_album.jspf"%>
        </div>
    </body>
</html>
