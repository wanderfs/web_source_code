<%-- 
    Document   : Group_Homepage_enter
    Created on : 2010-4-30, 19:34:14
    Author     : voenix
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


<link href="CSS/top_enter.css" rel="stylesheet" type="text/css" />
<link href="CSS/Group_Homepage_enter.css" rel="stylesheet" type="text/css" />
<link href="CSS/ie_roundrect.css" rel="stylesheet" type="text/css" />
<link href="CSS/footer.css" rel="stylesheet" type="text/css" />
<link href="CSS/tabs.css" rel="stylesheet" type="text/css" />
<link href="CSS/Left_push_video.css" rel="stylesheet" type="text/css" />
<link href="CSS/videos_hot.css" rel="stylesheet" type="text/css" />
<link href="CSS/people_groupe_sidebar.css" rel="stylesheet" type="text/css" />
</head>
<body >
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
                                                        <div id="main">

                                                        <div id="header">

	<div id="push_video">
                                                                <v:roundrect id="roundrect_push_video_form"  arcsize="0.05" fillcolor="#e6e6dc" filled="t" stroked="f">
                                                                    <form id="push_video_form" action="" method="post" >

                                                                        <v:roundrect id="roundrect_push_video_textarea" arcsize="0.4" fillcolor="#fff" filled="t" stroked="f"><textarea id="push_video_textarea" cols="" rows="" ></textarea></v:roundrect>


                                                                        <input id="push_video_btn" type=button value="" />
                                                                  </form>
                                                                </v:roundrect>
                                                        </div>
                                                        <strong>曼&nbsp;&nbsp;&nbsp;&nbsp;联</strong>

	</div>



 <div class="columns">
                                                              <div class="column" id="columnA">
                                                              <div class="tabs">
                                                                        <ul>
                                                                            <li class="active">
                                                                                <v:roundrect class="roundrect_tab_6" style="top:280px;" arcsize="0.8" fillcolor="#e6e6dc" filled="t" stroked="f" ></v:roundrect>
                                                                                <div  class="tab">小组推荐视频</div>
                                                                            </li>
                                                                            <li>
                                                                                <v:roundrect class="roundrect_tab_6" style="top:280px;" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect>
                                                                                <div  class="tab"  > 小组最新视频</div>
                                                                            </li>
                                                                            <li>
                                                                                <v:roundrect class="roundrect_tab_4" style="top:280px;" arcsize="0.8" fillcolor="rgb(244, 244, 238)" filled="t" stroked="f"></v:roundrect>
                                                                                <div  class="tab" > 小组讨论</div>
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

                                                                                        <li class="videos_top">
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                                <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                                        </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                        <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                                      </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                        <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                                    </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                        <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                                  </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                        <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                                </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                      <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                              </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                    <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                            </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                  <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                          </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                            <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                        </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                        <li>
                                                                                            <!--<div class="digg_label">
                                                                                                <div class="digg_count">99999</div>
                                                                                                <input class= "share" type="button" value="收藏+" />
                                                                                            </div>-->

                                                                                          <div class="thumbnail" style="background-image:url('http://g2.ykimg.com/0100641F464AD67C99E4CF0227C018782B3935-2224-970A-1F06-CED73C77A6D9')"></div>
                                                                                          <div class="digest">
                                                            <div class="cancel" >×</div>
                                                            <h3><a href="Video_Homepage_enter.jsp">视频标题</a></h3>
                                                            <div class="byline">来自 <a href="userHomepage_enter.jsp">收藏者</a>
                                                                999秒 前</div>
                                                            <div class="description">收藏者描述</div>
                                                            <div class="share_video_btn"><img src="pic/icon_act_like2125.png"   /><strong>收藏</strong></div>
                                                            <div class="stat"><img src="pic/icon_act_channel1010white.gif" /><strong>  9999  </strong>观看&nbsp;&nbsp;<span class="comment"><img src="pic/icon_descriptionwhite.gif" />  总评  <strong>★★★★★&nbsp;&nbsp;<img src="pic/msg_reply.gif"/>  88</strong>  评论   </span></div>
                                      </div>

                                                                                            <div class="clear"></div>
                                                                                        </li>
                                                                                    </ul>
                                                                                    <div class="next"><h2>下一批</h2></div>



                                                                                </div>
                                                                            </div>
                                                                        </div></div>

                                                              </div>

<div class="column" id="columnB">
<div class="infoBox">

		<div id="mini_logo">
			<a href="Group_Homepage_All_enter.jsp" title="爱微视小组"><img
src="pic/icon_groups_med.png"></a>
		</div>
		<div id="mini_name">
			<h1>
				<span class="group_name">曼 联</span>
			</h1>
		</div>
		<div class="clear"></div>

		<br>

		<div id="mini_stats"><a >888 个成员</a> / <a >999 个视频</a></div>

				<div class="description">
			曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述曼联小组描述...
		</div>

	</div>
    <div id="get_started">
    <div id="join_button"><span id="join_btn_span" class="faux_link" ><strong>加入这个小组</strong></span>

    </div>

    <ul class="buttons">
																<li><a href="Group_Homepage_enter.jsp">向这个<img
 src="pic/groups_icon_upload_filewhite.gif" />小组推荐视频</a></li>


			</ul>
	  <div class="clear"></div>
                                    		<br>
		<span class="faux_link" >我可以在这个小组做什么？</span>
		<ul id="can_do_list" >
			<li>
								只有小组成员才可以向小组中添加视频
			</li>
			<li>
								小组成员可以小组成员可以小组成员可以
			</li>
			<li>小组成员可以小组成员可以小组成员可以
</li>
							<li>小组成员可以小组成员可以小组成员可以
</li>
									<li>
小组成员可以小组成员可以小组成员可以			</li>
		</ul>
	</div>

    <div class="nippleBox groupsidebar">
	<div class="bar" >
		<h4>小组创建者</h4>	</div>
	<div class="nipple" ></div>
	<div class="content">
		<div class="moderator_row">
			<div class="portrait">
				<a href="userHomepage_enter.jsp"><img
src="pic/ul4594619-7575.jpg" alt="" title="wanderfs"
class="portrait"  height="75" width="75"></a>			</div>
			<div class="data">
				<a href="userHomepage_enter.jsp">wanderfs </a> - <span
class="byline"><strong>创立</strong></span><br>
				<span class="byline"><span class="date">2010 3月 加入</span></span><br>
				<a ><strong>999</strong>
个推荐视频</a> /
				<a ><strong>999</strong>
个收藏视频</a> / <br/>
				<a ><strong>999</strong>
个关注的人</a>
 /
				<a ><strong>999</strong>
粉丝</a>
			</div>
			<div class="clear"></div>
		</div>


		<div class="clear"></div>	</div>
</div>

    <div class="nippleBox groupsidebar">
	<div class="bar">
		<h4>友情小组</h4>	</div>
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

                                                                        <div class="nippleBox groupsidebar">
	<div class="bar">
		<h4>这个小组成员也喜欢去的小组</h4>	</div>
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

    <div class="nippleBox groupsidebar">
	<div class="bar" >
		<h4>广告</h4>	</div>
	<div class="nipple"></div>
	<div class="content">
		<div class="ad" id="dfp-ad-1" style="width: 300px; height: 250px;">
<img src="pic/ad.jpg" />

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