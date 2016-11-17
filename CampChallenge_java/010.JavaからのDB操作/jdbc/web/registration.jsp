<%-- 
    Document   : registration
    Created on : 2016/11/17, 11:31:40
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録画面</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            
            if(request.getParameter("submit1") != null){%>
        <form action="./processing" method="post">
            <table border>
                <tr>
                    <td>商品ID</td>
                    <td><input type="number" name="txtUser"></td>
                </tr>
                <tr>
                    <td>商品名</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                <tr>
                    <td>値段</td>
                    <td><input type="number" name="txtPrice"></td>
                </tr>
                <tr>
                    <td>個数</td>
                    <td><input type="number" name="txtValue"></td>
                </tr>
            </table>
            <input type="submit" value="登録"><br>
        </form>
        <%}else{
              out.println("null");
          }%>
    </body>
</html>
