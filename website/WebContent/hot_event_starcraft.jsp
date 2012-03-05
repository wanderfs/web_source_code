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
            var page_type = "starcraft.log";
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
                            <h1>星际争霸·彼时此刻</h1>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div id="dummy" style="height: 20px;"></div>
                                <div><img alt="海报" src="http://us.blizzard.com/_images/games/sc/wallpapers/wall2/wall2-1024x768.jpg" width="620px"/></div>
                                <div class="clips_head">
                                    <span>星际争霸职业联赛</span>
                                </div>
                                <div class="clips">
                                    <ol>
                                        <li class="top">
                                            <div title="星际争霸职业联赛精选(每周更新)" class="image">
                                                <a href="home.jsp?uid=31#caid149">
                                                    <img width="125" height="94" alt="hot event" src="http://g4.ykimg.com/0100641F464C330D3F899C00DE5A4DCC899A49-9815-1865-1060-DBFCDBF71710">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=31#caid149">星际争霸职业联赛精选(每周更新)</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=31#caid149">大老虎</a>
                                            </div>
                                        </li>
                                        <li class="top">
                                            <div title="奇葩开局" class="image">
                                                <a href="home.jsp?uid=31#caid177">
                                                    <img width="125" height="94" alt="hot event" src="http://g3.ykimg.com/0100641F464D1C5FFE434D00DE5A4D3671D6CF-D119-8058-7691-96BB5E4594F9">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=31#caid177">奇葩开局</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=31#caid177">大老虎</a>
                                            </div>
                                        </li>
                                        <li class="top">
                                            <div title="生生不息，rush不止 - 从头到尾的精彩" class="image">
                                                <a href="home.jsp?uid=31#caid176">
                                                    <img width="125" height="94" alt="hot event" src="http://g1.ykimg.com/0100641F464D1C5E6019D100DE5A4D9654B78C-4B50-3239-3B63-683815CFFE33">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=31#caid176">生生不息，rush不止 - 从头到尾的精彩</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=31#caid176">大老虎</a>
                                            </div>
                                        </li>
                                        <li class="top end">
                                            <div title="光荣与梦想的时刻" class="image">
                                                <a href="home.jsp?uid=5#caid178">
                                                    <img width="125" height="94" alt="hot event" src="http://g3.ykimg.com/0100641F464D2DCCEE283200AF1D8393745703-E0A0-A621-C176-173382E6FDD0">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=5#caid178">光荣与梦想的时刻</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=5#caid178">火兵</a>
                                            </div>
                                        </li>
                                        
                                        <li class="">
                                            <div title="不可思议的翻盘" class="image">
                                                <a href="home.jsp?uid=22#caid179">
                                                    <img width="125" height="94" alt="hot event" src="http://g2.ykimg.com/0100641F464CC67DC990ED00DE5A4DA8DD90A1-1305-58C1-3C03-279454635CE9">
                                                </a>											
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=22#caid179">不可思议的翻盘</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=22#caid179">PLU.StarSen</a>
                                            </div>
                                        </li>
                                        
                                        <li class="">
                                            <div title="鏖战 - 持久的男人才能笑到最后！" class="image">
                                                <a href="home.jsp?uid=22#caid180">
                                                    <img width="125" height="94" alt="hot event" src="http://g2.ykimg.com/0100641F464D1AE1550DEC00DE5A4DFA26BC32-C238-8CF7-1A77-1E40CAAE4B3A">
                                                </a>							
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=22#caid180">鏖战 - 持久的男人才能笑到最后！</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=22#caid180">PLU.StarSen</a>
                                            </div>
                                        </li>
                                        <!--
                                        <li class="" id="clip_7">
                                            <div title="How to do Time-Lapse Photography" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event7.jpg">
                                                </a>											
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">How to do Time-Lapse Photography</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">Scott Bourne</a>
                                            </div>
                                        </li>
                                        <li class="end" id="clip_8">
                                            <div title="Steadicam DIY" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event8.jpg">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">Steadicam DIY</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">KFLeung</a>
                                            </div>
                                        </li>
                                        <li class="" id="clip_9">
                                            <div title="Depth of Field Explained (by snodart.com)" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event9.jpg">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">Depth of	Field Explained (by snodart.com)</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">NT</a>
                                            </div>
                                        </li>
                                        <li class="" id="clip_10">
                                            <div title="Jay Boy's No Budget Tutorials 03: DIY Filming Dolly With 10' Track" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event10.jpg">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">Jay Boy's No	Budget Tutorials 03: DIY Filming Dolly With 10' Track</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">j:boyd</a>
                                            </div>
                                        </li>
                                        <li class="" id="clip_11">
                                            <div title="How to make a shoebox" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event11.jpg">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">How to make a	shoebox</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">Remyyy</a>
                                            </div>
                                        </li>
                                        <li class="end" id="clip_12">
                                            <div title="Time-Lapse Tutorial" class="image">
                                                <a href="#nogo">
                                                    <img width="125" height="94" alt="hot event" src="pic/event12.jpg">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="#nogo">Time-Lapse	Tutorial</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="#nogo">Zach Wise</a>
                                            </div>
                                        </li> -->
                                    </ol>
                                    <div class="clear"></div>
                                </div>
                                <div class="clips_head">
                                    <span>剧情动画</span>
                                </div>
                                <div class="clips">
                                    <ol>
                                        <li class="top">
                                            <div title="原版动画 - 大部分人都没看过吧:-)" class="image">
                                                <a href="home.jsp?uid=22#caid181">
                                                    <img width="125" height="94" alt="hot event" src="http://g2.ykimg.com/0100641F464D1457C99C1D018B45B53D8D4C22-0009-184F-8134-E64AFB524B5A">
                                                </a>
                                            </div>
                                            <div class="title_top_first">
                                                <a href="home.jsp?uid=22#caid181">原版动画 - 大部分人都没看过吧:-)</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=22#caid181">PLU.StarSen</a>
                                            </div>
                                        </li>
                                        
                                        <li class="top">
                                            <div title="母巢之战 动画" class="image">
                                                <a href="home.jsp?uid=22#caid182">
                                                    <img width="125" height="94" alt="hot event" src="http://g4.ykimg.com/0100641F464D153CFF6158018B45B51B9E0BA8-3E92-764B-A90F-BA9B79C37CF0">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=22#caid182">母巢之战 动画</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=22#caid182">PLU.StarSen</a>
                                            </div>
                                        </li>
                                        <!--
                                        <li class="top">
                                            <div title="生生不息，rush不止 - 从头到尾的精彩" class="image">
                                                <a href="home.jsp?uid=31#caid176">
                                                    <img width="125" height="94" alt="hot event" src="http://g1.ykimg.com/0100641F464D1C5E6019D100DE5A4D9654B78C-4B50-3239-3B63-683815CFFE33">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=31#caid176">生生不息，rush不止 - 从头到尾的精彩</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=31#caid176">大老虎</a>
                                            </div>
                                        </li>-->
                                        <!--
                                        <li class="top end">
                                            <div title="光荣与梦想的时刻" class="image">
                                                <a href="home.jsp?uid=5#caid178">
                                                    <img width="125" height="94" alt="hot event" src="http://g3.ykimg.com/0100641F464D2DCCEE283200AF1D8393745703-E0A0-A621-C176-173382E6FDD0">
                                                </a>
                                            </div>
                                            <div class="title">
                                                <a href="home.jsp?uid=5#caid178">光荣与梦想的时刻</a>
                                            </div>
                                            <div class="byline">
												by&nbsp;
                                                <a href="home.jsp?uid=5#caid178">火兵</a>
                                            </div>
                                        </li>-->
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
                                                    List<HotEventInfo> comments = HotEventCommentManager.getComments("starcraft.log");
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
                                        <h4>星际争霸·彼时此刻</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <p>
                                            &nbsp;&nbsp;《星际争霸》及其资料片已经伴随我们走过了十多个年头，这段时间足够一代人慢慢成长起来，而这其中的故事则有太多太多，星际争霸已经不单单是一款游戏，他包含了我们太多的经历、情感和成长，这样一款游戏在某种程度上已经不再是一款游戏，更像是伴随我们成长的一位忠实玩伴，在带给我们欢乐的同时更留给我们众多珍贵的回忆。<br/><br/>
                                            对于大多数游戏玩家与电子竞技爱好者而言，《星际争霸》的意义早已不仅仅局限于一款游戏、一个运动。<br/><br/>
                                            她代表了一个时代；象征了一种精神；开创了一门艺术；影响了数以千万计的玩家。
                                            <br/><br/>
                                        </p>
                                    </div>
                                </div>
                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>本周发现家Top5</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div id="top5_module">
                                            <ul class="top5_ul">
                                                <li class="top5_li top5_topvideo">
                                                    <div class="top5_num">1</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="#nogo"> </a>
                                                    <div class="top5_digest">
                                                        <h3><a href="#nogo">龙之谷自由领域公会</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo">7</a></strong> 个发现视频 /
                                                            <strong><a href="#nogo">2</a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top5_li">
                                                    <div class="top5_num">2</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="#nogo"></a>
                                                    <div class="top5_digest">
                                                        <h3><a href="#nogo">烟花易冷</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo">7</a></strong> 个发现视频 /
                                                            <strong><a href="#nogo">0</a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top5_li">
                                                    <div class="top5_num">3</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="#nogo"></a>
                                                    <div class="top5_digest">
                                                        <h3><a href="#nogo">xiaomeimixiu</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo">7</a></strong> 个发现视频 /
                                                            <strong><a href="#nogo">2</a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top5_li">
                                                    <div class="top5_num">4</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="#nogo"></a>
                                                    <div class="top5_digest">
                                                        <h3><a href="#nogo">馨裕香</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo">7</a></strong> 个发现视频 /
                                                            <strong><a href="#nogo">0</a></strong> 位粉丝
                                                        </div>
                                                    </div>
                                                    <div class="clear"></div>
                                                </li>
                                                <li class="top5_li">
                                                    <div class="top5_num">5</div>
                                                    <a style="background-image: url(pic/portrait/d.48.jpg);" class="top5_thumbnail" href="#nogo"></a>
                                                    <div class="top5_digest">
                                                        <h3><a href="#nogo">manutd_jh</a></h3>
                                                        <div class="top5_stat">
                                                            <strong><a href="#nogo">6</a></strong> 个发现视频 /
                                                            <strong><a href="#nogo">0</a></strong> 位粉丝
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
