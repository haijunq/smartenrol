/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalDate;

/**
 *
 * @author Swordghost
 */
public class Message {
    private int id;
    private int recepientID;
    private int senderID;
    private String type;
    private String message;
    private LocalDate date;
    private String status;

    public Message()
    {
        
    }
    
    public Message(int id, int recepeintID, int senderID, String type, String message, LocalDate date, String status) {
        this.id = id;
        this.recepientID = recepeintID;
        this.senderID = senderID;
        this.type = type;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the recepeintID
     */
    public int getRecepeintID() {
        return recepientID;
    }

    /**
     * @param recepeintID the recepeintID to set
     */
    public void setRecepeintID(int recepeintID) {
        this.recepientID = recepeintID;
    }

    /**
     * @return the senderID
     */
    public int getSenderID() {
        return senderID;
    }

    /**
     * @param senderID the senderID to set
     */
    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

   
    public String toString()
    {
        return Integer.toString(id)+","+Integer.toString(recepientID)+","+Integer.toString(senderID)+","+message;
    }
    
    
}
