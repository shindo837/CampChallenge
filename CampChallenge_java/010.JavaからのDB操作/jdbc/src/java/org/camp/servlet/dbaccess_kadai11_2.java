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
public class dbaccess_kadai11_2 extends HttpServlet {

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
        
        int id = Integer.parseInt(request.getParameter("txtID"));
        int age = Integer.parseInt(request.getParameter("txtAge"));
        String name = request.getParameter("txtName");
        String tell  = (request.getParameter("txtNum1")+"-"+request.getParameter("txtNum2")+"-"+request.getParameter("txtNum3"));
        String birth  = (request.getParameter("txtYear")+"-"+request.getParameter("txtMonth")+"-"+request.getParameter("txtDay"));
        
        Connection db_con = null;
        PreparedStatement db_stu = null;
        ResultSet db_data = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "shindo", "password");
            
            db_stu = db_con.prepareStatement("update profiles set name = ?, tell = ?, age = ?, birthday = ? where profilesID = ?");
            db_stu.setString(1, name);
            db_stu.setString(2, tell);
            db_stu.setInt(3, age);
            db_stu.setString(4, birth);
            db_stu.setInt(5, id);
            
            int db_udata = db_stu.executeUpdate();            
            
            db_stu = db_con.prepareStatement("select * from profiles");
            db_data = db_stu.executeQuery();
            
            while(db_data.next()){
                out.println("ID:"+db_data.getInt("profilesID")+"<br>");
                out.println("名前:"+db_data.getString("name")+"<br>");
                out.println("電話番号:"+db_data.getString("tell")+"<br>");
                out.println("年齢:"+db_data.getInt("age")+"<br>");
                out.println("誕生日:"+db_data.getDate("birthday")+"<br>");
            }
            
            db_data.close();
            db_stu.close();
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
