<%-- 
    Document   : kadai7_kiso9
    Created on : 2016/10/28, 13:09:17
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
        String str;
        
        File txt = new File("C:\\Users\\tomoya\\Documents\\CampChallenge\\Challenge\\CampChallenge_java\\007.標準クラス\\profile.txt");
        
        FileReader fr = new FileReader(txt);
        
        BufferedReader br = new BufferedReader(fr);
        
        while((str = br.readLine()) != null){
            out.println(str+"<br>");
        }
        
        br.close();
        %>
    </body>
</html>
