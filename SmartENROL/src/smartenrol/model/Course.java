package smartenrol.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This is the entity class for Course.
 * @author Haijun
 */
public class Course {
    private SimpleStringProperty idDepartment; 
    private SimpleStringProperty courseName; 
    private SimpleStringProperty courseDescription; 
    private SimpleStringProperty course; 
    private SimpleIntegerProperty idCourse; 
    private SimpleFloatProperty credits;      //should change the dababase attribute to float
    private SimpleBooleanProperty isRestricted;
    
    public Course() {
    }

    public Course(String idDepartment, int idCourse) {
        this.idDepartment = new SimpleStringProperty(idDepartment);
        this.idCourse = new SimpleIntegerProperty(idCourse);
    }

    public Course(String idDepartment, int idCourse, float credits, String courseName) {
        this.idDepartment = new SimpleStringProperty(idDepartment);
        this.idCourse = new SimpleIntegerProperty(idCourse);
        this.credits = new SimpleFloatProperty(credits);
        this.courseName = new SimpleStringProperty(courseName);
    }

    public Course(String idDepartment, int idCourse, float credits, String courseName, String courseDescription, boolean isRestricted) {
        this.idDepartment = new SimpleStringProperty(idDepartment);
        this.idCourse = new SimpleIntegerProperty(idCourse);
        this.credits = new SimpleFloatProperty(credits);
        this.courseName = new SimpleStringProperty(courseName);
        this.courseDescription = new SimpleStringProperty(courseDescription);
        this.isRestricted = new SimpleBooleanProperty(isRestricted);
    }
    
    /**
     * Return the string by concatenating the idDepartment and idCourse.
     * @return a string combing the idDepartment and idCourse.
     */
    @Override
    public String toString() {
        return idDepartment.get() + " " + idCourse.get();
    }
	
	public String getCourse() {
		return idDepartment.get() + " " + idCourse.get();
	}

	public void setCourse(String idDepartment, int idCourse) {
		this.course.set(idDepartment + String.valueOf(idCourse));
	}
	
    public String getIdDepartment() {
        return idDepartment.get();
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment.set(idDepartment);
    }

    public int getIdCourse() {
        return idCourse.get();
    }

    public void setIdCourse(int idCourse) {
        this.idCourse.set(idCourse);
    }

    public float getCredits() {
        return credits.get();
    }

    public void setCredits(float credits) {
        this.credits.set(credits);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public String getCourseDescription() {
        return courseDescription.get();
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription.set(courseDescription);
    }

    public boolean isRestricted() {
        return isRestricted.get();
    }

    public void setIsRestricted(boolean isRestricted) {
        this.isRestricted.set(isRestricted);
    }
        
}
