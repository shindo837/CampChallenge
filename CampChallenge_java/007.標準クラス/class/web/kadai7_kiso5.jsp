<%-- 
    Document   : kadai7_kiso5
    Created on : 2016/10/28, 13:08:05
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
        String name = "進藤友弥";
        
        out.println(name.length());
        out.println("<br>");
        
        out.println(name.getBytes().length);
        %>
    </body>
</html>
