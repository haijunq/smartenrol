/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class Section {
    private String idDepartment; 
    private int idCourse;
    private String idSection; 
    private int year;
    private String term;
    private String notes;
    private String type;
    private int maxClassSize;
    private ArrayList<SectionNode> snodes; 

    public Section() {
    }

    public Section(String idDepartment, int idCourse, String idSection, int year, String term) {
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.idSection = idSection;
        this.year = year;
        this.term = term;
    }

    @Override
    public String toString() {
        return idDepartment + " " + idCourse + " " + idSection;
    }

    public boolean isSectionFull(int currentEnrol) {
        if (currentEnrol < this.maxClassSize) 
            return false;
        else
            return true;
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

    public ArrayList<SectionNode> getSnodes() {
        return snodes;
    }

    public void setSnodes(ArrayList<SectionNode> snodes) {
        this.snodes = snodes;
    }
    
    
}
