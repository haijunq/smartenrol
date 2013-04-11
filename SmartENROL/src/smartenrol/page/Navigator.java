/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.model.User;
import smartenrol.page.administration.building.AddBuildingController;
import smartenrol.page.administration.course.AddCourseController;
import smartenrol.page.administration.department.AddDepartmentController;
import smartenrol.page.administration.faculty.AddFacultyController;
import smartenrol.page.administration.program.AddProgramController;
import smartenrol.page.administration.section.AddSectionController;
import smartenrol.page.dashboard.DashboardController;
import smartenrol.page.entities.building.BuildingPageController;
import smartenrol.page.entities.course.CoursePageController;
import smartenrol.page.entities.department.DepartmentPageController;
import smartenrol.page.entities.program.ProgramPageController;
import smartenrol.page.login.LoginController;
import smartenrol.page.myProgram.MyProgramPageController;
import smartenrol.page.myprofile.MyProfileController;
import smartenrol.page.myprofile.UpdateProfileController;
import smartenrol.page.noPageFound.NoPageFoundController;
import smartenrol.page.search.SearchController;
import smartenrol.page.timetable.TimetableController;
import smartenrol.sidebar.AdministratorSidebarController;
import smartenrol.sidebar.InstructorSidebarController;
import smartenrol.sidebar.StudentSidebarController;

public class Navigator extends SmartEnrolController {

    @FXML
    private BorderPane mainWindow;
    @Autowired
    private PageController pageController;
    @Autowired
    private LoginController loginController;
    @Autowired
    private DashboardController dashboardController;
    @Autowired
    private AddBuildingController addBuildingController;
    @Autowired
    private AddCourseController addCourseController;
    @Autowired
    private AddDepartmentController addDepartmentController;
    @Autowired
    private AddFacultyController addFacultyController;
    @Autowired
    private AddProgramController addProgramController;
    @Autowired
    private AddSectionController addSectionController;
    @Autowired
    private TimetableController timetableController;
    @Autowired
    private CoursePageController coursePageController;
    @Autowired
    private SearchController searchController;
    @Autowired
    private MyProgramPageController myProgramPageController;
    @Autowired
    private MyProfileController myProfileController;
    @Autowired
    private UpdateProfileController updateProfileController;
    @Autowired
    private ProgramPageController programPageController;
    @Autowired
    private BuildingPageController buildingPageController;
    @Autowired
    private DepartmentPageController departmentPageController;
    @Autowired
    private NoPageFoundController noPageController;
    @Autowired
    private InstructorSidebarController instructorSidebarController;
    @Autowired
    private StudentSidebarController studentSidebarController;    
    @Autowired
    private AdministratorSidebarController administratorSidebarController;
    
    @Override
    public void init() {
        loadController(loginController);
    }

    public Controller navigate(Page page) {
        
        if (page==null) {
            return loadInternalController(noPageController);
        }
        
        switch (page) {
            case LOGIN:
                return loadController(loginController);
            case DASHBOARD:
                return loadInternalController(dashboardController);
            case TIMETABLE:
                return loadInternalController(timetableController);
            case HOME:
                return loadController(pageController);
            case MY_PROFILE:
                return loadInternalController(myProfileController);
            case MY_PROGRAM:
                return loadInternalController(myProgramPageController);
            case SEARCH:
                return loadInternalController(searchController);
            case UPDATE_PROFILE:
                return loadInternalController(updateProfileController);
            case ADD_BUILDING:
                return loadInternalController(addBuildingController);
            case ADD_PROGRAM:
                return loadInternalController(addProgramController);
            case ADD_FACULTY:
                return loadInternalController(addFacultyController);
            case ADD_SECTION:
                return loadInternalController(addSectionController);
            case ADD_DEPARTMENT:
                return loadInternalController(addDepartmentController);
            case ADD_COURSE:
                return loadInternalController(addCourseController);
            case COURSE:
                return loadInternalController(coursePageController);
            case PROGRAM:
                return loadInternalController(programPageController);
            case BUILDING:
                return loadInternalController(buildingPageController);
            case DEPARTMENT:
                return loadInternalController(departmentPageController);
            default:
                return loadInternalController(noPageController);
        }
    }

    private Controller loadController(Controller controller) {
        mainWindow.setCenter(controller.getView());
        controller.init();
        return controller;
    }

    private Controller loadInternalController(Controller internal) {
        pageController.getInternalView().setCenter(internal.getView());
        if (internal.getSidebarEnabled()) {
            pageController.getInternalView().setRight(defaultSidebar().getView());
        }
        internal.init();
        return internal;
    }
    
    public Controller defaultSidebar() {
            User.Type usertype = getUserSession().getCurrentUser().getUsertype();
                
                if (getUserSession().isSignedIn()) {
                    
                    if (usertype == User.Type.INSTRUCTOR) {
                        return instructorSidebarController;
                    } else if (usertype == User.Type.ADMINISTRATOR) {
                        return administratorSidebarController;
                    } else {
                        return studentSidebarController;
                    }
                    
                } else {
                    return null;
                }
            
	}

    @Override
    public void load() {
    
    }
}
