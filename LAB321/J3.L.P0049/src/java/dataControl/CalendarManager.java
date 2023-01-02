/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataControl;

import entity.CalendarDate;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Kien
 */
public class CalendarManager {
    
    public static ArrayList<CalendarDate> getCalendar(int year, int month) {
        ArrayList<CalendarDate> cal = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        Calendar current = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dow = calendar.get(Calendar.DAY_OF_WEEK);

        while (dow != 1) {
            calendar.add(Calendar.DATE, -1);
            dow = calendar.get(Calendar.DAY_OF_WEEK);
        }
        
        int d, m, y;
        boolean cellDisplay, rowDisplay, isToday;
        boolean nextRow = true;

        for (int i = 1; i <= 42; i++) {
            CalendarDate day;
            d = calendar.get(Calendar.DATE);
            m = calendar.get(Calendar.MONTH);
            y = calendar.get(Calendar.YEAR);
            if ((y >= year) && (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                if ((m>month)) {
                    nextRow = false;
                }
                if (m<month && y> year) {
                    nextRow = false;
                }
            }
            if (calendar.equals(current)) {
                cellDisplay = true;
                rowDisplay = true;
                isToday = true;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            } else if (calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) >= year) {
                cellDisplay = true;
                rowDisplay = true;
                isToday = false;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            } else if (calendar.get(Calendar.MONTH) != month && calendar.get(Calendar.YEAR) == year && nextRow) {
                cellDisplay = false;
                rowDisplay = true;
                isToday = false;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            }else if (year > calendar.get(Calendar.YEAR) && nextRow ) {
                cellDisplay = false;
                rowDisplay = true;
                isToday = false;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            } 
            else if (year < calendar.get(Calendar.YEAR) && nextRow) {
                cellDisplay = false;
                rowDisplay = true;
                isToday = false;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            } 
            else {
                cellDisplay = false;
                rowDisplay = false;
                isToday = false;
                day = new CalendarDate(d, m, y, cellDisplay, rowDisplay, isToday);
            }
            cal.add(day);
            calendar.add(Calendar.DATE, 1);

        }

        return cal;
    }
    
}
