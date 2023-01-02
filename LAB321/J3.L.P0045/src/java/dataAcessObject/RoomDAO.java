/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcessObject;

import context.DBContext;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class RoomDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<Room> getRoomList() throws Exception {
        ArrayList<Room> roomList = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT *\n"
                    + "  FROM [dbo].[Room]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                roomList.add(new Room(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return roomList;
    }
}
