/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 *
 * @author Jeremy
 */
public class Timetable {
//    Course course; 
//    Instructor instructor;
//    Classroom classroom;
    
    ArrayList<SectionNode> currentEnrol; 
    
    public Timetable(ArrayList<SectionNode> nodesList) {
        this.currentEnrol = nodesList;
    }
    
    public boolean isConflict(Section sec) {
        return false;
    } 
    
    public boolean isConflict() {
        return false;
    }
        
    
    //in DAO, we should have 
    // getTimetableByStudentID()
    // getTimetableBy
}
