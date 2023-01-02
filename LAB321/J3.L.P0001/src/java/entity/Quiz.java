/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Kien
 */
public class Quiz implements Serializable{

    private int id;
    private String problem;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private int creator;
    private Date createdDate;

    public Quiz(int id, String problem, String option1, String option2, String option3, String option4, String answer, int creator, Date createdDate) {
        this.id = id;
        this.problem = problem;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.creator = creator;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean checkAnswer(String[] ans) {

        String anString = new String();
        if (ans.length == 0) {
            return false;
        }
        for (String an : ans) {
            anString += an;
        }
        return anString.equalsIgnoreCase(answer);
    }

    public static String createAnswer(String[] ans) {
        String anString = new String();
        for (String an : ans) {
            anString += an;
        }
        return anString;
    }
    
    public String getFormattedDate(){
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(createdDate);
    }
}
