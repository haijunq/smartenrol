/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalTime;

/**
 *
 * @author Haijun
 */
public class SectionNode extends Section {
    int day; 
    LocalTime startTime;
    LocalTime endTime;
    String idLocation;
    String idRoom;
    private String [] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public SectionNode(int day, LocalTime startTime, LocalTime endTime, String idLocation, String idRoom) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idLocation = idLocation;
        this.idRoom = idRoom;
    }
    
    public SectionNode(String idDepartment, int idCourse, String idSection, int year, String term, int day) {
        super(idDepartment, idCourse, idSection, year, term);
        this.day = day;
    }

    public SectionNode(String idDepartment, int idCourse, String idSection, int year, String term, int day, LocalTime startTime, LocalTime endTime, String idLocation, String idRoom) {
        super(idDepartment, idCourse, idSection, year, term);
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idLocation = idLocation;
        this.idRoom = idRoom;
    }

    public SectionNode(String idDepartment, int idCourse, String idSection, int day, LocalTime startTime, LocalTime endTime, String idLocation, String idRoom) {
        super(idDepartment, idCourse, idSection);
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idLocation = idLocation;
        this.idRoom = idRoom;
    }
    
    
    /**
     * Return the day of week in Abbreviation such as MON, TUE.
     * @return 
     */
    public String getDayOfWeek() {
        if (day < 1 || day > 7)
            return "";
        else 
            return days[day-1];
    }

    public String toLongString() {
        return this.getDayOfWeek() + "  " + this.getStartTime().toString("HH:mm") + " - " + this.getEndTime().toString("HH:mm") + "  " + this.getClassRoom();
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
    }

    public String getClassRoom() {
        return idLocation + "-" + idRoom;
    }
    
    
    
}
