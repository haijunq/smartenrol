package smartenrol.model;

/**
 * This is the entity class for Course.
 * @author Haijun
 */
public class Course {
    private String departmentID; 
    private int courseNumber; 
    private float credits;      //should change the dababase attribute to float
    private String courseName; 
    private String courseDescription; 
    
    public Course() {
        
    }
    
    /**
     * Return the string by concatenating the departmentID and courseNumber.
     * @return a string combing the departmentID and courseNumber.
     */
    @Override
    public String toString() {
        return departmentID + courseNumber;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
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
