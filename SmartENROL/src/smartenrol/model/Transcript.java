/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Haijun
 */
public class Transcript extends Section {
    Student student;
    int grade; 
    
    public Transcript(Section sec, Student stu, int grade) {
        super(sec.getIdDepartment(), sec.getIdCourse(), sec.getCourseName(), sec.getYear(), sec.getTerm());
        
        
    } 
}
