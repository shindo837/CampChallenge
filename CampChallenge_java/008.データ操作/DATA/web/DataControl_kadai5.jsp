<%-- 
    Document   : DataControl_kadai5
    Created on : 2016/11/01, 13:57:06
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession hs = request.getSession();    //セッションの取得
    String a = (String)hs.getAttribute("性別");
    if(a == null){
        a = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(応用)</title>
    </head>
    <body>
        <form action="./DataControl.jsp" method="post">
            
            <%//getAttributeメソッドでセッションから情報を読み出している↓%>
            名前：<input type="text" name="txtName" value="<%= hs.getAttribute("名前")%>">
            
            性別：
            <%//txtType=男が送信される%>
            <%//27行目はセッションの中の文字列を比較対象の文字列(男)と比較している%>
            男<input type="radio" name="txtType" value="男" <%if(a.equals("男")){%> checked="checked" <%}else if(a.equals("")){%> checked="checked" <%}%> >
            <%//txtType=女が送信される%>
            <%//36行目はセッションの中の文字列を比較対象の文字列(女)と比較している%>
            女<input type="radio" name="txtType" value="女" <%if(!(a.equals("")) && a.equals("女")){%> checked="checked" <%}%> ><br>
            
            <%//getAttributeメソッドでセッションから情報を読み出している↓%>
            趣味：<textarea name="txtHobby"><%= hs.getAttribute("趣味")%></textarea><br>
            <input type="submit" value="送信">

        </form>
    </body>
</html>
