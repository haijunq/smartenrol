/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.model.view;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import smartenrol.model.Course;
/**
 *
 * @author Jeremy
 */
public class CourseTable {
	
	private SimpleStringProperty idDepartment;
	private SimpleIntegerProperty idCourse;
	private SimpleStringProperty name;
	private SimpleFloatProperty credit;
	private SimpleStringProperty course;
	
	public CourseTable(Course course) {
		this.idDepartment = new SimpleStringProperty(course.getIdDepartment());
		this.idCourse = new SimpleIntegerProperty(course.getIdCourse());
		this.name = new SimpleStringProperty(course.getCourseName());
		this.credit = new SimpleFloatProperty(course.getCredits());
	}
	
	public CourseTable(String idDepartment, int idCourse) {
		this.idDepartment = new SimpleStringProperty(idDepartment);
		this.idCourse = new SimpleIntegerProperty(idCourse);
		this.course = new SimpleStringProperty(idDepartment + " " + String.valueOf(idCourse));
	}
	
	/**
	 * @return the department + course id
	 */
	public String getCourse() {
		return course.get();
	}
	
	/**
	 * @return the Department
	 */
	public String getIdDepartment() {
		return idDepartment.get();
	}
	
	/**
	 * @return the Course
	 */
	public int getIdCourse() {
		return idCourse.get();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name.get();
	}
	
	/**
	 * @return the credit
	 */
	public float getCredit() {
		return credit.get();
	}
	
	
	
}
