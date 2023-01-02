/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dataAcessObject.ClassDAO;
import dataAcessObject.RoomDAO;
import dataAcessObject.SlotDAO;
import dataAcessObject.TimeTableDAO;
import entity.Room;
import entity.Slot;
import entity.TimeTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
public class AddTimeTable extends HttpServlet {

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
            ClassDAO classDao = new ClassDAO();
            RoomDAO roomDAO = new RoomDAO();
            SlotDAO slotDAO = new SlotDAO();
//            TimeTableDAO timeTableDAO = new TimeTableDAO();

            request.setAttribute("classList", classDao.getClassList());
            request.setAttribute("roomList", roomDAO.getRoomList());
            request.setAttribute("slotList", slotDAO.getSlotList());
            request.getRequestDispatcher("jsp/add.jsp").forward(request, response);

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d1;
            Date date;
            try {
                d1 = sdf.parse(request.getParameter("date"));
                date = new Date(d1.getTime());
            } catch (Exception e) {
                d1 = null;
                date = null;
            }
            java.util.Date d2 = sdf.parse(LocalDate.now().toString());

            Date today = new Date(d2.getTime());
            int slot = Integer.parseInt(request.getParameter("slot"));
            String room = request.getParameter("room");
            String teacher = request.getParameter("teacher");
            String clas = request.getParameter("class");
            String subject = request.getParameter("subject");
            boolean fault = false;

            
            request.setAttribute("datep", date);
            request.setAttribute("slotp", slot);
            request.setAttribute("roomp", room);
            request.setAttribute("teacherp", teacher);
            request.setAttribute("classp", clas);
            request.setAttribute("subjectp", subject);
            

            if (date == null) {
                request.setAttribute("mess", "You must fill in all fields!");
                doGet(request, response);
                return;
            }

            ClassDAO classDao = new ClassDAO();
            RoomDAO roomDAO = new RoomDAO();
            SlotDAO slotDAO = new SlotDAO();
            TimeTableDAO timeTableDAO = new TimeTableDAO();
            ArrayList<TimeTable> list = timeTableDAO.getTimeTableList();
            ArrayList<entity.Class> listC = classDao.getClassList();
            ArrayList<Room> listR = roomDAO.getRoomList();
            ArrayList<Slot> listS = slotDAO.getSlotList();
            String mess = "";
             if (today.compareTo(date) > 0) {
                    mess = " Cannot add timetable before current date.";
                    request.setAttribute("mess", mess);
                    doGet(request, response);
                    return;
                }
            for (TimeTable item : list) {
               
                if (item.getDate().compareTo(date) == 0 && item.getSlot() == slot) {
                    if (item.getTeacher().equalsIgnoreCase(teacher)) {
                        mess += "The teacher is busy at this slot.";
                        fault = true;
                    }
                    else if (item.getClassName().equalsIgnoreCase(clas)) {
                        mess += "This class has already learn something at this time ";
                        fault = true;
                        
                    } else {
                        mess += "This room is occupied at this time!";
                        fault = true;
                    }
                }
            }

            if (fault == false) {
                timeTableDAO.addTimeTable(new TimeTable(date, slot, listS.get(slot - 1).getSlotTime(), clas, teacher, room, subject));
                mess = "Add success!";
            }

            request.setAttribute("classList", listC);
            request.setAttribute("roomList", listR);
            request.setAttribute("slotList", listS);
            request.setAttribute("mess", mess.trim());
            request.getRequestDispatcher("jsp/add.jsp").forward(request, response);

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
