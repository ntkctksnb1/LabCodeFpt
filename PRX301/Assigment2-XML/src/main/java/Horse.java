/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kien
 */
public class Horse {
    private String name;
    private String value;
    private String dateOfBirth;
    private String gender;

    public Horse() {
    }

    public Horse(String name, String value, String dateOfBirth, String gender) {
        this.name = name;
        this.value = value;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nHorse{" + "name=" + name + ", value=" + value + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + '}';
    }
    
    
}
