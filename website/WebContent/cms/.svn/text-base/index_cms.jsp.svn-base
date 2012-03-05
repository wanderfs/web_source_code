<%-- 
    Document   : index
    Created on : Feb 18, 2011, 5:12:17 PM
    Author     : Sen

    This page can only be accessed by webpage editors from browser. Do NOT try
    to hard-code or hand-change any thing if you are not a developer.
--%>

<%@page import="cms.IndexContentManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    String type = request.getParameter("type");

    if (type != null) {
        String[] vids = request.getParameter("vserial").split(",");
        IndexContentManager mgr = IndexContentManager.getInstance();
        if (type.equals("renren")) {
            mgr.renrenHotList.clear();
            for (String vid : vids)
                mgr.renrenHotList.add(Integer.parseInt(vid));
        } else if (type.equals("kaixin")) {
            mgr.kaixinHotList.clear();
            for (String vid : vids)
                mgr.kaixinHotList.add(Integer.parseInt(vid));
        } else if (type.equals("qzone")) {
            mgr.qzoneHotList.clear();
            for (String vid : vids)
                mgr.qzoneHotList.add(Integer.parseInt(vid));
        } else if (type.equals("iweishi")) {
            mgr.iweishiHotList.clear();
            for (String vid : vids)
                mgr.iweishiHotList.add(Integer.parseInt(vid));
        }
        response.sendRedirect("index_cms.jsp");
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>首页内容管理</title>
    </head>
    <body>
        <h1>人人网Hot</h1>
        <form action="index_cms.jsp" method="post">
            <input type="hidden" name="type" value="renren"/>
            填入十大视频的vid序列，用逗号隔开：<input type="text" name="vserial"/>
            <input type="submit" value="submit" />
        </form>
        <h1>开心网Hot</h1>
        <form action="index_cms.jsp" method="post">
            <input type="hidden" name="type" value="kaixin"/>
            填入十大视频的vid序列，用逗号隔开：<input type="text" name="vserial"/>
            <input type="submit" value="submit" />
        </form>
        <h1>QQ空间Hot</h1>
        <form action="index_cms.jsp" method="post">
            <input type="hidden" name="type" value="qzone"/>
            填入十大视频的vid序列，用逗号隔开：<input type="text" name="vserial"/>
            <input type="submit" value="submit" />
        </form>
        <h1>爱微视Hot</h1>
        <form action="index_cms.jsp" method="post">
            <input type="hidden" name="type" value="iweishi"/>
            填入十大视频的vid序列，用逗号隔开：<input type="text" name="vserial"/>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
