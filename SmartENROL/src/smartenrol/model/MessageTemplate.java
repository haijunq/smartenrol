/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

/**
 *
 * @author Jeremy
 */
public class MessageTemplate  {

    private String type;
    private String stringPattern;

    public MessageTemplate() {
    }

    public MessageTemplate(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStringPattern() {
        return stringPattern;
    }

    public void setStringPattern(String stringPattern) {
        this.stringPattern = stringPattern;
    }

    
}
