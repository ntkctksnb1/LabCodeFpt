/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kien
 */
public class Next extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Next</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Next at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
        HttpSession ses = request.getSession();
        ArrayList<Quiz> test = (ArrayList<Quiz>) ses.getAttribute("test");
        if (test != null) {
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
//        processRequest(request, response);
        HttpSession ses = request.getSession();
        ArrayList<Quiz> test = (ArrayList<Quiz>) ses.getAttribute("test");
        int currentQues = (int) ses.getAttribute("currentQues");
        int totalQues = (int) ses.getAttribute("totalQues");
        int point = (int) ses.getAttribute("point");
        String[] ans = request.getParameterValues("answer");
        boolean qRelsult = test.get(currentQues - 1).checkAnswer(ans);
//        System.out.println("NEXT PT1--------------------");
        System.out.println(qRelsult + "-------------------------");
        String path;
        if (qRelsult) {

            point++;
        }
        System.out.println("Next-----------" + point);
//        System.out.println("NEXT PT2--------------------");

//        System.out.println(path);
        if (currentQues == totalQues - 1) {
            ses.setAttribute("next", "Finish");
        }

//         System.out.println("NEXT PT3--------------------");
        currentQues++;
        if (currentQues == totalQues + 1) {
            path = "Finish";
//            ses.setAttribute("finish", true);
        } else {
            path = "jsp/doquiz.jsp";
        }
        System.out.println(currentQues + "--" + path);

//       System.out.println("NEXT PT4--------------------");
        ses.setAttribute("currentQues", currentQues);
        ses.setAttribute("point", point);
        request.getRequestDispatcher(path).forward(request, response);
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
