/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Haijun
 */
@Entity
@Table(name = "Program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByIdProgram", query = "SELECT p FROM Program p WHERE p.idProgram = :idProgram"),
    @NamedQuery(name = "Program.findByProgramName", query = "SELECT p FROM Program p WHERE p.programName = :programName"),
    @NamedQuery(name = "Program.findByProgramDescription", query = "SELECT p FROM Program p WHERE p.programDescription = :programDescription")})
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProgram")
    private String idProgram;
    @Column(name = "programName")
    private String programName;
    @Column(name = "programDescription")
    private String programDescription;
    @OneToMany(mappedBy = "program")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "idDepartment", referencedColumnName = "idDepartment")
    @ManyToOne
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

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProgram != null ? idProgram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.idProgram == null && other.idProgram != null) || (this.idProgram != null && !this.idProgram.equals(other.idProgram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smartenrol.model.Program[ idProgram=" + idProgram + " ]";
    }
    
}
