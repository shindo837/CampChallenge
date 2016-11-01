<%-- 
    Document   : DaraControl_kadai3
    Created on : 2016/11/01, 13:17:17
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作(クッキー)</title>
    </head>
    <body>
        <%
            //Cookieに現在時刻を記録
            Date time = new Date();     //現在時刻の取得
            Cookie c = new Cookie("LastLogin", time.toString());    //Cookieの初期化
            response.addCookie(c);
            
            //記録した日時を表示
            Cookie cs[] = request.getCookies();     //Cookieの配列を取得
            if(cs != null){
                for(int i=0; i<cs.length; i++){
                    if(cs[i].getName().equals("LastLogin")){    //渡した名前で情報の引き出し
                        out.println("最後のログインは、" + cs[i].getValue());   //日時の表示
                        break;
                    }
                }
            }
            %>
    </body>
</html>
