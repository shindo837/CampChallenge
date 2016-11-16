<%-- 
    Document   : dbaccess_kadai11_1
    Created on : 2016/11/15, 17:02:43
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データの上書き</title>
    </head>
    <body>
        <form action="./dbaccess_kadai11_2" method="post">
            <table>
                <tr>
                    <td>○上書きするデータのID：</td>
                    <td><input type="number" name="txtID"></td>
                </tr>
                <tr>
                    <td>○内容</td>
                </tr>
                <tr>
                    <td>・名前:</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                <tr>
                    <td>・年齢:</td>
                    <td><input type="number" name="txtAge">歳</td>
                </tr>
                <tr>    
                    <td>・生年月日:</td>
                    <td><input type="number" name="txtYear">年<input type="number" name="txtMonth">月<input type="number" name="txtDay">日</td>
                </tr>
                <tr>
                    <td>・電話番号:</td>
                    <td><input type="number" name="txtNum1"> - <input type="number" name="txtNum2"> - <input type="number" name="txtNum3"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="更新"><td>
                </tr>
            </table>
        </form>
        <%
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
                db_st = db_con.prepareStatement("select * from profiles");
                
                out.println("<br>○現在登録されているデータ<br>");
                
                db_data = db_st.executeQuery();
                while(db_data.next()){
                    out.println("ID:"+db_data.getInt("profilesID")+"<br>");
                    out.println("名前:"+db_data.getString("name")+"<br>");
                    out.println("電話番号:"+db_data.getString("tell")+"<br>");
                    out.println("年齢:"+db_data.getInt("age")+"<br>");
                    out.println("誕生日:"+db_data.getDate("birthday")+"<br><br>");
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
