<%-- 
    Document   : login
    Created on : 2016/11/17, 11:13:40
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
    </head>
    <body>
        <form action="./home.jsp" method="post">
            <table border>
                <tr>
                    <td>メールアドレス</td>
                    <td><input type="text" name="txtMail"></td>
                </tr>
                <tr>
                    <td>ユーザーID</td>
                    <td><input type="text" name="txtID"></td>
                </tr>
            </table>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
