<%-- 
    Document   : user_settings
    Created on : 2011-3-16, 21:43:34
    Author     : Administrator
--%>

<%@page import="servlet.ServletCommon"%>
<%@page import="logic.IUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            IUser user = ServletCommon.getCurrentUser(session);
            if (user.getUserid() == ServletCommon.nobodyId) {
                response.sendRedirect("index.jsp");
            }
%>

<html>
    <head>
        <title>个人设置 爱微视 你的视频私生活</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta http-equiv="imagetoolbar" content="no" />
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7,chrome=1"/>
        <meta name="description" content="爱微视 你的视频私生活" />

        <link rel="shortcut icon" href="pic/slogo.png" type="image/x-icon"/>
        <link href="CSS/all.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.5.1.min.js"></script>
        <script src="js/user_settings.js" type="text/javascript"></script>
        <script src="js/head_last.js" type="text/javascript"></script>

        <!--[if lte IE 6]>
        <link href="../CSS/ie6.css" rel="stylesheet" type="text/css" />
        <script src="../JS/ie6.js" type="text/javascript"></script>
        <![endif]-->

    </head>
    <body class="gray_background_2">
        <div id="outer_wrap">
            <div id="inner_wrap">
                <div id="everything">
                    <div id="top_small">
                        <div id="top_bar_small">
                            <ul>
                                <li class="float_left">
                                    <a id="second_logo" title="返回首页" href="user_index.jsp"></a>
                                </li>
                                <li class="setting_title_li float_left ">
                                    <div class="setting_title fontsize24">个人账号设置</div>
                                </li>
                                <li id="s_l_tag_bar" class="float_left s_l_tag_bar">
                                    <a class="work_tag" href="user_index.jsp">首页</a>
                                    <a class="work_tag" href="filer.jsp">筛视频</a>
                                    <div class="unwork_tag">
                                        <span>秀达人</span>
                                    </div>
                                    <div class="unwork_tag">
                                        <span>爱专辑</span>
                                    </div>
                                    <div class="unwork_tag">
                                        <span>团活动</span>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </ul>
                        </div>
                        <div class="clear"></div>
                    </div>

                    <div id="us_d_main">
                        <div class="us_d_columns">
                            <div id="us_d_columnA" class="us_d_column">
                                <div class="tabs">
                                    <div id="based_info_tab" class="selected_tab tab" >基本资料</div>
                                    <div id="pw_info_tab" class="closed_tab tab">密码信息</div>
                                    <div id="modify_photo_tab" class="closed_tab tab">修改头像</div>
                                    <div class="closed_tab tab mask">个人标签</div>
                                    <div class="closed_tab tab mask">账号互通</div>
                                    <div class="clear"></div>
                                </div>
                                <div class="setting_body_wrap">
                                    <div class="us_d_wrap">
                                        <div id="based_info_headtext" class="headtext fontsize15">以下信息将显示在个人资料页里，以供大家更快的了解你！</div>
                                        <form id="based_info_form" class="" method="get" action="../uinfo" target="_blank" >
                                            <div class="cute_name">
                                                <div class="float_left cute_name_text tit">昵称</div>
                                                <div class="cute_name_area float_left">
                                                    <input class="setting_input input_text" type="text" maxlength="50" autocomplete="off"  value="<%=user.getName()%>" id="cute_name_input" name="name" />
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="location margin_top20">
                                                <div class="float_left location_text tit">所在地</div>
                                                <div class="location_province float_left margin_left_10">
                                                    <select class="setting_sel" id="province" name="province"><option ></option><option >安徽</option><option>北京</option><option>重庆</option><option>福建</option><option>甘肃</option><option >广东</option><option>广西</option><option>贵州</option><option>海南</option><option>河北</option><option>黑龙江</option><option>河南</option><option>湖北</option><option>湖南</option><option>内蒙古</option><option>江苏</option><option>江西</option><option>吉林</option><option>辽宁</option><option>宁夏</option><option>青海</option><option>山西</option><option>山东</option><option>上海</option><option>四川</option><option>天津</option><option>西藏</option><option>新疆</option><option>云南</option><option>浙江</option><option>陕西</option><option>台湾</option><option>香港</option><option>澳门</option><option>海外</option><option>其他</option></select>
                                                </div>
                                                <div class="location_city float_left margin_left_10">
                                                    <select id="city" class="setting_sel" name="city"></select>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="gender margin_top20">
                                                <div class="float_left gender_text tit">性别</div>
                                                <div class=" float_left margin_left_10">
                                                    <select class="setting_sel" id="gender" name="gender"><option>不限</option><option>男</option><option>女</option></select>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div id="datepicker" class="birthday margin_top20">
                                                <div class="float_left tit">生日</div>
                                                <div class=" float_left margin_left_10">
                                                    <select class="setting_sel" id="year" name="year">
                                                        <option value="0"></option>
                                                        <% for (int i = 1900; i < 2012; ++i) {%><option value="<%= i%>"><%= i%></option><% }%>
                                                    </select>
                                                </div>
                                                <div class="float_left lineheight30">年</div>
                                                <div class=" float_left margin_left_10">
                                                    <select class="setting_sel" id="month" name="month">
                                                        <option value="0"></option>
                                                        <% for (int i = 1; i < 13; ++i) {%><option value="<%= i%>"><%= i%></option><% }%>
                                                    </select>
                                                </div>
                                                <div class="float_left lineheight30">月</div>
                                                <div class=" float_left margin_left_10">
                                                    <select class="setting_sel" id="day" name="day">
                                                        <option value="0"></option>
                                                        <% for (int i = 1; i < 32; ++i) {%><option value="<%= i%>"><%= i%></option><% }%>
                                                    </select>
                                                </div>
                                                <div class="float_left lineheight30">日</div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="margin_top20 des">
                                                <div class="float_left des_text tit">我的签名</div>
                                                <div class=" float_left">
                                                    <textarea class="des_area" name="motto" cols="" rows="3" id="des_textarea"><%=user.getDescription()%></textarea>
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="margin_top20">
                                                <div class="save">
                                                    <a href="#nogo" id="based_info_save" class="save_btn"></a>
                                                </div>
                                            </div>
                                        </form>
                                        <div id="pw_info_headtext" class="headtext fontsize15 mask">修改密码</div>
                                        <form id="modify_pw_form" class="mask" method="get" action="../uinfo" target="_blank" >
                                            <div class="new_pw margin_top20">
                                                <div class="float_left tit">新密码</div>
                                                <div class="np_area float_left">
                                                    <input class="setting_input input_text" type="text" maxlength="50" autocomplete="off"  value="" id="np_input" name="password" />
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="new_pw_again margin_top20">
                                                <div class="float_left tit">再次输入新密码</div>
                                                <div class="npa_area float_left">
                                                    <input class="setting_input input_text" type="text" maxlength="50" autocomplete="off"  value="" id="npa_input" name="rewrite_password" />
                                                </div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="margin_top20">
                                                <div class="save">
                                                    <a href="#nogo" id="modify_pw_save" class="save_btn"></a>
                                                </div>
                                            </div>
                                        </form>
                                        <div id="modify_photo_headtext" class="headtext fontsize15 mask">选择默认头像</div>
                                        <form id="setting_photo_form" class="mask" method="get" action="../uinfo" target="_blank" >
                                            <div class="spdiv">
                                                <div id="faceA" class="photo float_left" style="background: url('pic/face/faceA45.png')"></div>
                                                <div id="faceB" class="photo float_left" style="background: url('pic/face/faceB45.png')"></div>
                                                <div id="faceC" class="photo float_left" style="background: url('pic/face/faceC45.png')"></div>
                                                <div id="faceD" class="photo float_left" style="background: url('pic/face/faceD45.png')"></div>
                                                <div id="faceE" class="photo float_left" style="background: url('pic/face/faceE45.png')"></div>
                                                <div id="faceF" class="photo float_left" style="background: url('pic/face/faceF45.png')"></div>
                                                <div id="faceG" class="photo float_left" style="background: url('pic/face/faceG45.png')"></div>
                                                <div id="faceH" class="photo float_left" style="background: url('pic/face/faceH45.png')"></div>
                                                <div id="faceI" class="photo float_left" style="background: url('pic/face/faceI45.png')"></div>
                                                <div id="faceJ" class="photo float_left" style="background: url('pic/face/faceJ45.png')"></div>
                                                <div id="faceK" class="photo float_left" style="background: url('pic/face/faceK45.png')"></div>
                                                <div id="faceL" class="photo float_left" style="background: url('pic/face/faceL45.png')"></div>
                                                <div id="faceM" class="photo float_left" style="background: url('pic/face/faceM45.png')"></div>
                                                <div id="faceN" class="photo float_left" style="background: url('pic/face/faceN45.png')"></div>
                                                <div id="faceO" class="photo float_left" style="background: url('pic/face/faceO45.png')"></div>
                                                <div id="faceP" class="photo float_left" style="background: url('pic/face/faceP45.png')"></div>
                                                <div id="faceQ" class="photo float_left" style="background: url('pic/face/faceQ45.png')"></div>
                                                <div id="faceR" class="photo float_left" style="background: url('pic/face/faceR45.png')"></div>
                                                <div id="faceS" class="photo float_left" style="background: url('pic/face/faceS45.png')"></div>
                                                <div id="faceT" class="photo float_left" style="background: url('pic/face/faceT45.png')"></div>
                                                <div id="i1face" class="photo float_left" style="background: url('pic/face/i1face45.png')"></div>
                                                <div id="i2face" class="photo float_left" style="background: url('pic/face/i2face45.png')"></div>
                                                <div id="i3face" class="photo float_left" style="background: url('pic/face/i3face45.png')"></div>
                                                <div id="i4face" class="photo float_left" style="background: url('pic/face/i4face45.png')"></div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="headtext fontsize15 border_top margin_top20">你的头像将以以下尺寸出现，请注意最小的是否清晰</div>
                                            <div class="selected_photo center margin_top20">
                                                <div id="" class="sp_160 float_left margin_left_30" style="background: url('<%=user.getPhoto()%>')"></div>
                                                <div id="" class="sp_75 float_left margin_left_30" style="background: url('<%=user.getPhotoMedium()%>')"></div>
                                                <div id="" class="sp_45 float_left margin_left_30" style="background: url('<%=user.getPhotoSmall()%>')"></div>
                                                <div id="" class="sp_25 float_left margin_left_30" style="background: url('<%=user.getPhotoMini()%>')"></div>
                                                <div class="clear"></div>
                                            </div>
                                            <div class="margin_top20">
                                                <div class="save">
                                                    <a href="#nogo" id="setting_photo_save" class="save_btn"></a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file="jspf/footer.jspf"%>
                </div>
            </div>
        </div>
    </body>
</html>
