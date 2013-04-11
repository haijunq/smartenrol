/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Jeremy
 */
public class CourseSearchResult {
    
    private SimpleStringProperty idDepartment;
    private SimpleIntegerProperty idCourse;
    private SimpleStringProperty name;
    private SimpleFloatProperty credit;

    public CourseSearchResult(Course course) {
        this.idDepartment = new SimpleStringProperty(course.getIdDepartment());
        this.idCourse = new SimpleIntegerProperty(course.getIdCourse());
        this.name = new SimpleStringProperty(course.getCourseName());
        this.credit = new SimpleFloatProperty(course.getCredits());
    }

    
    
    
    /**
     * @return the Department
     */
    public String getIdDepartment() {
        return idDepartment.get();
    }

    /**
     * @return the Course
     */
    public int getIdCourse() {
        return idCourse.get();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @return the credit
     */
    public float getCredit() {
        return credit.get();
    }
    
   
    
}
