/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Haijun
 */
public class Prerequisite {
    
    private String idDepartment;
    private int idCourse;    
    private String idDepartmentPreReq;
    private int idCoursePreReq;

    public Prerequisite() {
    }

    public Prerequisite(String idDepartment, int idCourse, String idDepartmentPreReq, int idCoursePreReq) {
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.idDepartmentPreReq = idDepartmentPreReq;
        this.idCoursePreReq = idCoursePreReq;
    }

    @Override
    public String toString() {
        return idDepartmentPreReq + idCoursePreReq;
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

    public String getIdDepartmentPreReq() {
        return idDepartmentPreReq;
    }

    public void setIdDepartmentPreReq(String idDepartmentPreReq) {
        this.idDepartmentPreReq = idDepartmentPreReq;
    }

    public int getIdCoursePreReq() {
        return idCoursePreReq;
    }

    public void setIdCoursePreReq(int idCoursePreReq) {
        this.idCoursePreReq = idCoursePreReq;
    }

    
}
