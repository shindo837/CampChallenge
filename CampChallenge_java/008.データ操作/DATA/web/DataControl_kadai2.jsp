<%-- 
    Document   : DataControl_kadai2
    Created on : 2016/11/01, 11:10:30
    Author     : tomoya
--%>

<%
    request.setCharacterEncoding("UTF-8");
    //データの受け取り
    String name = request.getParameter("名前");
    String male = request.getParameter("男");
    String female = request.getParameter("女");
    String hobby = request.getParameter("趣味");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(データ取得)</title>
    </head>
    <body>
        <%
        out.println("名前：" + name + "<br>");
        if(male != null){
            out.println("性別："+male+"<br>");
        }else if(female != null){
            out.println("性別："+female+"<br>");
        }
        out.println("趣味：" + hobby);
        %>
    </body>
</html>
