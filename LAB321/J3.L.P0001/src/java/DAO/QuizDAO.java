/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.Quiz;
import entity.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kien
 */
public class QuizDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<Quiz> makeTest(int totalQuiz) throws SQLException {
        ArrayList<Quiz> test = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            String sql = "SELECT TOP(" + totalQuiz + ")\n"
                    + "	   [id]\n"
                    + "      ,[problem]\n"
                    + "      ,[option1]\n"
                    + "      ,[option2]\n"
                    + "      ,[option3]\n"
                    + "      ,[option4]\n"
                    + "      ,[answer]\n"
                    + "      ,[creator]\n"
                    + "      ,[createdDate]\n"
                    + "  FROM [dbo].[QuizQuestion]\n"
                    + "  ORDER BY NEWID()  ";
//            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                test.add(new Quiz(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getDate(9)));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return test;
    }

    public ArrayList<Quiz> getQuizListByCreator(int id) throws SQLException {
        ArrayList<Quiz> quizList = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[problem]\n"
                + "      ,[option1]\n"
                + "      ,[option2]\n"
                + "      ,[option3]\n"
                + "      ,[option4]\n"
                + "      ,[answer]\n"
                + "      ,[creator]\n"
                + "      ,[createdDate]\n"
                + "  FROM [dbo].[QuizQuestion]\n"
                + "  WHERE [creator]=" + id + "";
//        System.out.println("QuizDAO: "+sql);
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                quizList.add(new Quiz(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getDate(9)));
            }
        } catch (Exception e) {
            System.out.println("QuizDao" + e);
        } finally {
            rs.close();
            con.close();
            ps.close();
        }
        return quizList;
    }

    public void addNewQuiz(String problem, String op1, String op2, String op3, String op4, String ans, int creator, String date) throws SQLException {
        try {
            con = new DBContext().getConnection();
            String sql = "INSERT INTO [dbo].[QuizQuestion]\n"
                    + "           ([problem]\n"
                    + "           ,[option1]\n"
                    + "           ,[option2]\n"
                    + "           ,[option3]\n"
                    + "           ,[option4]\n"
                    + "           ,[answer]\n"
                    + "           ,[creator]\n"
                    + "           ,[createdDate])\n"
                    + "     VALUES\n"
                    + "           ('" + problem + "'\n"
                    + "           ,'" + op1 + "'\n"
                    + "           ,'" + op2 + "'\n"
                    + "           ,'" + op3 + "'\n"
                    + "           ,'" + op4 + "'\n"
                    + "           ,'" + ans + "'\n"
                    + "           ," + creator + "\n"
                    + "           ,'" + date + "')";
            System.out.println("QuizDAO\n"+sql);
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            ps.close();
            con.close();
        }
    }
    
    

}
