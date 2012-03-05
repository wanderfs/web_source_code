/* 
 * feedback javascript
 */

$(document).ready(function(){
    $("#feedback_btn").click(function(e) {
        if ($("#feedback_text").val() != "") {
            $.post("fb", {
                text:   $("#feedback_text").val()
            },
            function(xml) {
                //var string = (new XMLSerializer()).serializeToString(xml);
                //alert(string);
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    var newFeedback = $("#feedback_template").clone();
                    var username = gUsername;
                    if (gUserid == 39) // nobody
                        username = "匿名";
                    $(".rightside > .name", newFeedback).html("<a href=\#nogo\">" + username + "</a> " + new Date());
                    $(".rightside > .text", newFeedback).text($("#feedback_text").val());
                    $("#feedback_template").append(newFeedback);
                    msgbox("感谢您的帮助，爱微视将尽快向您报告修改结果！");
                } else {
                    msgbox("服务器出错，请稍后再试！");
                }
            });
        }
    });
});