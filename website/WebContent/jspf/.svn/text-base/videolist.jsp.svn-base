<%-- 
    Document   : videolist
    Created on : Aug 8, 2010, 6:38:05 PM
    Author     : senhu

    This is a JSP fragment for generating videolist
--%>

<%@page pageEncoding="UTF-8" %>

<%@page import="java.lang.Math"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.datatype.JoinChannelEvent"%>
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>

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
            if (type.equals("hot")) {
                if (alreadyHas == 0) {
                    list = user.GetHotVideo(WebpageLayoutParam.NUM_HOTLIST_ITEMS);
                } else {
                    list = user.GetMoreHotVideo(alreadyHas, WebpageLayoutParam.NUM_HOTLIST_ITEMS);
                }
            } else if (type.equals("new")) {
                if (alreadyHas == 0) {
                    list = user.GetNewVideo(WebpageLayoutParam.NUM_NEWLIST_ITEMS);
                } else {
                    list = user.GetMoreNewVideo(alreadyHas, WebpageLayoutParam.NUM_HOTLIST_ITEMS);
                }
            }

            if (list == null) {
                return;
            }
%>

<ul class="videos">
    <%
                List channellist = user.getJoinedChannel(WebpageLayoutParam.NUM_TOPLIMIT_ALBUMS);
                Iterator<JoinChannelEvent> channelit = channellist.iterator();
                int channel_num = channellist.size();
                int[] channel_id_array = new int[channel_num];
                String[] channel_name_array = new String[channel_num];
                int channel_index = 0;
                while (channelit.hasNext()) {
                    channel_id_array[channel_index] = channelit.next().getGroupid();
                    channel_name_array[channel_index] = EntityFactory.getGroup(channel_id_array[channel_index]).getName();
                    ++channel_index;
                }

                Iterator<IVideo> it = list.iterator();
                IVideo video = it.next();
                int uid = video.getFirstSubmitUserid();
                int vid = 0;
                if (video != null) {
                    vid = video.getVideoid();
    %>
    <li id='<%= "vid" + vid%>'class="videos_top lVideoItem">
        <!--<div class="digg_label">
            <div class="digg_count"><%= video.getWatchUserCount()%></div>

            <div id="share"><a href="Login.jsp" style="height:15px; width:37px;display:block;" class="share">收藏+</a></div>
        </div>-->
        <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')"><a href="#nogo" class="play">播放</a>
            <div class ="embeded_code" id='<%= "vid" + vid%>' style="display:none;"><%= video.getEmbededUrl()%></div>
        </div>
        <div class="digest">
            <div class="cancel" >×</div>
            <h3><a href="<%= "video.jsp?vid=" + vid%>" target="_blank"><%= video.getTitle()%></a></h3>
            <div class="byline">发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                <%= Misc.pastTime(video.getTime())%> 前<span style="height:15px;width:15px;"                 ></span></div>
            <div class="description"><%= video.getSummary()%></div>
            <div class="share_video_btn">
                <!--[if gte IE 6]>   <div class="share_video_btn_top"><div class="share_video_btn_tl"></div><div class="share_video_btn_tr"></div><div class="share_video_btn_tm"></div></div><![endif]--><div class="share_video_btn_mid"><!--<img src="pic/icon_act_like2125.png"   />--><strong>收藏</strong></div><!--[if gte IE 6]><div class="share_video_btn_bottom"><div class="share_video_btn_bl"></div><div class="share_video_btn_br"></div><div class="share_video_btn_bm"></div></div><![endif]-->

                <div class="dAlbumItems videolist_ai login_needed mask">
                    <ul class="uAlbumItems">
                        <%
                                            if (user != ServletCommon.nobody) {
                                                for (channel_index = 0; channel_index < channel_num; ++channel_index) {
                        %>
                        <li id ='<%= "cid" + channel_id_array[channel_index]%>' class="album_name "><a href="#nogo"><%= channel_name_array[channel_index]%></a></li>
                        <%
                                                }
                                            }
                        %>
                        <li class="create_album ">新建专辑</li>
                    </ul>
                </div>
            </div>
            <div class="stat">
                <img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  <%=video.getWatchUserCount()%>&nbsp;&nbsp;
                <span class="comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>
                    <span class="stars">
                        <%
                                            int numOfStars = (int) Math.round(video.getScore());
                        %>
                        <span class="<%=numOfStars >= 1 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 2 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 3 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 4 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 5 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                    </span>&nbsp;&nbsp;
                    <img src="pic/msg_reply.gif"/><strong>  评论  </strong>  <%=video.getCommentCount()%>
                </span>

            </div>
            <div class="clear"></div>
        </div>

        <div class="clear"></div>
    </li>
    <%}
                while (it.hasNext()) {
                    video = it.next();
                    uid = video.getFirstSubmitUserid();
                    vid = video.getVideoid();
    %>
    <li id='<%= "vid" + vid%>' class="lVideoItem">
        <!--<div class="digg_label">
            <div class="digg_count"><%= video.getWatchUserCount()%></div>

            <div id="share"><a href="Login.jsp" style="height:15px; width:37px;display:block;" class="share">收藏+</a></div>
        </div>-->
        <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')" ><a href="#nogo" class="play"></a>
            <div class ="embeded_code" id='<%= "vid" + vid%>' style="display:none;"><%= video.getEmbededUrl()%></div>
        </div>
        <div class="digest">
            <div class="cancel" >×</div>
            <h3><a href="<%= "video.jsp?vid=" + vid%> " target="_blank"><%= video.getTitle()%></a></h3>
            <div class="byline">发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                <%= Misc.pastTime(video.getTime())%> 前</div>
            <div class="description"><%= video.getSummary()%></div>

            <div class="share_video_btn">
                <!--[if gte IE 6]>   <div class="share_video_btn_top"><div class="share_video_btn_tl"></div><div class="share_video_btn_tr"></div><div class="share_video_btn_tm"></div></div><![endif]--><div class="share_video_btn_mid"><!--<img src="pic/icon_act_like2125.png"   />--><strong>收藏</strong></div><!--[if gte IE 6]><div class="share_video_btn_bottom"><div class="share_video_btn_bl"></div><div class="share_video_btn_br"></div><div class="share_video_btn_bm"></div></div><![endif]-->

                <div class="dAlbumItems videolist_ai login_needed mask">
                    <ul class="uAlbumItems">
                        <%
                                            if (user != ServletCommon.nobody) {
                                                for (channel_index = 0; channel_index < channel_num; ++channel_index) {
                        %>
                        <li id ='<%= "cid" + channel_id_array[channel_index]%>' class="album_name"><a href="#nogo"><%= channel_name_array[channel_index]%></a></li>
                        <%
                                                }
                                            }
                        %>
                        <li class="create_album ">新建专辑</li>
                    </ul>
                </div>
            </div>

            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  观看  </strong>  <%=video.getWatchUserCount()%>&nbsp;&nbsp;
                <span class="comment"><img src="pic/icon_descriptionwhite.gif" /><strong>  总评  </strong>
                    <span class="stars">
                        <%
                                            int numOfStars = (int) Math.round(video.getScore());
                        %>
                        <span class="<%=numOfStars >= 1 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 2 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 3 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 4 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                        <span class="<%=numOfStars >= 5 ? "star full" : "star"%>"><!--[if gte IE 6]><span class="ieStarText">&nbsp;</span><![endif]--></span>
                    </span>&nbsp;&nbsp;
                    <img src="pic/msg_reply.gif"/><strong>  评论  </strong>  <%=video.getCommentCount()%>
                </span>
            </div>
            <div class="clear"></div>
        </div>

        <div class="clear"></div>
    </li>
    <% }%>
</ul>