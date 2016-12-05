<%@page import="javax.servlet.http.HttpSession"
        import="jums.UserDataBeans"
        import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報検索画面</title>
    </head>
    <body>
         <form action="SearchResult" method="POST"><!--ユーザーにみせてもいいものはGET(文字数制限あり)で、みせたくないものはPOST-->
        名前:
        <input type="text" name="name" value="<%if(udb!=null){ out.println(udb.getName()); }%>">
        <br><br>

        生年:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<%if(udb!=null&&udb.getYear()==i){%> selected="selected" <%}%>><%=i%></option>
            <% } %>
        </select>年生まれ
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(udb!=null&&udb.getType()==i){%> checked="checked" <%}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="検索">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
