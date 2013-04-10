package smartenrol.page;

import javafx.scene.Node;
 
public interface Controller
{
    void init();
    
    void load();
    
    Node getView();

    public void setView(Node view);
    
    Node getInternalView();
    
    boolean getSidebarEnabled();
    
    void setSidebarEnabled(boolean sidebarEnabled);
    
    
}