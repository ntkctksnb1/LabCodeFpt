/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dataAcessObject.TimeTableDAO;
import entity.TimeTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kien
 */
public class TimeTableLoader extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            TimeTableDAO timetableDao = new TimeTableDAO();
            String minDate, maxDate;
            minDate = request.getParameter("fromD");
            maxDate = request.getParameter("toD");
            if (minDate == null || maxDate == null) {
                maxDate = LocalDate.now().plusDays(7).toString();
                minDate = LocalDate.now().toString();
            }

            int count = timetableDao.countTimeTableByDate(minDate, maxDate);

            int totalPage = count / 10;
            if (count % 10 != 0) {
                totalPage++;
            }
            
            int currentPage;
            try {
                currentPage = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
            ArrayList<TimeTable> list = timetableDao.getTimeTableList(currentPage, minDate, maxDate);
            request.setAttribute("maxDate", maxDate);
            request.setAttribute("minDate", minDate);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("timetableList", list);
            request.getRequestDispatcher("jsp/loadTimetable.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("err", e);
            request.getRequestDispatcher("jsp/err.jsp").forward(request, response);
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
