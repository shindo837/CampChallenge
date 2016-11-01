<%-- 
    Document   : DataControl_kadai4
    Created on : 2016/11/01, 13:39:15
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(セッション)</title>
    </head>
    <body>
        <%
        Date time = new Date();     //現在時刻の取得
        HttpSession hs = request.getSession(true);  //セッションの取得
        hs.setAttribute("LastLogin", time.toString());  //セッションへ情報を持たせる
        out.println("最後のログインは、"+ hs.getAttribute("LastLogin"));    //渡した名前で情報を引き出し表示
        %>
    </body>
</html>
