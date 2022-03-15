/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;

/**
 *
 * @author haiph
 */
public class InvoiceDBContext extends DBContext {

    public void insertInvoice(Invoice inv) {
        String sql = "INSERT INTO [Invoice]\n"
                + "           ([rid]\n"
                + "           ,[datecreated]\n"
                + "           ,[timestarted]\n"
                + "           ,[timeended]\n"
                + "           ,[timeelapsed]\n"
                + "           ,[othercost]\n"
                + "           ,[totalcost])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, inv.getRid());
            stm.setTimestamp(2, inv.getTimestarted());
            stm.setTimestamp(3, inv.getTimestarted());
            stm.setTimestamp(4, inv.getTimeended());
            stm.setTime(5, inv.getTimeelapsed());
            stm.setInt(6, inv.getOthercost());
            stm.setInt(7, inv.getTotalcost());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
    public ArrayList<Invoice> getInvoices(){
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "SELECT bid ,rid, datecreated , timestarted , timeended, timeelapsed, othercost, totalcost FROM Invoice\n"
                    + "   ORDER BY bid ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setBid(rs.getInt("bid"));
                invoice.setRid(rs.getInt("rid"));
                invoice.setDatecreated(rs.getTimestamp("datecreated"));
                invoice.setTimestarted(rs.getTimestamp("timestarted"));
                invoice.setTimeended(rs.getTimestamp("timeended"));
                invoice.setTimeelapsed(rs.getTime("timeelapsed"));
                invoice.setOthercost(rs.getInt("othercost"));
                invoice.setTotalcost(rs.getInt("totalcost"));
                invoices.add(invoice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoices;
    }
    
    public void deleteInvoice(int bid){
                String sql = "DELETE Invoice\n" +
                             " WHERE [bid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
