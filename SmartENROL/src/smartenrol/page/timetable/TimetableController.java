/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.timetable;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import jfxtras.labs.scene.control.Agenda;
import jfxtras.labs.scene.control.Agenda.CalendarRange;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import smartenrol.dao.StudentSectionDAO;
import smartenrol.model.Timetable;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class TimetableController extends AbstractController {
    private DateTime fixDay;
    private Timetable currentTimetable;
    
    @FXML BorderPane innerContent;
     
    public void init() {
        fixDay = new DateTime(2013, 3, 31, 0, 0);
        currentTimetable = new StudentSectionDAO().getStudentTimetable(80013010);
//        currentTimetable = new StudentSectionDAO().getInstructorTimetable(80012002);
     }
    
    /**
     * Open and display the Agenda view. 
     */
    public void openAgenda() {
        final Agenda smartTimetable = new Agenda();
        smartTimetable.setMouseTransparent(true);
        smartTimetable.setDisplayedCalendar(fixDay.toGregorianCalendar());
        
        for (int i = 0; i < currentTimetable.getSectionNodeList().size(); i++) 
            smartTimetable.appointments().add(
                new Agenda.AppointmentImpl()
                        .withStartTime(this.calSectionTime(currentTimetable.getSectionNodeList().get(i).getDay(), currentTimetable.getSectionNodeList().get(i).getStartTime()).toGregorianCalendar())
                        .withEndTime(this.calSectionTime(currentTimetable.getSectionNodeList().get(i).getDay(), currentTimetable.getSectionNodeList().get(i).getEndTime()).toGregorianCalendar())
                        .withSummary(currentTimetable.getSectionNodeList().get(i).getIdDepartment() + " " + currentTimetable.getSectionNodeList().get(i).getIdCourse() + "\n" + currentTimetable.getSectionNodeList().get(i).getClassRoom())
    //                        .withDescription("Instructor Name")
    //                        .withLocation("FSC-101")
                        .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group16"))
                    );
        
        smartTimetable.setMinHeight(400);  

        innerContent.setCenter(smartTimetable);
            
     }
    
    /**
     * Calculate the DateTime that will be displayed in the timetable view according to DayOfWeek and LocalTime.
     * @param day
     * @param time
     * @return 
     */
    private DateTime calSectionTime(int day, LocalTime time) {
        DateTime dt = fixDay;
        dt = dt.plusDays(day).plusHours(time.getHourOfDay()).plusMinutes(time.getMinuteOfHour()).plusSeconds(time.getSecondOfMinute());
        return dt;
    }
}
