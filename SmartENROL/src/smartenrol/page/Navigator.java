/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.model.view.CourseGradeRecordTable;
import smartenrol.model.view.CourseTable;
import smartenrol.model.view.DepartmentTable;
import smartenrol.model.view.ProgramTable;
import smartenrol.model.view.UserTable;
import static smartenrol.page.SmartEnrolController.Page.UPDATE_PROFILE;
import smartenrol.page.administration.building.AddBuildingController;
import smartenrol.page.administration.course.AddCourseController;
import smartenrol.page.administration.department.AddDepartmentController;
import smartenrol.page.administration.faculty.AddFacultyController;
import smartenrol.page.administration.program.AddProgramController;
import smartenrol.page.administration.section.AddSectionController;
import smartenrol.page.classlist.ClassListController;
import smartenrol.page.dashboard.DashboardController;
import smartenrol.page.entities.building.BuildingPageController;
import smartenrol.page.entities.course.CoursePageController;
import smartenrol.page.entities.department.DepartmentPageController;
import smartenrol.page.entities.program.ProgramPageController;
import smartenrol.page.login.LoginController;
import smartenrol.page.myProgram.MyProgramPageController;
import smartenrol.page.entities.user.UserController;
import smartenrol.page.entities.user.AdminProfileController;
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
    private AdminProfileController adminProfileController;
    @Autowired
    private ProgramPageController programPageController;
    @Autowired
    private BuildingPageController buildingPageController;
    @Autowired
    private DepartmentPageController departmentPageController;
    @Autowired
    private UserSidebarController userSidebarController;
    @Autowired
    private ClassListController classListController;
    @Autowired
    private ActivityHistoryController activityHistoryController;
    @Autowired
    private ErrorController errorController;
    @Autowired
    private FormController formController;
    
    @Override
    public void init() {
        loadController(loginController);
    }

    public Controller navigate(Page page) {
        
        if (page==null) {
            errorController.load(PageError.NO_PAGE_HERE);
            return loadInternalController(errorController,null);
        }
        
        switch (page) {
            case LOGIN:
                return loadController(loginController);
            case DASHBOARD:
                return loadInternalController(dashboardController,null);
            case TIMETABLE:
                return loadInternalController(timetableController,null);
            case HOME:
                return loadController(pageController);
            case MY_PROFILE:
                userController.load(getUserSession().getCurrentUser().getIdUser());
                return loadInternalController(userController,null);
            case MY_PROGRAM:
                return loadInternalController(myProgramPageController,null);
            case SEARCH:
                return loadInternalController(searchController,null);
            case UPDATE_PROFILE:
                return loadFormController(adminProfileController, null);
            case ADD_USER:
                return loadFormController(adminProfileController, "admin-user");
            case ADD_BUILDING:
                return loadFormController(addBuildingController,"admin-building");
            case ADD_PROGRAM:
                return loadFormController(addProgramController,"admin-program");
            case ADD_FACULTY:
                return loadFormController(addFacultyController,"admin-faculty");
            case ADD_SECTION:
                return loadFormController(addSectionController, "admin-user");
            case ADD_DEPARTMENT:
                return loadFormController(addDepartmentController,"admin-department");
            case ADD_COURSE:
                return loadFormController(addCourseController, "admin-course");
            case COURSE:
                return loadInternalController(coursePageController,null);
            case PROGRAM:
                return loadInternalController(programPageController,null);
            case BUILDING:
                return loadInternalController(buildingPageController,null);
            case DEPARTMENT:
                return loadInternalController(departmentPageController,null);
            case CLASSLIST:
                return loadInternalController(classListController,null);
            case ACTIVITY_HISTORY:
                return loadInternalController(activityHistoryController,"admin-course");
            case USER:
                if (getUserSession().getCurrentUser().isAdministrator()) {
                    return loadInternalController(userController, "search-all");
                } else {
                    return loadInternalController(userController, "search-basic");
                }
            case ERROR:
                return loadInternalController(errorController,null);
            default:
                return loadInternalController(errorController,null);
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

    private Controller loadInternalController(Controller internal, String permission) {
        if (hasAccess(permission)) {
            pageController.getInternalView().setCenter(internal.getView());
            internal.init();

            if (internal.getSidebarEnabled()) {
                pageController.getInternalView().setRight(defaultSidebar().getView());
                defaultSidebar().init();
            } else {
                pageController.getInternalView().setRight(null);
            }

            return internal;
        } else {
            errorController.load(PageError.ACCESS_DENIED);
            pageController.getInternalView().setCenter(errorController.getView());
            pageController.getInternalView().setRight(defaultSidebar().getView());
            return errorController;
        }
    }
    
    public Controller defaultSidebar() {
        return userSidebarController;            
    }

    @Override
    public void load() {
    
    }
    
    private boolean hasAccess(String permission) {
       if (permission==null||getUserSession().checkPermission(permission))
           return true;
       else 
            return false;
    }
    
    public Controller loadFormController(Controller internal, String permission) {
        loadInternalController(formController, permission); 
        formController.getInternalView().setContent(internal.getView());
        internal.init();
        return internal;
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
                ((UserController) this.navigate(Page.USER)).load(result.getUserID());
            }

            if (type.equalsIgnoreCase("program")) {
                ProgramTable result = (ProgramTable) selectedItem;
               
                ((ProgramPageController) this.navigate(Page.PROGRAM)).load(result.getProgram());
            }
            
            if (type.equalsIgnoreCase("department")) {
                DepartmentTable result = (DepartmentTable) selectedItem;
                ((DepartmentPageController) this.navigate(Page.DEPARTMENT)).load(result.getDepartment());
            }
            
            if (type.equalsIgnoreCase("transcript")) {
                CourseGradeRecordTable result = (CourseGradeRecordTable) selectedItem;
                ((CoursePageController) this.navigate(Page.COURSE)).load(result.getIdDepartment(), result.getIdCourse());
            }

        }
    }
    
}
