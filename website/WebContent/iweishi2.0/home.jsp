<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : xiaoxiao Apr 21,2010, 17:00 beijing
--%>

<%@page import="logic.datatype.CommentEvent"%>
<%@page import="logic.IEvent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.EntityFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="logic.IVideo"%>
<%@page import="logic.IUser"%>
<%@page import="logic.IChannel"%>
<%@page import="logic.Video"%>
<%@page import="logic.User"%>
<%@page import="logic.EntityFactory"%>
<%@page import="logic.datatype.JoinChannelEvent"%>
<%@page import="java.util.Date" %>
<%@page import="logic.datatype.CollectEvent" %>
<%@page import="logic.datatype.SubmitEvent" %>
<%@page import="java.text.SimpleDateFormat;" %>
<%@page import="utility.Misc"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>
<%@page import="logic.datatype.VisitEvent" %>

<%
            IUser user = ServletCommon.getCurrentUser(session);
            IUser host;
            try {
                host = EntityFactory.getUser(Integer.parseInt(request.getParameter("uid")));
            } catch (Exception e) {
                host = user;
                if (ServletCommon.nobodyId == host.getUserid()) {
                    response.sendRedirect("index.jsp");
                }
            }

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            boolean isequal = false;
            String pro = "";
            if (user.getUserid() == host.getUserid()) {
                isequal = true;
                pro = "我";
            } else {
                pro = "TA";
                user.visit(host.getUserid());
            }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title><%=host.getName()%>的个人主页 爱微视 你的视频私生活</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视 你的视频私生活" />

        <link rel="shortcut icon" href="pic/slogo.png" type="image/x-icon"/>
        <link href="CSS/all.css" rel="stylesheet" type="text/css"/>
       
        <!--[if lte IE 6]>
        <link href="../CSS/ie6.css" rel="stylesheet" type="text/css" />
        <script src="../JS/ie6.js" type="text/javascript"></script>
        <![endif]-->

        <!--<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>-->
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>

        <script type="text/javascript">
            var hostid = "<%= host.getUserid()%>";
            var user_id = <%= user.getUserid()%>;
            var user_name = "<%= user.getName()%>";
            var user_photo_small = "<%=user.getPhotoSmall()%>";
            <% if (isequal) {%>
                var isequal = true;
            <% } else {%>
                isequal = false;
            <% }%>
        </script>

        <script src="js/tools.js" type="text/javascript"></script>
        <script src="js/all.js" type="text/javascript"></script>
    </head>

    <body class="<% if (isequal) {%>gray_background<% } else {%>gray_background_2<% }%>">
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <% if (isequal) {%>
                    <%@include file="jspf/top_home_other.jspf"%>
                    <% } else {%>
                    <%@include file="jspf/top_home.jspf"%>
                    <% }%>
                    <div id="h_d_main">
                        <div class="h_d_columns">
                            <div class="cloth"></div>
                            <div id="h_d_columnB" class="h_d_column right float_left">
                                <div id="head">
                                    <div id="headbg">                                        
                                        <div class="float_left"><div class="face" style="background-image: url('<%= host.getPhoto()%>'); "></div>
                                            <div class="head_bordertop"></div>                                            
                                            <div class="name"><%= host.getName()%></div>
                                            <% int generation = (int) ((host.getBirthday().getYear() - 1900) / 10);
                                                        String province = "";
                                                        if (host.getLocation() != null) {
                                                            province = host.getLocation().split("|")[0];
                                                        }
                                            %>
                                            <div class="info">来自<%= province%>的<%= generation%>0后<%= host.getConstellation().getChineseName()%><%= host.getGender()%>生</div>
                                        </div>
                                        <div class="head_borderleft"></div>
                                        <div class="float_left div_info portrait_text">
                                            <%
                                                        List<Integer> fr_list = host.getFollower();
                                            %>
                                            <div id="f_num" class=""><%= fr_list.size()%></div>
                                            <div class="">粉丝</div>
                                            <div id="v_num"><%= host.getSubmitedVideoNumber() + host.getCollectedVideoNumber()%></div>
                                            <div class="">视频</div>
                                            <div class="star"></div>
                                            <% if (!isequal) {
                                                            if (user.getFollowee().contains(host.getUserid())) {
                                            %>
                                            <div class="disfollowme_wrapper "><a id="disfollow_me" href="#nogo" class="followed followlogo"></a></div>
                                            <div class="followme_wrapper mask"><a id="follow_me" href="#nogo" class="follow followlogo mask"></a> </div>
                                            <% } else {%>
                                            <div class="disfollowme_wrapper mask"><a id="disfollow_me" href="#nogo" class="followed followlogo"></a></div>
                                            <div class="followme_wrapper"><a id="follow_me" href="#nogo" class="follow followlogo mask"></a> </div>
                                            <% }
                                             } else {%>
                                            <div id="edit_info" class="info_btn"><a href="user_settings.jsp" target="_blank">编辑资料</a></div>
                                            <div class="set_text">------------</div>
                                            <div id="safe_set" class="info_btn"><a href="user_settings.jsp" target="_blank">修改头像</a></div>
                                            <% }%>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                </div>
                                <div class="lisettop_box">
                                    <div class="lisettop margin_top20"><span><%= pro%>的最近来访</span></div>
                                    <div class="people45_sidebar_wrap">
                                        <div class="people45_sidebar">
                                            <%
                                                        List<VisitEvent> vlist = host.getRecentVisitors(WebpageLayoutParam.NUM_VISITORS);
                                                        Iterator<VisitEvent> vit = vlist.iterator();
                                                        SimpleDateFormat df = new SimpleDateFormat("HH:mm");

                                                        while (vit.hasNext()) {
                                                            VisitEvent ve = vit.next();
                                                            IUser visitor = EntityFactory.getUser(ve.getVisitorid());
                                            %>
                                            <div class="ps_people float_left">
                                                <div class="ps_portrait" style="background: url('<%= visitor.getPhotoSmall()%>')"></div>
                                                <div class="ps_name"><a href="home.jsp?uid=<%=visitor.getUserid()%>" target="_blank"><%= visitor.getName()%></a></div>
                                                <div class="ps_date">(<%= df.format(ve.getTime())%>)</div>
                                            </div>
                                            <% }%>
                                            <div class="clear"></div>
                                        </div>
                                    </div>
                                    <div class="rlisetfommtbg"></div>

                                    <div class="lisettop margin_top20"><span><%= pro%>的粉丝(<%= fr_list.size()%>)</span></div>
                                    <div class="people45_sidebar_wrap">
                                        <div class="people45_sidebar">
                                            <%
                                                        Iterator<Integer> feeit = fr_list.iterator();
                                                        for (int i = 0; feeit.hasNext() && i < WebpageLayoutParam.NUM_FANS; ++i) {
                                                            int feeuid = feeit.next();
                                                            IUser feeuser = EntityFactory.getUser(feeuid);
                                            %>
                                            <div class="ps_people float_left">
                                                <a href="home.jsp?uid=<%= feeuser.getUserid()%>" target="_blank"><div class="ps_portrait" style="background: url('<%= feeuser.getPhotoSmall()%>')"></div></a>
                                                <div class="ps_name"><a href="home.jsp?uid=<%= feeuser.getUserid()%>" target="_blank"><%= feeuser.getName()%></a></div>
                                            </div>
                                            <% }%>
                                            <div class="clear"></div>
                                        </div>
                                        <div class="more"><a href="#nogo" target="_blank">更多</a></div>
                                    </div>
                                    <div class="rlisetfommtbg"></div>
                                </div>
                            </div>
                            <div class="columnAwraper float_left">
                                <div class="status">
                                    <div class="status_top">
                                        <div class="status_date float_left">三天前的下午</div>
                                        <div class="status_toptext float_left"><%=pro%>是这么认为的：</div>
                                        <div class="function float_right">
                                            <a href="#nogo" class="status_all mask">所有状态</a><% if (isequal) {%><span>&nbsp;&nbsp;</span><a href="#nogo" class="status_edit">编辑签名</a> <% }%>
                                        </div>
                                        <div class="clear"></div>
                                    </div>
                                    <textarea id="ta_description" class="mask" cols="" rows="3" value=" "></textarea>
                                    <div class="ds_wrapper mask"><div id="des_save" class="float_right"><a class="save_btn" href="#nogo"></a></div><div class="clear"></div></div>
                                    <div class="status_text cursor_p"><%= host.getDescription()%></div>
                                </div>
                                <div id="h_d_columnA" class="h_d_column">
                                    <div class="tabs">
                                        <div id="collecttab" class="tab selected_tab"><%= pro%>的收藏</div>
                                        <div id="concerntab" class="closed_tab tab"><%= pro%>的关注</div>
                                        <div id="newstab" class="closed_tab tab"><%= pro%>的动态</div>
                                        <div id="messagetab" class="closed_tab tab"><%= pro%>的留言</div>
                                        <div class="clear"></div>
                                    </div>
                                    <div class="h_d_hot_video_clips">
                                        <div class="wrap">
                                            <div id="album_content" class="">
                                                <div class="mask">
                                                    <div class="function float_right">
                                                        <% if (isequal) {%><a href="#nogo" class="">新建专辑</a><span>&nbsp;|&nbsp;</span><a href="#nogo" class="">删除专辑</a><% }%>
                                                    </div>
                                                    <div class="clear"></div>
                                                </div>

                                                <div class="mniconta mask">
                                                    <ul>
                                                        <li >
                                                            <div class="licade magings">
                                                                <ul>
                                                                    <li><em>你的图片</em><span><b>我的大学生活</b><i class="txt">五字班的视频，还是有好
                                                                                多牛人啊，期待 我们自已
                                                                                的比业DV。</i></span></li>
                                                                    <li class="arrt"><i class="k">观看(1024)</i><i class="z">赞(40)</i><i class="d">订阅(100)</i></li>
                                                                </ul>
                                                            </div>
                                                            <div class="licade">
                                                                <ul>
                                                                    <li><em>你的图片</em><span><b>我的大学生活</b><i class="txt">五字班的视频，还是有好
                                                                                多牛人啊，期待 我们自已
                                                                                的比业DV。</i></span></li>
                                                                    <li class="arrt"><i class="k">观看(1024)</i><i class="z">赞(40)</i><i class="d">订阅(100)</i></li>
                                                                </ul>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div>
                                                    <div class="float_left">
                                                        <a id="my_collect" href="#nogo" class=""><%= pro%>收藏的视频</a><span>&nbsp;|&nbsp;</span><a id="my_submit" href="#nogo" class=""><%= pro%>发现的视频</a>
                                                    </div>
                                                    <% if (isequal) {%>
                                                    <div class="function float_right mask">
                                                        <a href="#nogo" class="">整理视频</a><span>&nbsp;|&nbsp;</span><a href="#nogo" class="">删除视频</a>
                                                    </div>
                                                    <% }%>
                                                    <div class="clear"></div>
                                                </div>
                                                <div id="my_submit_content" class="mask">
                                                    <%
                                                                List dvlist = host.getSubmitedVideo(0, host.getSubmitedVideoNumber());
                                                                Iterator<SubmitEvent> dvit = dvlist.iterator();
                                                                while (dvit.hasNext()) {
                                                                    IVideo dv = EntityFactory.getVideo(dvit.next().getVideoid());
                                                    %>
                                                    <div class="hv_wrapper float_left">
                                                        <div class="deleter mask"><div class="float_right deleter_bg"></div><div class="float_right">删除此视频</div><div class="clear"></div></div>
                                                        <div class="h_d_hot_video">
                                                            <%
                                                                                                                                SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
                                                            %>

                                                            <div class="collect_date">收藏日期:<%= dformat.format(dv.getTime())%></div>
                                                            <a class="display_block" href="video.jsp?vid=<%= dv.getVideoid()%>" target="_blank"><div style="background-image: url('<%= dv.getSnapshotURL()%>');" title="<%= dv.getTitle()%>" class="thumbnail"></div></a>
                                                            <div class="video_title"><a href="video.jsp?vid=<%= dv.getVideoid()%>" title="<%= dv.getTitle()%>" target="_blank"><%= dv.getTitle()%></a></div>
                                                            <div class="video_discription"></div>
                                                        </div>
                                                    </div>
                                                    <% }%>
                                                    <div class="clear"></div>
                                                </div>
                                                <div id="my_collect_content" class="">
                                                    <%
                                                                List cvlist = host.getCollectedVideo(0, host.getCollectedVideoNumber());
                                                                Iterator<CollectEvent> cvit = cvlist.iterator();
                                                                while (cvit.hasNext()) {
                                                                    IVideo cv = EntityFactory.getVideo(cvit.next().getVideoid());
                                                    %>
                                                    <div id="vid<%= cv.getVideoid()%>" class="hv_wrapper hcv_wrapper float_left">
                                                        <div class="deleter delete_cv mask"><div class="float_right deleter_bg"></div><div class="float_right">删除此视频</div><div class="clear"></div></div>
                                                        <div class="h_d_hot_video">
                                                            <div class="collect_date">收藏日期:<%= dateformat.format(cv.getTime())%></div>
                                                            <a class="display_block" href="video.jsp?vid=<%= cv.getVideoid()%>" target="_blank"><div style="background-image: url('<%= cv.getSnapshotURL()%>');" title="<%= cv.getTitle()%>" class="thumbnail"></div></a>
                                                            <div class="video_title"><a href="video.jsp?vid=<%= cv.getVideoid()%>" title="<%= cv.getTitle()%>" target="_blank"><%= cv.getTitle()%></a></div>
                                                            <div class="video_discription"></div>
                                                        </div>
                                                    </div>
                                                    <%                                                            }
                                                    %>
                                                    <div class="clear"></div>
                                                </div>
                                            </div>
                                            <div id="concern_content" class="taConcern mask">
                                                <%
                                                            List<Integer> feelist = host.getFollowee();
                                                            Iterator<Integer> frit = feelist.iterator();
                                                            while (frit.hasNext()) {
                                                                IUser fr = EntityFactory.getUser(frit.next());
                                                %>
                                                <div class="concernP_wrapper">
                                                    <div id="hid<%= fr.getUserid()%>" class="cancel_follow cf_deleter mask"><div class="float_right deleter_bg"></div><div class="float_right">取消关注</div><div class="clear"></div></div>
                                                    <div class="concernP">
                                                        <div class="person_pic" >
                                                            <a class="person_picimg" style="background: url('<%= fr.getPhotoMedium()%>') no-repeat scroll 0 0 transparent;">
                                                            </a>
                                                        </div>
                                                        <div class="person_name">
                                                            <div>
                                                                <a href="home.jsp?uid=<%= fr.getUserid()%>" target="_blank"><strong><%= fr.getName()%></strong></a>
                                                            </div>
                                                        </div>
                                                        <a class="deleteconcern">                                                            
                                                        </a
                                                        <a href="#nogo">&nbsp;</a>
                                                        <div class="Per_title">
                                                            <div></div>
                                                        </div>
                                                        <div class="Per_des">
                                                            <%
                                                                                                                            List<IEvent> fre = fr.GetMyNewEvents(1);
                                                                                                                            Iterator<IEvent> freit = fre.iterator();
                                                                                                                            while (freit.hasNext()) {
                                                                                                                                IEvent event = freit.next();
                                                                                                                                if (event instanceof CollectEvent) {
                                                                                                                                    CollectEvent ce = (CollectEvent) event;
                                                            %>
                                                            <span><%=ce.getTime()%>收藏了</span>
                                                            <a href="video.jsp?vid=<%= ce.getVideoid()%>" target="_blank"><%= EntityFactory.getVideo(ce.getVideoid()).getTitle()%></a>
                                                            <% } else if (event instanceof SubmitEvent) {
                                                                                                                                                                                                SubmitEvent se = (SubmitEvent) event;
                                                            %>
                                                            <span><%=se.getTime()%>发现了</span>
                                                            <a href="video.jsp?vid=<%= se.getVideoid()%>" target="_blank"><%= EntityFactory.getVideo(se.getVideoid()).getTitle()%></a>
                                                            <% }
                                                                                                                            }%>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </div>
                                                </div>
                                                <%

                                                            }
                                                %>                                                
                                                <div class="clear"></div>
                                            </div>
                                            <div id="news_content" class="Tanews mask">
                                                <jsp:include page="jspf/hangaround.jsp" >
                                                    <jsp:param name="type" value="me" />
                                                    <jsp:param name="hostid" value="<%=host.getUserid()%>" />
                                                    <jsp:param name="time" value="<%=new Date().getTime()%>" />
                                                </jsp:include>
                                            </div>
                                            <div id="message_content" class="Tamessage mask">
                                                <%
                                                            List<CommentEvent> celist = host.getUserComments(host.getUserCommentCount());
                                                            Iterator<CommentEvent> ceit = celist.iterator();
                                                %>
                                                <div id="hd_reply">
                                                    <div class="lime">
                                                        <a class="limeface" href="#nogo">
                                                        </a>
                                                        <textarea rows="2" class="limekk"></textarea>
                                                        <div class="li140">0/140</div>
                                                        <a id="lireplyicen" href="#nogo"></a>
                                                        <div class="linum"><%= celist.size()%>条评论</div>
                                                        <div class="clear"></div>
                                                    </div>
                                                    <%
                                                                while (ceit.hasNext()) {
                                                                    CommentEvent ce = ceit.next();
                                                                    IUser cuser = EntityFactory.getUser(ce.getUserid());
                                                    %>

                                                    <div class="lifl">
                                                        <div class="li">
                                                            <a class="float" href="#nogo">
                                                                <img src="<%= cuser.getPhotoMini()%>" width="25px" height="25px" alt="photo"/>
                                                            </a>
                                                            <div id="<%= cuser.getName()%>" class="float reply_byline">
                                                                <a href="#nogo"><%= cuser.getName()%></a>
                                                                <span><%= ce.getTime()%></span>
                                                                <div class="reply">
                                                                    <%= ce.getComment()%>
                                                                    <a class="reply_other" href="#nogo">回复</a>
                                                                </div>
                                                            </div>
                                                            <div class="clear"></div>
                                                        </div>
                                                    </div>
                                                    <% }%>                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <%@include file="jspf/footer.jspf"%>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function(){
                var url = document.location.href;
                var click_start = url.indexOf('#c');
                var click_elems = new Array();
                click_elems = url.substring(click_start + 2).split('|');
                for (var i = 0; i < click_elems.length; ++i) {
                    //alert(click_elems[i]);
                    $("#" + click_elems[i]).click();
                }
            });
        </script>
    </body>
</html>
