/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model;

import org.joda.time.LocalDate;

/**
 *
 * @author Haijun
 */
public class Term {
    private String term; 
    private int year;

    /**
     * Constructor for Term class by checking the current local date.
     */
    public Term() {
        LocalDate today = new LocalDate();
        this.year = today.getYear();
        if (today.getMonthOfYear() < 5) 
            this.term = "winter";
        else if (today.getMonthOfYear() < 9)
            this.term = "summer";
        else
            this.term = "fall";
    }

    public String getCurrentTerm() {
        return term;
    }

    public int getCurrentYear() {
        return year;
    }
    
    /**
     * Return the Current Date for later reference.
     * @return 
     */
    public LocalDate getCurrentDate() {
        return new LocalDate();
    }
    
    
    
}
