
/*
 * main js file for linking third_party sites
 */

$(document).ready(function(){
    $("#ignite_renren").click(ignite_renren);
    $("#ignite_gmail").click(function() {
        $.colorbox({
            opacity:        0.5,
            inline:         true,
            href:           "#popup_gmail"
        });
    });

    $("form#gmail_ignite_form").submit(ignite_gmail);

    $("input#disfollow_all").click(function() {
        if ($(this).attr("checked") == false) {
            $("input.contact_checkbox").attr("checked", false);
        }
    })

    $("a#follow_contacts").click(function() {
        $("span#contact_statusbar").html("您已经成功关注了这些联系人");
        $.colorbox.resize();
    })
});

function ignite_renren() {
    
}

function ignite_gmail() {
    // use ajsx, don't allow default form submission
    var gmail = $("#gmail_input_email").val();
    var gpasswd = $("#gmail_input_passwd").val();
    if (check_email(gmail, gpasswd)) {
        $.colorbox.close();
        $.get("ignite", {
            which:  "gmail",
            mail:   gmail,
            passwd: gpasswd
        },
        function(xml) {
            //var string = (new XMLSerializer()).serializeToString(xml);
            //alert(string);
            if ($(xml).find("reply > status").text() == "ERROR") {
                msgbox("Remote Server Error!");
            } else {
                var contacts = [];
                $(xml).find("reply > contact").each(function() {
                    contacts.push($(this).text());
                })
                // alert("haha " + contacts);
                $("#contact_list > h3").html("你有这些GMail好友在爱微视上");
                fill_contact_list(contacts);
                $.colorbox({
                    opacity:        0.5,
                    inline:         true,
                    href:           "#contact_list"
                });
            }
        }
        );
    }
    return false;
}

function check_email(email, passwd) {
    if (email.indexOf("@") == -1) {
        msgbox("邮箱输入错误！");
        return false;
    }

    if (passwd == "") {
        msgbox("密码不能为空！");
        return false;
    }

    return true;
}

function fill_contact_list(contacts) {
    var list = $("#contact_list > .profile_contacts > ul");
    for (key in contacts) {
        list.append('<li><a class="outside_site" href="#nogo"><img src="pic/portrait/d.48.png"/><span>' + contacts[key] + '</span></a><div class="ignite_equal">||</div><a class="inside_site" href="#nogo"><img src="pic/portrait/d.48.png"/><input class="contact_checkbox" type="checkbox" checked="true" name="user_id"  /><span>&nbsp;' + contacts[key]+ '</span></a></li>');
    }
}