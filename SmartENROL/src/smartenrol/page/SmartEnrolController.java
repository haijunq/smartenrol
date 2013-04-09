package smartenrol.page;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import smartenrol.security.UserSession;

public abstract class SmartEnrolController implements Controller
{
    
    private UserSession currentUserSession = UserSession.getInstance();
    
    private Node view;
    
    @Override
    public abstract void init();

    @Override
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
    
    public void inject(BorderPane contentArea, Controller view, Controller sidebar) {
            
            contentArea.setCenter(null);
            if (view!=null) {
                contentArea.setCenter(view.getView());
                view.init();
            }
            
            contentArea.setRight(null);
            if (sidebar!=null) {
                contentArea.setRight(sidebar.getView());
                sidebar.init();
            }
            
    }
         
}