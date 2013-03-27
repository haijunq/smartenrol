package smartenrol.model;

/**
 * This is the entity class for Course.
 * @author Haijun
 */
public class Course {
    private String idDepartment; 
    private int idCourse; 
    private float credits;      //should change the dababase attribute to float
    private String courseName; 
    private String courseDescription; 
    
    public Course() {
        
    }
    
    /**
     * Return the string by concatenating the idDepartment and idCourse.
     * @return a string combing the idDepartment and idCourse.
     */
    @Override
    public String toString() {
        return idDepartment + idCourse;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
        
}
