/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.elements.icons;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import smartenrol.page.Navigator;

/**
 *
 * @author Jeremy
 */
public class Icon extends ImageView {
    
    @Autowired private Navigator navigator;
    
    private String fileName;
    private Image iconImg, iconHit;
    private Boolean stayOn = false;
    
    public Icon(String fileName) {
        
        this.iconImg = new Image("/smartenrol/images/"+fileName+".png");
        this.iconHit = new Image("/smartenrol/images/"+fileName+"-hit.png");
        
        setImage(iconImg);
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                setImage(iconHit);
                if (!stayOn)
                    setCursor(Cursor.HAND);
            }
        });        

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (stayOn)
                    setImage(iconHit);
                else
                    setImage(iconImg);
            }
        });         
        
    }

    public void setActive() {
        setStayOn(true);
        setImage(iconHit);
    }
    
    /**
     * @return the stayOn
     */
    public Boolean getStayOn() {
        return stayOn;
    }

    /**
     * @param stayOn the stayOn to set
     */
    public void setStayOn(Boolean stayOn) {
        this.stayOn = stayOn;
    }
    
    public void reset() {
        setImage(iconImg);
        setStayOn(false);
    }

}
