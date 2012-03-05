/*=== GLOBAL FUNCTIONS BEGIN ===*/
function msgbox(msg) {
    alert(msg);
}

function doShare(webid, url, title) {
    $("#jia_webid").val(webid);
    $("#jia_url").val(url);
    $("#jia_title").val(title);
    $("form#share").submit();

    // determine content type based on url.
    var vid = url.match(/video\.jsp\?vid=([0-9]+)/)[1];
    if (vid == null) return;

    $.get("../sharestat", {
        type:   "video",
        sns:    webid,
        id:     vid
    });
}

// increase watch count
function addWatchCount(videoId) {
    $.get("../vcs", {
        action: "watch",
        vid: videoId
    },
    function(xml) {
        var status = $(xml).find("status").text();
        if (status != "OK") {
            msgbox("观看点击错误！");
        }
    });
}

// change browser url on the fly
function urlAnchorTo(tagId) {
    var url = document.location.href;
    var idx = url.indexOf('#c');
    if (idx != -1)
        url = document.location.href.substring(0, idx);

    url = url.replace(/#nogo/i, ""); // remove extra tags.

    if ($("#" + tagId).length > 0)
        document.location.href = url + "#c" + tagId;
    //alert(document.location.href);
}

// check if a reply is empty. e.g. in the form of empty string "" or "回复XXX："
function checkEmptyReply(reply) {
    if ((reply.substring(0, 2) == "回复" && reply.match(/回复.+：.+/) == null)
        || reply == "") {
        return true;
    } else return false;
}
/*=== GLOBAL FUNCTIONS END ===*/

/*=== LOGIN & JOIN BOX BEGIN ===*/
function enableLoginJoinBox() {
    $("input#input_email").change(function() {
        // check input ($(this).val()) for validity here
        if ($(this).val().indexOf('@') == -1) {
            $("form#join").data("validate", false);
            $("#join_email > .email_wrong").text("邮箱格式错误").show();
            $("#join_email").removeClass("red_long_bg")
            .removeClass("red_long_right_bg")
            .addClass("red_long_wrong_bg");
            return;
        }
        $.getJSON("../ufeed", {
            email: $(this).val()
            }, function(json) {
            if (json.result == "none") {
                $("#join_email > .email_wrong").hide();
                $("#join_email").removeClass("red_long_bg")
                .removeClass("red_long_wrong_bg")
                .addClass("red_long_right_bg");
            } else {
                $("#join_email > .email_wrong").text("该邮箱已被注册").show();
                $("#join_email").removeClass("red_long_bg")
                .removeClass("red_long_right_bg")
                .addClass("red_long_wrong_bg");
            }
        })
    });

    $("input#show_password").select(function() {
        $(this).hide();
        $("input#input_password").show().focus();
    });

    $("input#input_password").change(function() {
        if ($(this).val().length < 6 || $(this).val().length > 16) {
            $("#join_password > .pw_wrong").show();
            $("#join_password").removeClass("red_mid_bg")
            .removeClass("red_mid_right_bg")
            .addClass("red_mid_wrong_bg");
        } else {
            $("#join_password > .pw_wrong").hide();
            $("#join_password").removeClass("red_mid_bg")
            .removeClass("red_mid_wrong_bg")
            .addClass("red_mid_right_bg");
        }
    });

    $("#login_link").click(function() {
        $("#join_link").removeClass("active");
        $("#login_link").addClass("active");

        $("form#login").show();
        $("form#join").hide();

        $("#login_head").css("background-color", "#A9D339");
    });

    $("#join_link").click(function() {
        $("#login_link").removeClass("active");
        $("#join_link").addClass("active");

        $("form#join").show();
        $("form#login").hide();

        $("#login_head").css("background-color", "#fc575e");
    });

    $("form#join").submit(function() {
        var icode = $("input#input_invite_code").val();
        if (icode == null || icode == "") {
            msgbox("对不起，内测阶段需要邀请码才能注册。");
            return false;
        }

        var email = $("input#join_email").val();
        if(email.indexOf("@") == -1) {
            msgbox("邮箱格式无法识别。");
            return false;
        }

        if($("input#tos", "form#join").attr("checked") == false) {
            msgbox("还未同意用户条例。");
            return false;
        }
        return true;
    });
}
/*=== LOGIN & JOIN BOX END ===*/

/*=== ROLLING FEED BOX BEGIN ===*/
var feed_arr = [];

function head_auto_feed() {
    if (feed_arr.length < 3) {
        $.getJSON("../gfeed", {fn: 5}, function(json) {
            $.each(json.feed, function(i, feed) {
                feed_arr.push(feed);
            });
        });
    }
}

function head_auto_fill() {
    if (feed_arr.length ==0) return;
    var feed = feed_arr.shift();
    $.getJSON("../ufeed", {
        uid: feed.uid
    }, function(uinfo) {
        $.getJSON("../vfeed", {
            vid: feed.vid
        }, function(vinfo) {
            var feedDiv = $("#head_feed > .head_video_inner");
            feedDiv.fadeOut("slow", function() {
                feedDiv.find(".head_photo > a > img").attr("src", uinfo.photo_small);
                feedDiv.find("a.user_name").text(uinfo.name)
                                           .attr("href", "home.jsp?uid=" + uinfo.uid);
                feedDiv.find(".video_pic > a").attr("href", "video.jsp?vid=" + vinfo.vid)
                       .find("img").attr("src", vinfo.thumbnail);
                feedDiv.find("a.video_name").text(vinfo.title)
                                            .attr("href", "video.jsp?vid=" + vinfo.vid);
                feedDiv.find("a.submitter").text(vinfo['submitter-name'])
                                           .attr("href", "home.jsp?uid=" + vinfo.submitter);
                feedDiv.find(".content > span").text(vinfo.summary);
                feedDiv.find(".play > a").attr("href", "video.jsp?vid=" + vinfo.vid);
                feedDiv.find("span.time").text(feed.ago + "前");
                feedDiv.find(".submit_time").text(" " + vinfo.time.split(" ")[0]);
                feedDiv.find(".play_count").text("观看(" + vinfo['watch-count'] + ")");
                feedDiv.find(".comment_count").text("(" + vinfo['comment-count'] + ")");
                feedDiv.find(".collect_text").text(feed.comment);
                switch (feed['class-name']) {
                    case "SubmitEvent":
                        feedDiv.find(".title > span.act").text("发现了");
                        feedDiv.find(".collect_text").text("");
                        feedDiv.find("a.album_name").hide();
                        break;
                    case "CollectEvent":
                        feedDiv.find(".title > span.act").text("收藏了");
                        feedDiv.find("a.album_name").hide();
                        break;
                    case "PostEvent":
                        feedDiv.find(".title > span.act").text("收藏到专辑");
                        feedDiv.find("a.album_name").text("[" + feed['album-name'] + "]").show();
                        break;
                    default:
                        break;
                }
                feedDiv.fadeIn("slow");
            });
        });
    });
}

function enableRollingFeedBox() {
    setInterval("head_auto_feed()", 10000);
    setInterval("head_auto_fill()", 10000);
}
/*=== ROLLING FEED BOX END ===*/

/*=== FEEDLIST BEGIN ===*/
function enableFeedList() {
    $("input.reply_content").live("click", function() {
        var li = $(this).parents(".last_li");
        var reply_li = li.next();
        li.hide();
        reply_li.show();
        $("input.replying", reply_li).val("")
                                     .data("respondee", -1) // no respondee
                                     .data("pcid", -10) // no parent comment id
                                     .focus();
    });

    $("div.intro").live("click", function() {
        var li = $(this).nextAll("div.comments").find("ul > li.last_li:first");
        var reply_li = li.next();
        li.hide();
        reply_li.show();
        $("input.replying", reply_li).val("")
                                     .data("respondee", -1) // no respondee
                                     .data("pcid", -10) // no parent comment id
                                     .focus();
    });

    $("input.replying").blur(function() {
        if (($(this).val().substring(0, 2) == "回复" && $(this).val().match(/回复.+：.+/) == null)
            || $(this).val() == "") {
            var reply_li = $(this).parents(".last_li");
            var li = reply_li.prev(".last_li");
            li.show();
            reply_li.hide();
        }
    });

    $(".reply > a").live("click", function() {
        var div = $(this).parents(".reply_byline");
        var respondee_id = $("a", div).attr("href").match(/uid=([0-9]+)/)[1];
        var respondee_name = $("a.username", div).text();
        var pcid = $(this).parents("li").attr("id").substring(2);
        //alert(pcid);
        //alert(respondee_id);
        //alert(respondee_name);

        var reply_li = div.parents("ul").find("li.last_li:last");
        var li = reply_li.prev(".last_li");
        li.hide();
        reply_li.show();
        $("input.replying", reply_li).val("回复" + respondee_name + "：")
                                     .data("respondee", respondee_id)
                                     .data("pcid", pcid)
                                     .focus();
    });

    $("a.reply_btn").live("click", function() {
        var reply_input = $(this).prev("div.float").find("form > input.replying");
        var response = reply_input.val();
        if (checkEmptyReply(response)) {
            alert("您不能提交空回复呀。。。");
            return ;
        }

        var feedid = $(this).parents("div.video_clip").attr("id").match(/feed([0-9]+)/)[1];
        var vid = $(this).parents("div.video_content").attr("id").match(/feed_vid([0-9]+)/)[1];
        var pcid = reply_input.data("pcid");

        $.post("../fcs", {
            comment: response,
            fid: feedid,
            pid: pcid,
            vid: vid
        },
        function(json) {
            //alert(json);
            if(json.result == "OK") {
                var time = json.timestamp;
                var last_li = $("#feed" + feedid).find(".last_li:first");
                var new_li = $("#vc_template").clone(true);
                new_li.find("a > img").attr("src", user_photo_mini);
                var new_byline = new_li.attr("id", "vc" + json.cid)
                                       .find(".reply_byline");
                new_byline.find("a.username")
                          .attr("href", "home.jsp?uid=" + user_id)
                          .text(user_name);
                new_byline.find("span").text(time);
                new_byline.find(".reply").html(response + "<a href=\"#nogo\">&nbsp;&nbsp;回复</a>");
                new_li.insertBefore(last_li);
                last_li.show();
                last_li.next().hide();
            } else {
                alert("shouldn't reach here ... how did you do this? file me a bug! :-)");
            }
        });
    });

    // in-place playback
    $("div.play > a").live("click", function() {
        $(this).parents(".detailwrap").css("height", "436px")
                                      .css("background", "url(\"pic/newvbg4.png\") no-repeat scroll 0 0 transparent");
        var div = $(this).parents("div.video_content");
        var code_div = div.find(".person_detail > .embed_code");
        if (code_div.children(".stat").length == 0) {
            var stat = div.find(".person_detail > .person_video_des > .stat").clone();
            stat.find("a.hide_btn").show();
            code_div.append(stat);
        }
        div.find(".person_detail > div").not(".clear").toggleClass("mask");
        var videoid = $(this).parents(".video_content").attr("id").match(/feed_vid([0-9]+)/)[1];
        addWatchCount(videoid);
    });

    $("div.video_pic > a > img").live("click", function() {
        $(this).parents(".person_detail").find(".play > a").click();
    });

    // in-place fold
    $("a.hide_btn").live("click", function() {
        var div = $(this).parents("div.video_content");
        div.find(".person_detail > div").not(".clear").toggleClass("mask");
        $(this).parents(".detailwrap").css("height", "133px")
                                      .css("background", "url(\"pic/newvbg.png\") no-repeat scroll 0 0 transparent");
    });

    $("div.share_img").hoverIntent(function() {
        $(this).find(".share_hoverbox").show();
    }, function() {
        $(this).find(".share_hoverbox").hide();
    });

    $(".shareclip").live("click", function() {
        var cl = $(this).attr("class").split(' ')[0];
        var sns = cl.substring(0, cl.indexOf('_'));

        var vcontent = $(this).parents(".right_bar").prev();
        var videoid = vcontent.attr("id").match(/feed_vid([0-9]+)/)[1];

        doShare(sns,
                 "http://www.iweishi.cn/website/iweishi2.0/video.jsp?vid=" + videoid,
                 vcontent.find(".vtitle > a").text() + " 爱微视，微视频精选");
    });

    $(".delete > a").live("click", function() {
        var vclip = $(this).parents(".video_clip");
        if (!vclip.hasClass("not_first_clip"))
            vclip.next().removeClass("not_first_clip");
        vclip.slideUp("slow");
    });
}
/*=== FEEDLIST END ===*/

/*=== COLLECT FRAME BEGIN ==*/
var SUBMIT_BEFORE = -1;
var SUBMIT_URL_ERROR = -2;
var SUBMIT_SUCCESS = -3;
var SUBMIT_UNKNOWN_ERROR = -4;

var CONFIRM_SUCCESS = 1000;
var CONFIRM_PREEMPTED = 1001;
var CONFIRM_TIMEOUT = 1002;
var COLLECT_SUCCESS = 1003;

var VIDEO_SUMMARY = "为何收藏它，写点什么吧。。。";

function enableCollectFrame() {
    // discover & collect video
    $("#push_video_btn").colorbox({
        inline:         true,
        href:           "#push_frame_loading",
        opacity:        0.5,
        scrolling:      false,
        innerWidth:     580,
        innerHeight:    160,
        onLoad:         function() {
            $("textarea#pushbtn_usertalk").val(VIDEO_SUMMARY);
        },
        onComplete:     parseVideo
    });

    $(".collect_img > a").live("click", function() {
        var vcontent = $(this).parents(".right_bar").prev();
        var videoid = vcontent.attr("id").match(/feed_vid([0-9]+)/)[1];
        invokeCollectFrame( {title : vcontent.find(".vtitle > a").text(),
                             thumbnail: vcontent.find(".video_pic > a > img").attr("src"),
                             "submiter-name": vcontent.find("a > strong").text(),
                             time: vcontent.find("span.time").not(".float_right").text()}, "", {vid: videoid}, collectVideo);
    });
}

function collectVideo(e) {
    // forbid multiple confirmations
    $(".collect_btn").unbind("click", collectVideo);
    $.colorbox.close();

    var usertalk = $("#pushbtn_usertalk").val();
    if (usertalk == VIDEO_SUMMARY)
        usertalk = "";

    $.get("../hotlist", {
        action: "collect",
        vid:    e.data.vid,
        comment: usertalk
    },
    function(xml) {
        var status = $(xml).find("status").text();
        if (status == "OK") {
            alert("收藏成功！");
        } else {
            alert("提交收藏请求错误！");
        }
        return false;
    });
}

function parseVideo() {
    $.get("../submitvideo", {
        service: "0", //0 means submission request
        videourl: $("#push_video_textarea").val()
    }, function(xml) {
        var status = $(xml).find("status").text();

        if (status == SUBMIT_SUCCESS) {
            invokeCollectFrame({title: $(xml).find("title").text(),
                                thumbnail: $(xml).find("thumbnail").text(),
                                "submitter-name": user_name},
                              "您将是此视频的发现者",
                              {siteid: $(xml).find("siteid").text(), album: 0},
                              confirmVideo
                             );
        } else if (status == SUBMIT_BEFORE) {
            invokeCollectFrame({title: $(xml).find("title").text(),
                                thumbnail: $(xml).find("thumbnail").text(),
                                "submitter-name": $(xml).find("user").text(),
                                time: $(xml).find("time").text()},
                              "您可以收藏此视频",
                              {siteid: $(xml).find("siteid").text(),
                               vid: $(xml).find("vid").text(),
                               album: 0},
                              confirmVideo
                             );
        } else if (status == SUBMIT_URL_ERROR) {
            $.colorbox({
                inline:     true,
                href:       "#push_frame_error",
                opacity:    0.5
            });
        } else if (status == SUBMIT_UNKNOWN_ERROR) {
            alert("未知错误！");
        } else {
            alert("unknow status code: " + status);
        }
    });
}

function confirmVideo(e){
    // forbid multiple confirmations
    $(".collect_btn").unbind("click", confirmVideo);
    $.colorbox.close();

    var siteid = e.data.siteid;
    // var album = e.data.album;
    var videoid = -1;
    if (e.data.vid != null)
        videoid = e.data.vid;

    var usertalk = $("#pushbtn_usertalk").val();
    if (usertalk == VIDEO_SUMMARY)
        usertalk = "";
    $.post("../submitvideo", {
        service: "1", // 1 means submission confirmation
        usertext: usertalk,
        siteid: siteid,
        uid: user_id,
        vid: videoid  // when you submit a confirmation, there isn't a valid vid yet.
    },
    function(xml){
        var status = $(xml).find("status").text();
        if (status == CONFIRM_SUCCESS || status == COLLECT_SUCCESS) {
            alert("发现成功！");
        } else {
            alert("提交发现请求错误！");
        }
    });
}

function invokeCollectFrame(vinfo, ctext, data, callback) {
    var frame_ok = $("#push_frame_ok");
    frame_ok.find(".video_pic > a > img").attr("src", vinfo.thumbnail);
    frame_ok.find(".vtitle > a").text(vinfo.title).attr("title", "确认后，这里就指向视频主页哦:-)");
    if (vinfo["submitter-name"] != null)
        frame_ok.find("a > strong").text(vinfo["submitter-name"]);
    if (vinfo.time != null)
        frame_ok.find("span.time").text("  " + vinfo.time + "前");
    else
        frame_ok.find("span.time").text("");
    frame_ok.find(".collect_btn").unbind("click"); // avoid multiple submission.
    frame_ok.find(".collect_btn").bind("click", data, callback);
    $("#collect_text").text(ctext);

    $.colorbox({
        inline:     true,
        href:       "#push_frame_ok",
        opacity:    0.5,
        onLoad:     function() {
            $("textarea#pushbtn_usertalk").val(VIDEO_SUMMARY);
        }
    });
}
/*=== COLLECT FRAME END ==*/

/*=== PAGE SETUP FUNCTIONS BEGIN ===*/
function indexPageSetup() {
    //alert("running index page setup!");
    enableLoginJoinBox();
    enableRollingFeedBox();
}

function user_indexPageSetup() {
    //alert("running user_index page setup!");
    enableFeedList();
    enableCollectFrame();
}

function videoPageSetup() {
    //alert("running video page setup!");
    $(".reply > a").live("click", function() {
        var pcid = $(this).parents("li").attr("id").substring(2);
        var respondee_name = $(this).parents(".reply_byline").find("a.username").text();
        $("#user_reply").data("pcid", pcid).val("回复" + respondee_name + "：").focus();
    });

    $("#user_reply").keyup(function() {
        var nw = $(this).val().length;
        $(this).next().text(nw + "/140");
    });

    $("#reply_btn").click(function() {
        var response = $("#user_reply").val();
        if (checkEmptyReply(response)) {
            alert("您不能提交空回复呀。。。");
            return ;
        }

        var pcid = -10;
        if (response.match(/回复.+：.+/) != null)
            pcid = $("#user_reply").data("pcid");

        $.post("../vcs", {
            action: "comment",
            comment: response,
            uid: user.uid,
            vid: video.vid, // global variable defined in video.jsp head section
            pid: pcid
        },
        function(xml){
            var status = $(xml).find("status").text();
            if(status == "OK") {
                var time = $(xml).find("timestamp").text();
                var vcid = $(xml).find("vcid").text(); // video comment's id
                var new_li = $("#vc_template").clone(true);
                new_li.find("img").attr("src", user.photo_mini);
                var new_byline = new_li.attr("id", "vc" + vcid)
                .find(".reply_byline");
                new_byline.find("a.username")
                .attr("href", "home.jsp?uid=" + user.uid)
                .text(user.name);
                new_byline.find("span").text(time);
                new_byline.find(".reply").html(response + "<a href=\"#nogo\">&nbsp;&nbsp;回复</a>");
                new_li.insertAfter($("#vc_template")).show();
            } else {
                alert("shouldn't reach here ... how did you do this? file me a bug! :-)");
            }
        });
    });

    $("div.shareicon").hover(function(){
        $("div.collecticon").addClass("mask");
        $(this).find(".v_d_share_hoverbox").show();
    }, function(){
        $("div.collecticon").removeClass("mask");
        $(this).find(".v_d_share_hoverbox").hide();
    });

    $("div.collecticon").hover(function(){
        $("div.shareicon").addClass("mask");
    }, function(){
        $("div.shareicon").removeClass("mask");
    });

    $(".shareclip").live("click", function() {
        var cl = $(this).attr("class").split(' ')[0];
        var sns = cl.substring(0, cl.indexOf('_'));

        doShare(sns,
            document.location.href,
            document.title);
    });

    $(".collecticon").click(function() {
        invokeCollectFrame(video, "",
        {
            vid: video.vid
        }, collectVideo); // collectVideo() is defined in push_frame.js
    });
}

function editDescription() {
    $(".status_text").addClass("mask");
    $("#ta_description").removeClass("mask");
    $("#ta_description").focus();
    $("#ta_description").select();
    $("div.ds_wrapper").removeClass("mask");
}

function hometabClick(target) {
    $("div.selected_tab").addClass("closed_tab");
    $("div.tabs > div").removeClass("selected_tab");
    $("div.wrap > div").addClass("mask");
    $(target).addClass("selected_tab");
    $(target).removeClass("closed_tab");
}

function homePageSetup() {
    $("a.reply_other").live("click", function(){
        $("textarea.limekk").val("回复" + $(this).parents("div.reply_byline").attr("id") + ": ");
        $("textarea.limekk").focus();
        $("div.reply_byline")
    });
    $("a#lireplyicen").click(function() {
        $.get("jspf/leave_message.jsp", {
            comment: $("textarea.limekk").val(),
            hostid: hostid
        },function(message){
            $("div#reply").append(message);
        });
    });
    $("#follow_me").click(function(e){
        //if (!checkLogin()) return false;
        $.get(
            "../follow", {
                action: "follow",
                followee: hostid
            },
            function(xml) {
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    $(".followme_wrapper").addClass("mask");
                    $(".disfollowme_wrapper").removeClass("mask");
                } else {
                    alert("提交关注请求错误！");
                }
            });
    });

    $("#disfollow_me").click(function(e){
        //if (!checkLogin()) return false;
        $.get(
            "../follow", {
                action: "disfollow",
                followee: hostid
            },
            function(xml) {
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    $(".disfollowme_wrapper").addClass("mask");
                    $(".followme_wrapper").removeClass("mask");
                } else {
                    alert("提交关注请求错误！");
                }
            });
    });

    $("#collecttab").click(function(){
        urlAnchorTo("collecttab");
        hometabClick(this);
        $("#album_content").removeClass("mask");
    });

    $("#concerntab").click(function(){
        urlAnchorTo("concernab");
        hometabClick(this);
        $("#concern_content").removeClass("mask");
    });
    $("#newstab").click(function(){
        urlAnchorTo("newstab");
        hometabClick(this);
        $("#news_content").removeClass("mask");
    });
    $("#messagetab").click(function(){
        urlAnchorTo("newstab");
        hometabClick(this);
        $("#message_content").removeClass("mask");
    });
    $("#my_submit").click(function(){
        $("#my_submit_content").removeClass("mask");
        $("#my_collect_content").addClass("mask");
    });
    $("#my_collect").click(function(){
        $("#my_collect_content").removeClass("mask");
        $("#my_submit_content").addClass("mask");
    });

    if (isequal) {
        $(".hcv_wrapper").hover(function(){
            $(this).find("div.delete_cv").removeClass("mask");
        }, function(){
            $(this).find("div.delete_cv").addClass("mask");
        });
        $(".status_text").click(function(){
            editDescription();
        });
        $("a.status_edit").click(function(){
            editDescription();
        });
        $("#ta_description").blur(function(){
            $("div.ds_wrapper").addClass("mask");
            if ($("#ta_description").val() != $(".status_text").text()){
                $.get("../uinfo",{
                    moto: $(this).val()
                }, function(xml){
                    if ($(xml).find("status").text() == "OK") {
                        $(".status_text").text($("#ta_description").val());
                    } else {
                        alert("修改状态失败请重试");
                    }
                });
            }
            $(".status_text").removeClass("mask");
            $("#ta_description").addClass("mask");
        });
        $("div#des_save").click(function(){
            $.get("../uinfo",{
                moto: $(this).val()
            }, function(xml){
                if ($(xml).find("status").text() == "OK") {
                    $(".status_text").text($("#ta_description").val());
                    $(".status_text").removeClass("mask");
                    $("#ta_description").addClass("mask");
                }
            });
        });
        $(".delete_cv").click(function() {
            var vidall = $(this).parent("div.hv_wrapper").attr("id");
            vid = vidall.substring(3);
            $.get("../vds", {
                vid: vid
            }, function() {
                $("div#" + vidall).remove();
            });
        });
        $(".concernP_wrapper").hover(function(){
            $(this).find("div.cancel_follow").removeClass("mask");
        }, function(){
            $(this).find("div.cancel_follow").addClass("mask");
        });
        $(".cancel_follow").click(function(){
            var hid = $(this).attr("id").substring(3);
            $.get(
                "../follow", {
                    action: "disfollow",
                    followee: hid
                },
                function(xml) {
                    var status = $(xml).find("status").text();
                    if (status == "OK") {
                        $("div#hid" + hid).parent("div.concernP_wrapper").remove();
                    } else {
                        alert("提交关注请求错误！");
                    }
                });
        });
    }
}
/*=== PAGE SETUP FUNCTIONS END ===*/

