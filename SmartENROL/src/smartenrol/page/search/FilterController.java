/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.search;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.dao.DepartmentDAO;
import smartenrol.dao.ProgramDAO;
import smartenrol.model.User;
import smartenrol.page.SmartEnrolController;
import smartenrol.security.UserSession;

/**
 *
 * @author Jeremy, Terry
 */
public class FilterController extends SmartEnrolController {
    
    @Autowired private SearchController searchController;
    
    @FXML private Text labelFilter1;
    @FXML private Text labelFilter2;
    @FXML private Text labelFilter3;
    @FXML private Text labelFilterTitle;
    
    @FXML private ComboBox comboFilter1;
    @FXML private ComboBox comboFilter2;
    @FXML private ComboBox comboFilter3;
    
    private EventHandler updateHandler;
    
    public void init() {


            this.updateHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateSearch();
            }
        };
        
            
        
        comboFilter1.addEventHandler(ActionEvent.ACTION,updateHandler);
        comboFilter2.addEventHandler(ActionEvent.ACTION,updateHandler);
        comboFilter3.addEventHandler(ActionEvent.ACTION,updateHandler);

    }
    
    
    
   
    private void updateSearch() {

           searchController.doSearch();
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
        if (type.equalsIgnoreCase("department"))
        {
           createDepartmentFilters(); 
        }
        
    }
    
    public void resetFilters()
    {
              
        comboFilter1.removeEventHandler(ActionEvent.ACTION, updateHandler);   
        comboFilter2.removeEventHandler(ActionEvent.ACTION, updateHandler);  
        comboFilter3.removeEventHandler(ActionEvent.ACTION, updateHandler);  
        
        comboFilter1.getSelectionModel().selectFirst();
        comboFilter2.getSelectionModel().selectFirst();
        comboFilter3.getSelectionModel().selectFirst();
        
        comboFilter1.addEventHandler(ActionEvent.ACTION,updateHandler);
        comboFilter2.addEventHandler(ActionEvent.ACTION,updateHandler);
        comboFilter3.addEventHandler(ActionEvent.ACTION,updateHandler);

        
    }
    
    
    public String getFilterValue(int filterNo)
    {
        if (filterNo==1)
        {
             if (!(comboFilter1.getValue()==null))
             {
                 return (String) comboFilter1.getValue();
             }
                 
        }
        
        if (filterNo==2)
        {
            if (!(comboFilter2.getValue()==null))
            {
                return comboFilter2.getValue().toString();
            }
        }
        
        if (filterNo==3)
        {
            if (!(comboFilter3.getValue()==null))
            {
                return (String) comboFilter3.getValue();
            }
        }
        
        return "";
    }
    
    private void creatCourseFilters()
    {
        labelFilterTitle.setText("Course Filter");
        labelFilter1.setText("Department");
        labelFilter2.setText("Level");
        labelFilter3.setText("Program");
    
        initDeptFilter(comboFilter1);  
        initLevelFilter(comboFilter2);
        initProgramFilter(comboFilter3);
        
        comboFilter1.setVisible(true);
        comboFilter2.setVisible(true);
        comboFilter3.setVisible(true);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(true);
        labelFilter3.setVisible(true);
        
      
    }
    
    private void creatProgramFilters()
    {
        labelFilterTitle.setText("Program Filter");
        labelFilter1.setText("Department");
        
        initDeptFilter(comboFilter1);   
        
        comboFilter1.setVisible(true);
        comboFilter2.setVisible(false);
        comboFilter3.setVisible(false);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(false);
        labelFilter3.setVisible(false);
    
           
    }
    
    private void createUserFilters()
    {
        labelFilterTitle.setText("People Filter");
        labelFilter1.setText("Type");

        User.Type userType = UserSession.getInstance().getCurrentUser().getUsertype();
        System.out.println(userType);
        if (userType == User.Type.STUDENT) 
        {
            initUserFilterInsturctorOnly(comboFilter1);
        }
        else
        {
             initUserFilter(comboFilter1);
        }
       
                     
        comboFilter1.setVisible(true);
        comboFilter2.setVisible(false);
        comboFilter3.setVisible(false);
        labelFilter1.setVisible(true);
        labelFilter2.setVisible(false);
        labelFilter3.setVisible(false);
        
    }
    
    private void createDepartmentFilters() {
        labelFilterTitle.setText("Department");
        comboFilter1.setVisible(false);
        comboFilter2.setVisible(false);
        comboFilter3.setVisible(false);
        labelFilter1.setVisible(false);
        labelFilter2.setVisible(false);
        labelFilter3.setVisible(false);
    }

  
    
    private void initDeptFilter(ComboBox combo)
    {
        ArrayList<String> deptList = new ArrayList<>();
        deptList=new DepartmentDAO().getAllDeptID();
        combo.removeEventHandler(ActionEvent.ACTION, updateHandler);
        combo.getItems().clear();
        combo.getItems().add("ALL");
        combo.getItems().addAll(deptList);
        combo.getSelectionModel().selectFirst();
        combo.addEventHandler(ActionEvent.ACTION, updateHandler);
        

    }
    
     private void initProgramFilter(ComboBox combo)
    {
        ArrayList<String> programList = new ArrayList<>();
        combo.removeEventHandler(ActionEvent.ACTION, updateHandler);
        programList=new ProgramDAO().getAllProgramID();
        combo.getItems().clear();
        combo.getItems().add("ALL");
        combo.getItems().addAll(programList);
        combo.getSelectionModel().selectFirst();
        combo.addEventHandler(ActionEvent.ACTION, updateHandler);

    }
    
    private void initLevelFilter(ComboBox combo)
    {
        combo.removeEventHandler(ActionEvent.ACTION, updateHandler);
        combo.getItems().clear();
        combo.getItems().add("ALL");
        combo.getItems().addAll(100,200,300,400,500,600,700,800,900);
        combo.getSelectionModel().selectFirst();
        combo.addEventHandler(ActionEvent.ACTION, updateHandler);

    }

    private void initUserFilter(ComboBox combo)
    {
        combo.removeEventHandler(ActionEvent.ACTION, updateHandler);
        combo.getItems().clear();
        combo.getItems().add("ALL");
        combo.getItems().addAll("Student","Instructor","Administrator");
        combo.getSelectionModel().selectFirst();
        combo.addEventHandler(ActionEvent.ACTION, updateHandler);
    }
    
     private void initUserFilterInsturctorOnly(ComboBox combo)
    {
        combo.removeEventHandler(ActionEvent.ACTION, updateHandler);
        combo.getItems().clear();
        combo.getItems().add("Instructor");
        combo.getSelectionModel().selectFirst();
        combo.addEventHandler(ActionEvent.ACTION, updateHandler);
    }


}
