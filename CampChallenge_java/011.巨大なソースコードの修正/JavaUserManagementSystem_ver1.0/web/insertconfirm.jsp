<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper"%>  <!-- JumsHelperクラスをimportしました -->
<%@page import="jums.UserDateBeans"%>   <!-- UserDateBeansクラスをimportしました -->

<%
    HttpSession hs = request.getSession();
    UserDateBeans udb = (UserDateBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <!--
        課題3.フォームから受け取ったデータ自体を格納できるJavaBeans(UserDataBeans.java)を作成し、これを利用して表示や分岐などをさせなさい
        課題4.insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい
    -->
    <% if(!udb.getName().equals("") && udb.getYear()!=0 && udb.getMonth()!=0 && udb.getDay()!=0
          && udb.getType()!=0 && !udb.getTell().equals("") && !udb.getComment().equals("")){%>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
    <% }else{
          if(udb.getName().equals("")){%><h1>名前</h1><%}
          if(udb.getYear()!=0){%><h1>年</h1><%}
          if(udb.getMonth()!=0){%><h1>月</h1><%}
          if(udb.getDay()!=0){%><h1>日</h1><%}
          if(udb.getType()!=0){%><h1>種別</h1><%}
          if(udb.getTell().equals("")){%><h1>電話番号</h1><%}
          if(udb.getComment().equals("")){%><h1>自己紹介文</h1><%}%>
        <h1>の入力が不完全です</h1>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>    <!-- トップページへのリンクを表示 -->
    </body>
</html>
