/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Haijun
 */
public class StudentGradeRecord {
    private int idStudent; 
    private String idProgram;
    private String givenName;
    private String surname; 
    private int grade;

    public StudentGradeRecord() {
    }

    public StudentGradeRecord(int idStudent, String idProgram, String givenName, String surname, int grade) {
        this.idStudent = idStudent;
        this.idProgram = idProgram;
        this.givenName = givenName;
        this.surname = surname;
        this.grade = grade;
    }

    public String getStudentName() {
        return this.getGivenName() + " " + this.getSurname();
    }
            
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    
}
