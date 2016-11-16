<%-- 
    Document   : dbaccess_kadai12_1
    Created on : 2016/11/16, 10:19:26
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ検索</title>
    </head>
    <body>
        <form action="./dbaccess_kadai12_2" method="post">
            <table>
                ○検索内容の入力<br>
                <tr><td>名前：</td><td><input type="text" name="txtName"></td></tr>
                <tr><td>年齢：</td><td><input type="number" name="txtAge"></td></tr>
                <tr><td>誕生日：</td><td><input type="number" name="txtBirth"></td></tr>
                <tr><td><input type="submit" value="検索"></td></tr>
            </table>
        </form>
    </body>
</html>
