/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("a.replylink").live("click", prepareHotEventReply);
    $("input#new_comment_btn").click(function(){
        if (checkLogin() == false) return false;
        var comment_content = $("textarea#new_comment_text").val();
        if (comment_content == "") {
            alert("您不能提交空评论呀。。。");
            return false;
        }
        $.get("hot_event", {
            comment: comment_content,
            event_name: page_type
        },function(xml){
            var time = $(xml).find("time").text();
            var newComment = $("li#hc_template").clone();
            newComment.attr("id", "hc").removeClass("mask");
            $("a", newComment).attr("href", "home.jsp?uid=" + gUserid);
            $("div.rightside > div.name", newComment).html(
                '<a href="home.jsp?uid=' + gUserid + '">' + gUsername + '</a> ' + time
                );
            $("div.rightside > div.text", newComment).html(comment_content +
                '<a class="replylink" href="#new_comment" style="float: right;"><img src="pic/msg_reply.gif" alt="+" style="position:relative; top: 2px;"/> 回复</a>');
            $("ul#comments").prepend(newComment);
        });
    });
});
function prepareHotEventReply(e) {
    if (checkLogin() == false) return false;
    var parent = $(e.target).parents("li.parent");
    var respondee = $("div.rightside > div.name > a", parent).text();
    $("textarea#new_comment_text").val("回复 " + respondee + ": ");
}