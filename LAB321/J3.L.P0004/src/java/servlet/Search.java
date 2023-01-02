/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dataAccessObject.DigitalNewsDAO;
import entity.DigitalNews;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kien
 */
public class Search extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");

            DigitalNewsDAO digitalDAO = new DigitalNewsDAO();
            //Get top 5 News
            ArrayList<DigitalNews> topFive = digitalDAO.getTopNews(5);
            request.setAttribute("topFive", topFive);
            //Get top 1 News
            request.setAttribute("topOne", topFive.get(0));
            //Get string want to search
            String txtSearch = request.getParameter("txtSearch").trim();
            request.setAttribute("txtSearch", txtSearch);
            
            //Count the number of Digital was searched          
            int count = digitalDAO.countSearchNews(txtSearch);
            request.setAttribute("totalNumber", count);
            //Set 4 news in 1 page
            int endPage = count / 4;
            if (count % 4 != 0) {
                endPage++;
            }
            request.setAttribute("endPage", endPage);
            //Get the page number
            String strIndex = request.getParameter("index");
            if (strIndex == null) {
                strIndex = "1";
            }
            int index = Integer.parseInt(strIndex);
            request.setAttribute("currentPage", index);
            //Get a page of list search;

            ArrayList<DigitalNews> srchList = digitalDAO.searchNews(txtSearch, index);

            request.setAttribute("listSearch", srchList);

            request.getRequestDispatcher("jsp/search.jsp").forward(request, response);
        } catch (Exception e) {
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
            response.setContentType("text/html;charset=UTF-8");

            DigitalNewsDAO digitalDAO = new DigitalNewsDAO();
            //Get top 5 News
            ArrayList<DigitalNews> topFive = digitalDAO.getTopNews(5);
            request.setAttribute("topFive", topFive);
            //Get top 1 News
            request.setAttribute("topOne", topFive.get(0));
            //Get string want to search
            String txtSearch = request.getParameter("txtSearch").trim();
            request.setAttribute("txtSearch", txtSearch);
            //Count the number of Digital was searched
            int count = digitalDAO.countSearchNews(txtSearch);
            request.setAttribute("totalNumber", count);
            //Set 4 news in 1 page
            int endPage = count / 4;
            if (count % 4 != 0) {
                endPage++;
            }
            request.setAttribute("endPage", endPage);
            //Get the page number
            String strIndex = request.getParameter("index");
            if (strIndex == null) {
                strIndex = "1";
            }
            int index = Integer.parseInt(strIndex);
            request.setAttribute("currentPage", index);
            //Get a page of list search;

            ArrayList<DigitalNews> srchList = digitalDAO.searchNews(txtSearch, index);

            request.setAttribute("listSearch", srchList);

            request.getRequestDispatcher("jsp/search.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("jsp/error.jsp").forward(request, response);
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
