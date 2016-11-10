/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;  //①
/**
 *
 * @author tomoya
 */
public class dbaccess_kadai4 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection db_con = null;   //②
        PreparedStatement db_st = null;   //SQLを実行するのに必要
        ResultSet db_data = null;   //select文などの結果を取得するのに必要
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();   //③
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");     //④
            // ageが30のデータを取得
            db_st = db_con.prepareStatement("select * from profiles where profilesID = ?");    //引数として実行したいSQL文を渡す
            db_st.setInt(1, 1);    //「?」への設定
            
            db_data = db_st.executeQuery();     //実地すると結果が返却される
            while(db_data.next()){
                out.println("ID:"+db_data.getInt("profilesID")+"<br>");
                out.println("名前:"+db_data.getString("name")+"<br>");
                out.println("電話番号:"+db_data.getString("tell")+"<br>");
                out.println("年齢:"+db_data.getInt("age")+"<br>");
                out.println("誕生日:"+db_data.getDate("birthday")+"<br>");
            }
            
            db_data.close();
            db_st.close();
            db_con.close();     //⑤
        }catch(SQLException e_sql){
            out.println("接続時にエラーが発生しました："+e_sql.toString());
        }catch(Exception e){
            out.println("接続時にエラーが発生しました："+e.toString());
        } finally {
            if(db_con != null){
                try{
                    db_con.close();
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
