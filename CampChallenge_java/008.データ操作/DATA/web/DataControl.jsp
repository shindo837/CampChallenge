<%-- 
    Document   : DataControl
    Created on : 2016/11/01, 14:22:26
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    request.setCharacterEncoding("UTF-8");
    //データの受け取り
    String name = request.getParameter("txtName");
    String type = request.getParameter("txtType");
    String hobby = request.getParameter("txtHobby");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(応用)</title>
    </head>
    <body>
        <%
        out.println("名前：" + name + "<br>");
        out.println("性別：" + type + "<br>");
        out.println("趣味：" + hobby);
        
        HttpSession hs = request.getSession();  //セッションの取得
        //セッションへ情報を持たせる
        hs.setAttribute("名前", name);
        hs.setAttribute("性別", type);
        hs.setAttribute("趣味", hobby);
        %>
    </body>
</html>
