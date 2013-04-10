package smartenrol.page;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.security.UserSession;

public abstract class SmartEnrolController implements Controller
{
    private UserSession currentUserSession = UserSession.getInstance();
    
    private Node view;
    private Node internalView;
    
    @Override
    public abstract void init();

    @Override
    public Node getView()
    {
        return view;
    }

    public Node getInternalView()
    {
        return internalView;
    }    
    
    public UserSession getUserSession() {
        return currentUserSession;
    }

    public void setView(Node view)
    {
        this.view = view;
    }
    
}