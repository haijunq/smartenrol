/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Haijun
 */
public class Program  {

    private String idProgram;
    private String programName;
    private String programDescription;
    private String idDepartment;
    private float totalCreditsToGraduate;

    public Program() {
    }

    public Program(String idProgram) {
        this.idProgram = idProgram;
    }

    public Program(String idProgram, String programName, String idDepartment,float credit) {
        this.idProgram = idProgram;
        this.programName = programName;
        this.idDepartment = idDepartment;
        this.totalCreditsToGraduate=credit;
    }

    public Program(String idProgram, String programName, String programDescription, String idDepartment, float totalCreditsToGraduate) {
        this.idProgram = idProgram;
        this.programName = programName;
        this.programDescription = programDescription;
        this.idDepartment = idDepartment;
        this.totalCreditsToGraduate = totalCreditsToGraduate;
    }
    
    

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }
    
    public float gettotalCreditsToGraduate() {
        return totalCreditsToGraduate;
    }

    public void settotalCreditsToGraduate(float totalCreditsToGraduate) {
        this.totalCreditsToGraduate = totalCreditsToGraduate;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }


    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Program[ idProgram=" + idProgram + " ]";
    }
    
}
