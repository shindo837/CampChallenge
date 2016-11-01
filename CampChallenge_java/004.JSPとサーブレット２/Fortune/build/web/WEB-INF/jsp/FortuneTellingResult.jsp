<%-- 
    Document   : FortuneTellingResult
    Created on : 2016/09/21, 16:19:52
    Author     : tomoya
--%>

<%@page import="org.camp.servlet.ResultData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
                ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>占い</title>
    </head>
    <body>
        <%
            if (data != null) {
                out.print("<h1>あなたの"+data.getD()+"の運勢は、"+data.getLuck()+"です！</h1>");
            }
        %>
    </body>
</html>
