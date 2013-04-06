/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import smartenrol.page.course.CoursePageController;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import javafx.scene.Node;

import smartenrol.page.*;
import smartenrol.page.administration.building.*;
import smartenrol.page.administration.course.*;
import smartenrol.page.administration.department.*;
import smartenrol.page.administration.faculty.*;
import smartenrol.page.administration.program.*;
import smartenrol.page.administration.section.*;
import smartenrol.page.dashboard.*;
import smartenrol.page.timetable.*;
import smartenrol.page.login.*;
import smartenrol.sidebar.StudentSidebarController;

/**
 * @author Jeremy
 */
@Configuration
public class SmartEnrolFactory {
    
    @Bean
    public PageController mainController() throws IOException
    {
        return (PageController) loadController("page/Page.fxml");
    }
    
    @Bean
    public CoursePageController coursePage() throws IOException
    {
        return (CoursePageController) loadController("page/coursePage/CoursePage.fxml");
    }

    @Bean
    public DashboardController dashboard() throws IOException
    {
        return (DashboardController) loadController("page/dashboard/Dashboard.fxml");
    }
    
    @Bean
    public LoginController login() throws IOException
    {
        return (LoginController) loadController("page/login/Login.fxml");
    }

    @Bean
    public AddBuildingController adminAddBuilding() throws IOException
    {
        return (AddBuildingController) loadController("page/administration/building/AddBuilding.fxml");
    }    

    @Bean
    public AddCourseController adminAddCourse() throws IOException
    {
        return (AddCourseController) loadController("page/administration/course/AddCourse.fxml");
    }     

    @Bean
    public AddDepartmentController adminAddDepartment() throws IOException
    {
        return (AddDepartmentController) loadController("page/administration/department/AddDepartment.fxml");
    }        
    
    @Bean
    public AddFacultyController adminAddFaculty() throws IOException
    {
        return (AddFacultyController) loadController("page/administration/faculty/AddFaculty.fxml");
    }  
    
    @Bean
    public AddProgramController adminAddProgram() throws IOException
    {
        return (AddProgramController) loadController("page/administration/program/AddProgram.fxml");
    } 
    
    @Bean
    public AddSectionController adminAddSection() throws IOException
    {
        return (AddSectionController) loadController("page/administration/section/AddSection.fxml");
    }
    
    @Bean
    public TimetableController timetable() throws IOException
    {
        return (TimetableController) loadController("page/timetable/Timetable.fxml");
    }
    
    @Bean
    public StudentSidebarController studentSidebar() throws IOException
    {
        return (StudentSidebarController) loadController("sidebar/StudentSidebar.fxml");
    }
    
    protected Object loadController(String url) throws IOException
    {
        try
        (InputStream fxmlStream = getClass().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(url));
            Node view = (Node) loader.load(fxmlStream);
            Controller controller = (Controller) loader.getController();
            controller.setView(view);
            return controller; 
        }
    }
    
   }

