/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDao;
import entity.UserInfor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kien
 */
public class Register extends HttpServlet {

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
        request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
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
        ArrayList<UserInfor> uList = new ArrayList<>();
        try {
            String username = request.getParameter("user");
            String password = request.getParameter("pass");
            String type = request.getParameter("type");
            String email = request.getParameter("mail");
            uList = new UserDao().getUserList();
            String path = "jsp/home.jsp";
            String msg = "";
            boolean commit = true;
            for (UserInfor userInfor : uList) {
                if (userInfor.getUsername().equals(username)) {
                    commit = false;
                    path = "jsp/register.jsp";
                    msg += "Username is existed! ";
                }
                if (userInfor.getEmail().equals(email)) {
                    commit = false;
                    path = "jsp/register.jsp";
                    msg += "Email is taken! ";
                }
                if (password.length() < 6) {
                    commit = false;
                    path = "jsp/register.jsp";
                    msg += "Password length must be at least 6 characters! ";
                }
                if (!commit) {

                    break;
                }
            }
            if (commit) {
                msg = "Register successful! Please login!";
                request.setAttribute("msg", msg);
                new UserDao().addNewUser(username, password, type, email);
            } else {
                request.setAttribute("u", username);
                request.setAttribute("e", email);
                request.setAttribute("msg", msg);
            }
            request.getRequestDispatcher(path).forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("err", ex);
            request.getRequestDispatcher("err.jsp").forward(request, response);
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
