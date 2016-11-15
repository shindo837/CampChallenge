<%-- 
    Document   : dbaccess_kadai9_1
    Created on : 2016/11/14, 15:07:51
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="import java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データベース入力</title>
    </head>
    <body>
        <form action="./dbaccess_kadai9_2.jsp" method="post">
            ID:<input type="number" name="txtID">
            名前：<input type="text" name="txtName">
            年齢：<input type="number" name="txtAge">歳<br>
            生年月日：<input type="number" name="txtYear">年<input type="number" name="txtMonth">月<input type="number" name="txtDay">日<br>
            電話番号：<input type="number" name="txtNum1"> - <input type="number" name="txtNum2"> - <input type="number" name="txtNum3"><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
