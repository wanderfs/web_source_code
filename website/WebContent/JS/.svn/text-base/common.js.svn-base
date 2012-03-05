/* 
 * This file contains the code shared by all/most pages, including those in head and foot
 */

var DATABASE_INSERT_DUPLICATE = -9;
var HOME_JSP = "home.jsp";
var USER_INDEX_JSP = "user_index.jsp";
var VIDEO_JSP = "video.jsp";
var PUSH_FRAME_BTN_ID = "push_frame_ok";

$(document).ready(function(){
    $("input#menudo_search_field").click(function(event){
        $("input#menudo_search_field").attr("value", " ");
    });
    /*$("*").not("input#menudo_search_field").click(function(){
        $("input#menudo_search_field").val("搜索人或视频");
    });*/
    $("li.firstborn").hover(function(){
        if ($.browser.msie && $.browser.version == "6.0")
        {
            $(this).find("ul.favoritechild").slideToggle(10);
        }
    });
    // slideup help banner
    $(".undertaker").click(function(e) {
        $(e.target).parents(".obiwan").slideUp('elastic');
    });

    $("input#menudo_search_field").click(function(){
        if ($(this).val() == "搜索") {
            $(this).val("");
        }
    });

    $("#logout").click(function(){
        $.cookie('userid', '', {
            expires: -1
        }); // delete cookie
    });

    // debug helpers
    $(document).keyup(function(e){
        var key = e.charCode || e.keyCode || 0;
        if(key == 113) { // F2
            alert("current user: " + gUsername);
        }
    });

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
    
    // login & register

    $("a#login_link").click(function(){
        $("form#login").show();
        $("form#join").hide();

        $("a#login_link").addClass("active");
        $("a#join_link").removeClass("active");

        $.colorbox.resize();
    });

    $("a#join_link").click(function(){
        $("form#login").hide().removeClass("active");
        $("form#join").show().addClass("active");

        $("a#login_link").removeClass("active");
        $("a#join_link").addClass("active");

        $.colorbox.resize();
    });

    $("form#login").submit(function() {
        var email = $("input#login_email").val();
        if (email.indexOf("@") == -1) {
            handleEmailError();
            return false;
        }

        if ($("input#login_password").val() == "") {
            handlePasswordError();
            return false;
        }

        return true;
    });

    $("form#join").submit(function() {
        var icode = $("input#invite_code").val();
        if (icode == null || icode == "") {
            msgbox("对不起，内测阶段需要邀请码才能注册。");
            return false;
        }
        
        var email = $("input#join_email").val();
        if(email.indexOf("@") == -1) {
            handleEmailError();
            return false;
        }

        var pw0 = $("input#join_password").val();
        var pw1 = $("input#join_password_check").val();
        if(pw0 != pw1 || pw0 == "") {
            handlePasswordError();
            return false;
        }

        if($("input#tos", "form#join").attr("checked") == false) {
            handleTosError();
            return false;
        }
        return true;
    });

    $(".login_needed").live("click", function() {
        return checkLogin();
    });

    $(".join_needed").live("click", function() {
        return popJoin();
    });

    $("div.dAlbumItems.videolist_ai > ul.uAlbumItems > li.album_name").live("click", function(){
        var videoid = $(this).parents("li.lVideoItem").attr("id").substring(3);
        var channelid = $(this).attr("id").substring(3);
        var clicked_sharebtn = $(this).parents("div.share_video_btn");
        postVideoToAlbum(videoid, channelid, clicked_sharebtn);
    });

    $("div.share_video_btn").live("hover", function(event){
        if (event.type == "mouseover") {
            var t_this = $(this); // in timer's callback, 'this' has changed!
            var down = $(this).find("div.dAlbumItems");
            var t = setTimeout(function() {
                if ($.browser.msie)
                {
                    t_this.find("div.share_video_btn_bl").addClass("mask");
                    t_this.find("div.share_video_btn_br").addClass("mask");
                }
                else{
                    t_this.addClass("softcorner_bottom");
                }
                down.slideDown(100);
            }, 100);
            $(this).data('timeout', t);
            
            return false;
        }
        
        if (event.type == "mouseout" ){
            clearTimeout($(this).data('timeout'));
            if ($.browser.msie && $(this).find("div.dAlbumItems").hasClass('confirm_ai'))
            {                
                return false;
            }
            else{
                slideupSharebtn($(this));
                return false;
            }
        }
        

    /*
         if ($(this).parent("div.digest") != null)
        {
            $("div.dAlbumItems:not(:animated)" ,$(this).parent("div.digest")).slideToggle(200);
        }
        if ($(this).attr("id") == "push_frame_ok")
        {
            $(this).find("div.dAlbumItems:not(:animated)").slideToggle(200);
        }

    
        if (event.type == "mouseover") {
            $("div.dAlbumItems" ,$(this).parent("div.digest")).slideDown(200);
        }
        if (event.type == "mouseout"){
            $("div.dAlbumItems" ,$(this).parent("div.digest")).slideUp(200);
        }
         */
    });


    /*
    $("div.dAlbumItems > ul.uAlbumItems > li").live("mouseover mouseout", function(event){
        if (event.type == "mouseover") {
            $(this).addClass("hilite");
        }
        if (event.type == "mouseout"){
            $(this).removeClass("hilite");
        }
    }); */

    $("div.dAlbumItems > ul.uAlbumItems > li").live("mouseover", function(){
        $(this).addClass("hilite").siblings().removeClass("hilite");
    });

    $(".create_album").live("click", function(){
        $("#iNewAlbumName").val("");
        $("#iNewAlbumName").removeClass("mask");
        $("h3#create_album_name").text("专辑名称:");
        $("h3#create_album_descrip").text("专辑描述:");
        $("#iCreateAlbumBtn").removeClass("grey_button");
        $("#iCreateAlbumBtn").addClass("blue_button");
        $("input#iCreateAlbumBtn").val("新建");
        $.colorbox({
            opacity: 0.5,
            inline: true,
            href: "#dCreateAlbumPopup"
        });
    });

    $("input#iCreateAlbumBtn").click(function(){
        $("form#fCreateAlbum").submit();
    });

    $("form#fCreateAlbum").submit(function(){
        $("#iNewAlbumName").addClass("mask");
        $("#iNewAlbumDescription").addClass("mask");
        SetNewAlbum();
        return false;
    });
});


