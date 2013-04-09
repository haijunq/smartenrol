/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartenrol.page.entities.department;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import smartenrol.dao.DepartmentDAO;
import smartenrol.model.Department;
import smartenrol.page.SmartEnrolController;

/**
 *
 * @author MrAtheist
 */
public class DepartmentPageController extends SmartEnrolController{
	
	private Department department;

	@FXML BorderPane innerContent;
	@FXML Text fxDepartmentName;
	@FXML Text fxDepartmentDescription;

	@Override
	public void init(){
		
		System.out.println("Entering Department Page");
	}

	public void load(String idDepartment) {

		department = new DepartmentDAO().getDepartmentByID(idDepartment);

		if (department != null) {

			fxDepartmentName.setText(department.getName());
			fxDepartmentDescription.setText(department.getDescription());
			
		}
	}
}
