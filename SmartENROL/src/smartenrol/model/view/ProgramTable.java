/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.Program;

/**
 *
 * @author Jeremy
 */
public class ProgramTable {
    
    private SimpleStringProperty program;
    private SimpleStringProperty name;
    private SimpleStringProperty department;
    private SimpleFloatProperty totalCredit;
    
    public ProgramTable(Program program)
    {
        this.program=new SimpleStringProperty(program.getIdProgram());
        this.department=new SimpleStringProperty(program.getIdDepartment());
        this.name=new SimpleStringProperty(program.getProgramName());
        this.totalCredit=new SimpleFloatProperty(program.gettotalCreditsToGraduate());
    }

    /**
     * @return the Program
     */
    public String getProgram() {
        return program.get();
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name.get();
    }

    /**
     * @return the Department
     */
    public String getDepartment() {
        return department.get();
    }

    /**
     * @return the totalCredit
     */
    public float getTotalCredit() {
        return totalCredit.get();
    }
    
    @Override
    public String toString()
    {
        return program.get();
    }
}