function SetNewAlbum(){    
    var albumName = $("input#iNewAlbumName").val();

    $("#iCreateAlbumBtn").removeClass("blue_button");
    $("#iCreateAlbumBtn").addClass("grey_button");
    $("h3#create_album_feedback").text("正在新建...");
    $("input#iCreateAlbumBtn").val("正在新建...");
    $.colorbox.resize();
    $("#colorbox").css("overflow", "visible");
    if (albumName == null || albumName == "")
    {
        $("h3#create_album_feedback").text("对不起，专辑名称不能为空。");
        $("input#iCreateAlbumBtn").val("新建失败");
        setTimeout($.colorbox.close, 3000);
        return false;
    }
    var userid_temp = " ";   
    if (page_type == HOME_JSP)
    {
        userid_temp = gHostid;
    }else
    {
        userid_temp = gUserid;
    }
    $.get("createAlbum", {
        name:           albumName,
        description:    $("input#iNewAlbumDescription").val(),
        uid:            userid_temp
    },
    function(xml){
        var response_status = $(xml).find("status").text();
        var FLAG_OVERFLOW = 0;
        var CREATED_OK = 1;
        if (response_status == FLAG_OVERFLOW)
        {
            $("h3#create_album_feedback").text("专辑上限数为" + $(xml).find("albumtoplimit").text() + "个，你已经用完。");
            $("input#iCreateAlbumBtn").val("新建失败");
            $.colorbox.resize();
            $("#colorbox").css("overflow", "visible");
            setTimeout($.colorbox.close, 3000);
            return false;
        } else {
            if (response_status == DATABASE_INSERT_DUPLICATE)
            {
                $("h3#create_album_feedback").text(albumName + " 已存在！");
                $("input#iCreateAlbumBtn").val("新建失败");
                $.colorbox.resize();
                setTimeout($.colorbox.close, 3000);
                return false;
            } else {
                if (response_status == CREATED_OK) {

                    if ($("li#unpost").length > 0){
                        $("li#unpost").after("<li id=cid" + $(xml).find("cid").text()+" class='album_item'>"+albumName+"</li>");
                    }

                    if($("ul.uAlbumItems").length > 0){
                        $("ul.uAlbumItems").prepend("<li id=cid" + $(xml).find("cid").text()+" class='album_name'><a href=\"#nogo\">"+albumName+"</a></li>");
                    }
                    $("h3#create_album_feedback").text(albumName + " 新建成功！");
                    $("input#iCreateAlbumBtn").val("已新建");
                    $.colorbox.resize();
                    setTimeout($.colorbox.close, 3000);
                }
            }
        }
    });
    return true;
}

// increase watch count
function addWatchCount(videoId) {
    $.get("vcs", {
        action: "watch",
        vid: videoId
    },
    function(xml) {
        var status = $(xml).find("status").text();
        if (status != "OK") {
            msgbox("观看点击错误！");
        }
    }
    );
}

function checkLogin() {
    if (gUserid == 39 || gUserid == "undefined") {
        popLogin();
        return false;
    }
    return true;
}

function popLogin() {
    $("a#login_link").click();
    $.colorbox({
        inline: true,
        href:           "#loginbox",
        //scrolling:      false,
        opacity:        0.5
    });
}

function popJoin() {
    $("a#join_link").click();
    $.colorbox({
        inline: true,
        href:           "#loginbox",
        //scrolling:      false,
        opacity:        0.5
    });
}

// simple error handling code
function handleEmailError() {
    msgbox("email not valid!");
}

function handlePasswordError() {
    msgbox("passwords don't agree!");
}

function handleTosError() {
    msgbox("tos not checked!");
}

function msgbox(msg) {
    $.colorbox({
        html:   "<br><br><p style='text-align:center'>" + msg + "</p><br>",
        opacity:          0.5,
        initialWidth:     500,
        initialHeight:    100,
        transition:       "fade",
        onLoad:         function() {
            setTimeout($.colorbox.close, 3000);
        },
        onComplete:         function() {
            $.colorbox.resize();
        }
    });
}
function postVideoToAlbum(videoid, channelid, clicked_sharebtn) {
    $.get("albumpost",
    {
        vid: videoid,
        cid: channelid,
        uid: gUserid
    },
    function(xml){
        msgbox($(xml).find("postreply").text());
        clicked_sharebtn.addClass("shared");
        $(".share_video_btn_mid > strong", clicked_sharebtn).text("已添加");
    });
}

function slideupSharebtn(clicked_sharebtn)
{
    if ($.browser.msie)
    {
        $(clicked_sharebtn).find("div.share_video_btn_bl").removeClass("mask");
        $(clicked_sharebtn).find("div.share_video_btn_br").removeClass("mask");
    }
    else{
        $(clicked_sharebtn).removeClass("softcorner_bottom");
    }
    $(clicked_sharebtn).find("div.dAlbumItems").slideUp(100);
}
