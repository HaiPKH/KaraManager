/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                + "           ,[timeelapsed])\n"
                + "           ,[othercost])\n"
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
}
