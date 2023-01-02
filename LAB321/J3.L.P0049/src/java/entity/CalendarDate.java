/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Kien
 */
public class CalendarDate {

    private int day;
    private int month;
    private int year;
    private boolean cellDisplay;
    private boolean rowDisplay;
    private boolean today;

    public CalendarDate(int day, int month, int year, boolean cellDisplay, boolean rowDisplay, boolean today) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.cellDisplay = cellDisplay;
        this.rowDisplay = rowDisplay;
        this.today = today;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isCellDisplay() {
        return cellDisplay;
    }

    public void setCellDisplay(boolean cellDisplay) {
        this.cellDisplay = cellDisplay;
    }

    public boolean isRowDisplay() {
        return rowDisplay;
    }

    public void setRowDisplay(boolean rowDisplay) {
        this.rowDisplay = rowDisplay;
    }

    public boolean isToday() {
        return today;
    }

    public void setToday(boolean today) {
        this.today = today;
    }

   
}
