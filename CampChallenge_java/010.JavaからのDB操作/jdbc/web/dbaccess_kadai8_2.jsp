<%-- 
    Document   : dbaccess_kadai8_2
    Created on : 2016/11/14, 13:38:33
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索結果</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String namae = request.getParameter("名前");
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
                db_st = db_con.prepareStatement("select * from profiles where name like ?");
                db_st.setString(1, "%"+namae+"%");
                db_data = db_st.executeQuery();
                
                while(db_data.next()){
                    out.println("<table><tr><td>ID:</td><td>"+db_data.getInt("profilesID")+"</td></tr>");
                    out.println("<tr><td>名前:</td><td>"+db_data.getString("name")+"</td></tr>");
                    out.println("<tr><td>電話番号:</td><td>"+db_data.getString("tell")+"</td></tr>");
                    out.println("<tr><td>年齢:</td><td>"+db_data.getInt("age")+"</td><tr>");
                    out.println("<tr><td>誕生日:</td><td>"+db_data.getDate("birthday")+"</td></tr></table>");
                }
                db_data.close();
                db_st.close();
                db_con.close();
            }catch(SQLException e_sql){
                out.println("接続時にエラーが発生しました："+e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました："+e.toString());
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
