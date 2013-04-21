/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.icons;

/**
 *
 * @author Jeremy
 */
public class IconFactory {
    
    public enum IconType {
        HOME, DASHBOARD, MY_PROFILE, MY_PROGRAM, TIMETABLE, ACTIVITY_HISTORY, ADD, REMOVE, REMOVE_SELECTED
    }
    
    public Icon getIcon(IconType type) {
        switch (type) {
            case DASHBOARD:
                return new Icon("se-icon-dashboard");
            case TIMETABLE:
                return new Icon("se-icon-timetable");
            case HOME:
                return new Icon("se-icon-arrows");
            case MY_PROFILE:
                return new Icon("se-icon-profile");
            case MY_PROGRAM:   
                return new Icon("se-icon-program-navigator");
            case ACTIVITY_HISTORY:   
                return new Icon("se-icon-recent-activity");
            case REMOVE:   
                return new Icon("se-remove");
            case ADD:   
                return new Icon("se-add");
            case REMOVE_SELECTED:   
                return new Icon("se-remove-selected");
            default:
                return new Icon("se-logo-arrows");
        }
    }
}
