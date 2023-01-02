/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author Kien
 */
public class DigitalNews {
    
    private int id;
    private String title;
    private String content;
    private String image;
    private String author;
    private Timestamp date;
    private String description;

    public DigitalNews() {
    }

    public DigitalNews(int id, String title, String content, String image, String author, Timestamp date, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.date = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getFormattedTime(){
        return new SimpleDateFormat("MMM dd yyyy - hh:mm a").format(date);
    }

}
