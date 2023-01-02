/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.QuizDAO;
import entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kien
 */
public class StartQuiz extends HttpServlet {

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
//        processRequest(request, response);
        if (request.getSession().getAttribute("test") != null) {
            request.getRequestDispatcher("jsp/doquiz.jsp").forward(request, response);
        } else {
            response.sendRedirect("Home");
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

        try {
            if (request.getSession().getAttribute("test") != null) {
                request.getRequestDispatcher("jsp/doquiz.jsp").forward(request, response);
                return;
            }
            int total = Integer.parseInt(request.getParameter("number"));
            if (total == 0) {
                request.getRequestDispatcher("jsp/takequiz.jsp").forward(request, response);
                return;
            }
            QuizDAO qDAO = new QuizDAO();
            HttpSession ses = request.getSession();
            ArrayList<Quiz> test = qDAO.makeTest(total);
            //------------------------------------------------------------------
            Date start = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(start);
            calendar.add(Calendar.MINUTE, test.size());
            Date end = calendar.getTime();
            String endTime = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aaa", Locale.ENGLISH).format(end);
            //------------------------------------------------------------------
            ses.setAttribute("endTime", endTime);
            ses.setAttribute("test", test);
            ses.setAttribute("totalQues", test.size());
            ses.setAttribute("currentQues", 1);
            if (total == 1) {
                ses.setAttribute("next", "Finish");
            } else {
                ses.setAttribute("next", "Next");
            }
            ses.setAttribute("point", 0);
            request.getRequestDispatcher("jsp/doquiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("err", e);
            request.getRequestDispatcher("jsp/err.jsp").forward(request, response);
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
