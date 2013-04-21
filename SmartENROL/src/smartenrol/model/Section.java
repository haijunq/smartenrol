/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 * The Section class extends the Course class and stores the info of section(s) of a course.
 * @author Jeremy
 */
public class Section extends Course {
    private String idSection;
    private int year;
    private String term;
    private String notes;
    private String type;
    private int maxClassSize; 
    private int idInstructor;
    private String givenName; 
    private String surname; 

    public Section() {
    }

    public Section(String idDepartment, int idCourse, String courseName, float credits, int year, String term ) {
        super(idDepartment, idCourse, credits, courseName);
        this.year = year;
        this.term = term;
    }
    
    public Section(String idDepartment, int idCourse, String idSection, String courseName, float credits, int year, String term ) {
        super(idDepartment, idCourse, credits, courseName);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
    }
    
    public Section(String idDepartment, int idCourse, String idSection, int year, String term) {   
        super(idDepartment, idCourse);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
    }

    public Section(String idDepartment, int idCourse, String idSection, int year, String term, int maxClassSize, int idInstructor) {
        super(idDepartment, idCourse);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
        this.maxClassSize = maxClassSize;
        this.idInstructor = idInstructor;
    }

    public Section(String idDepartment, int idCourse, String idSection, int year, String term, String notes, String type, int maxClassSize, int idInstructor) {
        super(idDepartment, idCourse);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
        this.notes = notes;
        this.type = type;
        this.maxClassSize = maxClassSize;
        this.idInstructor = idInstructor;
    }
    
    public Section(String idDepartment, int idCourse, String idSection, String courseName, int year, String term, String notes, String type, int maxClassSize, int idInstructor) {
        super(idDepartment, idCourse);
        this.idSection = idSection;
        super.setCourseName(courseName);
        this.year = year;
        this.term = term;
        this.notes = notes;
        this.type = type;
        this.maxClassSize = maxClassSize;
        this.idInstructor = idInstructor;
    }
    public Section(String idDepartment, int idCourse, String idSection) {
        super(idDepartment, idCourse);
        this.idSection = idSection;
    }

    public Section(String idDepartment, int idCourse, String idSection, int year, String term, String notes, String type, int maxClassSize, int idInstructor, String givenName, String surname) {
        super(idDepartment, idCourse);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
        this.notes = notes;
        this.type = type;
        this.maxClassSize = maxClassSize;
        this.idInstructor = idInstructor;
        this.givenName = givenName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return super.getIdDepartment() + " " + super.getIdCourse() + " " + this.idSection;
    }
    
    public String getCourseTypeString() {
        return super.getIdDepartment() + " " + super.getIdCourse() + " " + this.type;
    }
    
    public String getCourseString() {
        return super.getIdDepartment() + " " + super.getIdCourse();
    }    
    public String getInstructorName() {
        return this.givenName + " " + this.surname;
    }

    public boolean isSectionFull(int currentEnrol) {
        if (currentEnrol < this.maxClassSize) 
            return false;
        else
            return true;
    }

    public String getIdSection() {
        return idSection;
    }

    public void setIdSection(String idSection) {
        this.idSection = idSection;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxClassSize() {
        return maxClassSize;
    }

    public void setMaxClassSize(int maxClassSize) {
        this.maxClassSize = maxClassSize;
    }

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getYearTerm() {
        return this.getYear() + " " + this.getTerm();
    }
}
