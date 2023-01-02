/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcessObject;

import context.DBContext;
import entity.Slot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class SlotDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<Slot> getSlotList() throws Exception {
        ArrayList<Slot> slotList = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT *\n"
                    + "  FROM [dbo].[Slot]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                slotList.add(new Slot(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return slotList;
    }
}
