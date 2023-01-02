/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Kien
 */
public class CalTest {
    
    public String ToMonth(int month){
        String monthString;
        switch(month){
            case 0:
                monthString = "Jan";
                break;
            case 1:
                monthString = "Feb";
                break;
            case 2:
                monthString = "Mar";
                break;
            case 3:
                monthString = "Apr";
                break;
            case 4:
                monthString = "May";
                break;
            case 5:
                monthString = "Jun";
                break;
            case 6:
                monthString = "Jul";
                break;
            case 7:
                monthString = "Aug";
                break;
            case 8:
                monthString = "Sep";
                break;
            case 9:
                monthString = "Oct";
                break;
            case 10:
                monthString = "Nov";
                break;
            case 11:
                monthString = "Dec";
                break;
            default:
                monthString = "Error Input!";
                break;
        }
        return monthString;
    }
    public static void main(String[] args) {
        ArrayList<CalendarDay> lst = new ArrayList<>();
        Calendar c = Calendar.getInstance();
//        System.out.println(c.getTime().getDate());
//        System.out.println(c.getTime().getMonth());
//        System.out.println(c.getTime().getYear());
//        System.out.println(c.getTime().getDay());
//        c.add(Calendar.MONTH, 3);
//        c.add(Calendar.DATE, 11);
//        System.out.println(c.getTime());
        c.set(Calendar.DATE, 1);
        //day 1-31
        c.set(Calendar.MONTH, 11);
        //mont 0-11
        c.set(Calendar.YEAR, 2022);
        // year chuan
        c.set(Calendar.DAY_OF_WEEK_IN_MONTH, 0);
        int current = 11;
//        System.out.println(c.getTime());
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 7; j++) {
                int index = 7*i+j;
                
                if (c.getTime().getMonth() == current) {
                    
                }
            }
        }
    }
}
