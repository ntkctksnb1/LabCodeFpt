/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class New {
    private int id;
    private String title;
    private String description;
    private String image;
    private String author;
    private Date timePost;
    private String shortDescription;

    public New() {
    }

    public New(int id, String title, String description, String image, String author, Date timePost, String shortDescription) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDescription = shortDescription;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getTimePost() {
        return timePost;
    }

    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public String getDateFormat() {
        String dateFormat1 = new SimpleDateFormat("MMM dd yyyy - hh:mm").format(timePost);
        String dateFormat2 = new SimpleDateFormat("MMM dd yyyy - hh:mm a").format(timePost);
        String[] dateArray = dateFormat2.split(" ");
        return dateFormat1 + dateArray[dateArray.length - 1].toLowerCase();
    }
    
}
