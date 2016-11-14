<%-- 
    Document   : DataControl_kadai1
    Created on : 2016/11/01, 10:43:52
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(データ入力)</title>
    </head>
    <body>
        <form action="./DataControl_kadai2.jsp" method="post">
            名前:<input type="text" name="名前">
            性別:男<input type="radio" name="Type" value="男">女<input type="radio" name="Type" value="女"><br>
            趣味:<textarea name="趣味"></textarea><br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
