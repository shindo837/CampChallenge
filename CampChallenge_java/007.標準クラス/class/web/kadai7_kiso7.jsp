<%-- 
    Document   : kadai7_kiso7
    Created on : 2016/10/28, 13:08:41
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
        String i = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしています";
        i = i.replace("I","い");
        i = i.replace("U", "う");
        
        out.println(i);
        %>
    </body>
</html>
