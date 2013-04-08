/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import java.util.ArrayList;

/**
 * This is the timetable class, can be for a student, for an instructor, or for a classroom.
 * @author Jeremy
 */
public class Timetable {
    private String type;
    private int idUser; 
    private String givenName; 
    private String surname; 
    private String idLocation;
    private String idRoom; 
    
    ArrayList<SectionNode> sectionNodeList; 
    
    public Timetable(ArrayList<SectionNode> snlist) {
        this.sectionNodeList = snlist;
    }

    public Timetable(String type, int idUser, String givenName, String surname, String idLocation, String room) {
        this.type = type;
        this.idUser = idUser;
        this.givenName = givenName;
        this.surname = surname;
        this.idLocation = idLocation;
        this.idRoom = room;
    }
    
    public Timetable() {
    }

    public Timetable(String type) {
        this.type = type;
    }
    
    
    
    public Timetable(String type, int idUser, String givenName, String idLocation, String room) {
        this.type = type;
        this.idUser = idUser;
        this.givenName = givenName;
        this.idLocation = idLocation;
        this.idRoom = room;
    }
    
    public String getFullName() {
        return this.givenName + " " + this.surname;
    }
    
    public String getClassroom() {
        return this.idLocation + " " + this.idRoom;
    }
    
    public boolean isConflict(ArrayList<SectionNode> snlist) {
        
        return false;
    } 


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public ArrayList<SectionNode> getSectionNodeList() {
        return sectionNodeList;
    }

    public void setSectionNodeList(ArrayList<SectionNode> sectionNodeList) {
        this.sectionNodeList = sectionNodeList;
    }
        

}
