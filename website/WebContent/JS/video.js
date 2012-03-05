/* 
 * user-video interaction is defined here.
 */

var gPcid = -10;
// the id of user to whom the reply is sent.
// should be default to "utility.Constant.VIDEO_COMMENT_COMMON_PARENT_ID"
var gRespondeeId = -1;  

$(document).ready(function(){

    addWatchCount(gVideoid);

    $("input#new_comment_btn").click(function(){
        if (checkLogin() == false) return false;
        var comment = $("textarea#new_comment_text").val();
        if (comment == "") {
            alert("您不能提交空评论呀。。。");
            return false;
        }
        $.post("vcs", {
            action: "comment",
            comment: comment,
            uid: gUserid,
            vid: gVideoid,
            pid: gPcid,
            rid: gRespondeeId
        },
        function(xml){
            var status = $(xml).find("status").text();
            //alert(status);
            if(status == "OK") {
                var time = $(xml).find("timestamp").text();
                var vcid = $(xml).find("vcid").text(); // video comment's id
                updateCommentList(comment, time, vcid);
            } else {
                alert("shouldn't reach here ... how did you do this? file me a bug! :-)");
            }
            $("textarea#new_comment_text").val("");
        });
    });

    $("a.replylink").live("click", prepareReply);

    $("span.star").live("mouseover", function(e){
        $(e.target).addClass("full")
        .prevAll().addClass("full");
    });

    $("span.star").live("mouseout", function(e){
        $(e.target).removeClass("full")
        .nextAll().removeClass("full");
    });

    $("span.star").live("click", function(e){
        var rate = $(e.target).index() + 1; // index begins from 0
        $(e.target).removeClass("star").addClass("star_rated")
        .siblings().removeClass("star").addClass("star_rated");
        $.get("vcs", {
            action: "rate",
            vid: gVideoid,
            score: rate
        },
        function(xml) {
            var status = $(xml).find("status").text();
            if (status != "OK") {
                alert("评分出错！");
            }
        }
        );
    });

     $("div.dAlbumItems.video_ai > ul.uAlbumItems > li.album_name").live("click", function(){
        var videoid = gVideoid;
        var channelid = $(this).attr("id").substring(3);
        var clicked_sharebtn = $(this).parents("div.share_video_btn");
        postVideoToAlbum(videoid, channelid, clicked_sharebtn);
    });

    $("#collect_this > div.share_video_btn_mid").click(function(e) {
        if (checkLogin() == false) {
            return false;
        }
        $.get("hotlist", {
                action: "collect",
                vid: gVideoid
            },
            function(xml) {
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    $("#collect_this").addClass("shared");
                    $("#collect_this > .share_video_btn_mid > strong").text("已收藏");
                } else {
                    alert("提交收藏请求错误！");
                }
                return false;
            }
        );
        return false;
    });
});

function updateCommentList(comment, time, vcid) {
    var newComment = $("li#vc_template").clone();
    newComment.attr("id", "vc" + vcid).removeClass("mask");
    $("a", newComment).attr("href", "home.jsp?uid=" + gUserid);
    $("div.rightside > div.name", newComment).html(
        '<a href="home.jsp?uid=' + gUserid + '">' + gUsername + '</a> ' + time
        );
    $("div.rightside > div.text", newComment).html(comment +
        '<a class="replylink" href="#new_comment" style="float: right;"><img src="pic/msg_reply.gif" alt="+" style="position:relative; top: 2px;"/> 回复</a>');

    $("ul#comments").prepend(newComment);
    //move_view("#new_comment", "#vc" + vcid, 500);
}

// delete or debug? :-(
function updateCommentList0(comment, time, vcid) {
    var newComment = $(
        '<li class="parent" id="vc' + vcid + '">' +
            '<a href="home.jsp?uid=' + gUerid + '">' +
                '<img src="pic/portrait/d.75.jpg" alt="" title="" class="portrait"  height="75" width="75" />' +
            '</a>' +
            '<div class="rightside">' +
                '<div class="name">' +
                    '<a href="home.jsp?uid=' + gUserid + '">' + gUsername + '</a> ' + time +
                '</div>' +
                '<div class="text">' + comment +
                '<a class="replylink" href="#new_comment" style="float: right;">' +
                    '<img src="pic/msg_reply.gif" alt="+" style="position:relative; top: 2px;"/> 回复' +
                '</a>' +
                '</div>' +
             '</div>' +
             '<div class="clear"></div>' +
         '</li>');
     alert(newComment.html());
     $("ul#comments").prepend(newComment);
}

function prepareReply(e) {
    if (checkLogin() == false) return false;
    //move_view(e.target, "#new_comment", 500);
    var parent = $(e.target).parents("li.parent");
    // get parent comment id
    gPcid = parent.attr("id").substr(2);
    // get respondee's name
    var respondee = $("div.rightside > div.name > a", parent).text();
    gRespondeeId = $("a", parent).attr("href").substr(13);
    //alert(gRespondeeId);
    $("textarea#new_comment_text").val("回复 " + respondee + ": ");
}