/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.StudentGradeRecord;

/**
 *
 * @author Haijun
 */
public class StudentGradeRecordTable {
    private SimpleIntegerProperty idStudent;
    private SimpleStringProperty idProgram;
    private SimpleStringProperty givenName;
    private SimpleStringProperty surname; 
    private SimpleIntegerProperty grade;
    
    public StudentGradeRecordTable(StudentGradeRecord studentGradeRecord) {
        this.idStudent = new SimpleIntegerProperty(studentGradeRecord.getIdStudent());
        this.idProgram = new SimpleStringProperty(studentGradeRecord.getIdProgram());
        this.givenName = new SimpleStringProperty(studentGradeRecord.getGivenName());
        this.surname = new SimpleStringProperty(studentGradeRecord.getSurname());
        this.grade = new SimpleIntegerProperty(studentGradeRecord.getGrade());
    }
    
    public int getIdStudent() {
        return this.idStudent.get();
    }
    
    public String getIdProgram() {
        return this.idProgram.get();
    }
    
    public String getGivenName() {
        return this.givenName.get();
    }
    
    public String getSurname() {
        return this.surname.get();
    }
    
    public int getGrade() {
        return this.grade.get();
    }
    
    public void setGrade(int newgrade) {
        this.grade.set(newgrade);
    }
}
