<%--
    Document   : hangaround
    Created on : Aug 8, 2010, 5:27:46 PM
    Author     : senhu

    This is a JSP fragment for "随处看看" and "友邻动态"
--%>
<%@ page pageEncoding="UTF-8" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.IChannel"%>
<%@page import="logic.Global"%>
<%@page import="logic.IEvent"%>
<%@page import="logic.datatype.*"%>
<%@page import="logic.EntityFactory"%>
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>

<%
            IUser user = ServletCommon.getCurrentUser(session);

            int alreadyHas = 0;
            try {
                alreadyHas = Integer.parseInt(request.getParameter("already_has"));
            } catch (NumberFormatException e) {
                alreadyHas = 0;
            }

            List list = null;
            String type = request.getParameter("type");
            if (type.equals("global")) {
                if (alreadyHas == 0) {
                    list = Global.getActivity(WebpageLayoutParam.NUM_ACTIVITIES);
                } else {
                    list = Global.getMoreActivity(alreadyHas, WebpageLayoutParam.NUM_ACTIVITIES);
                }
            } else if (type.equals("mine")) {
                if (alreadyHas == 0) {
                    list = user.GetFolloweeNewEvents(WebpageLayoutParam.NUM_ACTIVITIES);
                } else {
                    list = user.GetMoreFolloweeNewEvents(alreadyHas, WebpageLayoutParam.NUM_ACTIVITIES);
                }
            } else if (type.equals("me")) {
                user = EntityFactory.getUser(Integer.parseInt(request.getParameter("hostid")));
                list = user.GetMyNewEvents(WebpageLayoutParam.NUM_ACTIVITIES);
            }

            if (list == null) {
                return;
            }

            SimpleDateFormat feed_dateformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat reply_dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            int ecount = 0;
            Iterator<IEvent> it = list.iterator();
            while (it.hasNext()) {
                IEvent event = it.next();
                if (event instanceof PostEvent) {
                    ++ecount;
                    PostEvent pe = (PostEvent) event;
                    IChannel album = EntityFactory.getGroup(pe.getGroupid());
                    IVideo video = EntityFactory.getVideo(pe.getVideoid());
                    IUser u = EntityFactory.getUser(pe.getUserid());
                    IUser submit_user = EntityFactory.getUser(video.getFirstSubmitUserid());
%>
<div class="video_clip <% if (ecount != 1) {%> not_first_clip <% }%>" id="feed<%=pe.getEventID()%>">
    <div class="left_bar">
        <div class="head_photo">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>">
                <img alt="photo" src="<%=u.getPhotoSmall()%>">
            </a>
        </div>
    </div>
    <div class="video_content" id="feed_vid<%=video.getVideoid()%>">
        <div class="title">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>"><%=u.getName()%></a>
            <span>收藏到专辑</span>
            <a target="_blank" href="home.jsp?uid=<%=pe.getUserid()%>#caid<%=pe.getGroupid()%>">[<%=album.getName()%>]</a>
            <span class="time float_right"><%=Misc.pastTime(pe.getTime())%>前</span>
            <div class="clear"></div>
        </div>
        <div class="detailwrap">
            <div class="collect_text"><%=pe.getComment()%></div>
            <div class="person_detail">

                <div class="embed_code mask"><%=video.getEmbededUrl(WebpageLayoutParam.IN_PLACE_SCREEN_WIDTH, WebpageLayoutParam.IN_PLACE_SCREEN_HEIGHT)%></div>
                <div class="video_pic">
                    <a href="#nogo">
                        <img width="120px" height="90px" src="<%=video.getSnapshotURL()%>" alt="video pic">
                    </a>
                </div>
                <div class="person_video_des">
                    <div class="video_discover_box">
                        <div class="vtitle">
                            <a target="_blank" href="video.jsp?fid=<%=pe.getEventID()%>"><%=video.getTitle()%></a>
                        </div>
                        <div>
                            <span>发现者</span>
                            <a target="_blank" href="home.jsp?uid=<%=video.getFirstSubmitUserid()%>" ><strong><%=submit_user.getName()%></strong></a>
                            <span class="time">&nbsp;&nbsp;<%= feed_dateformat.format(video.getTime())%></span>
                        </div>
                        <div class="content">
                            <span><%= video.getSummary()%></span>
                        </div>
                    </div>
                    <div class="stat">
                        <div class="play_count_img"></div>
                        <div class="float_left">观看(<%=video.getWatchUserCount()%>)</div>
                        <div class="comment_count_img"></div>
                        <div class="float_left"><a href="#nogo">评论</a><span>(<%=video.getCommentCount()%>)</span></div>
                        <a class="float_right hide_btn mask" href="#nogo"></a>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="play">
                    <a href="#nogo"></a>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <div class="comments">
            <ul>
                <%
                                    List<CommentEvent> commentlist = pe.getEventComments(0, pe.getEventCommentNum());
                                    Iterator<CommentEvent> eit = commentlist.iterator();
                                    while (eit.hasNext()) {
                                        CommentEvent ecomment = eit.next();
                                        int commentuserid = ecomment.getUserid();
                                        IUser commentuser = EntityFactory.getUser(commentuserid);
                %>
                <li id="vc<%=ecomment.getCommentid()%>">
                    <a class="float" href="#nogo">
                        <img height="25px" width="25px" src="<%=user.getPhotoMini()%>" alt="photo">
                    </a>
                    <div class="float reply_byline">
                        <a class="username" target="_blank" href="home.jsp?uid=<%= commentuserid%>"><%= commentuser.getName()%></a>
                        <span><%= reply_dateformat.format(ecomment.getTime())%></span>
                        <div class="reply">
                            <%= StringEscapeUtils.escapeHtml(ecomment.getComment())%>
                            <a href="#nogo">&nbsp;&nbsp;回复</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </li>
                <% }%>
                <li class="last_li">
                    <div>
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="reply_content long gray_border" value="添加回复">
                        </form>
                    </div>
                </li>
                <li class="last_li mask">
                    <a href="#nogo" class="float">
                        <img height="25px" width="25px" alt="photo" src="<%=user.getPhotoMini()%>">
                    </a>
                    <div class="float">
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="replying" />
                        </form>
                    </div>
                    <a class="float reply_btn" href="#nogo"></a>
                    <div class="clear"></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="right_bar">
        <div class="delete">
            <a href="#nogo"></a>
        </div>
        <div class="collect_img">
            <a href="#nogo"></a>
        </div>
        <div class="share_img">
            <a class="float_left" href="#nogo"></a>
            <div class="share_hoverbox float_left mask">
                <div class="share_hoverbox_inner">
                    <div class="innersite_share float_left">站内分享</div>
                    <div class="renren_share float_left shareclip">人人网&nbsp;&nbsp;</div>
                    <div class="tsina_share float_left shareclip">新浪微博</div>
                    <div class="tqq_share float_left shareclip">腾讯微博</div>
                    <div class="kaixin001_share float_left shareclip">开心网&nbsp;</div>
                    <div class="qzone_share float_left shareclip">QQ空间</div>
                    <div class="douban_share float_left shareclip">豆瓣&nbsp;&nbsp;&nbsp;</div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<div class="video_clip <% ++ecount; if (ecount != 1) {%> not_first_clip <% }%>">
    <div class="left_bar">
        <div class="album_photo">
            <a href="#nogo">
                <img alt="album" src="pic/playtbg.png">
            </a>
        </div>
    </div>
    <div class="video_content" id="feed_vid<%=video.getVideoid()%>">
        <div class="album_feed_title">
            <a target="_blank" href="home.jsp?uid=<%=pe.getUserid()%>#caid<%=pe.getGroupid()%>">[<%=album.getName()%>]</a>
            <span>更新了1个视频</span>
            <span class="time float_right"><%=Misc.pastTime(pe.getTime())%>前</span>
            <div class="clear"></div>
        </div>
        <div class="detail album_detail_width">
            <div class="embed_code mask"><%=video.getEmbededUrl(WebpageLayoutParam.IN_PLACE_SCREEN_WIDTH, WebpageLayoutParam.IN_PLACE_SCREEN_HEIGHT)%></div>
            <div class="video_pic">
                <a href="#nogo">
                    <img width="120px" height="90px" src="<%=video.getSnapshotURL()%>" alt="video pic">
                </a>
            </div>
            <div class="video_des">
                <div class="video_discover_box">
                        <div class="vtitle">
                            <a target="_blank" href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a>
                        </div>
                        <div>
                            <span>发现者</span>
                            <a target="_blank" href="home.jsp?uid=<%=video.getFirstSubmitUserid()%>" ><strong><%=submit_user.getName()%></strong></a>
                            <span class="time">&nbsp;&nbsp;<%= feed_dateformat.format(video.getTime())%></span>
                        </div>
                        <div class="content">
                            <span><%= video.getSummary()%></span>
                        </div>
                    </div>
                <div class="stat">
                    <div class="play_count_img"></div>
                    <div class="float_left">观看(<%=video.getWatchUserCount()%>)</div>
                    <div class="comment_count_img"></div>
                    <div class="float_left"><a href="#nogo">评论</a><span>(<%=video.getCommentCount()%>)</span></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="play">
                <a href="#nogo"></a>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <div class="right_bar">
        <div class="delete">
            <a href="#nogo"></a>
        </div>
        <div class="collect_img">
            <a href="#nogo"></a>
        </div>
        <div class="share_img">
            <a class="float_left" href="#nogo"></a>
            <div class="share_hoverbox float_left mask">
                <div class="share_hoverbox_inner">
                    <div class="innersite_share float_left">站内分享</div>
                    <div class="renren_share float_left shareclip">人人网&nbsp;&nbsp;</div>
                    <div class="tsina_share float_left shareclip">新浪微博</div>
                    <div class="tqq_share float_left shareclip">腾讯微博</div>
                    <div class="kaixin001_share float_left shareclip">开心网&nbsp;</div>
                    <div class="qzone_share float_left shareclip">QQ空间</div>
                    <div class="douban_share float_left shareclip">豆瓣&nbsp;&nbsp;&nbsp;</div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<%
                } else if (event instanceof CollectEvent) {
                    ++ecount;
                    CollectEvent e = (CollectEvent) event;
                    IVideo video = EntityFactory.getVideo(e.getVideoid());
                    IUser u = EntityFactory.getUser(e.getUserid());
                    IUser submit_user = EntityFactory.getUser(video.getFirstSubmitUserid());
                    String verb = "收藏";
                    if (submit_user.getUserid() == u.getUserid())
                        verb = "发现";
%>
<div class="video_clip <% if (ecount != 1) {%> not_first_clip <% }%>" id="feed<%=e.getEventID()%>">
    <div class="left_bar">
        <div class="head_photo">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>">
                <img alt="photo" src="<%=u.getPhotoSmall()%>">
            </a>
        </div>
    </div>
    <div class="video_content" id="feed_vid<%=video.getVideoid()%>">
        <div class="title">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>"><%=u.getName()%></a>
            <span><%=verb%>了视频</span>
            <span class="time float_right"><%=Misc.pastTime(e.getTime())%>前</span>
            <div class="clear"></div>
        </div>
        <div class="detailwrap">
            <div class="collect_text"><%=e.getComment()%></div>
            <div class="person_detail">

                <div class="embed_code mask"><%=video.getEmbededUrl(WebpageLayoutParam.IN_PLACE_SCREEN_WIDTH, WebpageLayoutParam.IN_PLACE_SCREEN_HEIGHT)%></div>
                <div class="video_pic">                    
                    <a href="#nogo">
                        <img width="120px" height="90px" src="<%=video.getSnapshotURL()%>" alt="video pic">
                    </a>
                    <%if (submit_user.getUserid() == u.getUserid()) {%>
                    <div class="video_discover_icon"></div>
                    <%}%>
                </div>
                
                <div class="person_video_des">
                    <div class="video_discover_box">
                        <div class="vtitle">
                            <a target="_blank" href="video.jsp?fid=<%=e.getEventID()%>"><%=video.getTitle()%></a>
                        </div>
                        <div>
                            <span>发现者</span>
                            <a target="_blank" href="home.jsp?uid=<%=video.getFirstSubmitUserid()%>" ><strong><%=submit_user.getName()%></strong></a>
                            <span class="time">&nbsp;&nbsp;<%= feed_dateformat.format(video.getTime())%></span>
                        </div>
                        <div class="content">
                            <span><%= video.getSummary()%></span>
                        </div>
                    </div>
                    <div class="stat">
                        <div class="play_count_img"></div>
                        <div class="float_left">观看(<%=video.getWatchUserCount()%>)</div>
                        <div class="comment_count_img"></div>
                        <div class="float_left"><a href="#nogo">评论</a><span>(<%=video.getCommentCount()%>)</span></div>
                        <a class="float_right hide_btn mask" href="#nogo"></a>
                        <div class="clear"></div>
                    </div>
                </div>
                <div class="play">
                    <a href="#nogo"></a>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

        <div class="comments">
            <ul>
                <%
                                    List<CommentEvent> commentlist = e.getEventComments(0, e.getEventCommentNum());
                                    Iterator<CommentEvent> eit = commentlist.iterator();
                                    while (eit.hasNext()) {
                                        CommentEvent ecomment = eit.next();
                                        int commentuserid = ecomment.getUserid();
                                        IUser commentuser = EntityFactory.getUser(commentuserid);
                %>
                <li id="vc<%=ecomment.getCommentid()%>">
                    <a class="float" href="#nogo">
                        <img height="25px" width="25px" src="<%=user.getPhotoMini()%>" alt="photo">
                    </a>
                    <div class="float reply_byline">
                        <a class="username" target="_blank" href="home.jsp?uid=<%= commentuserid%>"><%= commentuser.getName()%></a>
                        <span><%= reply_dateformat.format(ecomment.getTime())%></span>
                        <div class="reply">
                            <%= StringEscapeUtils.escapeHtml(ecomment.getComment())%>
                            <a href="#nogo">&nbsp;&nbsp;回复</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </li>
                <% }%>
                <li class="last_li">
                    <div>
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="reply_content long gray_border" value="添加回复">
                        </form>
                    </div>
                </li>
                <li class="last_li mask">
                    <a href="#nogo" class="float">
                        <img height="25px" width="25px" alt="photo" src="<%=user.getPhotoMini()%>">
                    </a>
                    <div class="float">
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="replying" />
                        </form>
                    </div>
                    <a class="float reply_btn" href="#nogo"></a>
                    <div class="clear"></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="right_bar">
        <div class="delete">
            <a href="#nogo"></a>
        </div>
        <div class="collect_img">
            <a href="#nogo"></a>
        </div>
        <div class="share_img">
            <a class="float_left" href="#nogo"></a>
            <div class="share_hoverbox float_left mask">
                <div class="share_hoverbox_inner">
                    <div class="innersite_share float_left">站内分享</div>
                    <div class="renren_share float_left shareclip">人人网&nbsp;&nbsp;</div>
                    <div class="tsina_share float_left shareclip">新浪微博</div>
                    <div class="tqq_share float_left shareclip">腾讯微博</div>
                    <div class="kaixin001_share float_left shareclip">开心网&nbsp;</div>
                    <div class="qzone_share float_left shareclip">QQ空间</div>
                    <div class="douban_share float_left shareclip">豆瓣&nbsp;&nbsp;&nbsp;</div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<% } else if (event instanceof RateEvent) {
                    ++ecount;
                    RateEvent re = (RateEvent) event;
                    IVideo video = EntityFactory.getVideo(re.getVideoid());
                    IUser u = EntityFactory.getUser(re.getUserid());
                    IUser submit_user = EntityFactory.getUser(re.getUserid());
%>
<div class="video_clip <% if (ecount != 1) {%> not_first_clip <% }%>" id="feed<%=re.getEventID()%>">
    <div class="left_bar">
        <div class="head_photo">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>">
                <img alt="photo" src="<%=u.getPhotoSmall()%>">
            </a>
        </div>
    </div>
    <div class="video_content" id="feed_vid<%=video.getVideoid()%>">
        <div class="title">
            <a target="_blank" href="home.jsp?uid=<%=u.getUserid()%>"><%=u.getName()%></a>
            <span>觉得这个很赞</span>
            <span class="time float_right"><%=Misc.pastTime(re.getTime())%>前</span>
            <div class="clear"></div>
        </div>
        <div class="detail person_detail_width">
            <div class="embed_code mask"><%=video.getEmbededUrl(WebpageLayoutParam.IN_PLACE_SCREEN_WIDTH, WebpageLayoutParam.IN_PLACE_SCREEN_HEIGHT)%></div>
            <div class="video_pic">
                <a href="#nogo">
                    <img width="120px" height="90px" src="<%=video.getSnapshotURL()%>" alt="video pic">
                </a>
            </div>
            <div class="video_des">
                <div class="video_discover_box">
                        <div class="vtitle">
                            <a target="_blank" href="video.jsp?fid=<%=re.getEventID()%>"><%=video.getTitle()%></a>
                        </div>
                        <div>
                            <span>发现者</span>
                            <a target="_blank" href="home.jsp?uid=<%=video.getFirstSubmitUserid()%>" ><strong><%=submit_user.getName()%></strong></a>
                            <span class="time">&nbsp;&nbsp;<%= feed_dateformat.format(video.getTime())%></span>
                        </div>
                        <div class="content">
                            <span><%= video.getSummary()%></span>
                        </div>
                    </div>
                <div class="stat">
                    <div class="play_count_img"></div>
                    <div class="float_left">观看(<%=video.getWatchUserCount()%>)</div>
                    <div class="comment_count_img"></div>
                    <div class="float_left"><a href="#nogo">评论</a><span>(<%=video.getCommentCount()%>)</span></div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="play">
                <a href="#nogo"></a>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="comments">
            <ul>
                <%
                                    List<CommentEvent> commentlist = re.getEventComments(0, re.getEventCommentNum());
                                    Iterator<CommentEvent> eit = commentlist.iterator();
                                    while (eit.hasNext()) {
                                        CommentEvent ecomment = eit.next();
                                        int commentuserid = ecomment.getUserid();
                                        IUser commentuser = EntityFactory.getUser(commentuserid);
                %>
                <li id="vc<%=ecomment.getCommentid()%>">
                    <a class="float" href="#nogo">
                        <img height="25px" width="25px" src="<%=user.getPhotoMini()%>" alt="photo">
                    </a>
                    <div class="float reply_byline">
                        <a class="username" target="_blank" href="home.jsp?uid=<%= commentuserid%>"><%= commentuser.getName()%></a>
                        <span><%= reply_dateformat.format(ecomment.getTime())%></span>
                        <div class="reply">
                            <%= StringEscapeUtils.escapeHtml(ecomment.getComment())%>
                            <a href="#nogo">&nbsp;&nbsp;回复</a>
                        </div>
                    </div>
                    <div class="clear"></div>
                </li>
                <% }%>
                <li class="last_li">
                    <div>
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="reply_content long gray_border" value="添加回复">
                        </form>
                    </div>
                </li>
                <li class="last_li mask">
                    <a href="#nogo" class="float">
                        <img height="25px" width="25px" alt="photo" src="<%=user.getPhotoMini()%>">
                    </a>
                    <div class="float">
                        <form method="post" action="reply" >
                            <input type="text" name="reply_content" class="replying" />
                        </form>
                    </div>
                    <a class="float reply_btn" href="#nogo"></a>
                    <div class="clear"></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="right_bar">
        <div class="delete">
            <a href="#nogo"></a>
        </div>
        <div class="collect_img">
            <a href="#nogo"></a>
        </div>
        <div class="share_img">
            <a class="float_left" href="#nogo"></a>
            <div class="share_hoverbox float_left mask">
                <div class="share_hoverbox_inner">
                    <div class="innersite_share float_left">站内分享</div>
                    <div class="renren_share float_left shareclip">人人网&nbsp;&nbsp;</div>
                    <div class="tsina_share float_left shareclip">新浪微博</div>
                    <div class="tqq_share float_left shareclip">腾讯微博</div>
                    <div class="kaixin001_share float_left shareclip">开心网&nbsp;</div>
                    <div class="qzone_share float_left shareclip">QQ空间</div>
                    <div class="douban_share float_left shareclip">豆瓣&nbsp;&nbsp;&nbsp;</div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
</div>
<%
                } else if (event instanceof UserRelationEvent) {
                    UserRelationEvent ur = (UserRelationEvent) event;
                    IUser fer = EntityFactory.getUser(ur.getFollowerid());
                    IUser fee = EntityFactory.getUser(ur.getFolloweeid());
                }
            }
%>

<div class="mask">
    <li id="vc_template">
        <a class="float" href="#nogo">
            <img height="25px" width="25px" src="pic/face/faceA25.png" alt="photo">
        </a>
        <div class="float reply_byline">
            <a class="username" target="_blank" href=""></a>
            <span></span>
            <div class="reply">

                <a href="#nogo">&nbsp;&nbsp;回复</a>
            </div>
        </div>
        <div class="clear"></div>
    </li>
</div>
