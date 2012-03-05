<%-- 
    Document   : index
    Created on : 2011-3-11, 16:41:54
    Author     : Sen
--%>

<%@page import="logic.datatype.CommentEvent"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="logic.datatype.CollectEvent"%>
<%@page import="logic.datatype.SubmitEvent"%>
<%@page import="logic.datatype.VideoCommentEvent"%>
<%@page import="logic.IVideo" %>
<%@page import="logic.IUser" %>
<%@page import="logic.EntityFactory" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            boolean feedPage = false;
            IVideo video = null;
            IUser collector = null;
            CollectEvent ce = null;
            if (request.getParameter("fid") != null) {
                feedPage = true;
                long fid = Long.parseLong(request.getParameter("fid"));
                ce = (CollectEvent) EntityFactory.getEventByEventID(fid);
                video = EntityFactory.getVideo(ce.getVideoid());
                collector = EntityFactory.getUser(ce.getUserid());
            } else {
                video = EntityFactory.getVideo(Integer.parseInt(request.getParameter("vid")));
                collector = EntityFactory.getUser(video.getFirstSubmitUserid());
            }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><%=video.getTitle()%> 爱微视 你的视频私生活</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视是网络视频的集散地" />

        <link rel="shortcut icon" href="pic/slogo.png" type="image/x-icon"/>
        <link href="CSS/all.css" rel="stylesheet" type="text/css" media="all"  />

        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.4.2.min.js"></script>

        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link href="colorbox/colorbox.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript">
            var user = <%=user.toJSONString()%>;
            var video = <%=video.toJSONString()%>;
            var user_name = user.name; // for compatibility reason. TODO(sen): change all to json
        </script>
        <script src="js/tools.js" type="text/javascript"></script>
        <script src="js/all.js" type="text/javascript"></script>
    </head>
    <body class="gray_background_2">
        <img class="mask" src="<%=video.getSnapshotURL()%>"/>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <%@include file="jspf/top_small.jspf"%>
                    <div id="v_d_main">
                        <div class="v_d_columns">
                            <div class="columnsa">
                                <div id="video">
                                    <div class="videoname_box">
                                        <a class="videoname" href="video.jsp?vid=<%= video.getVideoid()%>"><%= video.getTitle()%></a>
                                    </div>
                                    <div id="videobox">
                                        <div class="v_d_swf_holder">
                                            <%= video.getEmbededUrl(WebpageLayoutParam.FULL_SCREEN_WIDTH, WebpageLayoutParam.FULL_SCREEN_HEIGHT)%>
                                        </div>
                                        <div id="num">
                                            <div id="watchnum"> <%= video.getWatchUserCount()%></div>
                                            <div id="watchword">观 看</div>
                                            <div id="sharenum"> <%= video.getShareCount()%></div>
                                            <div id="shareword">分 享</div>
                                            <div class="shareicon">
                                                <a class="float_left" href="#nogo"></a>
                                                <div class="v_d_share_hoverbox float_left mask">
                                                    <div class="share_hoverbox_inner">
                                                        <div class="innersite_share float_left">站内分享</div>
                                                        <div class="renren_share float_left shareclip">人人网</div>
                                                        <div class="tsina_share float_left shareclip">新浪微博</div>
                                                        <div class="tqq_share float_left shareclip">腾讯微博</div>
                                                        <div class="kaixin001_share float_left shareclip">开心网</div>
                                                        <div class="qzone_share float_left shareclip">QQ空间</div>
                                                        <div class="douban_share float_left shareclip">豆瓣</div>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="collecticon">
                                                <a href="#nogo"></a>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>

                                <!--<ul id="reply">
                                    <%
                                                String entity_type = "视频";
                                                if (feedPage) {
                                                    entity_type = "分享";
                                                }
                                    %>
                                    <li class="replytag"><span><%=entity_type%> 评论(<%= video.getCommentCount()%>)</span></li>
                                   
                                   <div class="share_say" >
                                        <div class="shareface float"></div>                                        
                                        <div class="sharekk float">
                                            <div class="sharerbox">
                                                <a class="sharer float">流个白</a>
                                                <li>(2010.2.20)</li>
                                                <li>分享时是这么说的：</li>
                                                <div class="clear"></div>
                                            </div>
                                            <div id="share_describe">
                                                <span>赞</span>
                                                <a href="#nogo">&nbsp;&nbsp;回复</a>
                                            </div>
                                            <div  class="share_end"></div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <li class="vcomment" id="vc_template">                                        
                                        <div class="float reply_byline">
                                            <a class="float" href="" target="_blank">
                                                <img src="" width="25px" height="25px" alt="photo"/>
                                            </a>
                                            <a href="#nogo" class="username"></a>
                                            <span></span>
                                            <div class="reply">
                                                <a href="#nogo">&nbsp;&nbsp;回复</a>
                                                <div id="shafaicon"></div>
                                                <div id="coolicon mask"></div>
                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                   
                                    <%
                                                if (feedPage) {
                                                    List<CommentEvent> comments = ce.getEventComments(0, ce.getEventCommentNum());
                                                    Iterator<CommentEvent> it = comments.iterator();
                                                    while (it.hasNext()) {
                                                        CommentEvent vce = it.next();
                                                        IUser cuser = EntityFactory.getUser(vce.getUserid());%>
                                    <li class="vcomment" id="vc<%=vce.getCommentid()%>">
                                        <a class="float" href="home.jsp?uid=<%= cuser.getUserid()%>" target="_blank">
                                            <img src="<%= cuser.getPhotoMini()%>" width="25px" height="25px" alt="photo"/>
                                        </a>
                                        <div class="float reply_byline">
                                            <a href="#nogo" class="username"><%= cuser.getName()%></a>
                                            <span><%= vce.getTime()%></span>
                                            <div class="reply">
                                                <%= vce.getComment()%>
                                                <a href="#nogo">&nbsp;&nbsp;回复</a>
                                            </div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                    <%}
                                                                        } else {
                                                                            List<VideoCommentEvent> comments = video.getComment(video.getCommentCount());
                                                                            Iterator<VideoCommentEvent> it = comments.iterator();
                                                                            while (it.hasNext()) {
                                                                                VideoCommentEvent vce = it.next();
                                                                                IUser cuser = EntityFactory.getUser(vce.getUserid());
                                    %>
                                    <li class="vcomment" id="vc<%=vce.getCommentid()%>">

                                        <div class="float reply_byline">
                                            <a class="float" href="home.jsp?uid=<%= cuser.getUserid()%>" target="_blank">
                                                <img src="<%= cuser.getPhotoMini()%>" width="25px" height="25px" alt="photo"/>
                                            </a>
                                            <a href="#nogo" class="username"><%= cuser.getName()%></a>
                                            <span><%= vce.getTime()%></span>
                                            <div class="reply">
                                                <%= vce.getComment()%>
                                                <a href="#nogo">&nbsp;&nbsp;回复</a>
                                            </div>
                                            <div id="shafaicon"></div>
                                            <div id="coolicon mask"></div>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                    <% }
                                                }%>
                                    <li class="lime">
                                        <img class="limeface" src="<%=user.getPhotoMini()%>"/>
                                        <textarea class="limekk" id="user_reply"></textarea>
                                        <div class="li140">0/140</div>
                                        <a id="reply_btn"></a>
                                        <div class="clear"></div>
                                    </li>
                                    <div class="clear"></div>
                                </ul>
                                -->
                            </div>
                            <div class="columnsb">
                                <!--<div id="discoverintro">
                                    <div class="video_discover" style="background: url('<%=collector.getPhotoSmall()%>') no-repeat scroll 0 0 transparent;">
                                        <div class="icendiscover" style="background: url('pic/ie6/icon37_2.png') no-repeat scroll 0px 0px transparent;" >
                                        </div>
                                    </div>
                                    <div id="discoverintro2">
                                        <div class="video_intro">
                                            <a class="discover_name" href="home.jsp?uid=<%= video.getFirstSubmitUserid()%>" title="<%= collector.getName()%>">
                                                <%= collector.getName()%>:
                                            </a>
                                            <div class="discover_time">
                                                (<%= video.getTime()%>)
                                            </div>
                                            <div>
                                                <%= video.getSummary()%>
                                            </div>
                                        </div>
                                    </div>
                                    <a id="discoverintro3"></a>
                                </div>
                                -->
                                <div class="column right">
                                    <div class="v_d_settop"><span>TA的其他分享</span></div>
                                    <div class="v_d_setcont">
                                        <ul>
                                            <li class="hotvideo_info">观看</li>
                                            <%
                                                        List<SubmitEvent> sl = collector.getSubmitedVideo(0, WebpageLayoutParam.NUM_OTHER_VIDEOS);
                                                        Iterator<SubmitEvent> st = sl.iterator();
                                                        while (st.hasNext()) {
                                                            IVideo v = EntityFactory.getVideo(st.next().getVideoid());
                                                            String vlink = "video.jsp?vid=" + v.getVideoid();
                                            %>
                                            <li class="columnb_hotlist_maging">
                                                <big class="hotvideo_img"><a href="<%=vlink%>"><img width=60px height=45px src="<%=v.getSnapshotURL()%>" alt=""/></a></big><big class="hotvideo_txt"><a href="<%=vlink%>"><%=v.getTitle()%></a></big><big class="hotvideo_vnum"><%=v.getWatchUserCount()%></big>
                                            </li>
                                            <%}
                                                        if (sl.size() < WebpageLayoutParam.NUM_OTHER_VIDEOS) {
                                                            List<CollectEvent> cl = collector.getCollectedVideo(0, WebpageLayoutParam.NUM_OTHER_VIDEOS - sl.size());
                                                            Iterator<CollectEvent> ct = cl.iterator();
                                                            while (ct.hasNext()) {
                                                                IVideo v = EntityFactory.getVideo(ct.next().getVideoid());
                                                                String vlink = "video.jsp?vid=" + v.getVideoid();
                                            %>
                                            <li class="columnb_hotlist_maging">
                                                <big class="hotvideo_img"><a href="<%=vlink%>"><img width=60px height=45px src="<%=v.getSnapshotURL()%>" alt=""/></a></big><big class="hotvideo_txt"><a href="<%=vlink%>"><%=v.getTitle()%></a></big><big class="hotvideo_vnum"><%=v.getWatchUserCount()%></big>
                                            </li>
                                            <%}
                                                        }%>
                                            <li class="more"><a href="../notready.jsp">更多</a></li>
                                        </ul>
                                    </div>
                                    <div class="v_d_setfommtbg"></div>
                                    <%--
                                    <div class="lisettop"><span>收藏本视频的专辑</span></div>
                                    <div class="lisetcont">
                                        <ul>
                                            <li class="maging maging_top">
                                                <big class="img">xxxx</big><big class="txt"><b>星际之王降临</b>这是我第一个视频这是我第一个视频</big>
                                            </li>
                                            <li class="maging">
                                                <big class="img">xxxx</big><big class="txt"><b>星际之王降临</b>这是我第一个视频这是我第一个视频</big>
                                            </li>
                                            <li class="more"><a href="#">更多</a></li>
                                        </ul>
                                    </div>                                    
                                    <div class="rlisetfommtbg"></div>
                                    --%>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <%@include file="jspf/footer.jspf"%>
                </div>
            </div>
        </div>
        <div id="vault" class="mask">
            <%@include file="jspf/push_frame.jspf"%>
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
                addWatchCount(video.vid);
            });
        </script>
    </body>
</html>
