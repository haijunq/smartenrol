/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 * This is the transcript class used for viewing and printing official transcript.
 * @author Haijun
 */
public class Transcript {
    private int idStudent;
    private String givenName; 
    private String surname;
    private String idProgram; 
    private String programName; 
    
    private ArrayList<CourseGradeRecord> gradeRecords; 

    public Transcript() {
    }

    public Transcript(int idStudent, String givenName, String surname, String idProgram, String programName) {
        this.idStudent = idStudent;
        this.givenName = givenName;
        this.surname = surname;
        this.idProgram = idProgram;
        this.programName = programName;
    }

    public Transcript(Student student) {
        this.idStudent = student.getIdStudent();
        this.givenName = student.getGivenName();
        this.surname = student.getSurname();
        this.idProgram = student.getIdProgram();
        this.programName = student.getProgramName();
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public ArrayList<CourseGradeRecord> getGradeRecords() {
        return gradeRecords;
    }

    public void setGradeRecords(ArrayList<CourseGradeRecord> gradeRecords) {
        this.gradeRecords = gradeRecords;
    }
    
    
}
