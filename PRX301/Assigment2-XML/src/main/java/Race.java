
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kien
 */
public class Race {

    private String date;
    private String name;
    private String courseName;
    private String courseAddress;
    private List<Horse> horses;

    public Race() {
        horses = new ArrayList<>();
    }

    public Race(String date, String name, String courseName, String courseAddress, List<Horse> horses) {
        this.date = date;
        this.name = name;
        this.courseName = courseName;
        this.courseAddress = courseAddress;
        this.horses = horses;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseAddress() {
        return courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    @Override
    public String toString() {
        return "Race{" + "date=" + date + ", name=" + name + ", courseName=" + courseName + ", courseAddress=" + courseAddress + ", horses=" + horses + '}';
    }

}
