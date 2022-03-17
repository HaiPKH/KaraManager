/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.InvoiceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class IncomeController extends BaseAuthController {

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
        request.getRequestDispatcher("view/incometime.jsp").forward(request, response);
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
        Date d1 = null;
        Date d2 = null;
        int pageIndex;
        try {
            pageIndex = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
            pageIndex = 1;
        }
        try {
            d1 = Date.valueOf(request.getParameter("startdate"));
            d2 = Date.valueOf(request.getParameter("enddate"));
        } catch (IllegalArgumentException ie) {
            String errormessage = "Invalid range of date";
            request.setAttribute("error", errormessage);
            request.getRequestDispatcher("view/incometime.jsp").forward(request, response);
        }
        if (d1.after(d2)) {
            String errormessage = "Invalid range of date";
            request.setAttribute("error", errormessage);
            request.getRequestDispatcher("view/incometime.jsp").forward(request, response);
        }
        InvoiceDBContext idb = new InvoiceDBContext();
        ArrayList<Invoice> invoices = idb.getInvoicesWithDate(pageIndex, d1, d2);
        int total = idb.getTotal(d1, d2);
        request.setAttribute("invoices", invoices);
        int count = idb.count("WHERE datecreated BETWEEN '"+d1+"' AND '"+d2+"'");
        int totalpage = (count % 10 == 0) ? (count / 10) : (count / 10) + 1;
        request.setAttribute("totalpage", totalpage);
        request.setAttribute("pageindex", pageIndex);
        request.setAttribute("total", total);
        request.setAttribute("startdate", d1);
        request.setAttribute("enddate", d2);
        request.getRequestDispatcher("view/income.jsp").forward(request, response);
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
