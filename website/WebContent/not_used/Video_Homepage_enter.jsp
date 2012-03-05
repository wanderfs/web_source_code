<%-- 
    Document   : Video_Homepage_enter
    Created on : 2010-4-30, 19:45:59
    Author     : xiaoxiao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >

    <head>
        <title>爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视是视频集散地..." />

        <link rel="stylesheet" type="text/css" media="all" href="CSS/top_enter.css" />

        <link href="CSS/ie_roundrect.css" rel="stylesheet" type="text/css" />

        <link href="CSS/video_homepage_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/bottom.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">

                    <div id="top">
                        <a id="logo" href="HomepageUserenter.jsp">爱微视<span >iweishi</span></a>
                  <div id="newmenudo">
                            <div id="capright" class="menudo_image"></div>
                    <ul id="nav" class="grandpappy">
                                <li class="firstborn search" id="menudo_search_subtier">
                                    <div class="rounded_input">
                                        <div class="contain menudo_image">
                                            <form  action method="get" >
                                                <input name="search" id="menudo_search_field" value="搜索人" class="field" autocomplete="off" maxlength="50"
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
                                                                    <a href="Group_Homepage_All_enter.jsp">小组</a>
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
						<a href="userHomepage_enter.jsp">我的主页</a>
						 <div class="left_shoulder menudo_image"></div>
                                                                    <div class="right_shoulder menudo_image"></div>
					</li>
                    <li><a href="Group_Homepage_All_enter.jsp">我的小组</a></li>
                    <li><a href="attention_and_fans_enter.jsp">我的友邻</a></li>
                    <li><a href="user_settings.jsp">我的设置</a></li>
				 <li class="last danger">
                                                                    <a href="index.jsp">退出</a>

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
					<a href="userHomepage_enter.jsp" class="label">我</a>
				</div>
			</li>
                                                        <li class="firstborn">
                                                            <a class="label" href="HomepageUserenter.jsp" rel="nofollow">首页</a>
                                                        </li>
                    </ul><div id="capleft" class="menudo_image"></div>
                    <div class="clear"></div>
                  </div>
                  </div>

                    <v:roundrect id="roundrect_cap" arcsize="0.5" fillcolor="#fff" filled="t" stroked="f"></v:roundrect>
                    <div id="cap" ></div>
                    <div id="header">

                        

                        <div class="rightside">
                            <div class="title">视频标题</div>
                            <div class="byline">发现者:<a href="userHomepage_enter.jsp"><img src="pic/littleul4594619-5.jpg" /> Wanderfs </a></div>
                            <div class="date">

                                <span id="clip-date" >2天前: 2010.03.20 22:00pm
                                </span>
                            </div>
                        </div>

                        <div class="clear"></div>

                    </div>
                    <div id="main">
                        <div id="grid" class="columns">
                            <div id="columnA" class="column">


                                <div class="softcorner native" style=" -moz-border-radius: 10px 10px 10px 10px;">
                                    <div id="module">
                                        <div class="video_background_black">
                                            <div id="clip"><div class="video_holder"><div style="" class="player" ><div
                                                            class="swf_holder"
                                                            >

                                                          <embed type="application/x-shockwave-flash"
                                                                   src="http://player.youku.com/player.php/sid/XNzc4MTE4Njg=&isAutoPlay=false/v.swf"   quality="high"
                                                                   allowscriptaccess="always" allowfullscreen="true" scalemode="showAll"
                                                                   wmode="opaque"
                                                                   height="450" width="100%"></div></div></div></div>

                                            <div id="details">
                                                <ul>
                                                    <li id="judge" ><span
                                                            class="faux_link" ><img
                                                                src="pic/icon_description.gif" alt=""><strong> 总评 </strong> <span class="star">★★★★</span> </span></li>
                                                                <li class="look"><span class="faux_link" ><img src="pic/play.gif" alt="" /> <strong
                                                                id="looks_count">9999</strong> 人观看</span></li>
                                                    <li class="likes"><img src="pic/icon_likes.gif" alt=""> <strong
                                                                id="likes_count">9999</strong> 人收藏</li>
                                                    <li class="comments"><span class="faux_link" ><img src="pic/icon_comments.gif"
                                                                                                       alt=""> <strong id="comments_count">9999</strong> 人评论</span></li>

                                                    <li class="comments"><span class="faux_link" > <strong >我的评价 </strong>★★★★★</span></li>
                                                    <li class="share_video"><div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div></li>
                                                    <div class="clear"></div>
                                                </ul>

                                                <div class="clear"></div>
                                            </div>
                                        </div>
                                        <div class="description_container">
                                            <div id="description">
    		    视频介绍
                                            </div>

                                        </div>
                                        <div class="columnAson">


                                            <div class="columnAB">


                                                <ul class="comments" id="comments_10314280">
                                                    <li class="parent first"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论. </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>


                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论. </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply"> <a href="userHomepage_enter.jsp"><img src="pic/ul4594619-5050.jpg" alt="" title="wanderfs"
                                                                                                              class="portrait"  /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 9 小时以前</div>
                                                            <div class="text">用户回复</div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply"> <a href="userHomepage_enter.jsp"><img src="pic/ul4594619-5050.jpg" alt="" title="wanderfs"
                                                                                                              class="portrait"  /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 9 小时以前</div>
                                                            <div class="text">用户回复<br />
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论</div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                    <li class="parent"> <a href="userHomepage_enter.jsp"> <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" /></a>
                                                        <div class="rightside">
                                                            <div class="name"><a href="userHomepage_enter.jsp">wanderfs</a> 99 小时以前 </div>
                                                            <div class="text">用户评论 </div>
                                                        </div>
                                                        <div class="clear"></div>
                                                    </li>
                                                    <li class="reply_controls">
                                                        <div class="controls">
                                                            <div class="replylink"> <a > <img src="pic/msg_reply.gif" alt="+" style="position:
                                                                                              relative; top: 3px;" /> 回复</a> </div>

                                                        </div>
                                                    </li>
                                                </ul>

                                                <div id="new_comment_10314280" class="new_comment">
                                                    <img src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
                                                                                                                class="portrait"  height="75" width="75" />
                                                    <div class="isay"><strong>添加新评论</strong></div>
                                                    <form id="frmNewComment">
                                                        <textarea id="new_comment_text" name="text"></textarea>
                                                        <br />
                                                        <input class="button blue_button" id="new_comment_btn_10314280"
                                                               value="   确    定  " type="button" />

                                                    </form>
                                                </div>
                                            </div>
                                            <div class="clear"></div>
                                        </div>

                                    </div>
                                </div>



                            </div>

                            <div id="columnB" class="column">
                                <div class="video_stuff">
                                    <div id="context_browser_1">



                                        <div class="brozar">
                                            <div class="tabs" >

                                                <div id="brozar_tab_more_off"
                                                     class="softcorner native" style="background-color: rgb(231, 231, 222);
                                                     -moz-border-radius-topleft: 8px; -moz-border-radius-topright: 8px;">
	相关内容视频</div>
                                                <div id="brozar_tab_add_on"
                                                     class="softcorner native" style="background-color: rgb(244, 244, 238);
                                                     -moz-border-radius-topleft: 8px; -moz-border-radius-topright: 8px;" >
                                                    <span class="faux_link" >相关收藏视频</span></div>
                                                <div class="clear"></div>
                                            </div>




                                            <div  class="more">
                                                <div class="context">

                                                    <a  class="see_all">全部</a>

                                                   




                                                    <div class="clear"></div>
                                                </div>
                                                <div class="softcorner native scrolly_container"
                                                     style="background-color: rgb(255, 255, 255); -moz-border-radius: 10px
                                                     10px 10px 10px;">

                                                    <div class="scrolly_area" style="width: 260px; height: 293px;">
                                                        <div class="content" style="width: 248px; height: 293px; overflow: hidden;">
                                                            <div >
                                                                <div id="brozar_current_clip" class="clip current">
                                                                    <div class="style_wrap" >

                                                                        <img src="pic/26744652_100.jpg" alt="">
                                                                            <div class="info" style="width: 128px;">
                                                                                <span class="index">999.</span> 视频标题<div
                                                                                    class="byline">来自 <a href="userHomepage_enter.jsp">视频标题李四王麻子</a></div>
                                                                                <div class="time">99 秒以前</div>
                                                                            </div>
                                                                            <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="clip">
                                                                    <div class="style_wrap" >
                                                                        <a href="Video_Homepage_enter.jsp" title="视频标题" >

                                                                            <img src="pic/26744652_100.jpg" alt="">
                                                                        </a>
                                                                        <div class="info" style="width: 130px;">
                                                                            <span class="index">998.</span> <a href="Video_Homepage_enter.jsp" title="视频标题" >视频标题</a>				<div class="byline">来自 <a
                                                                                    href="userHomepage_enter.jsp">视频标题李四王麻子</a></div>
                                                                            <div class="time">9 天以前</div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="clip">
                                                                    <div class="style_wrap" >
                                                                        <a href="Video_Homepage_enter.jsp" title="视频标题" >

                                                                            <img src="pic/26744652_100.jpg" alt="">
                                                                        </a>
                                                                        <div class="info" style="width: 130px;">
                                                                            <span class="index">997.</span> <a href="Video_Homepage_enter.jsp" title="视频标题" >视频标题</a>				<div class="byline">来自 <a
                                                                                    href="userHomepage_enter.jsp">视频标题李四王麻子</a></div>
                                                                            <div class="time">9 天以前</div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                                <div class="clip">
                                                                    <div class="style_wrap" >
                                                                        <a href="Video_Homepage_enter.jsp" title="视频标题" >

                                                                            <img src="pic/26744652_100.jpg" alt="">
                                                                        </a>
                                                                        <div class="info" style="width: 130px;">
                                                                            <span class="index">996.</span> <a
                                                                                "Video_Homepage_enter.jsp" title="视频标题" >视频标题</a>				<div class="byline">来自 <a
                                                                                    href="userHomepage_enter.jsp">视频标题李四王麻子</a></div>
                                                                            <div class="time">9 天以前</div>
                                                                        </div>
                                                                        <div class="clear"></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="scrolly swf_holder" style="height: 100%;"><embed
                                                                type="application/x-shockwave-flash" src="swf/scrolly.swf"
                                                                bgcolor="#ffffff" quality="medium" allowscriptaccess="always"
                                                                wmode="transparent" scalemode="showAll"

                                                                height="100%" width="12"></div>
                                                        <div class="clear"></div>
                                                    </div>


                                                </div>	</div></div></div>			</div>
                                <div class="clear"></div>
                                <div class="nippleBox abrahamLincoln">
                                    <div class="bar">
                                        <h4>最新收藏此视频的用户</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div class="profile_contacts">
                                            <ul>

                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                                <li><a href="userHomepage_enter.jsp"><img src="pic/395802_48.jpg" alt=""
                                                                                           title=" " >张三</a></li>
                                              </ul>

                                            <div class="clear"></div><p class="all"><a ><strong>全部</strong></a></p>
                                        </div>	</div>
                                </div>

                                <div class="nippleBox organicFritos">
                                    <div class="bar">
                                        <h4>收藏此视频的用户常去的小组</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div class="profile_contacts">
                                            <ul>

                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                                <li><a href="Group_Homepage_enter.jsp"><img src="pic/g18337-1.jpg" alt=""
                                                                                             title=" ">曼联</a></li>
                                              </ul>
                                            <div class="clear"></div>
                                            <p class="all"><a href="Group_Homepage_All_enter.jsp"><strong>全部</strong></a></p>
                                        </div>	</div></div>

                                

                                <div class="nippleBox ">
                                    <div class="bar">
                                        <h4>广告</h4>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                                                            <div class="ad" id="dfp-ad-1" style="width: 300px; height: 250px;">
