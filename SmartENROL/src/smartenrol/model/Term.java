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
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deadline;
    private String description;

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

    public Term(String term, int year) {
        this.term = term;
        this.year = year;
    }

    public Term(String term, int year, LocalDate startDate, LocalDate endDate, LocalDate deadline, String description) {
        this.term = term;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
        this.description = description;
    }

    public boolean isInCurrentTerm(int year, String term) {
        if (this.year == year && this.term.equals(term))
            return true; 
        else
            return false;
    }
    
    public boolean isInCurrentTerm(LocalDate date) {
        if (date.isAfter(this.startDate) && date.isBefore(this.endDate))
            return true;
        else 
            return false;
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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
