package smartenrol.page;

import javafx.scene.Node;
 
public interface Controller
{
    public abstract void init();
    
    Node getView();

    public void setView(Node view);
    
    Node getInternalView();
    
    boolean getSidebarEnabled();
    
    void setSidebarEnabled(boolean sidebarEnabled);
}