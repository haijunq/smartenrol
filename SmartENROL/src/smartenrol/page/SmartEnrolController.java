package smartenrol.page;

import javafx.scene.Node;
import smartenrol.security.UserSession;

public abstract class SmartEnrolController implements Controller
{

    public enum Page {

        HOME, LOGIN, DASHBOARD, MY_PROFILE, MY_PROGRAM, SEARCH, UPDATE_PROFILE,
        ADD_BUILDING, ADD_COURSE, ADD_SECTION, ADD_DEPARTMENT, ADD_CLASSROOM, CLASSLIST,
        ADD_FACULTY, TIMETABLE, ADD_PROGRAM, COURSE, PROGRAM, BUILDING, DEPARTMENT
    }
    
    private UserSession currentUserSession = UserSession.getInstance();
    
    private Node view;
    private Node internalView;
    private boolean sidebarEnabled;

    @Override
    public Node getView()
    {
        return view;
    }

    @Override
    public Node getInternalView()
    {
        return internalView;
    }    
    
    public void init() {
        
    }

    public void load() {
        
    }
    
    public UserSession getUserSession() {
        return currentUserSession;
    }

    @Override
    public void setView(Node view)
    {
        this.view = view;
    }
    
    public boolean getSidebarEnabled() {
        return sidebarEnabled;
    }
    
    public void setSidebarEnabled(boolean sidebarEnabled) {
        this.sidebarEnabled = sidebarEnabled;
    }  
}