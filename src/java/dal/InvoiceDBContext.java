/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
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

    public ArrayList<Invoice> getInvoices(int pageindex) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "SELECT bid ,rid, datecreated , timestarted , timeended, timeelapsed, othercost, totalcost FROM\n"
                    + "  (SELECT *,ROW_NUMBER() OVER (ORDER BY bid ASC) as row_index FROM Invoice) tbl"
                    + "   WHERE row_index >= (?-1)*10 + 1"
                    + "   AND row_index <= ? * 10";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pageindex);
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

    public void deleteInvoice(int bid) {
        String sql = "DELETE Invoice\n"
                + " WHERE [bid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
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

    public void updateInvoice(int bid, int othercost, int totalcost) {
        String sql = "UPDATE [Invoice]\n"
                + "   SET [othercost] = ?\n"
                + "   ,[totalcost] = ?\n"
                + " WHERE [bid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, othercost);
            stm.setInt(2, totalcost);
            stm.setInt(3, bid);
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

    public Invoice getInvoice(int bid) {
        try {
            String sql = "SELECT bid ,rid, datecreated , timestarted , timeended, timeelapsed, othercost, totalcost FROM Invoice\n"
                    + "WHERE bid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Invoice invoice = new Invoice();
                invoice.setBid(rs.getInt("bid"));
                invoice.setRid(rs.getInt("rid"));
                invoice.setDatecreated(rs.getTimestamp("datecreated"));
                invoice.setTimestarted(rs.getTimestamp("timestarted"));
                invoice.setTimeended(rs.getTimestamp("timeended"));
                invoice.setTimeelapsed(rs.getTime("timeelapsed"));
                invoice.setOthercost(rs.getInt("othercost"));
                invoice.setTotalcost(rs.getInt("totalcost"));
                return invoice;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int count(String extra) {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Invoice\n";
            if(!extra.isEmpty()){
                sql += extra;
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList<Invoice> getInvoicesWithDate(int pageindex, Date d1, Date d2) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = " SELECT bid ,rid, datecreated , timestarted , timeended, timeelapsed, othercost, totalcost FROM\n"
                    + "(SELECT *,ROW_NUMBER() OVER (ORDER BY bid ASC) as row_index FROM Invoice) tbl\n"
                    + " WHERE row_index >= (?-1)* 5 + 1\n"
                    + " AND row_index <= ? * 5\n"
                    + " AND datecreated BETWEEN ? AND ?";           
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pageindex);
            stm.setDate(3, d1);
            stm.setDate(4, d2);
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

    public int getTotal(Date d1, Date d2) {
        int total = 0;
        try {
            String sql = "SELECT SUM(totalcost) AS Total FROM Invoice\n"
                    + "  WHERE datecreated BETWEEN ? AND ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, d1);
            stm.setDate(2, d2);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                total = rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
