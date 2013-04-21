package smartenrol.page.administration.department;

import java.util.Map;

import smartenrol.SmartEnrolException;
import smartenrol.dao.DepartmentDAO;
import smartenrol.model.Building;
import smartenrol.model.Department;
import smartenrol.model.Faculty;

public class DepartmentService {

    private final Map<String, String> userInputValueHolder;
    private final DepartmentDAO departmentDAO;

    public DepartmentService(final Map<String, String> userInputValueHolder) {
        this.userInputValueHolder = userInputValueHolder;
        departmentDAO = new DepartmentDAO();
    }

    public String insertDepartment() throws SmartEnrolException {
        final DepartmentValidator departmentValidator = new DepartmentValidator();
        departmentValidator.validate(userInputValueHolder);
        final Department department = new Department();
        updateDepartmentFromUserInput(department);
        final Integer rowUpdateCount = departmentDAO.addDepartment(department);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Insertion Failed.";
        } else {
            message = "Insertion Successful.";
            return message;
        }
        return message;
    }

    public String updateDepartment() throws SmartEnrolException {
        final DepartmentValidator departmentValidator = new DepartmentValidator();
        departmentValidator.validate(userInputValueHolder);
        final Department department = new Department();
        updateDepartmentFromUserInput(department);
        final Integer rowUpdateCount = departmentDAO.updateDepartment(department);
        String message = "";
        if (rowUpdateCount == 0) {
            message = "Updation Failed.";
        } else {
            message = "Updation Successful.";
        }
        return message;
    }

    private void updateDepartmentFromUserInput(final Department department) {
        department.setIdDepartment(userInputValueHolder.get(IDepartmentServiceConstants.ID_DEPARTMENT));
        department.setName(userInputValueHolder.get(IDepartmentServiceConstants.NAME));
        department.setIdLocation(userInputValueHolder.get(IDepartmentServiceConstants.ID_LOCATION));
        department.setIdFaculty(userInputValueHolder.get(IDepartmentServiceConstants.ID_FACULTY));
        department.setDescription(userInputValueHolder.get(IDepartmentServiceConstants.DESCRIPTION));
        department.setMainContactID(userInputValueHolder.get(IDepartmentServiceConstants.MAIN_CONTACT_ID));
        department.setDepartmentHeadID(userInputValueHolder.get(IDepartmentServiceConstants.DEPARTMENT_HEAD_ID));
    }
}
