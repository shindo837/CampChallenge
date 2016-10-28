<%-- 
    Document   : kadai7_kiso1
    Created on : 2016/10/28, 11:58:44
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
            Calendar cal = Calendar.getInstance();
            cal.set(2016,0,1,0,0,0);
            Date calpast = cal.getTime();
            out.println(calpast.getTime());
        %>
    </body>
</html>
