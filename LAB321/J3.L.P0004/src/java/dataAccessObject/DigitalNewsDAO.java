/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

import context.DBContext;
import entity.DigitalNews;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class DigitalNewsDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    // This method is used to get a new by it id
    public DigitalNews getNews(int id) throws SQLException {
        DigitalNews news = new DigitalNews();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT [ID]\n"
                    + "      ,[title]\n"
                    + "      ,[ncontent]\n"
                    + "      ,[image]\n"
                    + "      ,[author]\n"
                    + "      ,[date]\n"
                    + "      ,[description]\n"
                    + "  FROM [dbo].[DigitalNews]\n"
                    + "Where [ID]=" + id;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int newsID = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                // image of news will be stored in in path web/images/news
                String image = "images\\news\\" + rs.getString(4);
                String author = rs.getString(5);
                Timestamp date = rs.getTimestamp(6);
                String description = rs.getString(7);
                news = new DigitalNews(newsID, title, content, image, author, date, description);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResultSet();
            closePreparedStatement();
            closeConnection();
        }
        return news;
    }

    // Return a newest list of news according to the number top
    public ArrayList<DigitalNews> getTopNews(int top) throws SQLException {
        ArrayList<DigitalNews> topList = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            // The list of news is sorted by time.
            String sql = "SELECT TOP(" + top + ") [ID]\n"
                    + "      ,[title]\n"
                    + "      ,[ncontent]\n"
                    + "      ,[image]\n"
                    + "      ,[author]\n"
                    + "      ,[date]\n"
                    + "      ,[description]\n"
                    + "  FROM [dbo].[DigitalNews] order by [date] desc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String image = "images\\news\\" + rs.getString(4);
                String author = rs.getString(5);
                Timestamp date = rs.getTimestamp(6);
                String description = rs.getString(7);
                DigitalNews news = new DigitalNews(id, title, content, image, author, date, description);
                topList.add(news);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResultSet();
            closePreparedStatement();
            closeConnection();
        }
        return topList;
    }

    public int countSearchNews(String search) throws SQLException {
        int count = 0;
        try {
            con = new DBContext().getConnection();
            // The list of news is sorted by time.
            String sql = "SELECT Count(*) \n"
                    + "       FROM [dbo].[DigitalNews]\n"
                    + "       Where title like '%" + search + "%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResultSet();
            closePreparedStatement();
            closeConnection();
        }

        return count;
    }

    // Search and return a list of all new whose title contain search string
    public ArrayList<DigitalNews> searchNews(String search, int page) throws SQLException {
        ArrayList<DigitalNews> searchList = new ArrayList<>();
        try {
            String startPosition = ((page - 1) * 4) + "";
            con = new DBContext().getConnection();
            // The list of news is sorted by time.
            String sql = "SELECT [ID],\n"
                    + "	[title],\n"
                    + "	[ncontent],\n"
                    + "	[image],\n"
                    + "	[author],\n"
                    + "	[date],\n"
                    + "	[description]\n"
                    + "FROM [dbo].[DigitalNews]\n"
                    + "\n"
                    + "  Where title like '%" + search + "%' order by [date] desc\n"
                    + "	OFFSET " + startPosition + " ROWS\n"
                    + "  FETCH NEXT 4 ROWS ONLY";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String title = rs.getString(2);
                String titleModified = title.replaceAll("(?i)"+search, "<mark>"+search+"</mark>");
                String content = rs.getString(3);
                String image = "images\\news\\" + rs.getString(4);
                String author = rs.getString(5);
                Timestamp date = rs.getTimestamp(6);
                String description = rs.getString(7);
                DigitalNews news = new DigitalNews(id, titleModified, content, image, author, date, description);
                searchList.add(news);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeResultSet();
            closePreparedStatement();
            closeConnection();
        }

        return searchList;
    }

    private void closeConnection() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    private void closeResultSet() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    private void closePreparedStatement() throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

}
