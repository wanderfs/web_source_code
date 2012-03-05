/**
 *  Every page that contains video list/event list should include this script.
 */

function countVideosInList(list_name) {
    return $(list_name + "> .videos_meat > .clips > ul.videos > li").length;
}

function countActivitiesInList(list_name) {
    return $(list_name + "> .activity > ul.log > li").length;
}

function CountAlbumsInList(list_name) {
    return $(list_name + "> .albumMeat > .clips > ul.ulAlbum > li").length;
}

function loading() {
    $("#content_wrapper > div").addClass("mask");
    $("#loading").removeClass("mask");
    $("div.wrappertop").removeClass("mask");
    $("div.wrapper_bottom").removeClass("mask");
}

$(document).ready(function() {
    
    // initialize each list's "already_has" value:
    $("#video_hotlist").data("already_has", countVideosInList("#video_hotlist"));
    $("#video_newlist").data("already_has", countVideosInList("#video_newlist"));
    $("#global_activity_insides").data("already_has", countActivitiesInList("#global_activity_insides"));
    $("#my_activity_insides").data("already_has", countActivitiesInList("#my_activity_insides"));

    var hotlist = $(".clips > ul.videos");
    //$("li > div.digest > div.cancel", hotlist).hide();

    $("li > .digest > .cancel", hotlist).live("click", function(e) {
        //$("li > .digest > .cancel", hotlist).click(function(e) {
        if ( page_type == HOME_JSP && $("div.last_open").hasClass("albumvideos") && gUserid == gHostid)
        {
            if (confirm("确定从这个专辑中删除此视频么？"))
            {
                var aidtarget = $(this).parents("li.lVideoItem").find("div.embeded_code");
                $.get("remove_post_from_album", {
                    uid: gUserid,
                    vid: aidtarget.attr("id").substring(3),
                    aid: $("div.last_open").attr("id").substring(4)
                }, function(xml){
                    });
            } else {
                return false;
            }
        }
        videoitemSlideup(e.target);
    });


    $("li > .thumbnail > a.play", hotlist).live("click", function(e){
        //$("li > .thumbnail > a.play", hotlist).click(function(e){
        var clicked = $(e.target);
        clicked.hide();
        var screen = clicked.parents("div.thumbnail");
        var codeDiv = $("div.embeded_code", screen);
        var vid = codeDiv.attr("id").substring(3);  // remove prefix "vid"
        addWatchCount(vid);  // from common.js
        var embededCode = codeDiv.html();
        codeDiv.html(embededCode);
        screen.css("background", "url('pic/ani/screen.PNG') no-repeat scroll center center transparent");
        screen.css("float", "none").css("margin-left", "auto").css("margin-right", "auto");
        $("div.digest", screen.parents("li")).css("float", "right");
        screen.animate({
            width: "560px"
        }, 800, "linear", function(){
            screen.animate({
                height: "467px"
            }, 800, "linear", function(){
                codeDiv.show();
            });
        });
    });

    $(".share_video_btn > .share_video_btn_mid", hotlist).live("click", function(e) {
        if (!checkLogin()) return false;
        var clicked = $(e.target).parents("li");
        var vid = $("div.thumbnail > div.embeded_code", clicked).attr("id");
        $.get("hotlist", {
            action: "collect",
            vid: vid.substring(3) // remove prefix "vid"
        },
        function(xml) {
            var status = $(xml).find("status").text();
            if (status == "OK") {
                var share_btn = $(".share_video_btn", clicked);
                share_btn.addClass("shared");
                $(".share_video_btn_mid > strong", share_btn).text("已收藏");
            } else {
                alert("提交收藏请求错误！");
            }
            return false;
        }
        );
        return false;
    });
    /*
    $("li", hotlist).hover(
        function(e){
            var target = $(e.target);
            $(".digest > .cancel", target).show();
            //$(".digest > .cancel", target).fadeIn(400);
        },
        function(e){
            var target = $(e.target);
            $(".digest > .cancel", target).hide();
            //$(".digest > .cancel", target).fadeOut(400);
        }
    );
 */
    /*
    $("li > div.digest > h3 > a", hotlist).hover(
        function(e){
            var digest = $(e.target).parents("div.digest");
            $(".cancel", digest).show();
        },
        function(e){
            var digest = $(e.target).parents("div.digest");
            $(".cancel", digest).hide();
        }
    );
*/

    $("#more_hot").click(function(e) {
        loading();
        $("#video_hotlist > div.videos_meat > div.clips > ul.videos").html("");
        var now_has = $("#video_hotlist").data("already_has");
        //alert(now_has);
        $.get("jspf/videolist.jsp", {
            type:           "hot",
            already_has:    now_has
        },
        function(newlist_html) {
            $("#video_hotlist > div.videos_meat > div.clips > ul.videos").replaceWith(newlist_html);
            $("#video_hotlist").data("already_has", now_has + countVideosInList("#video_hotlist"));
            $("#loading").addClass("mask");
            $("#video_hotlist").removeClass("mask");
        }
        );
    });

    $("#more_new").click(function(e) {
        loading();
        $("#video_newlist > div.videos_meat > div.clips > ul.videos").html("");
        var now_has = $("#video_newlist").data("already_has");
        //alert(now_has);
        $.get("jspf/videolist.jsp", {
            type:           "new",
            already_has:    now_has
        },
        function(newlist_html) {
            $("#video_newlist > div.videos_meat > div.clips > ul.videos").replaceWith(newlist_html);
            $("#video_newlist").data("already_has", now_has + countVideosInList("#video_newlist"));
            $("#loading").addClass("mask");
            $("#video_newlist").removeClass("mask");
        }
        );
    });

    $("#more_activity").click(function(e) {
        loading();
        $("#global_activity_insides > div.activity > ul.log").html("");
        var now_has = $("#global_activity_insides").data("already_has");
        //alert(now_has);
        $.get("jspf/hangaround.jsp", {
            type:           "global",
            already_has:    now_has
        },
        function(newlist_html) {
            //alert(newlist_html);
            $("#global_activity_insides > div.activity > ul.log").replaceWith(newlist_html);
            $("#global_activity_insides").data("already_has", now_has + countActivitiesInList("#global_activity_insides"));
            $("#loading").addClass("mask");
            $("#global_activity").removeClass("mask");
        }
        );
    });

    $("#moreNewAlbum").click(function(e) {
        loading();
        $("div#albumNewlist > div.albumMeat > div.clips > ul.ulAlbums").html("");
        var now_has = $("#albumNewlist").data("already_has");
        //alert(now_has);
        $.get("jspf/albumlist.jsp", {
            type:           "new",
            already_has:    now_has
        },
        function(newlist_html) {
            $("#albumNewlist > div.albumMeat > div.clips > ul.ulAlbums").replaceWith(newlist_html);
            $("#albumNewlist").data("already_has", now_has + CountAlbumsInList("#albumNewlist"));
            $("#loading").addClass("mask");
            $("#albumNewlist").removeClass("mask");
        }
        );
    });

    $("#more_my_activity").click(function(e) {
        loading();
        $("#my_activity_insides > div.activity > ul.log").html("");
        var now_has = $("#my_activity_insides").data("already_has");
        //alert(now_has);
        $.get("jspf/hangaround.jsp", {
            type:           "mine",
            already_has:    now_has
        },
        function(newlist_html) {
            $("#my_activity_insides > div.activity > ul.log").replaceWith(newlist_html);
            $("#my_activity_insides").data("already_has", now_has + countActivitiesInList("#my_activity_insides"));
            $("#loading").addClass("mask");
            $("#my_activity").removeClass("mask");
        }
        );
    });
});

function videoitemSlideup(event_target){
    var clicked = $(event_target).parents("li");
    $("div.thumbnail > div.embeded_code", clicked).html("");
    if (clicked.hasClass("videos_top")) {
        clicked.next().addClass("videos_top");
    }
    clicked.slideUp("slow", function() {
        clicked.remove();
    });
    return false;
}