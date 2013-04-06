/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Haijun
 */
@Embeddable
public class StudentSection implements Serializable {
    @Basic(optional = false)
    @Column(name = "idStudent")
    private int idStudent;
    @Basic(optional = false)
    @Column(name = "idDepartment")
    private String idDepartment;
    @Basic(optional = false)
    @Column(name = "idCourse")
    private int idCourse;
    @Basic(optional = false)
    @Column(name = "idSection")
    private String idSection;
    @Basic(optional = false)
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private int year;
    @Basic(optional = false)
    @Column(name = "term")
    private String term;
    @Column(name = "grade")
    private Integer grade;
    @Basic(optional = false)
    @Column(name = "onWaitlist")
    private boolean onWaitlist;

    public StudentSection() {
    }

    public StudentSection(int idStudent, String idDepartment, int idCourse, String idSection, int year, String term) {
        this.idStudent = idStudent;
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.idSection = idSection;
        this.year = year;
        this.term = term;
    }

    public StudentSection(int idStudent, String idDepartment, int idCourse, String idSection, int year, String term, Integer grade, boolean onWaitlist) {
        this.idStudent = idStudent;
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.idSection = idSection;
        this.year = year;
        this.term = term;
        this.grade = grade;
        this.onWaitlist = onWaitlist;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public boolean isOnWaitlist() {
        return onWaitlist;
    }

    public void setOnWaitlist(boolean onWaitlist) {
        this.onWaitlist = onWaitlist;
    }

    @Override
    public String toString() {
        return "smartenrol.model.StudentSectionPK[ idStudent=" + idStudent + ", idDepartment=" + idDepartment + ", idCourse=" + idCourse + ", idSection=" + idSection + ", year=" + year + ", term=" + term + " ]";
    }
    
}
