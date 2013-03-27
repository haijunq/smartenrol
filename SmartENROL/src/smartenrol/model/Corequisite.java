/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Haijun
 */
public class Corequisite {
    private String idDepartment;
    private int idCourse;  
    private String idDepartmentCoReq;
    private int idCourseCoReq;

    public Corequisite() {
    }

    public Corequisite(String idDepartment, int idCourse, String idDepartmentCoReq, int idCourseCoReq) {
        this.idDepartment = idDepartment;
        this.idCourse = idCourse;
        this.idDepartmentCoReq = idDepartmentCoReq;
        this.idCourseCoReq = idCourseCoReq;
    }

    
    @Override
    public String toString() {
        return  idDepartmentCoReq + idCourseCoReq;
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

    public String getIdDepartmentCoReq() {
        return idDepartmentCoReq;
    }

    public void setIdDepartmentCoReq(String idDepartmentCoReq) {
        this.idDepartmentCoReq = idDepartmentCoReq;
    }

    public int getIdCourseCoReq() {
        return idCourseCoReq;
    }

    public void setIdCourseCoReq(int idCourseCoReq) {
        this.idCourseCoReq = idCourseCoReq;
    }
    
    
    
}
