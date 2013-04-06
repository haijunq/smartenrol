/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

/**
 *
 * @author Jeremy
 */
public class Person {
    
    private boolean active;
    private String firstName;
    private String lastName;
    private String primaryEmail;
    private String secondaryEmail;
    private int age;
    
    public Person(boolean isActive, String firstName, String lastName, String primaryEmail, String secondaryEmail, int age) {
       this.active = isActive;
       this.firstName = firstName;
       this.lastName = lastName;
       this.primaryEmail = primaryEmail;
       this.secondaryEmail = secondaryEmail;
       this.age = age;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the primaryEmail
     */
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    /**
     * @param primaryEmail the primaryEmail to set
     */
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    /**
     * @return the secondaryEmail
     */
    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    /**
     * @param secondaryEmail the secondaryEmail to set
     */
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
