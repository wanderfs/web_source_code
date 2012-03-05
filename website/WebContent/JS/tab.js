
$(document).ready(function() {

    var NONE = 0;
    var LOADING = 1;
    var READY = 2;

    //columnA's tabs
    var tabs = $("#columnA > div.tabs > ul > li");
    var content_wrapper = $("#content_wrapper");

    /****** tabs in index.jsp and user_index.jsp ******/

    var hotlist_state = NONE;
    $("li#hot_tab").click(function(e) {
        urlAnchorTo("hot_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");
         
        if (hotlist_state == READY) {
            $("#video_hotlist").removeClass("mask");
            return false;
        }

        $("#loading").removeClass("mask");
        if (hotlist_state == LOADING) {
            return false;
        }

        hotlist_state = LOADING;
        $.get("jspf/hotlist.jsp?time=" + (new Date()).getTime(), {},
            function(hotlist_html) {
                if ($("div#video_hotlist > div.videos_meat > div.clips > div.obiwan").length > 0)
                    $(hotlist_html).insertAfter("div#video_hotlist > div.videos_meat > div.clips > div.obiwan");
                else
                    $("div#video_hotlist > div.videos_meat > div.clips").prepend(hotlist_html);
                hotlist_state = READY;
                if ($("li#hot_tab").hasClass("active")) {
                    $("#loading").addClass("mask");                   
                    $("#video_hotlist").removeClass("mask");
                    $("div.dAlbumItems").removeClass("mask");
                    if ($.browser.mozilla)
                    {
                        $("div.dAlbumItems > ul.uAlbumItems > li.album_name").textOverflow();
                    }
                    $("div.dAlbumItems").addClass("mask");
                }
                // it's first time load this tab, should initialize already_has values.
                $("#video_hotlist").data("already_has", countVideosInList("#video_hotlist"));
            });
    });

    var newlist_state = NONE;
    $("li#new_tab").click(function(e) {
        urlAnchorTo("new_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");

        if (newlist_state == READY) {
            $("#video_newlist").removeClass("mask");
            return false;
        }

        $("#loading").removeClass("mask");
        if (newlist_state == LOADING) {
            return false;
        }

        newlist_state = LOADING;
        $.get("jspf/newlist.jsp?time=" + (new Date()).getTime(), {},
            function(newlist_html) {
                if ($("div#video_newlist > div.videos_meat > div.clips > div.obiwan").length > 0)
                    $(newlist_html).insertAfter("div#video_newlist > div.videos_meat > div.clips > div.obiwan");
                else
                    $("div#video_newlist > div.videos_meat > div.clips").prepend(newlist_html);
                newlist_state = READY;
                if ($("li#new_tab").hasClass("active")) {
                    $("#loading").addClass("mask");                    
                    $("#video_newlist").removeClass("mask");
                    $("div.dAlbumItems").removeClass("mask");
                    if ($.browser.mozilla)
                    {
                        $("div.dAlbumItems > ul.uAlbumItems > li.album_name").textOverflow();
                    }
                    $("div.dAlbumItems").addClass("mask");
                }
                $("#video_newlist").data("already_has", countVideosInList("#video_newlist"));
            });
    });

    var global_activity_state = NONE;
    $("li#explore_tab").click(function(e) {
        urlAnchorTo("explore_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");

        if (global_activity_state == READY) {
            $("#global_activity").removeClass("mask");
            return false;
        }

        $("#loading").removeClass("mask");
        if (global_activity_state == LOADING) {
            return false;
        }

        global_activity_state = LOADING;
        $.get("jspf/hangaround.jsp?type=global&time=" + (new Date()).getTime(), {},
            function(activity_html) {
                $("#global_activity_insides > .activity").prepend(activity_html);
                global_activity_state = READY;
                if ($("li#explore_tab").hasClass("active")) {
                    $("#loading").addClass("mask");
                    $("#global_activity").removeClass("mask");
                }
                $("#global_activity_insides").data("already_has", countActivitiesInList("#global_activity_insides"));
            }
            );
    });

    $("li#newAlbumTab").click(function(e) {
        urlAnchorTo("newAlbumTab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");
        $("div#albumNewlist").removeClass("mask");

    /*
        if (newAlbumState == READY) {
            $("#albumNewlist").removeClass("mask");
            return false;
        }

        $("#loading").removeClass("mask");
        if (newAlbumState == LOADING) {
            return false; //why return? and next time the how's the state?'
        }

        newAlbumState = LOADING;
        $.get("jspf/newAlbumlist.jsp", {},
            function(albumlistHtml) {
                $("div#albumNewlist > div.albumMeat > div.clips").prepend(albumlistHtml);
                newAlbumState = READY;
                if ($("li#newAlbumTab").hasClass("active")) {
                    $("#loading").addClass("mask");
                    $("#albumNewlist").removeClass("mask");
                }
            }
            );*/
    });

    var my_activity_state = NONE;
    $("li#activity_tab").click(function(e) {
        urlAnchorTo("activity_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");

        if (my_activity_state == READY) {
            $("#my_activity").removeClass("mask");
            return false;
        }

        $("#loading").removeClass("mask");
        if (my_activity_state == LOADING) {
            return false;
        }

        my_activity_state = LOADING;
        $.get("jspf/hangaround.jsp?type=mine&time=" + (new Date()).getTime(), {},
            function(activity_html) {
                $("#my_activity_insides > .activity").prepend(activity_html);
                my_activity_state = READY;
                if ($("li#activity_tab").hasClass("active")) {
                    $("#loading").addClass("mask");
                    $("#my_activity").removeClass("mask");
                }
                $("#my_activity_insides").data("already_has", countActivitiesInList("#my_activity_insides"));
            }
            );
    });

    /****** tabs in home.jsp ******/

    $("li#collected_tab").click(function(e) {
        urlAnchorTo("collected_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");
        if ($("div#loading_albumvideos").hasClass("loading_albumvideos"))
        {
            $("div#loading_albumvideos").removeClass("mask");
        }
        else{
            $("#content_wrapper > div.last_open").removeClass("mask");
        }
        $("div.toobar").removeClass("mask");
    });
 
    var imported_videos_state = NONE;
    $("li#imported_tab").click(function(e) {
        urlAnchorTo("imported_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");

        if (imported_videos_state == READY) {
            $("#imported_videos").removeClass("mask");
            return false;
        }

        $("#loading_imported_videos").removeClass("mask");
        if (imported_videos_state == LOADING) {
            return false;
        }

        imported_videos_state = LOADING;
        $.get("jspf/homeclips.jsp?time=" + (new Date()).getTime(),
        {
            type:   "imported",
            uid:    gHostid
        },
        function(newlist_html) {
            $("#imported_videos > div.videos_meat > div.clips").prepend(newlist_html);
            imported_videos_state = READY;
            if ($("li#imported_tab").hasClass("active")) {
                $("#loading_imported_videos").addClass("mask");
                $("#imported_videos").removeClass("mask");
            }
        }
        );
    });

    var watched_videos_state = NONE;
    $("li#watched_tab").click(function(e) {
        urlAnchorTo("watched_tab");
        tabs.removeClass("active");
        $(this).addClass("active");
        $("#content_wrapper > div").addClass("mask");
        $("div.wrappertop").removeClass("mask");
        $("div.wrapper_bottom").removeClass("mask");

        if (watched_videos_state == READY) {
            $("#watched_videos").removeClass("mask");
            return false;
        }

        $("#loading_watched_videos").removeClass("mask");
        if (watched_videos_state == LOADING) {
            return false;
        }

        watched_videos_state = LOADING;
        $.get("jspf/homeclips.jsp?time=" + (new Date()).getTime(),
        {
            type:   "watched",
            uid:    gHostid
        },
        function(newlist_html) {
            $("#watched_videos > div.videos_meat > div.clips").prepend(newlist_html);
            watched_videos_state = READY;
            if ($("li#watched_tab").hasClass("active")) {
                $("#loading_watched_videos").addClass("mask");
                $("#watched_videos").removeClass("mask");
            }
        }
        );
    });
});

