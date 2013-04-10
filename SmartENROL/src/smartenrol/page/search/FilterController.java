/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author Jeremy, Terry
 */
public class FilterController extends SmartEnrolController {
    
    @FXML private Text labelFilter1;
    @FXML private Text labelFilter2;
    @FXML private Text labelFilter3;
    @FXML private Text labelFilterTitle;
    
    @FXML private ComboBox comboFilter1;
    @FXML private ComboBox comboFilter2;
    @FXML private ComboBox comboFilter3;
    
    
    public void init() {

    }
    
    public void createFilters(String type)
    {
        if (type.equalsIgnoreCase("course"))
        {
           creatCourseFilters(); 
        }
        if (type.equalsIgnoreCase("program"))
        {
           creatProgramFilters(); 
        }
        if (type.equalsIgnoreCase("people"))
        {
           createUserFilters(); 
        }
        
    }
    
    
    private void creatCourseFilters()
    {
        labelFilterTitle.setText("Course Filters");
        labelFilter1.setText("Department");
        labelFilter2.setText("Level");
        labelFilter3.setText("Program");
    
        comboFilter1.setVisible(true);
        comboFilter2.setVisible(true);
        comboFilter3.setVisible(true);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(true);
        labelFilter3.setVisible(true);
    }
    
    private void creatProgramFilters()
    {
        labelFilterTitle.setText("Program Filters");
        labelFilter1.setText("Department");
        comboFilter1.setVisible(true);
        comboFilter2.setVisible(false);
        comboFilter3.setVisible(false);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(false);
        labelFilter3.setVisible(false);
           
    }
    
    private void createUserFilters()
    {
        labelFilterTitle.setText("People Filters");
        labelFilter1.setText("Type");
       comboFilter1.setVisible(true);
        comboFilter2.setVisible(true);
        comboFilter3.setVisible(true);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(false);
        labelFilter3.setVisible(false);
    }
    
    
}
