/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAcessObject;

import context.DBContext;
import entity.TimeTable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class TimeTableDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<TimeTable> getTimeTableList() throws Exception {
        ArrayList<TimeTable> list = new ArrayList<>();
        try {

            con = new DBContext().getConnection();
            String sql = "SELECT * FROM [dbo].[TimeTable]\n";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeTable(rs.getDate(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return list;
    }

    public ArrayList<TimeTable> getTimeTableList(int page, String from, String to) throws Exception {
        ArrayList<TimeTable> list = new ArrayList<>();
        try {
            String startPosition = page * 10 - 10 + "";
            con = new DBContext().getConnection();
            String sql = "SELECT * FROM [dbo].[TimeTable]\n"
                    + "     WHERE [Date] between '" + from + "' and '" + to + "'\n"
                    + "     ORDER BY [Date] ASC\n"
                    + "     OFFSET " + startPosition + " ROWS\n"
                    + "     FETCH NEXT 10 ROWS ONLY";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimeTable(rs.getDate(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return list;
    }

    public int countTimeTableByDate(String from, String to) throws Exception {
        int count = 0;
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT Count(*) FROM [Timetable].[dbo].[TimeTable]\n"
                    + "WHERE [Date] between '" + from + "' and '" + to + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {

        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return count;
    }

    public void addTimeTable(TimeTable data) throws SQLException {
        try {
            con = new DBContext().getConnection();
            String sql = "INSERT INTO [dbo].[TimeTable]\n"
                    + "           ([Date]\n"
                    + "           ,[Slot]\n"
                    + "           ,[SlotTime]\n"
                    + "           ,[Class]\n"
                    + "           ,[Teacher]\n"
                    + "           ,[Room]"
                    + "           ,[Subject])\n"
                    + "     VALUES\n"
                    + "           ('" + data.getDate() + "'\n"
                    + "           ," + data.getSlot() + "\n"
                    + "           ,'" + data.getSlotTime() + "'\n"
                    + "           ,'" + data.getClassName() + "'\n"
                    + "           ,'" + data.getTeacher() + "'\n"
                    + "           ,'" + data.getRoomNo() + "'"
                    + "           ,'" + data.getSubject() + "')";
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.execute();

        } catch (Exception e) {
            System.out.println("Add loi: " + e);
        } finally {
            ps.close();
            con.close();
        }
    }

    public String getMaxDate() throws SQLException {
        String maxDate = "";
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT MAX([Date])\n"
                    + "  FROM [Timetable].[dbo].[TimeTable]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                maxDate = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(1));
            }

        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return maxDate;
    }

    public String getMinDate() throws SQLException {
        String minDate = "";
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT MIN([Date])\n"
                    + "  FROM [Timetable].[dbo].[TimeTable]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                minDate = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(1));
            }

        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return minDate;
    }
}
