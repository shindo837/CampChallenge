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
public class processing extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("txtUser"));
        String name = request.getParameter("txtName");
        int price  = Integer.parseInt(request.getParameter("txtPrice"));
        int value  = Integer.parseInt(request.getParameter("txtValue"));
        
        Connection db_con = null;
        PreparedStatement db_stw = null;
        ResultSet db_data = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
            
            db_stw = db_con.prepareStatement("insert into product_infomation(productID, product_name, price, stock) values(?, ?, ?, ?)");
            db_stw.setInt(1, id);
            db_stw.setString(2, name);
            db_stw.setInt(3, price);
            db_stw.setInt(4, value);
            
            int db_wdata = db_stw.executeUpdate();
            
            db_stw = db_con.prepareStatement("select * from product_infomation");
            db_data = db_stw.executeQuery();
            
            out.println("<h1>商品が登録されました。</h1><br>");
            out.println("<a href=\"login.jsp\"><span class=\"select\">[TOPページ]</span></a>");
            out.println("<a href=\"logout.jsp\"><span class=\"select\">[ログアウト]</span></a>");
            
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
