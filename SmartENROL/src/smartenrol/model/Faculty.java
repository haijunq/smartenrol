/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Haijun
 */

public class Faculty {

    private String idFaculty;
    private String name;
    private String description;
    private String mainPhone;
    private String deanID;
    private String mainContactID;
    private String headOfficeLocationID;

    public Faculty() {
    }

    public Faculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getDeanID() {
        return deanID;
    }

    public void setDeanID(String deanID) {
        this.deanID = deanID;
    }

    public String getMainContactID() {
        return mainContactID;
    }

    public void setMainContactID(String mainContactID) {
        this.mainContactID = mainContactID;
    }

    public String getHeadOfficeLocationID() {
        return headOfficeLocationID;
    }

    public void setHeadOfficeLocationID(String headOfficeLocationID) {
        this.headOfficeLocationID = headOfficeLocationID;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Faculty[ idFaculty=" + idFaculty + " ]";
    }
    
}
