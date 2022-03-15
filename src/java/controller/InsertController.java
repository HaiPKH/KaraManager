/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.InvoiceDBContext;
import dal.RoomDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
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
public class InsertController extends BaseAuthController {

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
        RoomDBContext rdb = new RoomDBContext();
        Room room = rdb.getRoom(rid);
        request.setAttribute("room", room);      
        request.getRequestDispatcher("view/insert.jsp").forward(request, response);
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
        
        int raw_rid = Integer.parseInt(request.getParameter("roomid"));
        Timestamp raw_timeStarted = Timestamp.valueOf(request.getParameter("timestarted"));
        Timestamp raw_timeEnded = Timestamp.valueOf(request.getParameter("timeended"));
        Time raw_timeElapsed = Time.valueOf(request.getParameter("timeelapsed"));
        int raw_otherCost;
        if (!request.getParameter("others").equals("")) {
            raw_otherCost = Integer.parseInt(request.getParameter("others"));
        }else{
            raw_otherCost = 0;
        }
        InvoiceDBContext idb = new InvoiceDBContext();
        RoomDBContext rdb = new RoomDBContext();
        Room room = rdb.getRoom(raw_rid);
        int priceperhour = room.getPriceperhour();
        int raw_totalcost;
        int priceper10mins = priceperhour / 6;
        raw_totalcost = priceperhour * raw_timeElapsed.getHours() + priceper10mins *(raw_timeElapsed.getMinutes()/ 10) + raw_otherCost;
        Invoice inv = new Invoice();
        inv.setRid(raw_rid);
        inv.setDatecreated(raw_timeStarted);
        inv.setTimestarted(raw_timeStarted);
        inv.setTimeended(raw_timeEnded);
        inv.setTimeelapsed(raw_timeElapsed);
        inv.setOthercost(raw_otherCost);
        inv.setTotalcost(raw_totalcost);
        idb.insertInvoice(inv);
        rdb.updateRoomStat(raw_rid, false, null);
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
