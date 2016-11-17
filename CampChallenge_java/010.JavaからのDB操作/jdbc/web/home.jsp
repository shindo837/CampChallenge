<%-- 
    Document   : home
    Created on : 2016/11/17, 11:55:12
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ホーム画面</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String mail = request.getParameter("txtMail");
            String id = request.getParameter("txtID");
            
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            String ru = null;
            String rm = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
            
                db_st = db_con.prepareStatement("select userID, mail from user_infomation where userID = ? and mail = ?");
                db_st.setString(1, id);
                db_st.setString(2, mail);
                db_data = db_st.executeQuery();
            
                while(db_data.next()){
                    ru = db_data.getString("userID");
                    rm = db_data.getString("mail");
                }
        
        if(id.equals(ru) && mail.equals(rm)){%>
                
                <form action="./registration.jsp" method="post">
                    <input type="submit" name="submit1" value="登録画面">
                </form>
                <form action="./display" method="post">
                    <input type="submit" name="submit2" value="商品一覧">
                </form>
                
        <%}else{
            out.println("ログインできませんでした。<br>");
            out.println(ru+"<br>"+rm+"<br>"+id+"<br>"+mail);
          }
           db_data.close();
           db_st.close();
           db_con.close();
            
           }catch(SQLException e_sql){
               out.println("接続時にエラーが発生しました"+e_sql.toString());
           }catch(Exception e){
               out.println("接続時にエラーが発生しました"+e.toString());
           }finally{
               if(db_con != null){
                   try{
                       db_con.close();
                   }catch(Exception e_con){
                       System.out.println(e_con.getMessage());
                   }
               }
           }
        %>
    </body>
</html>
