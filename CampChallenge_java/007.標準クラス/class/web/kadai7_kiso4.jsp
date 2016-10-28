<%-- 
    Document   : kadai7_kiso4
    Created on : 2016/10/28, 13:07:49
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
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        
        cal1.set(2015,11,31,23,59,59);
        cal2.set(2015,0,1,0,0,0);
        
        Date calpast1 = cal1.getTime();
        Date calpast2 = cal2.getTime();
        
        out.println(calpast1.getTime() - calpast2.getTime());
        %>
    </body>
</html>
