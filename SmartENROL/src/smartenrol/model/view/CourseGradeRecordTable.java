/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.CourseGradeRecord;

/**
 * This class is for the transcript 
 * @author Haijun
 */
public class CourseGradeRecordTable {
    private SimpleStringProperty idDepartment;
    private SimpleIntegerProperty idCourse;
    private SimpleStringProperty name;
    private SimpleFloatProperty credit;
    private SimpleIntegerProperty year;
    private SimpleStringProperty term;
    private SimpleIntegerProperty grade;
    
    public CourseGradeRecordTable(CourseGradeRecord courseGradeRecord) {
        this.idDepartment = new SimpleStringProperty(courseGradeRecord.getIdDepartment());
        this.idCourse = new SimpleIntegerProperty(courseGradeRecord.getIdCourse());  
        this.name = new SimpleStringProperty(courseGradeRecord.getCourseName());
        this.credit = new SimpleFloatProperty(courseGradeRecord.getCredits());
        this.year = new SimpleIntegerProperty(courseGradeRecord.getYear());  
        this.term = new SimpleStringProperty(courseGradeRecord.getTerm());
        this.grade = new SimpleIntegerProperty(courseGradeRecord.getGrade());         
    }

   /**
     * @return the Department
     */
    public String getIdDepartment() {
        return idDepartment.get();
    }

    /**
     * @return the Course
     */
    public int getIdCourse() {
        return idCourse.get();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @return the credit
     */
    public float getCredit() {
        return credit.get();
    }
    
    public int getYear() {
        return year.get();
    }
    
    public String getTerm() {
        return term.get();
    }
    
    public int getGrade() {
        return grade.get();
    }

}
