/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 * This class is used in the Transcript class. 
 * @author Haijun
 */
public class CourseGradeRecord {
    private String idDepartment; 
    private int idCourse;
    private float credits; 
    private String courseName; 
    private int year; 
    private String term; 
    private int grade;

    public CourseGradeRecord() {
    }

    public CourseGradeRecord(String idDepartment, int idCourse, float credits, String courseName, int year, String term, int grade) {
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.credits = credits;
        this.courseName = courseName;
        this.year = year;
        this.term = term;
        this.grade = grade;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    
}
