/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
public class Finish extends HttpServlet {

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
//            out.println("<title>Servlet Finish</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Finish at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
//        String[] ans = request.getParameterValues("answer");
        HttpSession ses = request.getSession();
        System.out.println("Result----------------PT1");
//        if ((boolean) ses.getAttribute("finish")) {
        ArrayList<Quiz> test = (ArrayList<Quiz>) ses.getAttribute("test");
        int totalQues = test.size();
        int point = (int) ses.getAttribute("point");
        ses.removeAttribute("test");
        ses.removeAttribute("totalQues");
        ses.removeAttribute("currentQues");
        ses.removeAttribute("finish");
        ses.removeAttribute("next");
        ses.removeAttribute("point");
        DecimalFormat df = new DecimalFormat("#.#");
        
        String result = df.format(((double)point / (double)totalQues)*10);
        df = new DecimalFormat("#");
        String percent = df.format(((double)point / (double)totalQues) * 100) + "%";
        String pass = "Failed";
        if (((double)point / (double)totalQues)*10 >= 5.0) {
            pass = "Pass";
        }
        System.out.println("Result----------------PT2");
        request.setAttribute("result", result + " (" + percent + ") " + " - " + pass);
        request.getRequestDispatcher("jsp/result.jsp").forward(request, response);
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
