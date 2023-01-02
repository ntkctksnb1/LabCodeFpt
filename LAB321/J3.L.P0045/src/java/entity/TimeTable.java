/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Kien
 */
public class TimeTable {

    private Date date;
    private int slot;
    private String slotTime;
    private String className;
    private String teacher;
    private String roomName;
    private String subject;

    public TimeTable() {
    }

    public TimeTable(Date date, int slot, String slotTime, String className, String teacher, String roomNo, String subject) {
        this.date = date;
        this.slot = slot;
        this.slotTime = slotTime;
        this.className = className;
        this.teacher = teacher;
        this.roomName = roomNo;
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoomNo() {
        return roomName;
    }

    public void setRoomNo(String roomNo) {
        this.roomName = roomNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    

    @Override
    public String toString() {
        
        return "<td>"+getFormattedDate()+"</td>\n"
                + "<td>"+slot+"</td>\n"
                + "<td>"+slotTime+"</td>\n"
                + "<td>"+className+"</td>\n"
                + "<td>"+teacher+"</td>\n"
                + "<td>"+roomName+"</td>"
                + "<td>"+subject+"</td>";
    }

    public String getFormattedDate(){
        return new SimpleDateFormat("EEE dd-MM-yyyy", Locale.ENGLISH).format(date);
    }
}
