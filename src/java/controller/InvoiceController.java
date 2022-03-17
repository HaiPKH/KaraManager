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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;

/**
 *
 * @author haiph
 */
public class InvoiceController extends BaseAuthController {

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
        int pageIndex;
        try{
            pageIndex = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){
            pageIndex = 1;
        }
        InvoiceDBContext idb = new InvoiceDBContext();
        RoomDBContext rdb = new RoomDBContext();
        ArrayList<Invoice> invoices = idb.getInvoices(pageIndex);
        ArrayList<String> roomname = new ArrayList<>();
        for(Invoice i: invoices){
            roomname.add(rdb.getRoom(i.getRid()).getName());
        }
        int count = idb.count("");
        int totalpage = (count%10==0)?(count/10):(count/10)+1;
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageIndex);
        request.setAttribute("roomnames", roomname);
        request.setAttribute("invoices", invoices);
        request.getRequestDispatcher("view/invoice.jsp").forward(request, response);
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
