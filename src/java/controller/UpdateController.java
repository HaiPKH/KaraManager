/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.InvoiceDBContext;
import dal.RoomDBContext;
import java.io.IOException;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;
import model.Room;

/**
 *
 * @author haiph
 */
public class UpdateController extends BaseAuthController {

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
        int bid = Integer.parseInt(request.getParameter("bid"));
        InvoiceDBContext idb = new InvoiceDBContext();
        RoomDBContext rdb = new RoomDBContext();       
        Invoice inv = idb.getInvoice(bid);
        Room room = rdb.getRoom(inv.getRid());
        request.setAttribute("invoice", inv);
        request.setAttribute("room", room);
        request.getRequestDispatcher("view/update.jsp").forward(request, response);
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
        int bid = Integer.parseInt(request.getParameter("bid"));
        Time timeElapsed = Time.valueOf(request.getParameter("timeelapsed"));
        int priceperhour = Integer.parseInt(request.getParameter("priceperhour"));
        int priceper10mins = priceperhour / 6;
        int othercost;
        try{
            othercost = Integer.parseInt(request.getParameter("othercost"));
        }catch(NumberFormatException ne){
            othercost = 0;
        }
        int totalcost = priceperhour * timeElapsed.getHours() + priceper10mins *(timeElapsed.getMinutes()/ 10) + othercost;
        InvoiceDBContext idb = new InvoiceDBContext();
        idb.updateInvoice(bid, othercost, totalcost);
        response.sendRedirect("invoice");
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
