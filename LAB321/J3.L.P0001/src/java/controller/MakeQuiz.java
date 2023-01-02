/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.QuizDAO;
import entity.Quiz;
import entity.UserInfor;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kien
 */
public class MakeQuiz extends HttpServlet {

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
        UserInfor info = (UserInfor) request.getSession().getAttribute("user");
        if (info == null) {
             response.sendRedirect("Home");
        } else {
            request.getRequestDispatcher("jsp/make.jsp").forward(request, response);
        }

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
//        processRequest(request, response);
        try {
            HttpSession ses = request.getSession();
            UserInfor uInfo = (UserInfor) ses.getAttribute("user");
            int uID = uInfo.getId();
            String ques = request.getParameter("question");
            String op1 = request.getParameter("option1");
            String op2 = request.getParameter("option2");
            String op3 = request.getParameter("option3");
            String op4 = request.getParameter("option4");
            String[] answ = request.getParameterValues("answer");
            String ans = Quiz.createAnswer(answ);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDateTime createdDate = LocalDateTime.now();
            new QuizDAO().addNewQuiz(ques, op1, op2, op3, op4, ans, uID, dtf.format(createdDate));
            request.setAttribute("msg", "Add Success!");
            request.getRequestDispatcher("jsp/make.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("MakeQuiz-----" + e);
        }
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
