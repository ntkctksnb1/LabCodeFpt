/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.New;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext {

    private PreparedStatement st;
    private ResultSet rs;

    public ArrayList<New> getAllNews(){
        ArrayList<New> list = new ArrayList<>();
        String sql = "select * from News";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                list.add(n);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public New getFirstNew(){
        String sql = "select top(1) * from News where postTime = (select MAX(postTime) from News)";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                return n;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public New getNewByID(int id){
        String sql = "select * from News where id = ?";
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                return n;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<New> getTop5NewsAtHomepage(){
        ArrayList<New> list = new ArrayList<>();
        String sql = "select top(6) * from News except (select top(1) * from News where postTime = (select MAX(postTime) from News)) order by postTime desc ";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                list.add(n);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<New> getTop5News(){
        ArrayList<New> list = new ArrayList<>();
        String sql = "select top(5) * from News order by postTime desc ";
        try {
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                list.add(n);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getNewsNumberBySearching(String txtSearch){
        String sql = "select count (*) from News where title like ?";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, "%" + txtSearch + "%");
            rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<New> getSearching(String txtSearch, int index){
        ArrayList<New> list = new ArrayList<>();
        String sql = "select * from (select ROW_NUMBER() over (order by postTime desc) as r, * from News where title like ?) as x where r between ?*3-2 and ?*3";
        try {
            st = connection.prepareStatement(sql);
            st.setString(1, "%"+txtSearch+"%");
            st.setInt(2, index);
            st.setInt(3, index);
            rs = st.executeQuery();
            while (rs.next()) {
                New n = new New(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8));
                list.add(n);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
