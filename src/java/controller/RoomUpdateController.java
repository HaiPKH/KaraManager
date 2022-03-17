/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.RoomDBContext;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haiph
 */
public class RoomUpdateController extends BaseAuthController {

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
        int rid = Integer.parseInt(request.getParameter("roomid"));
        int error = 0;
        request.setAttribute("rid", rid);
        request.setAttribute("errorCode", error);
        request.getRequestDispatcher("/view/roomupdate.jsp").forward(request, response);
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
        int rid = Integer.parseInt(request.getParameter("rid"));
        String name = request.getParameter("roomname");
        int priceperhour = 0;
        if (name.isEmpty()) {
            error = 1;
            request.setAttribute("rid", rid);
            request.setAttribute("errorCode", error);
            request.getRequestDispatcher("/view/roomupdate.jsp").forward(request, response);
            return;
        }
        try {
            priceperhour = Integer.parseInt(request.getParameter("priceperhour"));
        } catch (NumberFormatException ne) {
            error = -1;
            request.setAttribute("rid", rid);
            request.setAttribute("errorCode", error);
            request.getRequestDispatcher("/view/roomupdate.jsp").forward(request, response);
        }
        if (priceperhour <= 0) {
            error = -1;
            request.setAttribute("rid", rid);
            request.setAttribute("errorCode", error);
            request.getRequestDispatcher("/view/roomupdate.jsp").forward(request, response);
            return;
        }
        RoomDBContext rdb = new RoomDBContext();
        rdb.updateRoom(rid, name, priceperhour);
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
