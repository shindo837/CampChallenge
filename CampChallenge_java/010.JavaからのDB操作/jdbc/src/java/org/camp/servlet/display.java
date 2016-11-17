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

import java.sql.*;

/**
 *
 * @author tomoya
 */
public class display extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
        
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        if(request.getParameter("submit2") != null){
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
                
                db_st = db_con.prepareStatement("select * from product_infomation");
                db_data = db_st.executeQuery();
                
                while(db_data.next()){
                    out.println("<table border><tr><td>商品ID</td><td>" + db_data.getInt("productID") + "</td></tr>");
                    out.println("<tr><td>商品名</td><td>" + db_data.getString("product_name") + "</td></tr>");
                    out.println("<tr><td>値段</td><td>" + db_data.getString("price") + "</td></tr>");
                    out.println("<tr><td>在庫数</td><td>" + db_data.getInt("stock") + "</td></tr></table><br>");
                }
                
                out.println("<a href=\"login.jsp\"><span class=\"select\">[TOPページ]</span></a>");
                out.println("<a href=\"logout.jsp\"><span class=\"select\">[ログアウト]</span></a>");
                
                db_data.close();
                db_st.close();
                db_con.close();
            
            }catch(SQLException e_sql){
                out.println("接続時にエラーが発生しました"+e_sql.toString());
            }catch(Exception e){
                out.println("接続時にエラーが発生しました"+e.toString());
            }finally {
                out.close();
            }
        }else{
            out.println("null");
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
