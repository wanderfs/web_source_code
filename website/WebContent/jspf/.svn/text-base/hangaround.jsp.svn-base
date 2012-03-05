<%-- 
    Document   : hangaround
    Created on : Aug 8, 2010, 5:27:46 PM
    Author     : senhu

    This is a JSP fragment for "随处看看" and "友邻动态"
--%>
<%@ page pageEncoding="UTF-8" %>

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
    if (alreadyHas == 0)
        list = Global.getActivity(WebpageLayoutParam.NUM_ACTIVITIES);
    else
        list = Global.getMoreActivity(alreadyHas, WebpageLayoutParam.NUM_ACTIVITIES);
} else if (type.equals("mine")) {
    if (alreadyHas == 0)
        list = user.GetFolloweeNewEvents(WebpageLayoutParam.NUM_ACTIVITIES);
    else
        list = user.GetMoreFolloweeNewEvents(alreadyHas, WebpageLayoutParam.NUM_ACTIVITIES);
}

if (list == null) return;
%>
            <ul class="log" >
                <%
                            Iterator<IEvent> it = list.iterator();
                            while (it.hasNext()) {
                                IEvent event = it.next();
                                if (event instanceof SubmitEvent) {
                                    SubmitEvent se = (SubmitEvent) event;
                                    IVideo video = EntityFactory.getVideo(se.getVideoid());
                                    IUser u = EntityFactory.getUser(se.getUserid());
                             %>
                                    <li class="action">
                                        <div class="icon"><img src="pic/icon_groups_header.gif" /></div>
                                        <div class="thumb_clip"><a href="video.jsp?vid=<%=video.getVideoid()%>">
                                                <img src="<%=video.getSnapshotURL()%>" height="60" width="80"/></a></div>
                                        <div class="thumb_user">
                                            <a href="home.jsp?uid=<%=se.getUserid()%>">
                                                <img src="<%=u.getPhotoSmall()%>" title="<%=u.getName()%>" height="30" width="30"/>
                                            </a>
                                        </div>
                                        <div class="text discover_text">
                                            <div class="message"><a href="home.jsp?uid=<%=se.getUserid()%>" ><strong><%=u.getName()%></strong></a><span class="time"> <%=Misc.pastTime(se.getTime())%> 前</span></div>
                                            <div class="message"> 发现了视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>


                                <%
                                } else if (event instanceof PostEvent) {
                                    PostEvent pe = (PostEvent)event;
                                    IChannel album = EntityFactory.getGroup(pe.getGroupid());
                                    IVideo video = EntityFactory.getVideo(pe.getVideoid());
                                    IUser u = EntityFactory.getUser(pe.getUserid());
                                %>
                                <li class="action">
                                        <div class="icon"><img src="pic/icon_act_album.gif" /></div>
                                        <div class="thumb_clip"><a href="video.jsp?vid=<%=pe.getVideoid()%>">
                                                <img src="<%=video.getSnapshotURL()%>" height="60" width="80"/></a></div>
                                        <div class="thumb_user">
                                            <a href="home.jsp?uid=<%=u.getUserid()%>">
                                                <img src="<%=u.getPhotoSmall()%>" title="<%=u.getName()%>" height="30" width="30"/>
                                            </a>
                                        </div>
                                        <div class="text">
                                            <div class="message"><a href="home.jsp?uid=<%=pe.getUserid()%>" ><strong><%=u.getName()%></strong></a><span class="time"> <%=Misc.pastTime(pe.getTime())%> 前</span></div>
                                            <div class="message"> 把视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong>放入了专辑 <strong><a href="home.jsp?uid=<%=pe.getUserid()%>#caid<%=pe.getGroupid()%>"><%=album.getName()%></a></strong></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                <%
                                } else if (event instanceof RateEvent) {
                                    RateEvent re = (RateEvent)event;
                                    IVideo video = EntityFactory.getVideo(re.getVideoid());
                                    IUser u = EntityFactory.getUser(re.getUserid());
                                %>
                                    <li class="action">
                                        <div class="icon"><img src="pic/icon_act_upload.gif" /></div>
                                        <div class="thumb_clip"><a href="video.jsp?vid=<%=video.getVideoid()%>">
                                                <img src="<%=video.getSnapshotURL()%>" height="60" width="80"/></a></div>
                                        <div class="thumb_user">
                                            <a href="home.jsp?uid=<%=re.getUserid()%>">
                                                <img src="<%=u.getPhotoSmall()%>" title="<%=u.getName()%>" height="30" width="30"/>
                                            </a>
                                        </div>
                                        <div class="text">
                                            <div class="message"><a href="home.jsp?uid=<%=re.getUserid()%>" ><strong><%=u.getName()%></strong></a><span class="time"> <%=Misc.pastTime(re.getTime())%> 前</span></div>
                                            <div class="message"> 评价了视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                 <%
                                 } else if (event instanceof UserRelationEvent) {
                                      UserRelationEvent ur = (UserRelationEvent)event;
                                      IUser fer = EntityFactory.getUser(ur.getFollowerid());
                                      IUser fee = EntityFactory.getUser(ur.getFolloweeid());
                                  %>
                                    <li class="action">
                                          <div class="icon"><img src="pic/icon_act_tag.gif"/></div>
                                          <div class="thumb_clip"><a href="home.jsp?uid=<%=fee.getUserid()%>">
                                                  <img src="<%=fee.getPhoto()%>" alt=""   style="margin-left:20px;width:60px;height:60px;" height="60" width="80"/></a></div>
                                          <div class="thumb_user">
                                              <a href="home.jsp?uid=<%=fer.getUserid()%>">
                                                  <img src="<%=fer.getPhotoSmall()%>" title="<%=fer.getName()%>" height="30" width="30"/></a></div>
                                          <div class="text">
                                              <div class="message"><a href="home.jsp?uid=<%=fer.getUserid()%>"><strong><%=fer.getName()%></strong></a><span class="time"> <%=Misc.pastTime(ur.getTime())%> 前</span></div>
                                              <div class="message"> 关注了 <a href="home.jsp?uid=<%=fee.getUserid()%>"><strong><%=fee.getName()%></strong></a></div>
                                          </div>
                                          <div class="clear"></div>
                                      </li>

                                <%
                                } else if (event instanceof VideoCommentEvent) {
                                    VideoCommentEvent vc = (VideoCommentEvent)event;
                                    IVideo video = EntityFactory.getVideo(vc.getVideoid());
                                    IUser commenter = EntityFactory.getUser(vc.getUserid());
                                %>
                                    <li class="action">
                                        <div class="icon"><img src="pic/icon_act_comment_forum.gif"/></div>
                                        <div class="thumb_clip"><a href="video.jsp?vid=<%=video.getVideoid()%>">
                                            <img src="<%=video.getSnapshotURL()%>" height="60" width="80"/></a></div>
                                        <div class="thumb_user">
                                            <a href="home.jsp?uid=<%=commenter.getUserid()%>"><img src="<%=commenter.getPhotoSmall() %>" alt="" title="" height="30" width="30" /></a></div>
                                        <div class="text">
                                            <div class="message"><a href="home.jsp?uid=<%=commenter.getUserid()%>"><strong><%=commenter.getName()%></strong></a><span class="time"> <%=Misc.pastTime(vc.getTime())%> 前</span></div>
                                            <div class="message"> 评论了视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                <%
                                } else if (event instanceof VideoRelation) {

                                %>
                                <%
                                } else if (event instanceof WatchEvent) { 
                                    WatchEvent we = (WatchEvent)event;
                                    IVideo video = EntityFactory.getVideo(we.getVideoid());
                                    IUser u = EntityFactory.getUser(we.getUserid());
                                %>
                                    <li class="action">
                                        <div class="icon"><img src="pic/icon_act_channel.gif"/></div>
                                        <div class="thumb_clip"><a href="video.jsp?vid=<%=video.getVideoid()%>">
                                            <img src="<%=video.getSnapshotURL()%>" alt="" height="60" width="80" /></a></div>
                                        <div class="thumb_user">
                                            <a href="home.jsp?uid=<%=u.getUserid()%>">
                                                <img src="<%=u.getPhotoSmall() %>" alt="<%=u.getName()%>" title="<%=u.getName()%>" height="30" width="30" />
                                            </a>
                                        </div>
                                        <div class="text">
                                            <div class="message"><a href="home.jsp?uid=<%=u.getUserid()%>"><strong><%=u.getName()%></strong></a><span class="time"> <%=Misc.pastTime(we.getTime())%> 前</span></div>
                                            <div class="message"> 观看了视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong></div>
                                        </div>
                                        <div class="clear"></div>
                                    </li>
                                <%
                                } else if (event instanceof CollectEvent) {
                                    CollectEvent ce = (CollectEvent)event;
                                    IVideo video = EntityFactory.getVideo(ce.getVideoid());
                                    IUser u = EntityFactory.getUser(ce.getUserid());
                                %>
                                <li class="action">
                                    <div class="icon"><img src="pic/icon_act_like.gif"/></div>
                                    <div class="thumb_clip"><a href="video.jsp?vid=<%=video.getVideoid()%>">
                                            <img src="<%=video.getSnapshotURL()%>"  alt="" height="60" width="80" /></a></div>
                                    <div class="thumb_user">
                                        <a href="home.jsp?uid=<%=u.getUserid()%>">
                                            <img src="<%=u.getPhotoSmall() %>" alt="<%=u.getName()%>" title="<%=u.getName()%>" height="30" width="30" />
                                        </a>
                                    </div>
                                    <div class="text">
                                        <div class="message"><a href="home.jsp?uid=<%=u.getUserid()%>"><strong><%=u.getName()%></strong></a><span class="time"> <%=Misc.pastTime(ce.getTime())%> 前</span></div>
                                        <div class="message"> 收藏了 <strong><a href="home.jsp?uid=<%=video.getFirstSubmitUserid()%>"><%=video.getFirstSubmitUserid()%> </a></strong>发现的视频 <strong><a href="video.jsp?vid=<%=video.getVideoid()%>"><%=video.getTitle()%></a></strong></div>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                                <%}
                            }
                            %>
            </ul>
        
