<%-- 
    Document   : kadai7_kiso6
    Created on : 2016/10/28, 13:08:21
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String mail = "tomoya.g.shindo@gmail.com";
        out.println(mail.substring(15));
        %>
    </body>
</html>
