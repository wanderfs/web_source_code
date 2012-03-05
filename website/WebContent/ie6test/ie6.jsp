<%-- 
    Document   : ie6
    Created on : 2010-10-23, 17:19:25
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en" xmlns:v="urn:schemas-microsoft-com:vml" >
    <head>
        <title>爱微视 iweishi</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="ie6.css" rel="stylesheet" type="text/css" />
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
    </head>

    <body>
     

        <jsp:include page="../jspf/hotlist.jsp" />
        <script type="text/javascript">
            $(document).ready(function(){
                var hotlist = $("ul.videos");
                  $("li > .digest > .cancel", hotlist).live("click", function(e) {
        //$("li > .digest > .cancel", hotlist).click(function(e) {
        var clicked = $(e.target).parents("li");
        $("div.thumbnail > div.embeded_code", clicked).html("");
        clicked.slideToggle(clicked.height()*4);
        if (clicked.hasClass("videos_top")) {
            clicked.next().addClass("videos_top");
        }
        return false;
    });
            });
        </script>
    </body>
</html>
