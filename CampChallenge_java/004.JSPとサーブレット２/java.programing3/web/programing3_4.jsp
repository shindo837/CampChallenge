<%-- 
    Document   : programing3_4
    Created on : 2016/09/30, 15:33:07
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList"%>
<%@page import="java.io.IOException"%>

<%!
    public boolean getProfile(JspWriter out) throws IOException {
        ArrayList<String> mine = new ArrayList<String>();

        out.println("進藤友弥<br>");
        out.println("1994年08月18日<br>");
        out.println("趣味は料理です。<br>");

        return true;
    }
%>

<%
    for (int x = 1; x <= 10; x++) {
        out.print(x + "回目<br>");
        if (getProfile(out)) {
            out.println("【この処理は正しく実行されました。】<br>");
        } else {
            out.println("【この処理は正しく実行できませんでした。】<br>");
        }
            out.println("<br>");
    }
%>