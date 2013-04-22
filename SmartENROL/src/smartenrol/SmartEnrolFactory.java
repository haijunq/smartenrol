/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol;

import smartenrol.page.error.ErrorController;
import smartenrol.page.login.LoginController;
import smartenrol.page.entities.course.CoursePageController;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import javafx.scene.Node;

import smartenrol.page.*;
import smartenrol.page.activityHistory.ActivityHistoryController;
import smartenrol.page.administration.building.*;
import smartenrol.page.administration.course.*;
import smartenrol.page.administration.department.*;
import smartenrol.page.administration.faculty.*;
import smartenrol.page.administration.program.*;
import smartenrol.page.administration.section.*;
import smartenrol.page.classlist.ClassListController;
import smartenrol.page.dashboard.*;
import smartenrol.page.entities.building.BuildingPageController;
import smartenrol.page.entities.department.DepartmentPageController;
import smartenrol.page.timetable.*;
import smartenrol.sidebar.*;
import smartenrol.page.search.*;
import smartenrol.page.myProgram.*;
import smartenrol.page.entities.user.UserController;
import smartenrol.page.entities.program.ProgramPageController;
import smartenrol.page.entities.user.UpdateProfileController;

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
    public UserController UserController() throws IOException
    {
        return (UserController) loadController("page/entities/user/User.fxml");
    }
    
    @Bean
    public UpdateProfileController updateProfileController() throws IOException
    {
        return (UpdateProfileController) loadController("page/entities/user/UpdateProfile.fxml");
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
        return (ProgramPageController) loadController("page/entities/program/ProgramPage.fxml");
    }
    
    @Bean
    public TimetableController timetable() throws IOException
    {
        return (TimetableController) loadController("page/timetable/Timetable.fxml");
    }
    
    @Bean
    public CourseSidebarController courseSidebar() throws IOException
    {
        return (CourseSidebarController) loadController("sidebar/CourseSidebar.fxml");
    }
   
    @Bean
    public CoursePageController course() throws IOException
    {
        return (CoursePageController) loadController("page/entities/course/CoursePage.fxml");
    }
    
    @Bean
    public DepartmentPageController departmentPage() throws IOException
    {
        return (DepartmentPageController) loadController("page/entities/department/DepartmentPage.fxml");
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
    public FilterController searchFilters() throws IOException
    {
        return (FilterController) loadController("page/search/Filter.fxml");
    }
    
    @Bean
    public MyProgramPageController myProgramPage() throws IOException
    {
        return (MyProgramPageController) loadController("page/myProgram/MyProgram.fxml");
    }
    
    @Bean
    public BuildingPageController buildingPage() throws IOException
    {
        return (BuildingPageController) loadController("page/entities/building/BuildingPage.fxml");
    }

    @Bean
    public ErrorController errorPage() throws IOException
    {
        return (ErrorController) loadController("page/error/Error.fxml");
    }    

    @Bean
    public Navigator entryPage() throws IOException
    {
        return (Navigator) loadController("page/Navigator.fxml");
    }   
    
    @Bean
    public ClassListController classListPage() throws IOException
    {
        return (ClassListController) loadController("page/classlist/ClassList.fxml");
    }   
    
    @Bean
    public UserSidebarController userSidebar() throws IOException
    {
        return (UserSidebarController) loadController("sidebar/UserSidebar.fxml");
    }  
    
    @Bean
    public ActivityHistoryController activityHistory() throws IOException
    {
        return (ActivityHistoryController) loadController("page/activityHistory/ActivityHistory.fxml");
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

