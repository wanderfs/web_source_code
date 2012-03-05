<%@ page pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@page import="logic.IVideo"%>
<%@page import="logic.Video"%>
<%@page import="logic.IUser"%>
<%@page import="logic.Global"%>
<%@page import="logic.EntityFactory"%>
<%@page import="utility.Misc"%>
<%@page import="utility.Pair"%>
<%@page import="servlet.ServletCommon"%>
<%@page import="servlet.WebpageLayoutParam"%>

<div class="column" id="columnB">
    <div class="join_login">用户通道</div>
    <%@include file="loginbox.jspf"%>

    <div class="nippleBox arousedBaboon margin_top20">
        <div class="bar">
            <h4>特色</h4>	</div>
        <div class="nipple"></div>
        <div class="content">
            <div class="products">
                <ul class="dottedlist">
                    <li class="first">
                        <a href="notready.jsp" id="product_first">
                            <div class="home_icon"></div>
                            <h3>收藏视频</h3>
                            <p>在这里你可以便捷收藏众多网络视频分享网站上你所喜爱的视频并将之整理编辑为专辑</p>
                        </a>
                        <div class="clear"></div>
                    </li>
                    <li>
                        <a href="notready.jsp" id="product_second">
                            <div class="home_icon"></div>
                            <h3>订阅视频</h3>
                            <p>在这里你可以订阅爱微视个人推荐系统，友邻，视频专辑等找到喜爱却不曾观看的视频</p>
                        </a>
                        <div class="clear"></div>
                    </li>
                    <li class="last">
                        <a  href="notready.jsp" id="product_projects">
                            <div class="home_icon"></div>
                            <h3>分享视频</h3>
                            <p>在这里你可以分享喜爱的视频给世界，欢迎把视频分享到爱微视，或从这里分享到站外</p>
                        </a>
                        <div class="clear"></div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <%@include file="top5_stars.jspf"%>

</div>