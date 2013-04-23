/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.SectionNode;

/**
 *
 * @author MrAtheist
 */
public class SectionNodeTable {
	
	private SimpleStringProperty idDepartment, idSection, term, startTime, endTime, idLocation, idRoom, dayOfWeek;
	private SimpleIntegerProperty idCourse, day, year;

	public SectionNodeTable(SectionNode snode) {

		this.idDepartment = new SimpleStringProperty(snode.getIdDepartment());
		this.idCourse = new SimpleIntegerProperty(snode.getIdCourse());
		this.idSection = new SimpleStringProperty(snode.getIdSection());
		this.year = new SimpleIntegerProperty(snode.getYear());
		this.term = new SimpleStringProperty(snode.getTerm());
		this.day = new SimpleIntegerProperty(snode.getDay());
		this.startTime = new SimpleStringProperty(snode.getStartTime().toString("HH:mm"));
		this.endTime = new SimpleStringProperty(snode.getEndTime().toString("HH:mm"));
		this.idLocation = new SimpleStringProperty(snode.getIdLocation());
		this.idRoom = new SimpleStringProperty(snode.getIdRoom());
		this.dayOfWeek = new SimpleStringProperty(snode.getDayOfWeek());

	}

	/**
	 * @return the department + course id
	 */
	public String getCourse() {
		return idDepartment.get() + " " + idCourse.get();
	}
	
	public String getDayOfWeek() {
		return dayOfWeek.get();
	}

	public String getDepartment() {
		return idDepartment.get();
	}

	public int getIdCourse() {
		return idCourse.get();
	}

	public String getIdSection() {
		return idSection.get();
	}

	public int getYear() {
		return year.get();
	}

	public int getDay() {
		return day.get();
	}

	public String getTerm() {
		return term.get();
	}

	public String getStartTime() {
		return startTime.get();
	}

	public String getEndTime() {
		return endTime.get();
	}

	public String getIdLocation() {
		return idLocation.get();
	}

	public String getIdRoom() {
		return idRoom.get();
	}
}

