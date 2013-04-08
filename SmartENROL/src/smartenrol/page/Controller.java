package smartenrol.page;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
 
public interface Controller
{
    public abstract void init();
    
    Node getView();

    public void setView(Node view);
    
    public void inject(BorderPane contentArea, Controller view, Controller sidebar);
    
}