<img src="pic/1727490.jpg" />

                                                                            </div>	</div>
                                </div>

                                <div class="nippleBox arousedBaboon">
                                    <div class="bar">
                                        <h4>此视频数据</h4><a class="toggle" title="以图画形式查看"><img
                                                src="pic/icon_clipstats_graph_off.gif"  alt=""></a><a title="以表格形式查看" class="toggle"
                                                                                              ><img src="pic/icon_clipstats_chart_on.gif" alt=""></a>	</div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <div id="stats">
                                            <div id="user_stats">
                                                <table id="spreadsheet" class="spreadsheet">
                                                    <thead>
                                                        <tr>
                                                            <th class="date">时间</th>
                                                            <th class="total_plays">播放</th>
                                                            <th class="likes">收藏</th>
                                                            <th class="comments">评论</th>
                                                        </tr>
                                                    </thead>
                                                    <tfoot>
                                                        <tr>
                                                            <td>总数</td>
                                                            <td>0</td>
                                                            <td>0</td>
                                                            <td>0</td>
                                                        </tr>
                                                    </tfoot>
                                                    <tbody>
                                                        <tr class="alt">
                                                            <td class="date">三月 13<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="date">三月 12<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr class="alt">
                                                            <td class="date">三月 11<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="date">三月 10<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr class="alt">
                                                            <td class="date">三月 9<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr>
                                                            <td class="date">三月 8<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                        <tr class="alt">
                                                            <td class="date">三月 7<sup>日</sup></td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                            <td class="grey">0</td>
                                                        </tr>
                                                    </tbody>
                                                </table>

                                                <div id="graph" style="display: none;">
                                                    <ul>
                                                        <li class="plays">
                                                            <div id="plays_sparkline" class="sparkline"><canvas height="20"
                                                                                                                width="93" style="display: inline-block; width: 93px; height: 20px;
                                                                                                                vertical-align: top;"></canvas></div>
                                                            <p><var>0</var>Plays</p>
                                                        </li>
                                                        <li class="likes">
                                                            <div id="likes_sparkline" class="sparkline"><canvas height="20"
                                                                                                                width="93" style="display: inline-block; width: 93px; height: 20px;
                                                                                                                vertical-align: top;"></canvas></div>
                                                            <p><var>0</var>Likes</p>
                                                        </li>
                                                        <li class="last comments">
                                                            <div id="comments_sparkline" class="sparkline"><canvas height="20"
                                                                                                                   width="93" style="display: inline-block; width: 93px; height: 20px;
                                                                                                                   vertical-align: top;"></canvas></div>
                                                            <p><var>0</var>Comments</p>
                                                        </li>
                                                    </ul>

                                                    <div class="clear"></div>

                                                    <p class="date">Sun Mar 7, 2010 – Sat Mar 13, 2010</p>
                                                </div>

                                                <div id="stats_pager">
                                                    <a  rel="nofollow" style="float: left;" >
                                                        <img src="pic/browser_arrow_left_off.gif" alt="">上周
                                                    </a>


                                                    <div class="clear"></div>
                                                </div>

                                            </div>


                                            <p><a ><strong>全部数据</strong></a></p>
                                        </div>	</div>
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
             style="position: fixed; z-index: 20; top: 45px; right: -60px;"
             id="cloud"
             src="pic/land_cloud.gif"><img
             style="top: 322px;" id="cloud2"
             src="pic/land_cloud2.gif">
    </body>
</html>