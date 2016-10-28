<%-- 
    Document   : kadai7_kiso3
    Created on : 2016/10/28, 13:07:30
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒");
        Calendar cal = Calendar.getInstance();
        cal.set(2016,10,4,10,0,0);
        Date calpast = cal.getTime();
        String sdate = sdf.format(calpast.getTime());
        out.println(sdate);
        %>
    </body>
</html>
