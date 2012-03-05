/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready (function(){
    $("#search_video").click(function(){
        iweishiSearch();
    });
    $("form#search_form").submit(function(){
        iweishiSearch();
        return false;
    });
    $("div.s_d_video_clip").hoverIntent(clipover, clipout);
    $("div.s_d_share_img").hoverIntent(shareover, shareout);

    $(".s_d_shareclip").live("click", function() {
        var cl = $(this).attr("class").split(' ')[0];
        var sns = cl.substring(0, cl.indexOf('_'));

        var vclip = $(this).parents(".s_d_video_clip");
        var videoid = vclip.attr("id").match(/search_vid([0-9]+)/)[1];

        doShare(sns,
                "http://www.iweishi.cn/video.jsp?vid=" + videoid,
                vclip.find(".s_d_vtitle > a").text() + " 爱微视，微视频精选")
    });
});

function shareover() {
    $(this).find("div.s_d_share_hoverbox").removeClass("mask");
}

function shareout () {
    $(this).find("div.s_d_share_hoverbox").addClass("mask");
}

function clipover (){
    $("div.s_d_right_bar").insertAfter($(this).find('div.s_d_detail'));
}

function clipout (){
    $(this).remove("div.s_d_right_bar");
}

function iweishiSearch () {
    var keywordvar = $("input#s_i_menudo_search_field").val();
    $.get("jspf/search_result.jsp", {
        type: "video",
        keyword: keywordvar
    }, function(search_result){
        $("div.s_d_wrap").html(search_result);
    });
}