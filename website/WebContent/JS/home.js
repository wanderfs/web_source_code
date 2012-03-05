/* 
 * main js file for home.jsp
 */

$(document).ready(function(){    
    if ($.browser.mozilla)
    {
        addEpllisisToAlbumItem();
    }
    $("div.dropdown_items").addClass("mask");

    $("#follow_me").click(function(e){
        if (!checkLogin()) return false;
        $.get(
            "follow", {
                action: "follow",
                followee: gHostid
            },
            function(xml) {
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    $("#follow_me").addClass("mask");
                    $("#disfollow_me").removeClass("mask");
                } else {
                    alert("提交关注请求错误！");
                }
            });
    });

    $("#disfollow_me").click(function(e){
        if (!checkLogin()) return false;
        $.get(
            "follow", {
                action: "disfollow",
                followee: gHostid
            },
            function(xml) {
                var status = $(xml).find("status").text();
                if (status == "OK") {
                    $("#disfollow_me").addClass("mask");
                    $("#follow_me").removeClass("mask");
                } else {
                    alert("提交关注请求错误！");
                }
            }
            );
    });

    $(".pagination > ul > li").live("click", function(e) {
        //alert($(this).html());
        if (!$(this).hasClass("arrow") && !$(this).hasClass("dots")) {
            var pages = $(this).parents("ul");
            $("li.selected", pages).removeClass("selected");
            $(this).addClass("selected");
            loadHomeclip($(this), pageNum($(this))); // exclude first arrow.
        }
    });

    $("li.arrow").live("click", function(e) {
        var pages = $(this).parents("ul");
        var selected = $("li.selected", pages);
        if ($(this).index() == 0) { // prev arrow
            if (selected.index() > 1) {
                selected.removeClass("selected").prev().addClass("selected");
                loadHomeclip($(this), pageNum(selected.prev())); // exclude first arrow.
            }
        } else { // next arrow
            if (selected.index() < $(this).index() - 1) {
                selected.removeClass("selected")
                .next().addClass("selected");
                loadHomeclip($(this), pageNum(selected.next())); // exclude first arrow.
            }
        }
    });

    $(".dropdown").live("click", function(){
        if ($.browser.mozilla)
        {
            $("ul.ulDropdown > li.album_item").textOverflow();
        }
        $("div.dropdown_items").slideToggle(100);
    });

    $("div.dropdown_items > ul.ulDropdown > li").live("hover", function(event){
        $(this).toggleClass("hilite");
    });

    var items = $("div.dropdown_items > ul.ulDropdown > li");
   
    items.live("click", function(){
        $("div.dropdown_items").slideUp("fast");
    });

    $("div.dropdown_items > ul.ulDropdown > li.unpost").click(function() {    
        items.removeClass("selected");
        $(this).addClass("selected");
        $("div#inbox_dropdown_value").text($(this).text());
        $("#content_wrapper > div").addClass("mask");
        $("div.toobar").removeClass("mask");
        $("div#collected_videos").removeClass("mask");
        $("#content_wrapper > div.videos_content").removeClass("last_open");
        $("div#collected_videos").addClass("last_open");
    });

    // wei: you need to use LOCK ! sen: I am telling you why not used.
    $("div.dropdown_items > ul.ulDropdown > li.album_item").live("click", function() {
        var clicked = this;
        var channelid = $(clicked).attr("id").substring(3);

        urlAnchorTo("aid" + channelid);
        
        $("div.album_setting > a").attr("href", "album_settings.jsp?aid=" + $(clicked).attr("id").substring(3) + "&hostid=" + gHostid);
        $("div.album_setting").removeClass("mask");
        $("#content_wrapper > div.videos_content").removeClass("last_open");
                
        items.removeClass("selected");
        $(clicked).addClass("selected");
        $("div#inbox_dropdown_value").text($(clicked).text());
        $("#content_wrapper > div").addClass("mask");
        $("div.toobar").removeClass("mask");
        if ($(clicked).hasClass("ready")) {
            $("div.cid"+channelid).removeClass("mask");
            $("div.cid"+channelid).addClass("last_open");
            return false;
        }

        $("#loading_albumvideos").removeClass("mask");
        $("#loading_albumvideos").addClass("loading_albumvideos");

        $.get("jspf/homeclips.jsp?time=" + (new Date()).getTime(),
        {
            type:   "albumvideos",
            uid:    gHostid,
            cid:    channelid
        },
        function(newlist_html) {
            $("div#content_wrapper").append(newlist_html);
            $(clicked).addClass("ready");
            $("#loading_albumvideos").addClass("mask");
            $("#loading_albumvideos").removeClass("loading_albumvideos");

            if ($(clicked).hasClass("selected")) {
                if ($("li#collected_tab").hasClass("active"))
                {
                    $("div.cid"+channelid).removeClass("mask");
                }
                $("div.cid"+channelid).addClass("last_open");
            }
        });
    });

    $("#add_video").click(function() {
        $.colorbox({
            opacity: 0.5,
            inline: true,
            innerWidth:    620,
            innerHeight:   135,
            href: "#push_video"
        });
    });
});

function loadHomeclip(jq_obj, page_num) {
    //alert(page_num);
    loading();
    var jq_env = jq_obj.parents("div.clips");
    $("ul.videos", jq_env).html("");

    var page_type = null;
    if (jq_env.parents("div.videos_content").hasClass("albumvideos")) {
        $("div.toobar").removeClass("mask");
        $("ul.videos", jq_env).addClass("ready");
        page_type = "albumvideos";
        var aid = jq_env.parents("div.videos_content").attr("id").substring(4);
        $.get("jspf/homeclips.jsp", {
            type:           page_type,
            uid:            gHostid,
            from:           page_num,
            cid:            aid,
            first_time:     "no"
        },
        function(newlist_html) {
            $("ul.videos", jq_env).replaceWith(newlist_html);
            $("#loading").addClass("mask");
            jq_env.parents("div.videos_content").removeClass("mask");
        });
    } else {
        page_type = jq_env.parents("div.videos_content").attr("id");
        page_type = page_type.substr(0, page_type.indexOf("_"));
        $.get("jspf/homeclips.jsp", {
            type:           page_type,
            uid:            gHostid,
            from:           page_num
        },
        function(newlist_html) {
            $("ul.videos", jq_env).replaceWith(newlist_html);
            $("#loading").addClass("mask");
            jq_env.parents("div.videos_content").removeClass("mask");
        });
    }
        
}

function pageNum(jq_obj) {
    return $("a", jq_obj).text() - 1;
}

function addEpllisisToAlbumItem()
{
    $("div.dropdown_items > ul.ulDropdown > li.album_item").textOverflow();
}