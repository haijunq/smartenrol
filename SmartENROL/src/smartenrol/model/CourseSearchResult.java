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
    
    private Course course;
    private Program courseProgram;
    
    private final SimpleStringProperty courseID = new SimpleStringProperty("");
    private final SimpleStringProperty courseName = new SimpleStringProperty("");
    private final SimpleStringProperty program = new SimpleStringProperty("");
    private final SimpleStringProperty credits = new SimpleStringProperty("");
    
    public CourseSearchResult(Course thisCourse, Program courseProgram) {
        this.course = thisCourse;
        this.courseProgram = courseProgram;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return the courseProgram
     */
    public Program getCourseProgram() {
        return courseProgram;
    }

    /**
     * @param courseProgram the courseProgram to set
     */
    public void setCourseProgram(Program courseProgram) {
        this.courseProgram = courseProgram;
    }

    /**
     * @return the courseID
     */
    public SimpleStringProperty getCourseID() {
        return courseID;
    }

    /**
     * @return the courseName
     */
    public SimpleStringProperty getCourseName() {
        return courseName;
    }

    /**
     * @return the program
     */
    public SimpleStringProperty getProgram() {
        return program;
    }

    /**
     * @return the credits
     */
    public SimpleStringProperty getCredits() {
        return credits;
    }
    
}
