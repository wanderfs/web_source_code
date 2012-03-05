<%--
    Document   : index
    Created on : Apr 2, 2010, 1:24:49 PM
    Author     : sen
    Modify     : voenix Apr 21,2010, 17:00 beijing
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

        <link href="CSS/homepage_header_none_enter.css" rel="stylesheet" type="text/css" />
        <link href="CSS/join_login.css" rel="stylesheet" type="text/css" />
        <link href="CSS/Join_Login2.css" rel="stylesheet" type="text/css" />
        <link href="CSS/help.css" rel="stylesheet" type="text/css" />        
        <link href="CSS/footer.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="pic/tablogo_final.png" type="image/x-icon"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="colorbox/jquery.colorbox.js"></script>
        <link rel="stylesheet" href="colorbox/colorbox.css" type="text/css" media="screen" />

        <script type="text/javascript">
            var gUserid = <%= user.getUserid()%>;
            var gUsername = "<%= user.getName()%>";
        </script>

        <script src="JS/common.js" type="text/javascript"></script>
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
                            <h1>
								爱微视帮助中心
                            </h1>
                            <div id="intro">
								欢迎来到爱微视帮助中心，别着急，我们会努力解决你的所有问题。
                                <!--<img src="pic/help/white940.gif" alt="" id="wgo_topline">
								<img src="pic/help/white940.gif" alt="" id="wgo_bottomline">
							-->
                            </div>
                        </div>
                        <div class="columns">
                            <div class="column" id="columnA">
                                <div class="block">
                                    <h2 id="title_1"class="help_one">
										爱微视的那些事儿
                                    </h2>
                                    <div class="inner">
                                        <div>
											<h4 id="title_1_1">
												爱微视的诞生
                                            </h4>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												或许这就是冥冥中的命运安排，
												当一群热爱网络视频的年轻追梦者们聚到一起的时候，
												当Youtube，Facebook在美国诞生，
												当国内网络视频行业开始重振旗鼓的时候，
												这群年轻人便有了一个共同的梦想，
												而爱微视也就随之诞生了。
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												这里有必要说一下“微”的含义：
												微小，相比数以亿计的茫茫网络视频之海，
												一个小小的视频便显得多么微不足道。
												然而，微还有精妙的含义，网络中有许多优秀的视频，
												凝聚着制作者们多少心血和苦累，
												但却被埋没了，消失了。
                                            </p>
                                        </div>
                                        <div>
											<h4 id="title_1_2">
												你知道么
                                            </h4>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												互联网上有几十亿个网络视频，并且数目每天都在飞速增长。
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												互联网用户中，有80%会观看网络视频。
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												网络视频流量已经超过了所有其他网络行业的流量总和。
                                            </p>
                                        </div>
                                        <div>
											<h4 id="title_1_3">
												网络视频想说爱你不容易
                                            </h4>
                                            <p class="help_small_title">
												1.	想看视频，却不知道去哪里看!
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												你是否还在埋怨着这个网络世界太大，
												迷失在茫茫的视频海洋之中，令爱视频的你万般无奈？
												好不容易想了，却搜索不到。实在想不出吧，
												看朋友们的推荐，但感兴趣的不多，折腾半天，
												或是午休结束了，或是该熄灯睡觉了。除了无奈还是无奈...
                                            </p>
                                            <p class="help_small_title">
												2.	发布了自己制作的视频，却找不到观众!
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												网络世界鱼龙混杂，找一个臭味相投的朋友难，
												找一群，难上加难。辛辛苦苦做了大半天的视频，
												兴高采烈上传了却无人问津，没几天便沉了下去，悲剧啊...
                                            </p>
                                            <p class="help_small_title">
												3.	爱收藏整理视频，却无处可去!
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												这么多视频网站的视频都只能在本站收藏，
												更别说统一整理编辑成精选专辑了。
												优质的视频分布在各个视频网站上，
												有收藏癖的你，是否早就抓狂万分了呢？
                                            </p>
                                        </div>
                                        <div>
											<h4 id="title_1_4">
												幸好，我们有了爱微视
                                            </h4>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												爱微视是你的网络视频精选集。
												在这里你可以收藏网络上喜爱的精选视频并将其整理成专辑，
												同时你还可以通过友邻，
												频道等找到并定制众多符合自己爱好的视频。
												当然，如果你是某一个领域的专家，
												这里将成为你发布分享视频专辑从而展现自己的最好舞台。
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="block">
									<h2 class="help_two" id="title_2">
										爱微视帮助（FAQ）
                                    </h2>
                                    <div class="inner">
                                        <div>
											<h4 id="title_2_1">
												什么是视频收藏？
                                            </h4>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												偶然碰见一个自己喜欢的视频，想将它收入到你的爱微视收藏？很容易！
                                            </p>
											<p class="help_small_title" id="title_2_1_1">
												收藏视频:
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												1.	第一步，在登录爱微视状态下，
												复制你想收藏的视频所在网页地址链接即网页url（下图红色框内链接）
                                            </p>
                                            <img alt="第一步：复制网址" src="pic/help/collect_first_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												2.	在爱微视，将以上链接粘贴到爱微视收藏框中，并点击确定按钮：
                                            </p>
                                            <img alt="第二步：粘贴至收藏框" src="pic/help/collect_second_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												3.	 在点击确定后，爱微视的全网视频解析引擎便会帮你将这个视频收藏到你的爱微视。
												 在解析完毕后，点击收藏反馈框右下角的收藏按钮即可完成收藏。
												 如果你是第一个收藏该视频的人，恭喜你将成为该视频在爱微视的发现者，
												 你的大名将会出现在爱微视的该视频主页上。
												 同时，你还可以在收藏反馈框内填写你对该视频的收藏感言。
												 当然，你也可以在爱微视上看到很多别人收藏的好看视频，
												 觉得喜欢，也可以在爱微视上将其收藏。
                                            </p>
                                            <img alt="第三步：完成收藏" src="pic/help/collect_third_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												目前我们开放支持的视频网页所在网站有：
												优酷，土豆，CNTV，酷6，我乐，六间房，新浪视频。
                                            </p>
                                        </div>
                                        <div>
											<h4 id="title_2_2">
												什么是视频专辑？
                                            </h4>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												一不小心，视频收藏了一大堆，太乱了咋办？
												没事儿，你还可以建立并编辑属于自己的视频专辑。具体流程如下：
                                            </p>
											<p class="help_small_title" id="title_2_2_1">
												新建视频专辑：
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												1.	登录爱微视后，通过点击“我的主页”来到你的用户个人页面
                                            </p>
                                            <img alt="第一步：进入用户个人页面" src="pic/help/special_first_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												2.	在个人主页内，点击左侧视频专辑下拉菜单内的“新建专辑”按钮，
												或者直接点击右侧“新建专辑”按钮。
                                            </p>
                                            <img alt="第二步：新建专辑" src="pic/help/special_second_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												3.	在弹出框内输入需要新建专辑的名字后点击“新建”按钮即可完成专辑建立。
                                            </p>
                                            <img alt="第三步：输入名字，完成新建" src="pic/help/special_third_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												目前每个用户我们开放的视频专辑数目为5个
                                            </p>
											<p class="help_small_title" id="title_2_2_2">
												如何将视频加入专辑：
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												如果你已经创建了专辑，那么在收藏视频的过程中，
												当鼠标移至收藏反馈框“收藏”（或“发现”）按钮之上，
												会显示建立的专辑的下拉菜单。此时，点击对应的专辑名称，
												则可以将视频直接收藏到该专辑中。
                                            </p>
                                            <img alt="添加视频到专辑里" src="pic/help/add_video_to_special.jpg"/>
                                            <p id="title_2_2_3" class="help_small_title">
												如何查看并编辑视频专辑:
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												1.	登录爱微视后，通过点击“我的主页”来到你的用户个人页面
                                            </p>
                                            <img alt="进入用户个人页面" src="pic/help/check_first_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												2.	在个人主页内，点击左侧视频专辑下拉菜单按钮，
												便可以显示该用户的所有建立专辑。点击相应视频专辑，
												即可显示该专辑内所有视频。
                                            </p>
                                            <img alt="点击视频专辑菜单" src="pic/help/check_second_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												3.	当需要对专辑进行重命名，删除的编辑操作时，
												需要在用户主页先点击选择该视频专辑，
												然后点击“编辑这个视频专辑”按钮后，
                                            </p>
                                            <img alt="点击偏激视频专辑按钮" src="pic/help/check_third_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												即可进入视频专辑编辑页面：
                                            </p>
                                            <img alt="进入视频编辑页面" src="pic/help/check_fourth_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												目前专辑的编辑功能包括：
												重命名，删除。在完成编辑操作后，
												点击“保存所有设置”按钮后，点击“返回”按钮即可。
                                            </p>
                                        </div>
                                        <div>
											<h4 id="title_2_3">
												社区网络基本功能
                                            </h4>
											<p class="help_small_title" id="title_2_3_1">
												如何加关注：
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												在TA人主页上，点击右上角的“关注TA”按钮，即可非常方便地关注他人。
                                            </p>
                                            <img alt="点击关注TA按钮" src="pic/help/add_focus_first_step.jpg"/>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												加某人的关注后，便可以在你的爱微视登录主页的
												“友邻动态”栏里看到所关注朋友们的相关动态，
												例如：发现，收藏视频；评论或评价视频；关注其他爱微视用户等等。
                                            </p>
                                            <img alt="朋友的动态" src="pic/help/add_focus_second_step.jpg"/>
                                        </div>
                                        <div>
											<h4 id="title_2_4">
												爱微视服务
                                            </h4>
											<p class="help_small_title" id="title_2_4_1">
												什么是微视箱
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												在这里你可以发现众多你可能喜欢的火热视频！
												微视箱有每天更新的全网最火视频以及爱微视给你的量身推荐。
												还在犹豫什么，爱它就看吧
                                            </p>
											<p class="help_small_title" id="title_2_4_2">
												什么是最新收藏
                                            </p>
                                            <p>
                                                &nbsp;&nbsp;&nbsp;&nbsp;
												在这里你可以发现众多好看的最新视频！
												这里有每天实时更新的全网最新视频。更随潮流，
												看大家都在关注什么，永远不OUT！
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <div class="block">
									<h2 class="help_three" id="title_3">
										更多帮助
                                    </h2>
                                    <div class="inner">
                                        <P>
										&nbsp;&nbsp;&nbsp;&nbsp;
										基本操作和常见问题详见上文，如果您还有未解决的问题
										请与我们联系,并为您的问题提供详细的描述，我们会尽快回复您！
                                        </P>
                                    </div>
                                </div>                               
                            </div>
                            <div class="column" id="columnB">
                                <div class="nippleBox manateeCloud  instruction">
                                    <div class="bar">
                                        <h4>爱微视 帮助中心</h4>
                                    </div>
                                    <div class="nipple"></div>
                                    <div class="content">
                                        <a href="#title_1">1&nbsp;&nbsp;爱微视的那些事</a><br>
                                        <a href="#title_1_1">&nbsp;&nbsp;&nbsp;&nbsp;1.1&nbsp;&nbsp;爱微视的诞生</a><br>
                                        <a href="#title_1_2">&nbsp;&nbsp;&nbsp;&nbsp;1.2&nbsp;&nbsp;你知道么</a><br>
                                        <a href="#title_1_3">&nbsp;&nbsp;&nbsp;&nbsp;1.3&nbsp;&nbsp;网络视频想说爱你不容易</a><br>
                                        <a href="#title_1_4">&nbsp;&nbsp;&nbsp;&nbsp;1.4&nbsp;&nbsp;幸好，我们有了爱微视</a><br>
                                        <a href="#title_2">2&nbsp;&nbsp;爱微视帮助（FAQ）</a><br>
                                        <a href="#title_2_1">&nbsp;&nbsp;&nbsp;&nbsp;2.1&nbsp;&nbsp;什么是视频收藏</a><br>
                                        <a href="#title_2_1_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.1.1&nbsp;&nbsp;收藏视频</a><br>
                                        <a href="#title_2_2">&nbsp;&nbsp;&nbsp;&nbsp;2.2&nbsp;&nbsp;什么是视频专辑</a><br>
                                        <a href="#title_2_2_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.2.1&nbsp;&nbsp;新建视频专辑</a><br>
                                        <a href="#title_2_2_2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.2.2&nbsp;&nbsp;如何将视频加入专辑</a><br>
                                        <a href="#title_2_2_3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.2.3&nbsp;&nbsp;如何查看并编辑视频专辑</a><br>
                                        <a href="#title_2_3">&nbsp;&nbsp;&nbsp;&nbsp;2.3&nbsp;&nbsp;社区网络基本功能</a><br>
                                        <a href="#title_2_3_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.3.1&nbsp;&nbsp;如何加关注</a><br>
                                        <a href="#title_2_4">&nbsp;&nbsp;&nbsp;&nbsp;2.4&nbsp;&nbsp;爱微视服务</a><br>
                                        <a href="#title_2_4_1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.4.1&nbsp;&nbsp;什么是微视箱</a><br>
                                        <a href="#title_2_4_2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.4.2&nbsp;&nbsp;什么是最新收藏</a><br>
                                        <a href="#title_3">3&nbsp;&nbsp;更多帮助</a><br>
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
