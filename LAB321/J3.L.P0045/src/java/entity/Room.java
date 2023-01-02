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
public class Room {
    private int roomID;
    private String roomName;

    public Room(int roomID, String roomName) {
        this.roomID = roomID;
        this.roomName = roomName;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }
    
}
