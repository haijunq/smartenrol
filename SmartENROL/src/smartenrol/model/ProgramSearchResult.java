/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Jeremy
 */
public class ProgramSearchResult {
    
    private String program;
    private String name;
    private String department;
    private float totalCredit;
    
    public ProgramSearchResult(Program program)
    {
        this.program=program.getIdProgram();
        this.department=program.getIdDepartment();
        this.name=program.getProgramName();
        this.totalCredit=program.gettotalCreditsToGraduate();
    }

    /**
     * @return the Program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the Department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @return the totalcredit
     */
    public float getTotalcredit() {
        return totalCredit;
    }
    
    public String toString()
    {
        return program;
    }
}
