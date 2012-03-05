/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){

    $("input#goto_alb_btn").click(function(){
        window.location.href = "home.jsp?uid=" + gUserid;
    });

    $("li#delete").click(function(){
        if (confirm("确定删除此专辑么？") && gUserid == gHostid)
        {
            $.get("album_delete", {
                uid: gUserid,
                aid: $("form.meta_frm").attr("id").substring(3)
            }, function(xml){

                });
        }
    });

    $("input#save_btn").click(function(){
        if ($("input#title").val() != $("input#title").data("last_aname")
            || $("input#descrip").val() != $("input#descrip").data("last_adescrip"))
        {
            $("form.meta_frm").submit();   
        }
    });

    $("form.meta_frm").submit(function(){
        if (gUserid == gHostid)
        {
            $("input#title").data("last_aname", $("input#title").val());
            $("input#descrip").data("last_adescrip", $("input#descrip").val());
            $.get("album_rename", {
                aname: $("input#title").val(),
                adescrip: $("input#descrip").val(),
                aid: $("form.meta_frm").attr("id").substring(3)
            }, function(xml){
                });
        }
        return false;
    });
});

