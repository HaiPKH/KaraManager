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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Room;

/**
 *
 * @author haiph
 */
public class RoomDBContext extends DBContext {

    public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT rid, name , priceperhour , isused, timestarted FROM Room\n"
                    + "   ORDER BY rid ASC";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setRid(rs.getInt("rid"));
                room.setName(rs.getString("name"));
                room.setPriceperhour(rs.getInt("priceperhour"));
                room.setIsUsed(rs.getBoolean("isused"));
                room.setTimestarted(rs.getTimestamp("timestarted"));
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

    public Room getRoom(int rid) {
        try {
            String sql = "SELECT rid, name ,isused, priceperhour, timestarted FROM Room\n"
                    + "WHERE rid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, rid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setRid(rs.getInt("rid"));
                room.setName(rs.getString("name"));
                room.setIsUsed(rs.getBoolean("isused"));
                room.setPriceperhour(rs.getInt("priceperhour"));
                room.setTimestarted(rs.getTimestamp("timestarted"));
                return room;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateRoomStat(int rid, boolean isUsed, Timestamp time) {
        String sql = "UPDATE [Room]\n"
                + "   SET [isUsed] = ?\n"
                + "            ,[timestarted] = ?"
                + " WHERE [rid] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setBoolean(1, isUsed);
            stm.setTimestamp(2, time);
            stm.setInt(3, rid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RoomDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
