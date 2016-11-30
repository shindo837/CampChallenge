<%@page import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataDTO" %>
<%
    HttpSession hs = request.getSession();
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= jh.exTypenum(udd.getType())%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい" style="width:100px">
      <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
      <input type="hidden" name="id"  value="<%= udd.getUserID()%>">
    </form>
    <form action="ResultDetail" method="POST">
      <input type="submit" name="NO" value="いいえ" style="width:100px">
      <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
    <%=jh.home()%>
    </body>
</html>
