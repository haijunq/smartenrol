/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.timetable;

import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import jfxtras.labs.scene.control.Agenda;
import smartenrol.page.AbstractController;

/**
 *
 * @author Jeremy
 */
public class TimetableController extends AbstractController {
     
    @FXML BorderPane innerContent;
     Calendar test;
     
     public void init() {
        
     }
    
     public void openAgenda() {
            final Agenda smartTimetable = new Agenda();
            smartTimetable.setMinHeight(400);  
            test.setFirstDayOfWeek(1);
            smartTimetable.setDisplayedCalendar(test);
            innerContent.setCenter(smartTimetable);

     }
    
}
