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
public class Slot {
    private int slotNo;
    private String startTime;
    private String endTime;

    public Slot(int slotNo, String startTime, String endTime) {
        this.slotNo = slotNo;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }
    
    public String getSlotTime(){
        return startTime + " - " + endTime;
    }
    
    public String getSlotTime2(){
        return startTime.substring(0, startTime.length()-1) + " - " + endTime.substring(0, endTime.length()-1);
    }
}
