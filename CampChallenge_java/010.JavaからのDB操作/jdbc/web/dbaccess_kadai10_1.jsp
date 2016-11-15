<%-- 
    Document   : dbaccess_kadai10_1
    Created on : 2016/11/15, 14:19:51
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データの削除</title>
    </head>
    <body>
        <form action="./dbaccess_kadai10_2" method="post">
            profilesID：<input type="number" name="txtID">
            <input type="submit" value="削除">
        </form>
        <%
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
                db_st = db_con.prepareStatement("select * from profiles");
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.println("ID:"+db_data.getInt("profilesID")+"<br>");
                    out.println("名前:"+db_data.getString("name")+"<br>");
                    out.println("電話番号:"+db_data.getString("tell")+"<br>");
                    out.println("年齢:"+db_data.getInt("age")+"<br>");
                    out.println("誕生日:"+db_data.getDate("birthday")+"<br>");
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
