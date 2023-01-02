/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.UserAccount;
import entity.UserInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class UserDao {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<UserAccount> getAccountList() throws SQLException {
        ArrayList<UserAccount> accList = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[password]\n"
                    + "  FROM [dbo].[User]";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                accList.add(new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return accList;
    }

    public UserInfor getAccountInfoByID(int id) throws SQLException {
        UserInfor infor = new UserInfor();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[type]\n"
                    + "      ,[email]\n"
                    + "  FROM [dbo].[User]\n"
                    + "  Where [id]=" + id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                infor = new UserInfor(id, rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return infor;
    }

    public ArrayList<UserInfor> getUserList() throws SQLException {
        ArrayList<UserInfor> uInfoList = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT [id]\n"
                    + "      ,[username]\n"
                    + "      ,[type]\n"
                    + "      ,[email]\n"
                    + "  FROM [dbo].[User]\n";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserInfor infor = new UserInfor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                uInfoList.add(infor);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return uInfoList;
    }

    public void addNewUser(String user, String password, String type, String email) throws SQLException {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[type]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "           ('"+user+"'\n"
                + "           ,'"+password+"'\n"
                + "           ,'"+type+"'\n"
                + "           ,'"+email+"')";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            System.out.println(sql);
            ps.execute();
            System.out.println("Addd succcessssss------------------");
//            System.out.println(sql);
        } catch (Exception e) {
        } finally {
//            rs.close();
            ps.close();
            con.close();
        }
    }
}
