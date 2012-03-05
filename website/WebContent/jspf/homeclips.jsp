<%-- 
    Document   : home_clips
    Created on : Aug 9, 2010, 1:38:30 PM
    Author     : senhu

    This is the JSF for videolist in home.jsp. This is different from the list
    in other webpages because it doesn't have "收藏" button and "发现者" label.
--%>

<%@ page pageEncoding="UTF-8" %>

<%@page import="java.lang.Math"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.datatype.*"%>
<%@page import="logic.AD"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.IChannel"%>
<%@page import="logic.EntityFactory"%>
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>

<%
            // this user is the host of the page. NOT the viewer.
            IUser user = EntityFactory.getUser(Integer.parseInt(request.getParameter("uid")));
            int viewer_id = ServletCommon.getCurrentUser(session).getUserid();

            log("homeclips.jsp " + user.toString());
            String type = request.getParameter("type");
            int from = 0;
            if (request.getParameter("from") != null) {
                from = Integer.parseInt(request.getParameter("from"));
            }
            boolean showImporter = true;
            boolean hasInlineAd = false;
            boolean showEditAd = false;
            IChannel channel = null;
            List list = null;
            AD ad = null;
            boolean first_time = true;

            if (type.equals("collected")) {
                list = user.getCollectedVideo(from * WebpageLayoutParam.NUM_COLLECTED_VIDEOS, WebpageLayoutParam.NUM_COLLECTED_VIDEOS);
            } else if (type.equals("imported")) {
                list = user.getSubmitedVideo(from * WebpageLayoutParam.NUM_IMPORTED_VIDEOS, WebpageLayoutParam.NUM_IMPORTED_VIDEOS);
                showImporter = false;  // importer is the page host.
            } else if (type.equals("watched")) {
                list = user.getWatchedVideo(from * WebpageLayoutParam.NUM_WATCHED_VIDEOS, WebpageLayoutParam.NUM_WATCHED_VIDEOS);
            } else if (type.equals("albumvideos")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                channel = EntityFactory.getGroup(cid);
                list = channel.getPosts(from * WebpageLayoutParam.NUM_ALBUMVIDEOS, WebpageLayoutParam.NUM_ALBUMVIDEOS);
                if (channel.getAds().iterator().hasNext()) {
                    ad = channel.getAds().iterator().next();
                    hasInlineAd = true;
                }
                if (request.getParameter("first_time") != null) {
                    first_time = false;
                }
                if (from == 0 && first_time) {
%>
<div id="daid<%= cid%>"class="albumvideos videos_content <%= "cid"+cid%>">
    <!--[if gte IE 6]><div class="video_meat_top"><div class="video_meat_top_tl"></div><div class="video_meat_top_tr"></div><div class="video_meat_tm"></div></div><![endif]-->
    <div class="videos_meat">
        <div class="clips">
            <div style="background-color: rgb(242, 245, 195); -moz-border-radius: 10px 10px 10px 10px;" class="softcorner native obiwan">
                <div class="nipple"></div>
                <div class="myonlyhope vimeo">
                    <% if (user.getUserid() == viewer_id) {
                        showEditAd = true;
                        }
                    %>
                    <div class="title"><%=channel.getName()%></div>
                    <p><%=ServletCommon.nullStringFilter(channel.getDescription())%></p>
                    <div class="undertaker">×</div>
                </div>
            </div>
            <%  }
            }else {
                return;
            }
            %>

            <ul class="videos">
                <%
                            int ad_row_idx = 2; // insert ad row when this value is 0
                            IVideo video = null;
                            Date time = null;
                            int uid = 0;
                            Iterator it = list.iterator();
                            if (it.hasNext()) {
                                --ad_row_idx;
                                if (type.equals("collected")) {
                                    CollectEvent ce = (CollectEvent) it.next();
                                    video = EntityFactory.getVideo(ce.getVideoid());
                                    time = ce.getTime();
                                    uid = video.getFirstSubmitUserid();
                                } else if (type.equals("imported")) {
                                    SubmitEvent se = (SubmitEvent) it.next();
                                    video = EntityFactory.getVideo(se.getVideoid());
                                    time = se.getTime();
                                    uid = se.getUserid();
                                } else if (type.equals("watched")) {
                                    WatchEvent we = (WatchEvent) it.next();
                                    video = EntityFactory.getVideo(we.getVideoid());
                                    time = we.getTime();
                                    uid = video.getFirstSubmitUserid();
                                } else if (type.equals("albumvideos")) {
                                    PostEvent pe = (PostEvent) it.next();
                                    video = EntityFactory.getVideo(pe.getVideoid());
                                    time = pe.getTime();
                                    uid = video.getFirstSubmitUserid();
                                }
                %>
                <li class="videos_top lVideoItem">
                    <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')"><a href="#nogo" class="play">播放</a>
                        <div class ="embeded_code" id='<%= "vid" + video.getVideoid()%>' style="display:none;"><%= video.getEmbededUrl()%></div>
                    </div>
                    <div class="digest">
                        <div class="cancel" >×</div>
                        <h3><a target="_blank" href="<%= "video.jsp?vid=" + video.getVideoid()%>"><%= video.getTitle()%></a></h3>
                        <div class="byline">
                            <%
                                                if (showImporter) {
                            %>
                            发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                            <%}%>
                            <%= Misc.pastTime(time)%> 前
                        </div>
                        <div class="description"><%= video.getSummary()%></div>
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
                                if (ad_row_idx == 0 && (hasInlineAd || showEditAd)) {
                    %>
                                <li class="lVideoItem">
                                    <div style="font-size:30px;
                                                height:40px;
                                                text-align:center;
                                                background-image:url('pic/inlineAdBg.jpg');
                                                -moz-border-radius: 5px;-webkit-border-radius: 5px;">
                                        <%
                                        if (!hasInlineAd && showEditAd) { // case when no ad
                                        %>
                                        插入免费专辑广告，点<a id="newAlbumAd" href="#NOGO">这里</a>。
                                        <%} else {%>
                                        <a target="_blank" href="<%=ad.getUrl()%>"><%=ad.getText()%></a>
                                        <% if (showEditAd) {%>
                                        <span style="font-size:15px;"> <a id="newAlbumAd" href="#NOGO"> 更换</a></span>
                                        <%}}%>
                                    </div>
                                </li>
                                <%}
                                --ad_row_idx;
                                if (type.equals("collected")) {
                                    CollectEvent ce = (CollectEvent) it.next();
                                    video = EntityFactory.getVideo(ce.getVideoid());
                                    time = ce.getTime();
                                    uid = video.getFirstSubmitUserid();
                                } else if (type.equals("imported")) {
                                    SubmitEvent se = (SubmitEvent) it.next();
                                    video = EntityFactory.getVideo(se.getVideoid());
                                    time = se.getTime();
                                    uid = se.getUserid();
                                } else if (type.equals("watched")) {
                                    WatchEvent we = (WatchEvent) it.next();
                                    video = EntityFactory.getVideo(we.getVideoid());
                                    time = we.getTime();
                                    uid = video.getFirstSubmitUserid();
                                } else if (type.equals("albumvideos")) {
                                    PostEvent pe = (PostEvent) it.next();
                                    video = EntityFactory.getVideo(pe.getVideoid());
                                    time = pe.getTime();
                                    uid = video.getFirstSubmitUserid();
                                }
                %>
                <li class="lVideoItem">
                    <div class="thumbnail" style="background-image:url('<%= video.getSnapshotURL()%>')" ><a href="#nogo" class="play"></a>
                        <div class ="embeded_code" id='<%= "vid" + video.getVideoid()%>' style="display:none;"><%= video.getEmbededUrl()%></div>
                    </div>
                    <div class="digest">
                        <div class="cancel" >×</div>
                        <h3><a target="_blank" href="<%= "video.jsp?vid=" + video.getVideoid()%>"><%= video.getTitle()%></a></h3>
                        <div class="byline">
                            <%
                                                if (showImporter) {
                            %>
                            发现者 <a href="home.jsp?uid=<%=uid%>"><%= EntityFactory.getUser(uid).getName()%></a>
                            <%}%>
                            <%= Misc.pastTime(time)%> 前
                        </div>
                        <div class="description"><%= video.getSummary()%></div>
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
                                <img alt ="评论" src="pic/msg_reply.gif"/><strong>  评论  </strong>  <%=video.getCommentCount()%>
                            </span>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div class="clear"></div>
                </li>
                <% }%>
            </ul>
            <% if (type.equals("albumvideos") && from == 0 && first_time) {
            %>

            <div class="pagination ">
                <ul>
                    <%
                         int pages = ServletCommon.pagination(channel.getPostNumber(), WebpageLayoutParam.NUM_ALBUMVIDEOS);
                    %>
                    <li class="arrow"><a><img alt="previous" src="pic/page_arrow_prev_on.gif"/></a></li>
                    <li class="selected"><a>1</a></li>
                    <% int i = 1;
             while (i < pages && i < WebpageLayoutParam.NUM_PAGES) {%>
                    <li><a  href="#nogo"><%= ++i%></a></li>
                    <%}
             if (i < pages) {%>
                    <li class="dots">...</li>
                    <li><a  href="#nogo"><%=pages%></a></li>
                    <%}
                    %>
                    <li class="arrow"><a  href="#nogo"><img alt="next" src="pic/page_arrow_next_on.gif" /></a></li>
                    <div class="clear"></div>
                </ul>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!--[if gte IE 6]> <div class="video_meat_bottom"><div class="video_meat_bottom_bl"><img src="pic/blvideocontentroundedcorners.png" /></div><div class="video_meat_bottom_br"></div><div class="video_meat_bottom_bm"></div></div><![endif]-->
</div>
<% }%>