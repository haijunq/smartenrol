/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 * This class is defined for a class list of a section.
 * @author Jeremy
 */
public class ClassList extends Section {

    private String instructorGivenName; 
    private String instructorSurname;
    
    private ArrayList<StudentGradeRecord> stuRecordList;

    public ClassList() {
    }

    public ClassList(String idDepartment, int idCourse, String idSection, int year, String term) {
        super(idDepartment, idCourse, idSection, year, term);
    }

    public ClassList(String idDepartment, int idCourse, String idSection, int year, String term, String notes, String type, int maxClassSize, int idInstructor) {
        super(idDepartment, idCourse, idSection, year, term, notes, type, maxClassSize, idInstructor);
    }

    public ClassList(String idDepartment, int idCourse, String idSection, int year, String term, String notes, String type, int maxClassSize, int idInstructor, String instructorGivenName, String instructorSurname, ArrayList<StudentGradeRecord> stuRecordList) {
        super(idDepartment, idCourse, idSection, year, term, notes, type, maxClassSize, idInstructor);
        this.instructorGivenName = instructorGivenName;
        this.instructorSurname = instructorSurname;
        this.stuRecordList = stuRecordList;
    }

    public ClassList(String idDepartment, int idCourse, String idSection, int year, String term, String notes, String type, int maxClassSize, int idInstructor, String instructorGivenName, String instructorSurname) {
        super(idDepartment, idCourse, idSection, year, term, notes, type, maxClassSize, idInstructor);
        this.instructorGivenName = instructorGivenName;
        this.instructorSurname = instructorSurname;
    }

    public ClassList(Section section) {
        super(section.getIdDepartment(), section.getIdCourse(), section.getIdSection(), section.getYear(), section.getTerm(), section.getNotes(), section.getType(), section.getMaxClassSize(), section.getIdInstructor());
    }
    
    public String getInstructorName() {
        return this.instructorGivenName + " " + this.instructorSurname;
    }
    
    public String getInstructorGivenName() {
        return instructorGivenName;
    }

    public void setInstructorGivenName(String instructorGivenName) {
        this.instructorGivenName = instructorGivenName;
    }

    public String getInstructorSurname() {
        return instructorSurname;
    }

    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    public ArrayList<StudentGradeRecord> getStuRecordList() {
        return stuRecordList;
    }

    public void setStuRecordList(ArrayList<StudentGradeRecord> stuRecordList) {
        this.stuRecordList = stuRecordList;
    }  
    
}
