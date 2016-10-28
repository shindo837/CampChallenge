<%-- 
    Document   : kadai7_kiso8
    Created on : 2016/10/28, 13:08:58
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        File txt = new File("C:\\Users\\tomoya\\Documents\\CampChallenge\\Challenge\\CampChallenge_java\\007.標準クラス\\profile.txt");

        FileWriter fw = new FileWriter(txt);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("進藤友弥です。");
        bw.write("よろしくお願いします。");

        bw.close();
        %>
    </body>
</html>
