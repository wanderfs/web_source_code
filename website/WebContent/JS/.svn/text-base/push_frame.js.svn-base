/*  
 * defines the push_frame behavior in each page that contains push frame.
 */

/* global constants */

var SUBMIT_BEFORE = -1;
var SUBMIT_URL_ERROR = -2;
var SUBMIT_SUCCESS = -3;
var SUBMIT_UNKNOWN_ERROR = -4;

var CONFIRM_SUCCESS = 1000;
var CONFIRM_PREEMPTED = 1001;
var CONFIRM_TIMEOUT = 1002;
var COLLECT_SUCCESS = 1003;

var VIDEO_SUMMARY = "为何收藏它，写点什么吧。。。";
var VIDEO_COMMENT = "点击添加评论。。。";

var NOGO = "#nogo";
var UNDEFINED = "undefined";
var video_site_id;

$(document).ready(function() {

    var clear_usertext;

    $("#show_push_frame").click(function() {

        if (!checkLogin()) return false;
        
        $.colorbox({
            inline: true,
            href:           "#push_frame_mask",
            opacity:        0.5,
            scrolling:      false,
            innerWidth:     640,
            innerHeight:    160,
            onLoad:     function() {
                $("#push_frame_mask > div").addClass("mask");
                $("#push_frame_loading").removeClass("mask");
                clear_usertext = true;
            },
            onComplete: parseVideo
        });
    });

    $("#pushbtn_usertalk").click(function(e){
        if(clear_usertext) {
            $(this).val("");
            clear_usertext = false;
        }
    });

    $("#push_frame_cancel").click(function(){
        $.colorbox.close();
    });

    $(".closebtn").click(function(){
        $.colorbox.close();
    });

    
    $("div.dAlbumItems.confirm_ai > ul.uAlbumItems > li.album_name").live("click", function(){
        var videoid = 0;
        var channelid = $(this).attr("id").substring(3);
        var clicked_sharebtn = $(this).parents("div.share_video_btn");

        if ($(".pushbtn_frame_content > div.thumbnail > a").attr("href") == NOGO){
            confirmVideo(channelid, clicked_sharebtn);
        } 
        else {
            videoid = $(".pushbtn_frame_content > div.thumbnail > a").attr("href").substring(14);
            postVideoToAlbum(videoid, channelid, clicked_sharebtn);
        }
        slideupSharebtn(clicked_sharebtn);
    });
    //push frame's tabs
    var tabs = $("#pushbtn_frame > div.pushbtn_tabs > ul > li");
    tabs.click(function(e){
        tabs.removeClass("active");
        $(this).addClass("active");
    });
});

