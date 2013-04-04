/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 * this is the class for section of a course.
 * @author Jeremy
 */
public class Section extends Course {
    private String idSection;
    private int year;
    private String term;
    private String notes;
    private String type;
    private int maxClassSize;
//    private ArrayList<SectionNode> snodes; 
    private int idInstructor;

    public Section() {
    }

    public Section(String idDepartment, int idCourse, String idSection, int year, String term) {   
        super(idDepartment, idCourse);
        this.idSection = idSection;
        this.year = year;
        this.term = term;
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

    @Override
    public String toString() {
        return super.getIdDepartment() + " " + super.getIdCourse() + " " + idSection;
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

  }
