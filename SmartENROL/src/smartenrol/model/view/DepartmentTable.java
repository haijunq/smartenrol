/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.Department;

/**
 *
 * @author Swordghost
 */
public class DepartmentTable {
    private SimpleStringProperty department;
    private SimpleStringProperty name;
    private SimpleStringProperty building;
    private SimpleStringProperty phone;
    private SimpleStringProperty email;
    
    public DepartmentTable(Department department)
    {
        this.building=new SimpleStringProperty( department.getIdLocation() );
        this.name=new SimpleStringProperty( department.getName());
        this.department=new SimpleStringProperty(department.getIdDepartment());
        this.email=new SimpleStringProperty(department.getEmail());
        this.phone=new SimpleStringProperty(department.getPhone());
    }

    public String getDepartment() {
        return department.get();
    }

    public String getName() {
        return name.get();
    }

    public String getBuilding() {
        return building.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }
    
}
