/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.Human;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;

import org.camp.Human.Human;    //Humanクラスをimport

/**
 *
 * @author tomoya
 */
@WebServlet(name = "blackjackservlet", urlPatterns = {"/blackjackservlet"})
public class blackjackservlet extends HttpServlet {

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
        
        Dealer d = new Dealer();    //Humanクラスを継承したDealerクラスのインスタンス生成
        User u = new User();    //Humanクラスを継承したUserクラスのインスタンス生成
        
        //インスタンスされたオブジェクトの利用
        ArrayList<Integer> cards = d.Trump();
        ArrayList<Integer> D_firstcards = d.deal();
        ArrayList<Integer> D_hitcard = d.hit();
        
        ArrayList<Integer> D_setcard = d.setCard(/*D_firstcards, D_hitcard*/);
/*
        d.setCard(D_firstcards);
        ArrayList<Integer> D_setcard = d.setCard(D_hitcard);    3枚のカード情報がある
        */        
                
        ArrayList<Integer> D_Hand = d.finishHand();
        System.out.println("check"+d.myCards);
        Integer D_total = d.open();
        ArrayList<Integer> U_firstcards = u.deal();
        
//        ArrayList<Integer> U_setcard = u.setCard(U_firstcards);

        ArrayList<Integer> U_Hand = u.finishHand();
        Integer U_total = u.open();
        String result = u.Victory_or_Defeat();
        
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet blackjackservlet</title>");            
            out.println("</head>");
            out.println("<h1>トランプ："+cards+"</h1>");
            out.println("<h1>ディーラーの最初の手札"+D_firstcards+"</h1>");
            out.println("<h1>ディーラーの追加したカード："+D_hitcard+"</h1>");
            out.println("<h1>ディーラーのカード："+D_setcard+"</h1>");
            out.println("<h1>ユーザーの最初の手札"+U_firstcards+"</h1>");
//            out.println("<h1>ユーザーのカード："+U_setcard+"</h1>");
            out.println("<h1>ディーラー<br>"+"手札："+D_Hand+"<br>合計："+D_total+"点</h1>");
            out.println("<h1>あなた<br>"+"手札："+U_Hand+"<br>合計："+U_total+"点</h1>");
            out.println("<h1>"+result+"</h1>");
            out.println("</html>");
        } finally {
            out.close();
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
