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
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy
 */
public class TimetableController extends SmartEnrolController {
    private final DateTime fixDay = new DateTime(2013, 3, 31, 0, 0);
    private Timetable currentTimetable;
    private int idUser; 
    private String userType;
    
    @FXML BorderPane innerContent;
     
    public void init() {
        constructTimetable();
        openAgenda();
     }
    
    public void constructTimetable() {
        idUser = UserSession.getInstance().getCurrentUser().getIdUser(); 
        
        User.Type usertype = getUserSession().getCurrentUser().getUsertype();
                
                if (getUserSession().isSignedIn()) {
                    
                    if (usertype == User.Type.STUDENT) {
                        currentTimetable = new StudentSectionDAO().getStudentTimetable(idUser);
                    } else if (usertype == User.Type.INSTRUCTOR) {
                        currentTimetable = new StudentSectionDAO().getInstructorTimetable(idUser);
                    } else {
                        currentTimetable = null;
                    }
                    
                }

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
        dt = dt.plusDays(day).plusHours(time.getHourOfDay()-8).plusMinutes(time.getMinuteOfHour()).plusSeconds(time.getSecondOfMinute());
        return dt; 
    }
}