$(document).ready(function(){

    /*=== GLOBAL CONFIGURATION BEGIN ===*/
    $.ajaxSetup({
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        error: function(x,e){
            if(x.status==0){
                alert('You are offline!!\n Please Check Your Network.');
            }else if(x.status==404){
                alert('Requested URL not found.');
            }else if(x.status==500){
                alert('Internel Server Error.');
            }else if(e=='parsererror'){
                alert('Ajax Parser Error.\n');
            }else if(e=='timeout'){
                alert('Request Time out.');
            }else {
                alert('Unknow Error.\n'+x.responseText);
            }
        }
    });

    $("input").click(function() {
        $(this).select();
    });

    $("textarea").not("#user_reply").click(function() {
        $(this).select();
    });
    /*=== GLOBAL CONFIGURATION END ===*/

    /*=== NAVIGATION & TABS BEGIN == */
    $("#logout").click(function(){
        $.cookie('userid', '', {
            expires: -1
        }); // delete cookie
    });

    $("#register").click(function() {
        $("#join_link").click();
    });

    $("#bookmark").click(function() {
        var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd' : 'CTRL';
        if (document.all){
            window.external.addFavorite('http://www.iweishi.cn','爱微视 微视频精选');
        }else if (window.sidebar){
            window.sidebar.addPanel('爱微视 微视频精选', 'http://www.iweishi.cn', "");
        }else {
            alert('您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~');
        }
    });
    /*=== NAVIGATION & TABS END == */

    var url = document.location.href;
    // execute anchor clicks
    var click_start = url.indexOf('#c');
    var click_elems = new Array();
    click_elems = url.substring(click_start + 2).split('|');
    for (var i = 0; i < click_elems.length; ++i) {
        $("#" + click_elems[i]).click();
    }
    // start running page-specific code
    var page = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    // alert(page);
    eval(page + "PageSetup();");
});
