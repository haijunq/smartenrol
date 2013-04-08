/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Jeremy
 */
public class CourseSearchResult {
    
    private String Department;
    private int Course;
    private String name;
    private float credit;

    public CourseSearchResult(Course course) {
        this.Department = course.getIdDepartment();
        this.Course = course.getIdCourse();
        this.name = course.getCourseName();
        this.credit = course.getCredits();
    }

    
    
    
    /**
     * @return the Department
     */
    public String getDepartment() {
        return Department;
    }

    /**
     * @return the Course
     */
    public int getCourse() {
        return Course;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the credit
     */
    public float getCredit() {
        return credit;
    }
    
   
    
}
