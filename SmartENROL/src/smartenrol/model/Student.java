/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalDate;

/**
 * Student class extends User class and stores more info of a student.
 * @author Haijun
 */
public class Student extends User {
    private String idProgram;
    private String status; 
    private LocalDate dateStarted;
    private String type;

    public Student() {
    }

    public Student(int idStudent) {
        super(idStudent);
    }

    public Student(int idStudent, String givenName, String surname, String idProgram) {
        super(idStudent, givenName, surname);
        this.idProgram = idProgram;
    }

    public Student(int idStudent, String idProgram, String givenName, String surname, String status, LocalDate dateStarted, String type) {
        super(idStudent, givenName, surname);
        this.idProgram = idProgram;
        this.status = status;
        this.dateStarted = dateStarted;
        this.type = type;
    }

    /**
     * Return the full name of the student by calling superclass getFullName() method.
     * @return 
     */
    public String getStudentName() {
        return super.getFullName();
    }

    /**
     * Return the ID of the student by calling superclass getIdUser() method.
     * @return 
     */
    public int getIdStudent() {
        return super.getIdUser();
    }

    public void setIdStudent(int idStudent) {
        this.idUser = idStudent;
    }

    public void setGivenName(String givenName) {
        super.setGivenName(givenName); 
    }
    
    public void setSurname(String surname) {
        super.setSurname(surname);
    }
    
    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        
    
}
