package smartenrol.page;

import javafx.scene.Node;
import smartenrol.model.User;
import smartenrol.security.UserSession;

public abstract class AbstractController implements Controller
{
    
    private UserSession currentUserSession = UserSession.getInstance();
    
    private Node view;
    
    public abstract void init();

    public Node getView()
    {
        return view;
    }
    
    public UserSession getUserSession() {
        return currentUserSession;
    }

    public void setView(Node view)
    {
        this.view = view;
    }
}