function parseVideo() {
    $.get("submitvideo", {
        service: "0", //stands for submission request
        videourl: $("#push_video_textarea").val(),
        uid: gUserid
    },
    function(xml){
        //var string = (new XMLSerializer()).serializeToString(xml);
        //alert(string);
        var status = $(xml).find("status").text();

        if (status == SUBMIT_BEFORE || status == SUBMIT_SUCCESS) {

            video_site_id = $(xml).find("siteid").text();
            var thumbnail = $(xml).find("thumbnail").text();
            var title = $(xml).find("title").text();
            var user, userid, vlink, vtitle, info_text;
            
            if (status == SUBMIT_SUCCESS) {
                user = gUsername;
                userid = gUserid;
                info_text = "您将是此视频的发现者<img alt=\"发现者\" src=\"pic/icon_groups_mini.png\" />";
                $("#pushbtn_text").text("发现");
                $("#pushbtn_usertalk").val(VIDEO_SUMMARY).data("vid", "-1");  // negative values means vid not usable
                vlink = "#nogo";
                vtitle = "确认后，这里就指向视频主页哦:-)";

            } else {
                user = $(xml).find("user").text();
                userid = $(xml).find("userid").text();
                var time = $(xml).find("time").text();
                var vid = $(xml).find("vid").text();

                info_text = "<a href=\"home.jsp?uid=" + userid + "\">" + user + "</a>在" + time + "前发现了这个视频，您可以收藏它<img alt=\"收藏者\" src=\"pic/icon_act_like.gif\" width=\"20px\" height=\"20px\"/>";
                $("#pushbtn_text").text("收藏");
                $("#pushbtn_usertalk").val(VIDEO_COMMENT).data("vid", vid);
                vlink = "video.jsp?vid=" + vid;
                vtitle = "点击前往此视频的主页:-)";
            }
            
            $(".pushbtn_frame_content > div.thumbnail").css("background-image", "url('" + thumbnail + "')");
            $(".pushbtn_frame_content > div.thumbnail > a").attr("href", vlink);
            $(".pushbtn_frame_content > div.digest > h3 > a").html(title).attr("href", vlink).attr("title", vtitle);
            $(".pushbtn_frame_content > div.digest > div.byline > a").html(user).attr("href", "home.jsp?uid=" + userid);
            $("#info_text").html(info_text);
            $("#push_frame_ok").removeClass("shared");
            $("#push_frame_ok > div.share_video_btn_mid").bind("click", confirmVideo);  // enable confirmation button
            $("#push_frame_success").removeClass("mask");

            //FireFox album name epllisize and add complete album name to the title attribute
            if ($.browser.mozilla)
            {
                $("div.dAlbumItems").removeClass("mask");
                $("div.dAlbumItems > ul.uAlbumItems > li.album_name").textOverflow();
                $("div.dAlbumItems").addClass("mask");
            }
        /*
            $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").data("album_complete_name", $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").text());
            $("div.dAlbumItems").removeClass("mask");
            $("div.dAlbumItems > ul.uAlbumItems > li.album_name").textOverflow();
            $("div.dAlbumItems").addClass("mask");
            var EPLLISIS_THREEDOTS = "...";
            var album_name = $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").text();
            var album_name_length = album_name.length;
            alert($("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").text());
            alert($("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").text().substring($("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").length - 3, $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").length));
            if ($("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").text().substring($("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").length - 3, $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").length) == EPLLISIS_THREEDOTS)
            {
                alert("a");
                $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").attr("title", $("div.dAlbumItems > ul.uAlbumItems > li.album_name > a").data("album_complete_name"));
            }
            */
        } else if(status == SUBMIT_URL_ERROR) {
            $("#push_frame_error").removeClass("mask");
        } else if(status == SUBMIT_UNKNOWN_ERROR) {
            alert("未知错误！");
        } else {
            alert("unknow status code: " + status);
        }

        $("#push_frame_loading").addClass("mask");
        $.colorbox.resize({
            transition: "elastic"
        });
    });
}

function confirmVideo(channelid, clicked_sharebtn){
    if ($.browser.msie)
    {
        slideupSharebtn($(this).parent("div#push_frame_ok"));
    }
    $("#push_frame_ok").addClass("shared");
    var old_text = $("#pushbtn_text").text();
    $("#pushbtn_text").text("已" + old_text);
    var usertalk = $("#pushbtn_usertalk").val();
    if(usertalk == VIDEO_SUMMARY || usertalk == VIDEO_COMMENT)
        usertalk = "";
    $.post("submitvideo", {
        service: "1", //stands for submission confirmation
        usertext: usertalk,
        siteid: video_site_id,
        uid: gUserid,
        vid: $("#pushbtn_usertalk").data("vid")
    },
    function(xml){
        //var string = (new XMLSerializer()).serializeToString(xml);
        //alert(string);
        var status = $(xml).find("status").text();
        // forbid multiple confirmations
        $("#push_frame_ok  > div.share_video_btn_mid").unbind("click", confirmVideo);
        if (status == CONFIRM_SUCCESS) {
            $("#info_text").html("您已成功成为此视频的发现者<img alt=\"发现者\" src=\"pic/icon_groups_mini.png\" />");
            var vid = $(xml).find("videoid").text();
            var vlink = "video.jsp?vid=" + vid;
            var vtitle = "点击前往此视频的主页:-)";
            $(".pushbtn_frame_content > div.digest > h3 > a").attr("href", vlink).attr("title", vtitle);
            $(".pushbtn_frame_content > div.thumbnail > a").attr("href", vlink);
            if (channelid != null && clicked_sharebtn != null) {
                postVideoToAlbum(vid, channelid, clicked_sharebtn);
            }
        } else if (status == COLLECT_SUCCESS) {
            $("#info_text").html("您已成功收藏了此视频<img alt=\"收藏者\" src=\"pic/icon_act_like.gif\" width=\"20px\" height=\"20px\"/>");
            $(this).addClass("shared");
        } else if (status == CONFIRM_TIMEOUT) {
            $("#info_text").html("对不起, 提交已超时，请重新来过~");
        } else if (status == CONFIRM_PREEMPTED) {
            $("#info_text").html("这个错误……是不该出现的呀！");
        }        
    });
}
