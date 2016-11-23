<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDateBeans"%>   <!-- UserDateBeansクラスをimportしました --
<%
    HttpSession hs = request.getSession();
    UserDateBeans udb = (UserDateBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--
    課題5.insertconfirmからinsertへ再度入力する際に、このままではフォームに値が保持されていない。
    適切な処理を施して、再度入力の際にはフォームに値を保持したままにさせなさい
-->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%if(udb!=null&&!udb.getName().equals("")){ out.println(udb.getName()); }%>">    
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <%if(udb!=null&&i==udb.getYear()){%> selected="selected" <%}%>> <%=i%> </option>
            <%}%>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <%if(udb!=null&&i==udb.getMonth()){%> selected="selected" <%}%>> <%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <%if(udb!=null&&i==udb.getDay()){%> selected="selected" <%}%>> <%=i%></option>
            <% } %>
        </select>
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%if(udb!=null&&udb.getType()==1){%> checked="checked" <%}%> >エンジニア<br>
        <input type="radio" name="type" value="2" <%if(udb!=null&&udb.getType()==2){%> checked="checked" <%}%> >営業<br>
        <input type="radio" name="type" value="3" <%if(udb!=null&&udb.getType()==3){%> checked="checked" <%}%> >その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%if(udb!=null&&!udb.getTell().equals("")){ out.println(udb.getTell()); }%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%if(udb!=null&&!udb.getComment().equals("")){ out.println(udb.getComment()); }%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
