/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.RoomDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Room;

/**
 *
 * @author haiph
 */
public class RoomInsertController extends BaseAuthController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int error = 0;
        request.setAttribute("errorCode", error);
        request.getRequestDispatcher("/view/roominsert.jsp").forward(request, response);      
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int error;
       String roomname = request.getParameter("roomname");
       if(roomname.isEmpty()){
           error = 1;
           request.setAttribute("errorCode", error);
           request.getRequestDispatcher("/view/roominsert.jsp").forward(request, response);
           return;
       }
       int priceperhour = 0;
       try{
           priceperhour = Integer.parseInt(request.getParameter("priceperhour"));
       }catch(NumberFormatException ex){
           error = -1;
           request.setAttribute("errorCode", error);
           request.getRequestDispatcher("/view/roominsert.jsp").forward(request, response);
       }
       if(priceperhour <= 0){
           error = -1;
           request.setAttribute("errorCode", error);
           request.getRequestDispatcher("/view/roominsert.jsp").forward(request, response);
           return;
       }
        RoomDBContext rdb = new RoomDBContext();
        Room room = new Room();
        room.setName(roomname);
        room.setPriceperhour(priceperhour);
        room.setIsUsed(false);
        room.setTimestarted(null);
        rdb.insertRoom(room);
        response.sendRedirect("/KaraManager/rooms");
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
