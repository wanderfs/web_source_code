/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var filter_feed_arr = [];
var footer = 0;

function filter_auto_feed() {
    if (filter_feed_arr.length < 5) {
        $.getJSON("../gfeed", {
            fn: 30
        }, function(json) {
            $.each(json.feed, function(i, feed) {
                filter_feed_arr.push(feed);
            });
        });
    }
}

function filter_auto_fill() {
    if (filter_feed_arr.length ==0) return;
    var feed = filter_feed_arr.shift();
    $.getJSON("../vfeed", {
        vid: feed.vid
    }, function(vinfo) {
        var feedDiv = $("#hvb_" + footer);
        //alert("#hvb_" + footer + " title:" + vinfo.title + " vid:" + vinfo.vid);
        if (footer >= 6) {
            footer = 0;
        }
        feedDiv.find(".video_discription").text(vinfo.summary);
        feedDiv.find(".thumbnail").attr("title", vinfo.title).css("background-image", "url('" + vinfo.thumbnail + "')");
        feedDiv.find(".video_title > a").text(vinfo.title).attr("title", vinfo.title);
        feedDiv.css("height", "191px").css("margin-top", "0px");
        //$("div.swf_holder").text(vinfo);
        feedDiv.data("vinfo", {
            title: vinfo.title,
            vid: vinfo.vid,
            embed: "<div id='f_d_flash_container' class='swf_holder'>" + vinfo.embed + "</div>"
        });
        feedDiv.fadeIn("slow");
    });
}

function mouthScroll(){
    if (footer >= 6)
    {
        $("#mouth").css("margin-left", "15px");
        return;
    }
    $("#mouth").animate({
        marginLeft: 15+(footer)*160+"px"
    }, 1000);
}

function eatVideo() {
    ++footer;
    $("#hvb_" + footer).animate({
        "height": "0px",
        marginTop: "190px"
    }, 2000, function(){
        mouthScroll();
        filter_auto_fill();
    });
}

function setSixVideosData(key) {
    if (key < 7) {
        $.getJSON("../vfeed", {
            vid: f_a_vids[key-1]
        }, function(vinfo) {
            $("#hvb_" + key ).data("vinfo", {
                title: vinfo.title,
                vid: vinfo.vid,
                embed: "<div id='f_d_flash_container' class='swf_holder'>" + vinfo.embed + "</div>"
            });
            setSixVideosData(++key);
        });
    }
}

$(document).ready(function(){
    $("#filterbox_hover").hover(function(){
        eat_ps = setInterval("eatVideo()", 3000);
        $(this).addClass("mask");
        $("#filterbox").removeClass("mask");
        $("#filterbox").hover(function(){}, function(){
            $("#filterbox").addClass("mask");
            $("#filterbox_hover").removeClass("mask");
            clearInterval(eat_ps);
        });
    }, function(){
        });

    $("#top_hover").hover(function(){
        $(this).addClass("mask");
        $("body").addClass("green_background").removeClass("black_bg");
        $("div#top").removeClass("mask");
        $("div#top").hover(function(){}, function(){
            $(this).addClass("mask");
            $("body").removeClass("green_background").addClass("black_bg");
            $("div#top_hover").removeClass("mask");
        });
    }, function(){       
        });   
  
    $(".hot_video_box").click(function(){
        clearInterval(eat_ps);
        $(".video_t > a").text($(this).data("vinfo").title).attr("title", $(this).data("vinfo").title).attr("href", "video.jsp?vid=" + $(this).data("vinfo").vid);
        $("#f_d_flash_container").replaceWith($(this).data("vinfo").embed);
        $("body").removeClass("green_background").addClass("black_bg");
        $("#black_mask").removeClass("mask");
        $("div#top").addClass("mask");
        $("#filterbox").addClass("mask");
        $("div.video").removeClass("mask");
        $("#top_hover").removeClass("mask");
        $("#filterbox_hover").removeClass("mask");
        $("#f_d_main").addClass("mask");
    });
    $(".hot_video_box").hover(function(){
        $(this).find("div.video_discription_box").removeClass("mask");
    }, function(){
        $(this).find("div.video_discription_box").addClass("mask");
    });

    setSixVideosData(1);
    setInterval("filter_auto_feed()", 2000);
    var eat_ps = setInterval("eatVideo()", 3000);
});

