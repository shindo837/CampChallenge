<%-- 
    Document   : dbaccess_kadai9_2
    Created on : 2016/11/14, 15:08:15
    Author     : tomoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>結果表示</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            String name = request.getParameter("txtName");
            String birth = (request.getParameter("txtYear")+"-"+request.getParameter("txtMonth")+"-"+request.getParameter("txtDay"));
            String tell = (request.getParameter("txtNum1")+"-"+request.getParameter("txtNum2")+"-"+request.getParameter("txtNum3"));
            int id = Integer.parseInt(request.getParameter("txtID"));
            int age = Integer.parseInt(request.getParameter("txtAge"));

            Connection db_con = null;
            PreparedStatement db_stw = null;
            ResultSet db_data = null;
        
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
            
                db_stw = db_con.prepareStatement("insert into profiles(profilesID, name, tell, age, birthday) values(?, ?, ?, ?, ?)");
                db_stw.setInt(1, id);
                db_stw.setString(2, name);
                db_stw.setString(3, tell);
                db_stw.setInt(4, age);
                db_stw.setString(5, birth);
            
                int db_wdata = db_stw.executeUpdate();
            
                db_stw = db_con.prepareStatement("select * from profiles where profilesID = ?");
                db_stw.setInt(1, id);
                db_data = db_stw.executeQuery();
            
                out.println("以下の情報が入力されました。<br>");
            
                while(db_data.next()){
                    out.println("ID:" + db_data.getInt("profilesID") + "<br>");
                    out.println("名前:" + db_data.getString("name") + "<br>");
                    out.println("電話番号:" + db_data.getString("tell") + "<br>");
                    out.println("年齢" + db_data.getInt("age") + "<br>");
                    out.println("誕生日" + db_data.getString("birthday") + "<br>");
                }
            
                db_data.close();
                db_stw.close();
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
