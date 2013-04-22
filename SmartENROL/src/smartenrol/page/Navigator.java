/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.model.view.CourseTable;
import smartenrol.model.view.DepartmentTable;
import smartenrol.model.view.ProgramTable;
import smartenrol.model.view.UserTable;
import smartenrol.page.administration.building.AddBuildingController;
import smartenrol.page.administration.course.AddCourseController;
import smartenrol.page.administration.department.AddDepartmentController;
import smartenrol.page.administration.faculty.AddFacultyController;
import smartenrol.page.administration.program.AddProgramController;
import smartenrol.page.administration.section.AddSectionController;
import smartenrol.page.classlist.ClassListController;
import smartenrol.page.dashboard.DashboardController;
import smartenrol.page.elements.icons.Icon;
import smartenrol.page.entities.building.BuildingPageController;
import smartenrol.page.entities.course.CoursePageController;
import smartenrol.page.entities.department.DepartmentPageController;
import smartenrol.page.entities.program.ProgramPageController;
import smartenrol.page.login.LoginController;
import smartenrol.page.myProgram.MyProgramPageController;
import smartenrol.page.entities.user.UserController;
import smartenrol.page.entities.user.UpdateProfileController;
import smartenrol.page.error.ErrorController;
import smartenrol.page.activityHistory.ActivityHistoryController;
import smartenrol.page.search.SearchController;
import smartenrol.page.timetable.TimetableController;
import smartenrol.sidebar.UserSidebarController;

public class Navigator extends SmartEnrolController {
    
    private Page currentLinkName;
    
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
    private UserController userController;
    @Autowired
    private UpdateProfileController updateProfileController;
    @Autowired
    private ProgramPageController programPageController;
    @Autowired
    private BuildingPageController buildingPageController;
    @Autowired
    private DepartmentPageController departmentPageController;
    @Autowired
    private ErrorController noPageController;
    @Autowired
    private UserSidebarController userSidebarController;
    @Autowired
    private ClassListController classListController;
    @Autowired
    private ActivityHistoryController activityHistoryController;
    @Autowired
    private ErrorController errorController;
    
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
                return loadInternalController(userController);
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
            case CLASSLIST:
                return loadInternalController(classListController);
            case ACTIVITY_HISTORY:
                return loadInternalController(activityHistoryController);
            case ERROR:
                return loadInternalController(errorController);
            default:
                return loadInternalController(errorController);
        }
    }
    
    /*public clickableIcon(Icon item, Page name) {
            this.currentLinkName = name;
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent me) {
                            navigate(currentLinkName);
                        }
            });
            return item;
    }*/

    private Controller loadController(Controller controller) {
        mainWindow.setCenter(new Text("Loading"));
        mainWindow.setCenter(controller.getView());
        controller.init();
        return controller;
    }

    private Controller loadInternalController(Controller internal) {
        pageController.getInternalView().setCenter(internal.getView());
        internal.init();
        
        if (internal.getSidebarEnabled()) {
            pageController.getInternalView().setRight(defaultSidebar().getView());
            defaultSidebar().init();
        } else {
            pageController.getInternalView().setRight(null);
        }
        
        return internal;
    }
    
    public Controller defaultSidebar() {
        return userSidebarController;            
    }

    @Override
    public void load() {
    
    }
    
    
    public void loadSelectedItem(TableView tableView, String type) {
        Object selectedItem = null;
        selectedItem = tableView.getFocusModel().getFocusedItem();
        if (!(selectedItem == null)) {
            pageController.setLastSearchVisible(true);
            if (type.equalsIgnoreCase("course")) {
                CourseTable result = (CourseTable) selectedItem;
                ((CoursePageController) this.navigate(Page.COURSE)).load(result.getIdDepartment(), result.getIdCourse());
            }

            if (type.equalsIgnoreCase("user")) {
                UserTable result = (UserTable) selectedItem;
              
                //                ((CoursePageController) navigator.navigate(Page.COURSE)).load(result.getIdDepartment(), result.getIdCourse());
            }

            if (type.equalsIgnoreCase("program")) {
                ProgramTable result = (ProgramTable) selectedItem;
               
                ((ProgramPageController) this.navigate(Page.PROGRAM)).load(result.getProgram());
            }
            
            if (type.equalsIgnoreCase("department")) {
                DepartmentTable result = (DepartmentTable) selectedItem;
                ((DepartmentPageController) this.navigate(Page.DEPARTMENT)).load(result.getDepartment());
            }

        }
    }

}
