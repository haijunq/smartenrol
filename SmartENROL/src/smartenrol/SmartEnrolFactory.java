/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import smartenrol.page.login.LoginController;
import smartenrol.page.entities.course.CoursePageController;
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
import smartenrol.sidebar.*;
import smartenrol.page.search.*;
import smartenrol.page.myProgram.*;
import smartenrol.page.myprofile.MyProfileController;
import smartenrol.page.program.ProgramPageController;

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
    public MyProfileController myProfileController() throws IOException
    {
        return (MyProfileController) loadController("page/myprofile/MyProfile.fxml");
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
    public ProgramPageController programPage() throws IOException
    {
        return (ProgramPageController) loadController("page/program/ProgramPage.fxml");
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
    
    @Bean
    public CourseSidebarController courseSidebar() throws IOException
    {
        return (CourseSidebarController) loadController("sidebar/CourseSidebar.fxml");
    }
    
    @Bean
    public AdministratorSidebarController administratorSidebar() throws IOException
    {
        return (AdministratorSidebarController) loadController("sidebar/AdministratorSidebar.fxml");
    }
    
    @Bean
    public InstructorSidebarController instructorSidebar() throws IOException
    {
        return (InstructorSidebarController) loadController("sidebar/InstructorSidebar.fxml");
    }
   
    @Bean
    public CoursePageController course() throws IOException
    {
        return (CoursePageController) loadController("page/course/CoursePage.fxml");
    }
    
    @Bean
    public SearchController search() throws IOException
    {
        return (SearchController) loadController("page/search/Search.fxml");
    }
    
    @Bean
    public ResultsPaneController searchResultsPane() throws IOException
    {
        return (ResultsPaneController) loadController("page/search/ResultsPane.fxml");
    }
    
    @Bean
    public SearchTableController searchTable() throws IOException
    {
        return (SearchTableController) loadController("page/search/SearchTable.fxml");
    }
    
    @Bean
    public FilterController searchFilters() throws IOException
    {
        return (FilterController) loadController("page/search/Filter.fxml");
    }
    
    @Bean
    public MyProgramPageController myProgramPage() throws IOException
    {
        return (MyProgramPageController) loadController("page/myProgram/MyProgram.fxml");
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

