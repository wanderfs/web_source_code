/* 
 * define actions on user_setting.jsp
 */

$(document).ready(function(){
    var tabs = $("#settings_options > li");
    var forms = $("#columnB > form");

    $("#info_tab").click(function(e) {
        tabs.removeClass("current");
        $(this).addClass("current");

        forms.addClass("mask");
        $("#info_form").removeClass("mask");
    });

    $("#portrait_tab").click(function(e) {
        tabs.removeClass("current");
        $(this).addClass("current");

        forms.addClass("mask");
        $("#default_portrait_form").removeClass("mask");
    });

    $("#password_tab").click(function(e) {
        tabs.removeClass("current");
        $(this).addClass("current");

        forms.addClass("mask");
        $("#password_form").removeClass("mask");
    });

    $("#password_form").submit(function(e) {
        if ($("#password").val() != $("#rewrite_password").val()) {
            alert("passwords don't agree!");
            return false;
        }
        if ($("#password").val() == "") {
            alert("passwords cannot be empty!");
            return false;
        }
        return true;
    });

    $("div.ddp > div.dp_wrapper").click (function(e) {
        $("div.ddp > div.dp_wrapper > img").css("border", "none");
        $("img", this).css("border", "4px solid #A8DE86");
    });
});
