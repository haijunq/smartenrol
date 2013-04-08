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
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class TimetableController extends AbstractController {
     
    @FXML BorderPane innerContent;

     
     public void init() {
        
     }
    
     public void openAgenda() {
            final Agenda smartTimetable = new Agenda();
//            smartTimetable.setMouseTransparent(true);
//            smartTimetable.with
            smartTimetable.setDisplayedCalendar(new DateTime(2013, 4, 1, 8, 0).toGregorianCalendar());
            smartTimetable.appointments().add(
                new Agenda.AppointmentImpl()
                        .withStartTime(new DateTime(2013, 4, 3, 12, 0).toGregorianCalendar())
                        .withEndTime(new DateTime(2013, 4, 3, 14, 0).toGregorianCalendar())
                        .withSummary("Course \nInstructor \nFSC-101")
//                        .withDescription("Instructor Name")
//                        .withLocation("FSC-101")
                        .withAppointmentGroup(new Agenda.AppointmentGroupImpl().withStyleClass("group16"))
                    );
            
            smartTimetable.setMinHeight(400);  

            
            innerContent.setCenter(smartTimetable);
            
     }
    
}
